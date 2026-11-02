#!/usr/bin/env python3
"""Builds docs/index.html from the *Theory.java files in src/main/java/org/tl/theory
(English) and src/main/java/org/tl/theory/ru (Russian). The page has an RU / EN switch.

Usage:  python3 scripts/build_docs.py
No dependencies: the generated page is one self-contained HTML file.
"""
import html
import re
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
SRC = {"en": ROOT / "src/main/java/org/tl/theory",
       "ru": ROOT / "src/main/java/org/tl/theory/ru"}
OUT = ROOT / "docs/index.html"

# The header shows only these high-level groups; the topics of the active group go to a second row.
# Theory files not listed here end up in the group "Other".
GROUPS = [
    ("loops", "Loops", "Циклы", ["ForTheory", "WhileTheory"]),
    ("conditions", "Conditions", "Условия", ["IfElseTheory", "SwitchTheory"]),
    ("arrays", "Arrays", "Массивы", ["ArrayTheory"]),
    ("collections", "Collections", "Коллекции", ["ListTheory", "SetTheory", "MapTheory"]),
    ("types", "Types", "Типы", ["PrimitivesAndWrappersTheory"]),
    ("streams", "Stream API", "Stream API", ["StreamTheory"]),
]

KEYWORDS = set("""abstract boolean break byte case catch char class continue default do double else enum
extends final finally float for if implements import instanceof int interface long new package private
protected public return short static super switch this throw throws try void while yield var true false null""".split())

TOKEN = re.compile(r"""
    (?P<comment>//[^\n]*|/\*.*?\*/)
  | (?P<string>"(?:\\.|[^"\\\n])*"|'(?:\\.|[^'\\\n])*')
  | (?P<number>\b\d[\d_]*(?:\.\d+)?[LlFfDd]?\b)
  | (?P<word>\b[A-Za-z_]\w*\b)
""", re.X | re.S)

INLINE = re.compile(r"(?:new\s+)?[A-Z]\w*<[^<>]*>\((?:[^()]|\([^()]*\))*\)|[\w.]+\([^()]*\)|\b[A-Z]\w*<[^<>]*(?:<[^<>]*>)?[^<>]*>(?:\(\))?|\bnull\b|==|!=|->")


TITLE_RE = re.compile(r"^(?:THEORY|ТЕОРИЯ): (.*)")

UI = {
    "en": {"contents": "Contents", "copy": "Copy", "copied": "Copied",
           "footer": "Generated from <code>src/main/java/org/tl/theory</code> by "
                     "<code>scripts/build_docs.py</code>. Do not edit by hand."},
    "ru": {"contents": "Содержание", "copy": "Копировать", "copied": "Скопировано",
           "footer": "Сгенерировано из <code>src/main/java/org/tl/theory/ru</code> скриптом "
                     "<code>scripts/build_docs.py</code>. Не редактируйте вручную."},
}


TOPIC_KEYS = set()

# "XTheory" -> topic X; "section N" / "раздел N" -> section N of the same topic; "(see N)" / "(см. N)"
XREF = re.compile(r"\b([A-Z]\w*)Theory\b|\b(?:section|раздел(?:а|е)?)\s+(\d+)|\((?:see|см\.)\s+(\d+)\)")


def link(escaped, cur):
    """Turns cross-references in already escaped text into links. cur = key of the current topic."""
    if cur is None:
        return escaped

    def sub(m):
        if m.group(1):
            key = m.group(1).lower()
            return f'<a class="xref" href="#{key}">{m.group(0)}</a>' if key in TOPIC_KEYS else m.group(0)
        n = m.group(2) or m.group(3)
        text = m.group(0)
        i = text.rindex(n)
        return f'{text[:i]}<a class="xref" href="#{cur}-{n}">{n}</a>{text[i + len(n):]}'

    return XREF.sub(sub, escaped)


def esc(s):
    return html.escape(s, quote=False)


def highlight(code, cur=None):
    out, pos = [], 0
    for m in TOKEN.finditer(code):
        out.append(esc(code[pos:m.start()]))
        kind, text = m.lastgroup, m.group()
        if kind == "word":
            if text in KEYWORDS:
                kind = "kw"
            elif text[0].isupper():
                kind = "type"
            else:
                out.append(esc(text))
                pos = m.end()
                continue
        shown = link(esc(text), cur) if kind == "comment" else esc(text)
        out.append(f'<span class="t-{kind}">{shown}</span>')
        pos = m.end()
    out.append(esc(code[pos:]))
    return "".join(out)


def inline(text, cur=None):
    out, pos = [], 0
    for m in INLINE.finditer(text):
        out.append(link(esc(text[pos:m.start()]), cur))
        out.append(f"<code>{esc(m.group())}</code>")
        pos = m.end()
    out.append(link(esc(text[pos:]), cur))
    return "".join(out)


def doc_lines(block):
    return [re.sub(r"^\s*\* ?", "", l.rstrip()) for l in block.split("\n")]


NOTE_RE = re.compile(r"^(Note|Заметка):\s*(.*)")


def is_preformatted(p):
    """A table or aligned columns: keep as is. Indented lines after a bullet are just its continuation."""
    if any("|" in l for l in p):
        return True
    seen_bullet = False
    for l in p:
        if l.strip().startswith("- "):
            seen_bullet = True
        elif l.startswith("  ") and not seen_bullet:
            return True
    return False


def render_text(lines, topic=None):
    """Javadoc lines -> HTML: paragraphs, bullet lists, preformatted blocks and notes ("Note:" / "Заметка:")."""
    paras, cur = [], []
    for l in lines:
        if l.strip():
            cur.append(l)
        elif cur:
            paras.append(cur)
            cur = []
    if cur:
        paras.append(cur)

    out = []
    for p in paras:
        note = NOTE_RE.match(p[0])
        if note:
            p = ([note.group(2)] if note.group(2) else []) + p[1:]
        start = len(out)

        if not note and is_preformatted(p):
            out.append("<pre class=\"plain\">" + link(esc("\n".join(p)), topic) + "</pre>")
            continue

        text_buf, items = [], []

        def flush_text():
            if text_buf:
                out.append("<p>" + inline(" ".join(text_buf), topic) + "</p>")
                text_buf.clear()

        def flush_items():
            if items:
                out.append("<ul>" + "".join(f"<li>{inline(i, topic)}</li>" for i in items) + "</ul>")
                items.clear()

        for l in p:
            if l.strip().startswith("- "):
                flush_text()
                items.append(l.strip()[2:])
            elif items:
                items[-1] += " " + l.strip()
            else:
                flush_items()
                text_buf.append(l.strip())
        flush_text()
        flush_items()

        if note:
            body = out[start:]
            del out[start:]
            out.append(f'<div class="note"><div class="note-title">{esc(note.group(1))}</div>'
                       + "\n".join(body) + "</div>")
    return "\n".join(out)


def parse(path):
    s = path.read_text(encoding="utf-8")
    cls = path.stem
    key = cls.replace("Theory", "").lower()

    head = re.search(r"/\*\*(.*?)\*/\s*public class", s, re.S)
    lines = doc_lines(head.group(1))
    title_idx = next(i for i, l in enumerate(lines) if TITLE_RE.match(l))
    title = TITLE_RE.match(lines[title_idx]).group(1)
    intro = next((l for l in lines[title_idx + 1:] if l.strip()), "")

    groups, practice, cur_group = [], "", None
    started = False
    for l in lines:
        if l.strip() in ("Contents", "Содержание"):
            started = True
            continue
        if not started or not l.strip():
            continue
        if l.startswith(("Practice:", "Практика:")):
            practice = l
            continue
        m = re.match(r"\s+(\d+)\.\s+(.*)", l)
        if m:
            cur_group["items"].append((int(m.group(1)), m.group(2)))
        else:
            cur_group = {"name": l.strip(), "items": []}
            groups.append(cur_group)

    body = s[head.end():]
    sections = []
    last_end = 0
    for m in re.finditer(r"/\*\*\n(.*?)\n\s*\*/\n\s*static void \w+\(\) \{\n(.*?)\n    \}\n", body, re.S):
        dl = doc_lines(m.group(1))
        num, name = re.match(r"(\d+)\.\s+(.*)", dl[0]).groups()
        code = [l[8:] if l.startswith("        ") else l.strip() for l in m.group(2).split("\n")]
        sections.append({"n": int(num), "title": name, "text": dl[1:], "code": code})
        last_end = m.end()

    # comments left after the last method belong to the last section
    tail = [l.strip() for l in body[last_end:].split("\n") if l.strip().startswith("//")]
    if tail and sections:
        sections[-1]["code"] += [""] + tail

    return {"key": key, "cls": cls, "title": title, "intro": intro, "groups": groups,
            "practice": practice, "sections": sections}


def render_topic(t, lang):
    k = t["key"]
    ui = UI[lang]
    out = [f'<div class="l-{lang}">',
           f'<h1>{esc(t["title"][0].upper() + t["title"][1:])}</h1>',
           f'<p class="lead">{esc(t["intro"])}</p>',
           f'<nav class="card contents"><h2>{ui["contents"]}</h2><div class="cols">']
    for g in t["groups"]:
        out.append(f'<div class="group"><h4>{esc(g["name"])}</h4><ol>')
        for n, name in g["items"]:
            out.append(f'<li value="{n}"><a href="#{k}-{n}">{inline(name)}</a></li>')
        out.append("</ol></div>")
    out.append("</div>")
    if t["practice"]:
        out.append(f'<p class="practice">{esc(t["practice"])}</p>')
    out.append("</nav>")

    for g in t["groups"]:
        out.append(f'<h2 class="group-title">{esc(g["name"])}</h2>')
        wanted = {n for n, _ in g["items"]}
        for sec in t["sections"]:
            if sec["n"] not in wanted:
                continue
            out.append(f'<section class="card" data-id="{k}-{sec["n"]}">')
            out.append(f'<h3>{sec["n"]}. {inline(sec["title"])}</h3>')
            out.append(render_text(sec["text"], k))
            code = "\n".join(sec["code"]).strip("\n")
            if code.strip():
                out.append(f'<div class="code"><button class="copy" type="button" data-copy="{ui["copy"]}" '
                           f'data-copied="{ui["copied"]}">{ui["copy"]}</button>'
                           f"<pre><code>{highlight(code, k)}</code></pre></div>")
            out.append("</section>")
    out.append("</div>")
    return "\n".join(out)


PAGE = """<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Java cheat sheet</title>
<style>
:root {
  --bg: #f7f7f5; --card: #ffffff; --text: #1f2328; --muted: #656d76; --border: #e4e4df;
  --accent: #2563eb; --code-bg: #efeeea; --inline-bg: #eeede9;
  --kw: #8250df; --type: #0a6e8a; --str: #0a7d3e; --num: #b35900; --com: #7a828b;
}
@media (prefers-color-scheme: dark) {
  :root:not([data-theme="light"]) {
    --bg: #14161a; --card: #1c1f24; --text: #e6e8eb; --muted: #9aa3ad; --border: #2c3138;
    --accent: #6ea0ff; --code-bg: #12141a; --inline-bg: #2a2e35;
    --kw: #c297ff; --type: #5fd0e8; --str: #6fdc9a; --num: #ffb766; --com: #7f8a96;
  }
}
:root[data-theme="dark"] {
  --bg: #14161a; --card: #1c1f24; --text: #e6e8eb; --muted: #9aa3ad; --border: #2c3138;
  --accent: #6ea0ff; --code-bg: #12141a; --inline-bg: #2a2e35;
  --kw: #c297ff; --type: #5fd0e8; --str: #6fdc9a; --num: #ffb766; --com: #7f8a96;
}
* { box-sizing: border-box; }
body { margin: 0; background: var(--bg); color: var(--text);
  font: 16px/1.55 -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif; }
header { position: sticky; top: 0; z-index: 5; background: var(--card); border-bottom: 1px solid var(--border); }
.bar { max-width: 1040px; margin: 0 auto; padding: 0 16px; display: flex; align-items: center; gap: 20px; }
.brand { font-weight: 700; padding: 12px 0; white-space: nowrap; flex: none; }
.tabs { display: flex; gap: 4px; overflow-x: auto; min-width: 0; scrollbar-width: none; }
.tabs::-webkit-scrollbar { display: none; }
.tabs a, .subtabs a { padding: 12px 10px; color: var(--muted); text-decoration: none; white-space: nowrap; border-bottom: 2px solid transparent; }
.tabs a:hover, .subtabs a:hover { color: var(--text); }
.tabs a.active, .subtabs a.active { color: var(--accent); border-bottom-color: var(--accent); }
.subbar { border-top: 1px solid var(--border); background: var(--bg); }
.subbar.hidden { display: none; }
.subtabs { display: none; gap: 4px; overflow-x: auto; min-width: 0; scrollbar-width: none; }
.subtabs.on { display: flex; }
.subtabs a { padding: 8px 10px; font-size: 14px; }
main { max-width: 900px; margin: 0 auto; padding: 24px 16px 64px; }
h1 { margin: 8px 0 4px; font-size: 28px; }
.lead { color: var(--muted); margin: 0 0 20px; }
h2 { font-size: 20px; margin: 0 0 12px; }
.group-title { margin: 36px 0 12px; font-size: 22px; }
.card { background: var(--card); border: 1px solid var(--border); border-radius: 10px; padding: 16px 20px; margin: 0 0 14px; }
.card h3 { margin: 0 0 8px; font-size: 18px; }
.card p { margin: 0 0 10px; }
.card ul { margin: 0 0 10px; padding-left: 22px; }
.card li { margin: 2px 0; }
.contents .cols { columns: 2 280px; column-gap: 32px; }
.group { break-inside: avoid; margin-bottom: 14px; }
.group h4 { margin: 0 0 4px; font-size: 15px; }
.group ol { margin: 0; padding-left: 26px; }
.group li { margin: 3px 0; }
.group a { color: var(--accent); text-decoration: none; }
.group a:hover { text-decoration: underline; }
.practice { color: var(--muted); font-size: 14px; margin: 8px 0 0; }
.note { border-left: 4px solid var(--accent); background: var(--inline-bg); border-radius: 6px; padding: 10px 16px; margin: 0 0 12px; }
.note-title { font-weight: 700; font-size: 13px; text-transform: uppercase; letter-spacing: .04em; color: var(--accent); margin-bottom: 4px; }
.note p, .note ul { margin-bottom: 6px; } .note ul { margin-top: 4px; }
.xref { color: var(--accent); text-decoration: none; border-bottom: 1px dotted var(--accent); }
.xref:hover { border-bottom-style: solid; }
code { font: 0.9em ui-monospace, SFMono-Regular, Menlo, Consolas, monospace; background: var(--inline-bg);
  padding: 1px 5px; border-radius: 4px; }
.code { position: relative; margin: 10px 0 2px; }
.code pre { margin: 0; background: var(--code-bg); border-radius: 8px; padding: 14px 16px; }
.code pre code { background: none; padding: 0; font-size: 13.5px; line-height: 1.5; white-space: pre-wrap; overflow-wrap: anywhere; }
pre.plain { background: var(--code-bg); border-radius: 8px; padding: 12px 16px; white-space: pre-wrap; overflow-wrap: anywhere; margin: 0 0 10px;
  font: 13.5px/1.5 ui-monospace, SFMono-Regular, Menlo, Consolas, monospace; }
.copy { position: absolute; top: 8px; right: 8px; font: 12px inherit; padding: 3px 8px; cursor: pointer;
  background: var(--card); color: var(--muted); border: 1px solid var(--border); border-radius: 6px; opacity: 0; transition: opacity .15s; }
.code:hover .copy, .copy:focus { opacity: 1; }
.t-kw { color: var(--kw); } .t-type { color: var(--type); } .t-string { color: var(--str); }
.t-number { color: var(--num); } .t-comment { color: var(--com); font-style: italic; }
footer { max-width: 900px; margin: 0 auto; padding: 0 16px 32px; color: var(--muted); font-size: 13px; }
.js .topic { display: none; } .js .topic.active { display: block; }
html:not([lang="ru"]) .l-ru, html[lang="ru"] .l-en { display: none; }
.lang { margin-left: auto; flex: none; display: flex; gap: 2px; padding: 8px 0; }
.lang button { font: 600 13px inherit; padding: 4px 9px; cursor: pointer; background: none; color: var(--muted);
  border: 1px solid var(--border); }
.lang button:first-child { border-radius: 6px 0 0 6px; } .lang button:last-child { border-radius: 0 6px 6px 0; }
.lang button.active { background: var(--accent); border-color: var(--accent); color: #fff; }
section { scroll-margin-top: 110px; }
</style>
</head>
<body>
<header><div class="bar">
  <div class="brand">Java cheat sheet</div>
  <div class="tabs">
__TABS__
  </div>
  <div class="lang"><button type="button" data-lang="ru">RU</button><button type="button" data-lang="en">EN</button></div>
</div>
<div class="subbar"><div class="bar">
__SUBTABS__
</div></div></header>
<main>
__TOPICS__
</main>
<footer>
<span class="l-en">__FOOTER_EN__</span><span class="l-ru">__FOOTER_RU__</span>
</footer>
<script>
document.documentElement.classList.add("js");
const topics = [...document.querySelectorAll(".topic")];
const groupTabs = [...document.querySelectorAll(".tabs a")];
const subtabs = [...document.querySelectorAll(".subtabs")];
const subbar = document.querySelector(".subbar");
let lang = "en";
try { lang = localStorage.getItem("lang") || ""; } catch (e) {}
if (lang !== "ru" && lang !== "en") lang = (navigator.language || "").toLowerCase().startsWith("ru") ? "ru" : "en";
function setLang(l) {
  lang = l;
  document.documentElement.lang = l;
  document.querySelectorAll(".lang button").forEach(b => b.classList.toggle("active", b.dataset.lang === l));
  try { localStorage.setItem("lang", l); } catch (e) {}
}
document.querySelectorAll(".lang button").forEach(b => b.addEventListener("click", () => {
  setLang(b.dataset.lang);
  route();
}));
function route() {
  const h = decodeURIComponent(location.hash.slice(1));
  let key = h.split("-")[0];
  if (!topics.some(t => t.dataset.key === key)) key = topics[0].dataset.key;
  topics.forEach(t => t.classList.toggle("active", t.dataset.key === key));
  const group = topics.find(t => t.dataset.key === key).dataset.group;
  groupTabs.forEach(a => a.classList.toggle("active", a.dataset.group === group));
  let hasSub = false;
  subtabs.forEach(st => {
    const on = st.dataset.group === group;
    st.classList.toggle("on", on);
    if (on) hasSub = true;
    st.querySelectorAll("a").forEach(a => a.classList.toggle("active", a.dataset.key === key));
  });
  subbar.classList.toggle("hidden", !hasSub);
  const target = h.includes("-") ? document.querySelector('.l-' + lang + ' [data-id="' + h + '"]') : null;
  if (target) target.scrollIntoView(); else window.scrollTo(0, 0);
}
window.addEventListener("hashchange", route);
setLang(lang);
route();
document.querySelectorAll(".copy").forEach(b => b.addEventListener("click", async () => {
  const text = b.parentElement.querySelector("code").innerText;
  try { await navigator.clipboard.writeText(text); b.textContent = b.dataset.copied; }
  catch (e) { b.textContent = "Ctrl+C"; }
  setTimeout(() => b.textContent = b.dataset.copy, 1500);
}));
</script>
</body>
</html>
"""


def cap(t):
    return t[0].upper() + t[1:]


def main():
    data = {}
    for lang, folder in SRC.items():
        files = {p.stem: p for p in folder.glob("*Theory.java")}
        data[lang] = {n: parse(files[n]) for n in files}
    TOPIC_KEYS.update(d["key"] for d in data["en"].values())
    known = [n for g in GROUPS for n in g[3]]
    extra = sorted(n for n in data["en"] if n not in known)
    groups = [(k, e, r, [n for n in ns if n in data["en"]]) for k, e, r, ns in GROUPS]
    if extra:
        groups.append(("other", "Other", "Другое", extra))
    groups = [g for g in groups if g[3]]
    names = [n for g in groups for n in g[3]]
    group_of = {n: g[0] for g in groups for n in g[3]}

    def label(en_text, ru_text):
        return f'<span class="l-en">{esc(en_text)}</span><span class="l-ru">{esc(ru_text)}</span>'

    tabs, subtabs = [], []
    for gkey, gen, gru, gnames in groups:
        first = data["en"][gnames[0]]["key"]
        tabs.append(f'    <a href="#{first}" data-group="{gkey}">{label(gen, gru)}</a>')
        if len(gnames) > 1:
            links = "".join(
                f'<a href="#{data["en"][n]["key"]}" data-key="{data["en"][n]["key"]}">'
                f'{label(cap(data["en"][n]["title"]), cap(data["ru"].get(n, data["en"][n])["title"]))}</a>'
                for n in gnames)
            subtabs.append(f'  <div class="subtabs" data-group="{gkey}">{links}</div>')

    topics = []
    for n in names:
        en = data["en"][n]
        ru = data["ru"].get(n, en)
        topics.append(f'<div class="topic" data-key="{en["key"]}" data-group="{group_of[n]}">\n'
                      f'{render_topic(en, "en")}\n{render_topic(ru, "ru")}\n</div>')

    page = (PAGE.replace("__TABS__", "\n".join(tabs)).replace("__SUBTABS__", "\n".join(subtabs)).replace("__TOPICS__", "\n".join(topics))
            .replace("__FOOTER_EN__", UI["en"]["footer"]).replace("__FOOTER_RU__", UI["ru"]["footer"]))

    OUT.parent.mkdir(exist_ok=True)
    OUT.write_text(page, encoding="utf-8")
    ok = True
    for n in names:
        en, ru = data["en"][n], data["ru"].get(n)
        if ru is None:
            print(f"{n}: NO RUSSIAN VERSION")
            ok = False
            continue
        en_nums = [sec["n"] for sec in en["sections"]]
        ru_nums = [sec["n"] for sec in ru["sections"]]
        listed = sum(len(g["items"]) for g in en["groups"])
        bad = en_nums != ru_nums or listed != len(en_nums)
        ok = ok and not bad
        print(f"{n}: {len(en_nums)} sections" + ("   <-- en/ru or contents mismatch!" if bad else ""))
    print(f"Written {OUT.relative_to(ROOT)}" + ("" if ok else "  (with problems, see above)"))


if __name__ == "__main__":
    main()
