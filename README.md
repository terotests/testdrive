# testdrive

Minimaalinen Ranger CLI hello world — kääntäjä tulee npm:stä (`ranger-compiler`), ei tarvitse kloonata Ranger-monorepoa.

Perustuu [RangerStarter](https://github.com/terotests/RangerStarter)-malliin.

## Nopea alku

```bash
npm install
npm start              # paikallinen Import → hei maailma
npm run start:remote   # git-dependency pkg:starter → pkg RangerStarter
```

- **Paikallinen import:** `Import "Greeter.rgr"` (`src/Greeter.rgr`).
- **Etäpaketti ilman isoa kloonausta:** `ranger.json` viittaa RangerStarter-repon commitiin; `npm run deps` (tai `start:remote`) hakee lähteen `~/.cache/ranger/packages/` -välimuistiin (~3 MB tälle repolle). Koodissa: `Import "pkg:starter/src/Greeter.rgr"`.

Isommat kirjastot (esim. `lib/evg` Ranger-reposta) toimii samalla `git` + `rev` + `subdir` -mallilla — haetaan vain alihakemisto, ei koko repoa työhakemistoon.
