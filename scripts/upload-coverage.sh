#!/usr/bin/env bash

set -o pipefail

COVERAGE_TOKEN="${1}"

echo "Uploading Coverage Report"
export CODECOV_TOKEN=${COVERAGE_TOKEN}
bash <(curl -s https://codecov.io/bash)
