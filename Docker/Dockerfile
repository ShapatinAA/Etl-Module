FROM maven:3.8.6-amazoncorretto-11 as Build

RUN mkdir app

COPY . /app

RUN cd /app && \
    mvn clean package



