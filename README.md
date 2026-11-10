# Java cheat sheets

Cheat sheets and practice tasks for the main Java topics.

**Website:** https://vladimir-tl.github.io/cheat-sheet-java/

## Theory page

Online: https://vladimir-tl.github.io/cheat-sheet-java/ (GitHub Pages, published from `docs/` on `main`;
it updates a minute or two after a push).
Locally: open [`docs/index.html`](docs/index.html) in a browser (double click, no server needed).
It has a tab per topic, a table of contents, numbered sections with code and an **RU / EN** language switch
(the choice is remembered; by default it follows the browser language).

The page is generated from the theory files, so edit the theory there and rebuild:

- English: `src/main/java/org/tl/theory/*Theory.java`
- Russian: `src/main/java/org/tl/theory/ru/*Theory.java` (same file names, same sections and code, translated text and comments)

The two versions must have the same numbered sections; the script reports a mismatch.

```bash
python3 scripts/build_docs.py
```

Requires Python 3, no extra packages. Commit the updated `docs/index.html` together with the theory.
The header shows only high-level groups (Loops, Conditions, Arrays, Warm-up, Collections, Types, Stream API);
the topics of the chosen group are in a second row.
When you add a new topic, create `*Theory.java` in both folders and add its name to a group in `GROUPS` in
`scripts/build_docs.py` (otherwise it goes to the group "Other").

The Java cheat sheets, tasks and solutions have English comments only; the language switch applies to the theory page.

## Structure

```
src/main/java/org/tl/
  theory/                      theory in the style of a cheat sheet: contents + numbered sections
    ForTheory, WhileTheory, IfElseTheory, SwitchTheory, ArrayTheory, ListTheory, SetTheory, MapTheory, StreamTheory, PrimitivesAndWrappersTheory, WarmupTheory
    ru/                        the same files in Russian
  loops/
    forloop/                   ForCheatSheet, ForTasks, ForSolutions
    whileloop/                 WhileCheatSheet, WhileTasks, WhileSolutions
  conditions/
    ifelse/                    IfElseCheatSheet, IfElseTasks, IfElseSolutions
    switchcase/                SwitchCheatSheet, SwitchTasks, SwitchSolutions
  arrays/                      ArrayCheatSheet, ArrayTasks, ArraySolutions
  collections/
    list/                      ListCheatSheet, ListTasks, ListSolutions
    set/                       SetCheatSheet, SetTasks, SetSolutions
    map/                       MapCheatSheet, MapTasks, MapSolutions
  streams/                     StreamCheatSheet, StreamTasks, StreamSolutions
  types/                       PrimitivesAndWrappersCheatSheet
  warmup/                      WarmupCheatSheet, WarmupTasks, WarmupSolutions (LeetCode-easy style)
docs/index.html                theory page (generated)
scripts/build_docs.py          generator of the theory page
```

Every topic has the same files:

| File                | What it is                                                                |
|---------------------|---------------------------------------------------------------------------|
| `*Theory`           | Theory with a table of contents. Read it, nothing to run.                 |
| `*CheatSheet`       | Runnable code examples with comments.                                     |
| `*Tasks`            | Practice tasks as small support tickets of an online music store: empty methods that you implement. |
| `*Solutions`        | Solutions. Look only after you have tried.                                |

## Requirements

- JDK 17 or newer (checked with JDK 21). switch expressions need Java 14+.

## How to run

### In IntelliJ IDEA

1. Open the project folder (it is a Gradle project, IDEA imports it automatically).
2. Open a file, for example `ForCheatSheet.java`.
3. Click the green arrow next to `public static void main` and choose **Run**.

### From the terminal

Compile everything once:

```bash
javac -d out $(find src/main/java -name '*.java')
```

Run any class that has `main` by its full name:

```bash
java -cp out org.tl.loops.forloop.ForCheatSheet
java -cp out org.tl.loops.whileloop.WhileCheatSheet
java -cp out org.tl.conditions.ifelse.IfElseCheatSheet
java -cp out org.tl.conditions.switchcase.SwitchCheatSheet
java -cp out org.tl.arrays.ArrayCheatSheet
java -cp out org.tl.collections.list.ListCheatSheet
java -cp out org.tl.collections.set.SetCheatSheet
java -cp out org.tl.collections.map.MapCheatSheet
java -cp out org.tl.streams.StreamCheatSheet
java -cp out org.tl.types.PrimitivesAndWrappersCheatSheet
```

## How to practice

1. Read the theory in `org.tl.theory`.
2. Run the cheat sheet and play with the examples.
3. Open `*Tasks.java`, implement the methods and check them in its `main`
   (call your method and print the result).
4. Compare with `*Solutions.java`.

The `*Theory` classes are snippets to read, they have no `main`.
To try a snippet, copy it into a `main` method.
