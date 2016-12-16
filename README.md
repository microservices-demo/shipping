[![Build Status](https://travis-ci.org/microservices-demo/shipping.svg?branch=master)](https://travis-ci.org/microservices-demo/shipping) [![Coverage Status](https://coveralls.io/repos/github/microservices-demo/shipping/badge.svg?branch=master)](https://coveralls.io/github/microservices-demo/shipping?branch=master)
[![](https://images.microbadger.com/badges/image/weaveworksdemos/shipping.svg)](http://microbadger.com/images/weaveworksdemos/shipping "Get your own image badge on microbadger.com")

# shipping
A microservices-demo service that provides shipping capabilities.

This build is built, tested and released by travis.

# Build

## Java

`mvn -DskipTests package`

## Docker

`GROUP=weaveworksdemos COMMIT=test ./scripts/build.sh`

# Test

`./test/test.sh < python testing file >`. For example: `./test/test.sh unit.py`

# Run

`mvn spring-boot:run`

# Check

`curl http://localhost:8080/health`

# Use

`curl http://localhost:8080`

# Push

`GROUP=weaveworksdemos COMMIT=test ./scripts/push.sh`
