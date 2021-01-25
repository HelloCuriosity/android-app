#!/usr/bin/env bash

set -o pipefail

FLAVOR="${1-Production}"
BUILD_TYPE="${2-Release}"
PLAY_PUBLISH_PASSWORD=$3

# Start publishing
echo "Publishing App for ${FLAVOR}${BUILD_TYPE}"

REPO_DIR="$( cd "$( dirname "$0" )/../" && pwd )"

# Verify repo is clean
if [[ $(git status 2> /dev/null | tail -n1) != "nothing to commit, working tree clean" ]]; then
  echo "Working directory dirty. Please revert or commit."
  exit 1
fi

# Verify decrypting password
if [[ -z "${PLAY_PUBLISH_PASSWORD}" ]]; then
	echo "No password given. Abort"
	exit 1
fi

# Create Google Play json for publishing
echo "Creating Google Play Publish json"
./scripts/decrypt.sh android-template-302820-bc106506c0aa.json.aes-256-cbc.enc.b64 \
    android-template-302820-bc106506c0aa.json ${PLAY_PUBLISH_PASSWORD}

# Publish
${REPO_DIR}/gradlew -p "$REPO_DIR" publish${FLAVOR}${BUILD_TYPE}Bundle --info
