FROM java:8
EXPOSE 8087

VOLUME /tmp
ADD target/mpdemo.jar /mpdemo.jar
RUN bash -c 'touch /mpdemo.jar'
#ENTRYPOINT ["java","-jar","/app.jar"]
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/mpdemo.jar"]
