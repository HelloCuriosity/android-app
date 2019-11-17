.PHONY: clean assemble bundle unit-test report pre-push all

clean:
	./gradlew clean

lint:
	./gradlew lintRelease lintKotlin detekt --continue --console 'plain'

assemble:
	./gradlew assembleRelease --continue --console 'plain'

bundle:
	./gradlew bundleRelease --continue --console 'plain'

unit-test:
	./gradlew testDebug --continue --console 'plain'

report:
	./gradlew jacocoTestDebugUnitTestReport --continue --console 'plain'

pre-push: lint

all: clean assemble bundle unit-test report