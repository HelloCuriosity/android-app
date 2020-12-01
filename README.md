# Android App Template

[![Build Status](https://travis-ci.com/HelloCuriosity/android-app.svg?branch=master)](https://travis-ci.com/HelloCuriosity/android-app)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=curious-coding_android-app&metric=alert_status)](https://sonarcloud.io/dashboard?id=curious-coding_android-app)
[![codecov](https://codecov.io/gh/HelloCuriosity/android-app/branch/master/graph/badge.svg)](https://codecov.io/gh/HelloCuriosity/android-app)
[![License](https://img.shields.io/dub/l/vibe-d.svg)](https://github.com/curious-coding/android-app/blob/master/LICENSE)
[![ko-fi](https://img.shields.io/badge/donate%20on-Ko--fi-blue.svg)](https://ko-fi.com/U7U4L9F5)

## AndroidX Support

## CI Support:
- Github Actions
- Travis

## CI Integration:
- Linting
    - [kotlinter](https://github.com/jeremymailen/kotlinter-gradle)
    - [rxlint](https://www.littlerobots.nl/blog/RxLint-a-lint-rule-for-RxJava/)
- [Covdecov](https://codecov.io) coverage reports
- Integration tests
    - Run connected / ui tests on an emulator
- Static code analysis
    - Sonar
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
 