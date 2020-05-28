docker stop mpdemo && docker rm mpdemo
docker rmi lpf/mpdemo
mvn clean package docker:build
#docker build -t lpf/mpdemo .
docker run --name mpdemo -p 8087:8087 -d --restart=always -t lpf/mpdemo