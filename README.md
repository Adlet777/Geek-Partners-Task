# Geek Partners - задание "Очередь"

### Тлеубай Адлет
### Запуск
1) для того чтобы локально создать уже готовую бд для проекта можно из корневой папки проекта запустить: 
````
 docker-compose up
````
2) либо локально создать postgresSQL базу с такими данными: 
````
    user: user
    password: password
    database: postgres
    url: jdbc:postgresql://localhost:5432/postgres
````
3) для миграции данных испольовался FlyWay
4) файл с заданием можно найти в корневой папке проекта
5) в application.yml в строчках 
````
    url: jdbc:postgresql://localhost:5432/postgres
````
вслучае если docker запущен не на localhost нужно указать тот порт, на которм запущен docker
