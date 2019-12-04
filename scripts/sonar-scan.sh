#!/usr/bin/env bash

set -o pipefail

FLAVOR="${1-Production}"
BUILD_TYPE="${2-Release}"

REPO_DIR="$( cd "$( dirname "$0" )/../" && pwd )"

${REPO_DIR}/gradlew -p "$REPO_DIR" sonarqube \
 -Dsonar.java.binaries=${REPO_DIR}build/tmp/kotlin-classes/${FLAVOR}${BUILD_TYPE}/ \
  -Dsonar.java.test.binaries=${REPO_DIR}build/tmp/kotlin-classes/${FLAVOR}${BUILD_TYPE}/ \
  -Dsonar.coverage.jacoco.xmlReportPaths=${REPO_DIR}/app/build/reports/jacoco/jacocoTest${FLAVOR}${BUILD_TYPE}UnitTestReport/jacocoTest${FLAVOR}${BUILD_TYPE}UnitTestReport.xml