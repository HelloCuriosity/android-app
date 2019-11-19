#!/usr/bin/env bash

# special thanks to nxtstep
# https://github.com/nxtstep/duitsland-nieuws-kotlin/blob/develop/release.sh

set -o pipefail

FLAVOR="${1-Production}"
BUILD_TYPE="${2-Release}"

echo "Create App Apk for ${FLAVOR}${BUILD_TYPE}"

REPO_DIR="$( cd "$( dirname "$0" )/../" && pwd )"

echo "Keystore password: "
read -s KEYSTORE_PASS
if [[ -z "${KEYSTORE_PASS}" ]]; then
	echo "No password given. Abort"
	exit 1
fi
export KEYSTORE_PASSWORD=${KEYSTORE_PASS}

echo "Key (alias) password [return when same]: "
read -s KEYPASS
if [[ -z "${KEYPASS}" ]]; then
	KEYPASS=${KEYSTORE_PASS}
fi
export KEY_PASSWORD=${KEYPASS}

if [[ $(git status 2> /dev/null | tail -n1) != "nothing to commit, working tree clean" ]]; then
  echo "Working directory dirty. Please revert or commit."
  exit 1
fi

set -ex

${REPO_DIR}/gradlew -p "$REPO_DIR" clean assemble${FLAVOR}${BUILD_TYPE} -Dpre-dex=false

open "$REPO_DIR/app/build/outputs/apk/${FLAVOR}/${BUILD_TYPE}/"
