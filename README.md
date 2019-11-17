# Android App Template

[![Build Status](https://travis-ci.com/curious-coding/android-app.svg?branch=master)](https://travis-ci.com/curious-coding/android-app)
[![License](https://img.shields.io/dub/l/vibe-d.svg)](https://github.com/curious-coding/android-app/blob/master/LICENSE)
[![ko-fi](https://img.shields.io/badge/donate%20on-Ko--fi-blue.svg)](https://ko-fi.com/U7U4L9F5)

## AndroidX Support

## Travis CI Integration:
- Linting
    - [kotlinter](https://github.com/jeremymailen/kotlinter-gradle)
- Unit testing with coverage report (https://codecov.io)
- Static code analysis
    - Sonar
    - [detekt](https://github.com/arturbosch/detekt)

## Project Level Quality Gate

### Pre-push checks
You can enable pre-push hooks by running: `./gradlew tasks` 
You can add or remove checks by updating the `pre-push` target in the [makefile](Makefile). The following checks are enabled per default:
- linting
- kotlinter
- detekt