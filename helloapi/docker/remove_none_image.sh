#!/bin/bash

EXECUTE_DIR=`dirname $0`
. ${EXECUTE_DIR}/config.sh

NONE_IMAGE=`docker images -f "dangling=true" -q`
if [[ $NONE_IMAGE ]]; then
  docker images -f "dangling=true" -q | xargs docker rmi -f
fi

echo ""
docker images
