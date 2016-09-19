FROM java:openjdk-8-alpine

WORKDIR /usr/src/app
COPY *.jar ./app.jar

LABEL org.label-schema.vendor="Weaveworks" \
  org.label-schema.url="https://github.com/microservices-demo/shipping" \
  org.label-schema.name="Socks Shop: Shipping" \
  org.label-schema.version="${RELEASE_VERSION}" \
  org.label-schema.vcs-url="github.com:microservices-demo/shipping.git" \
  org.label-schema.vcs-ref="${COMMIT}" \
  org.label-schema.build-date="${BUILD_DATE}" \
  org.label-schema.docker.schema-version="1.0"

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar","./app.jar", "--port=80"]
