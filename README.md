# Android App Template

[![codecov](https://codecov.io/gh/HelloCuriosity/android-app/branch/main/graph/badge.svg)](https://codecov.io/gh/HelloCuriosity/android-app)
[![License](https://img.shields.io/dub/l/vibe-d.svg)](https://github.com/curious-coding/android-app/blob/main/LICENSE)
[![ko-fi](https://img.shields.io/badge/donate%20on-Ko--fi-blue.svg)](https://ko-fi.com/U7U4L9F5)

## AndroidX Support

## CI Support:
- Github Actions

## CI Integration:
- Linting
    - [kotlinter](https://github.com/jeremymailen/kotlinter-gradle)
    - [rxlint](https://www.littlerobots.nl/blog/RxLint-a-lint-rule-for-RxJava/)
- [Covdecov](https://codecov.io) coverage reports
- Integration tests
    - Run connected / ui tests on an emulator
- Static code analysis
    - [detekt](https://github.com/arturbosch/detekt)
- Build APKs
- Build Bundles

## Project Level Quality Gate

### LeakCanary
[LeakCanary](https://square.github.io/leakcanary/) is a memory leak detection library for Android.


### Pre-push checks
You can enable pre-push hooks by running: `./gradlew installGitHooks` 
You can add or remove checks by updating the `pre-push` target in the [makefile](Makefile). The following checks are 
enabled per default:
- linting
- kotlinter
- detekt

## App Signing

### On CI
Add your `storePassword` and `keyPassword` as an environment variable on your CI to enable app signing:
- `storePassword` env -> `KEYSTORE_PASSWORD`
- `keyPassword` env -> `KEY_PASSWORD`

### Local Signing
You can use the [release.sh](/scripts/release.sh) script to sign your apks or aabs.
`./scripts/release.sh`

## Tooling
You can use the [install.sh](/scripts/install.sh) script to easily deploy your apks built using the
[release.sh](/scripts/release.sh) script.

## NOTE:
Support for Travis CI has been discontinued respective of the pricing [changes](https://blog.travis-ci.com/2020-11-02-travis-ci-new-billing)
in November 2020. These pricing changes aren't viable for this specific open source project. If you are still interested
in running Travis on a paid plan you can still find an example in [v1.0.0](https://github.com/HelloCuriosity/android-app/releases/tag/v1.0.0)