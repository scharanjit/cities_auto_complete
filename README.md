# cities_auto_complete



**Build the project**

mvn clean install


**How to run the project**

mvn spring-boot:run


**API**


1.) http://localhost:8080/suggest_cities?start=Kot&atmost=5

```
{
    message: "Here is the list",
    status: 200,
    response: [
        "Kotagudibanda B.O",
        "Kothur Venkatapuram B.O",
        "Kotakonda B.O",
        "Kothapalem B.O",
        "Kotabailu B.O"
    ]
}

```

2.) http://localhost:8080/suggest_cities?start=Kot&atmost=2

```
{
    message: "Here is the list",
    status: 200,
    response: [
        "Kotagudibanda B.O",
        "Kothur Venkatapuram B.O"
    ]
}

```


3.) http://localhost:8080/suggest_cities?start=kot&atmost=6

```
{
    message: "Here is the list",
    status: 200,
    response: [
         "Kotagudibanda B.O",
        "Kothur Venkatapuram B.O",
        "Kotakonda B.O",
        "Kothapalem B.O",
        "Kotabailu B.O",
        "Kotakadapalle B.O"
    ]
}

```

4.) http://localhost:8080/suggest_cities?start=&atmost=6

```

{
    message: "Empty String",
    status: 404,
    response: [ ]
}

```

5.) http://localhost:8080/suggest_cities?start=abc&atmost=5

```

{
    message: "No city starting with string abc found",
    status: 404,
    response: [ ]
}

```
