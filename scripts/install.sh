#!/usr/bin/env bash

set -o pipefail

FLAVOR="${1-Production}"
BUILD_TYPE="${2-Release}"

REPO_DIR="$( cd "$( dirname "$0" )/../" && pwd )"

echo "Installing apk for ${FLAVOR}${BUILD_TYPE}"

ARTIFACT=$(echo "app-${FLAVOR}-${BUILD_TYPE}.apk" | tr '[:upper:]' '[:lower:]')

adb install "$REPO_DIR/app/build/outputs/apk/${FLAVOR}/${BUILD_TYPE}/${ARTIFACT}"