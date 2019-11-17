.PHONY: clean assemble bundle unit-test report all

clean:
	./gradlew clean

lint:
	./gradlew lintRelease

assemble:
	./gradlew assembleRelease

bundle:
	./gradlew bundleRelease

unit-test:
	./gradlew testDebug

report:
	./gradlew testDebugUnitTest jacocoTestReport

all: clean assemble bundle unit-test report