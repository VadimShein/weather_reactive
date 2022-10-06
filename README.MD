[![Build Status](https://travis-ci.org/VadimShein/weather_reactive.svg?branch=master)](https://travis-ci.org/VadimShein/weather_reactive)


# <p align="center">Приложение прогноз погоды</p>
Приложение показывает прогноз погоды. 
Работает в режиме реактивного программирования.


## Используемые технологии:
* Java 13
* Spring Boot
* WebFlux


## Запросы для Curl
1. Показать погоду во всех городах
```
curl -X GET http://localhost:8080/all
```

2. Показать погоду с наибольшей температурой 
```
curl -X GET http://localhost:8080/hottest
```

3. Показать погоду по id города
```
curl -X GET http://localhost:8080/get/1
```

4. Показать погоду больше указанной температуры
```
curl -X GET http://localhost:8080/cityGreatThen/13
```

## Сборка проекта:
```
mvn clean package -DskipTests
```


## Контакты:
[![alt-text](https://img.shields.io/badge/-telegram-grey?style=flat&logo=telegram&logoColor=white)](https://t.me/SheinVadim)
[![alt-text](https://img.shields.io/badge/@%20email-005FED?style=flat&logo=mail&logoColor=white)](mailto:shein.v94@mail.ru)
