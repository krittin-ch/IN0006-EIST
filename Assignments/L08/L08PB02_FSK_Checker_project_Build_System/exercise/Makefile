# DO NOT CHANGE THIS FILE! TESTS WILL ALMOST DEFINITELY FAIL!
# Should be replaced with Bazel(Bazelisk) path in the docker image once it is extended. Placeholder for now
BAZEL := bazel
TARGET := fsk_checker
MOVIE := movie
DATEOFBIRTH := date_of_birth

all: build run

build:
	$(BAZEL) build //:$(TARGET)

run:
	$(BAZEL)-bin/$(TARGET)

deps:
	$(BAZEL) query --notool_deps --nohost_deps --noimplicit_deps "deps($(TARGET))" --output graph

deps_movie:
	$(BAZEL) query --notool_deps --nohost_deps --noimplicit_deps "deps($(MOVIE))" --output graph

deps_date_of_birth:
	$(BAZEL) query --notool_deps --nohost_deps --noimplicit_deps "deps(//src/main/java/math:$(DATEOFBIRTH))" --output graph

clean:
	$(BAZEL) clean

.PHONY: all build run clean
