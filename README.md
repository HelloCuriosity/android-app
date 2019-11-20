# Android App Template

[![Build Status](https://travis-ci.com/curious-coding/android-app.svg?branch=master)](https://travis-ci.com/curious-coding/android-app)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=curious-coding_android-app&metric=alert_status)](https://sonarcloud.io/dashboard?id=curious-coding_android-app)
[![codecov](https://codecov.io/gh/curious-coding/android-app/branch/master/graph/badge.svg)](https://codecov.io/gh/curious-coding/android-app)
[![License](https://img.shields.io/dub/l/vibe-d.svg)](https://github.com/curious-coding/android-app/blob/master/LICENSE)
[![ko-fi](https://img.shields.io/badge/donate%20on-Ko--fi-blue.svg)](https://ko-fi.com/U7U4L9F5)

## AndroidX Support

## Travis CI Integration:
- Linting
    - [kotlinter](https://github.com/jeremymailen/kotlinter-gradle)
- [Covdecov](https://codecov.io) coverage reports
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
You can add or remove checks by updating the `pre-push` target in the [makefile](Makefile). The following checks are enabled per default:
- linting
- kotlinter
- detekt

## App Signing

### On Travis CI
Add your `storePassword` and `keyPassword` as an environment variable in Travis to enable app signing:
- `storePassword` env -> `KEYSTORE_PASSWORD`
- `keyPassword` env -> `KEY_PASSWORD`

### Local Signing
You can use the [release.sh](/scripts/release.sh) script to sign your apks or aabs.
`./scripts/release.sh`
