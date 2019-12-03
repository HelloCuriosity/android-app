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

.PHONY: clean assemble bundle unit-test report pre-push analysis sonarqube all

clean:
	./gradlew clean

lint:
	./gradlew lint${FLAVOR}${BUILD_TYPE} lintKotlin detekt --continue --console 'plain' ${GRADLEARGS}

assemble:
	./gradlew assemble${FLAVOR}${BUILD_TYPE} --continue --console 'plain' ${GRADLEARGS}

bundle:
	./gradlew bundle${FLAVOR}${BUILD_TYPE} --continue --console 'plain' ${GRADLEARGS}

unit-test:
	./gradlew test${FLAVOR}${BUILD_TYPE} --continue --console 'plain' ${GRADLEARGS}

report:
	./gradlew jacocoTest${FLAVOR}${BUILD_TYPE}UnitTestReport --continue --console 'plain' ${GRADLEARGS}

sonarqube:
	./gradlew sonarqube --continue --console 'plain' ${GRADLEARGS}

analysis: unit-test report sonarqube

pre-push: lint

all: clean lint assemble bundle unit-test report analysis