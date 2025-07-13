# ETL Weather module
This is simple ETL module for extraction weather data from [open-meteo.com](https://open-meteo.com)
Data for ETL process should be represented in JSON like this one

[JSON from API of open-meteo](https://api.open-meteo.com/v1/forecast?latitude=55.0344&longitude=82.9434&daily=sunrise,sunset,daylight_duration&hourly=temperature_2m,relative_humidity_2m,dew_point_2m,apparent_temperature,temperature_80m,temperature_120m,wind_speed_10m,wind_speed_80m,wind_direction_10m,wind_direction_80m,visibility,evapotranspiration,weather_code,soil_temperature_0cm,soil_temperature_6cm,rain,showers,snowfall&timezone=auto&timeformat=unixtime&wind_speed_unit=kn&temperature_unit=fahrenheit&precipitation_unit=inch&start_date=2025-05-16&end_date=2025-05-30)

## Architecture

![Architecture](assets/Architecture.svg)

## Requirements

Docker version 25.0.3+

## Building

To build this project in directory run 

```
docker compose build
```

## Quick Start

This module runs in docker environment, so after starting it, there's 4 basic commands available for
user.

### Usage

1. After building start container by using command 
```
docker compose up
```
2. After fully starting the container you can use the module by using next commands:
- ```
  docker compose exec etl java -jar /app/target/Weather_ETL-1.0-SNAPSHOT.jar apiToPostgres [optional date interval]
  ```
  Example: 
  - ```
    docker compose exec etl java -jar /app/target/Weather_ETL-1.0-SNAPSHOT.jar apiTopostgres
    ```
  - ```
    docker compose exec etl java -jar /app/target/Weather_ETL-1.0-SNAPSHOT.jar apiTopostgres &start_date=2025-05-16&end_date=2025-05-30
    ```
- ``` 
  docker compose exec etl java -jar /app/target/Weather_ETL-1.0-SNAPSHOT.jar apiToCsv [optional date interval]
  ```
  Example: 
    - ```
      docker compose exec etl java -jar /app/target/Weather_ETL-1.0-SNAPSHOT.jar apiToCsv
      ```
    - ```
      docker compose exec etl java -jar /app/target/Weather_ETL-1.0-SNAPSHOT.jar apiToCsv &start_date=2025-05-16&end_date=2025-05-30
      ```
- ``` 
  docker compose exec etl java -jar /app/target/Weather_ETL-1.0-SNAPSHOT.jar jsonToPostgres json_file
  ```
  Example:
    - ```
      docker compose exec etl java -jar /app/target/Weather_ETL-1.0-SNAPSHOT.jar jsonToPostgres /app/input/haha.json
      ```
- ``` 
  docker compose exec etl java -jar /app/target/Weather_ETL-1.0-SNAPSHOT.jar jsonToCsv json_file
  ```
  Example:
    - ```
      docker compose exec etl java -jar /app/target/Weather_ETL-1.0-SNAPSHOT.jar jsonToCsv /app/input/haha.json
      ```

Remember, that when specifying json-file it either should be somehow mapped into container, 
or it should be placed in directory `input` in this project or subdirectories before building. 
And specified json_file should be written as absolute path to file on in docker-container 
file system.

## Configuration

You can configure PostgreSQL database by configuring Docker_ETL_Module/postgres.env file.
Default database name, username and password is `postgres`, `root`, `mypassword` accordingly.
Also, you can configure port, on which PostgreSQL is working by configuring docker-compose.yml file.
Default port is `31477`.

## Result checking

All results from running commands from previous sections can bee seen in file 
`result/weather_result.csv` or in `weather.weather_aggregated_data` table in `postgres` database 
of PostgreSQL.