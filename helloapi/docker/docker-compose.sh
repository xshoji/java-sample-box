#!/bin/bash

COMMAND_SUB=${1:-up}
DOCKER_COMPOSE_YML=${2:-docker-compose.yml}

EXECUTE_DIR="$(cd $(dirname ${BASH_SOURCE:-$0}) && pwd)"
. ${EXECUTE_DIR}/config.sh

case "$COMMAND_SUB" in
  up )
    docker-compose -f ${PROJECT_DIR}/${DOCKER_COMPOSE_YML} up -d --build
    ;;

  down )
    docker-compose -f ${PROJECT_DIR}/${DOCKER_COMPOSE_YML} down
    ;;

  start )
    docker-compose -f ${PROJECT_DIR}/${DOCKER_COMPOSE_YML} start
    ;;

  stop )
    docker-compose -f ${PROJECT_DIR}/${DOCKER_COMPOSE_YML} stop
    ;;

  status )
    ;;

  * )
    echo ""
    echo "parameter allow up|down|status."
    exit 1
esac

echo ""
docker-compose -f ${PROJECT_DIR}/${DOCKER_COMPOSE_YML} ps
echo ""
echo "Success!!"

