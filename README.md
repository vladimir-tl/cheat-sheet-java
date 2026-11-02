# Java cheat sheets

Cheat sheets and practice tasks for the main Java topics.

## Structure

```
src/main/java/org/tl/
  theory/                      theory in the style of a cheat sheet: contents + numbered sections
    ForTheory, WhileTheory, ListTheory, MapTheory, PrimitivesAndWrappersTheory
  loops/
    forloop/                   ForCheatSheet, ForTasks, ForSolutions
    whileloop/                 WhileCheatSheet, WhileTasks, WhileSolutions
  collections/
    list/                      ListCheatSheet, ListTasks, ListSolutions
    map/                       MapCheatSheet, MapTasks, MapSolutions
  types/                       PrimitivesAndWrappersCheatSheet
```

Every topic has the same files:

| File                | What it is                                                                |
|---------------------|---------------------------------------------------------------------------|
| `*Theory`           | Theory with a table of contents. Read it, nothing to run.                 |
| `*CheatSheet`       | Runnable code examples with comments.                                     |
| `*Tasks`            | Practice tasks: empty methods that you implement.                         |
| `*Solutions`        | Solutions. Look only after you have tried.                                |

## Requirements

- JDK 17 or newer (checked with JDK 21)

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
java -cp out org.tl.collections.list.ListCheatSheet
java -cp out org.tl.collections.map.MapCheatSheet
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
