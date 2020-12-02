TRAVIS_PULL_REQUEST ?= false
TRAVIS ?= false
FLAVOR ?= Staging
BUILD_TYPE ?= Debug
GRADLEARGS ?= --build-cache

ifeq ($(TRAVIS), true)
  ifeq ($(TRAVIS_PULL_REQUEST), false)
    # Branch [release] build
    GRADLEARGS +=
    FLAVOR = Production
    BUILD_TYPE = Release
  else
    # Pull request build
    GRADLEARGS += --build-cache
    FLAVOR = Staging
    BUILD_TYPE = Release
  endif
endif

.PHONY: analysis android-test assemble bundle clean install lint pre-push release report sonarqube unit-test \
upload-coverage all

analysis: unit-test report sonarqube

android-test:
	./gradlew connected${FLAVOR}DebugAndroidTest connectedCheck --console 'plain' ${GRADLEARGS}

assemble:
	./gradlew assemble${FLAVOR}${BUILD_TYPE} --continue --console 'plain' ${GRADLEARGS}

bundle:
	./gradlew bundle${FLAVOR}${BUILD_TYPE} --continue --console 'plain' ${GRADLEARGS}

clean:
	./gradlew clean

install:
	./scripts/install.sh ${FLAVOR} ${BUILD_TYPE}

lint:
	./gradlew lint${FLAVOR}${BUILD_TYPE} lintKotlin detekt --continue --console 'plain' ${GRADLEARGS}

pre-push: lint

release:
	./scripts/release.sh ${FLAVOR} ${BUILD_TYPE}

report:
	./gradlew jacocoTest${FLAVOR}${BUILD_TYPE}UnitTestReport --continue --console 'plain' ${GRADLEARGS}

sonarqube:
	./scripts/sonar-scan.sh ${FLAVOR} ${BUILD_TYPE}

unit-test:
	./gradlew test${FLAVOR}${BUILD_TYPE} --continue --console 'plain' ${GRADLEARGS}

upload-coverage:
	./scripts/upload-coverage.sh ${CODECOV_TOKEN}

all: clean lint assemble bundle unit-test android-test report analysis