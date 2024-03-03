#VARIABLES
MAIN_DIR=$(pwd)
WEB_CLIENT_DIR=$MAIN_DIR/web-client/
CONTENT_SERVICE_DIR=$MAIN_DIR/content-service/
CONTENT_SERVICE_DB_DIR=$MAIN_DIR/content-service/db

echo $MAIN_DIR
echo $WEB_CLIENT_DIR
echo $CONTENT_SERVICE_DIR

#WEB_CLIENT
cd $WEB_CLIENT_DIR
chmod +x ./buildDockerImage.sh
./buildDockerImage.sh

#CONTENT_SERVICE_DB
cd $CONTENT_SERVICE_DB_DIR
chmod +x ./buildDockerImage.sh
./buildDockerImage.sh

#CONTENT_SERVICE
cd $CONTENT_SERVICE_DIR
chmod +x ./buildDockerImage.sh
./buildDockerImage.sh

cd $MAIN_DIR
docker compose down --remove-orphans
docker-compose up -d

