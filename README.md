[![Build Status](https://travis-ci.org/microservices-demo/shipping.svg?branch=master)](https://travis-ci.org/microservices-demo/shipping)
[![Coverage Status](https://coveralls.io/repos/github/microservices-demo/shipping/badge.svg?branch=master)](https://coveralls.io/github/microservices-demo/shipping?branch=master)

# shipping

A microservices-demo service that provides shipping capabilities.

This build is built, tested and released by travis.

# Test

`./test/test.sh < python testing file >`. For example: `./test/test.sh
unit.py`

# Build

`GROUP=weaveworksdemos COMMIT=test ./scripts/build.sh`

# Push

`GROUP=weaveworksdemos COMMIT=test ./scripts/push.sh`

## Redesign

This microservices will shortly go through a redesign to allow for
multi-step checkouts. A rough sketch of the flow is below:

![Orders flow](./Orders-flow.png)
