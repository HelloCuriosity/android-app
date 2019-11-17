.PHONY: clean assemble bundle unit-test report all

clean:
	./gradlew clean

lint:
	./gradlew lintRelease lintKotlin

assemble:
	./gradlew assembleRelease

bundle:
	./gradlew bundleRelease

unit-test:
	./gradlew testDebug

report:
	./gradlew jacocoTestDebugUnitTestReport

all: clean assemble bundle unit-test report