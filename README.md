# testdrive — EVG 3.0 Storm from a Ranger app

A minimal Ranger 3.x program that imports the EVG package from a sibling
checkout of [terotests/evg](https://github.com/terotests/evg).

```text
repos/
  evg/          Thunderstruck 2.x + Storm 3.0
  ranger/       Ranger compiler
  testdrive/    this package
```

`ranger.json` names EVG by path (Ranger's gallery still uses a vendor
copy of Storm until this package is on `evg` master):

```json
"evg": { "path": "../evg/storm" }
```

After EVG 3.0 is on `master`, the same import works from Git:

```json
"evg": {
  "git": "https://github.com/terotests/evg.git",
  "rev": "<commit>",
  "subdir": "storm"
}
```

## Run

Needs a Ranger 3.x compiler (`ranger/bin/output.js`):

```bash
node run.mjs
```

That compiles `StormHello.rgr` against `../evg/storm` and prints a display
list. You should see a TEXT command for `"EVG 3.0 Storm"` at 28px.
