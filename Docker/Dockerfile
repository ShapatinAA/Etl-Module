FROM maven:3.8.6-amazoncorretto-17

RUN mkdir app

COPY . /app

RUN cd /app && \
    mvn clean package



