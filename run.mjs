#!/usr/bin/env node
import fs from "fs";
import path from "path";
import { spawnSync } from "child_process";
import { fileURLToPath } from "url";

const ROOT = path.resolve(path.dirname(fileURLToPath(import.meta.url)));

function rangerRoot() {
  const fromEnv = process.env.RANGER_ROOT;
  if (fromEnv && fs.existsSync(path.join(fromEnv, "bin/output.js"))) {
    return path.resolve(fromEnv);
  }
  for (const dir of [path.resolve(ROOT, "../ranger"), "/agent/repos/ranger"]) {
    if (fs.existsSync(path.join(dir, "bin/output.js"))) return dir;
  }
  return null;
}

const ranger = rangerRoot();
if (!ranger) {
  console.error("No Ranger compiler. Set RANGER_ROOT or clone terotests/ranger as a sibling.");
  process.exit(1);
}

const outDir = path.join(ROOT, "bin");
fs.mkdirSync(outDir, { recursive: true });
const lib = [
  path.join(ranger, "compiler/Lang.rgr"),
  path.join(ranger, "lib/stdops.rgr"),
].join(":");

const compile = spawnSync(
  process.execPath,
  [
    path.join(ranger, "bin/output.js"),
    "-es6",
    path.join(ROOT, "StormHello.rgr"),
    `-d=${outDir}`,
    "-o=StormHello.js",
    "-nodecli",
  ],
  { cwd: ranger, env: { ...process.env, RANGER_LIB: lib }, stdio: "inherit" }
);
if (compile.status !== 0) process.exit(compile.status || 1);

const run = spawnSync(process.execPath, [path.join(outDir, "StormHello.js")], {
  cwd: ROOT,
  stdio: "inherit",
});
process.exit(run.status || 0);
