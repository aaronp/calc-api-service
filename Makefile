run: build
	docker run -p 8080:8080 calcserver:latest
generate:
	. ./build.sh && generate
build: generate
	docker build . -t calcserver:latest