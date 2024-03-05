run: build
	docker run -p 8080:8080 calcserver:latest
generate:
	. ./build.sh && generate
compile: generate
	. ./build.sh && compile
build: compile
	docker build . -t calcserver:latest
ide: compile
	. ./build.sh && ide
clean:
	rm -rf ./server