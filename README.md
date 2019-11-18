# classroom-manager-webservices

## Requirements ##

* JDK 8
* apache maven

## Building ##

Spring boot was used for deploying the app

```
git clone https://github.com/alexocv/classroom-manager-webservices.git
mvn spring-boot:run
```

## Services ##
Serivecs  consists of :

```
GET
Get all students and classes
http://localhost:8080/class/ 
http://localhost:8080/student/

GET by id
http://localhost:8080/class/{id}/
http://localhost:8080/student/{id}/

GET students
http://localhost:8080/class/{id}/students/

Get classes
http://localhost:8080/student/{id}/classes/



POST
Creates new resources
POST http://localhost:8080/class/ 
{
  "title": "Math",
  "description": "Advanced Math"
}
POST http://localhost:8080/student/
{
  "firstName": "Alex",
  "lastName": "Velasco"

}

DELETE by id
http://localhost:8080/class/{id}/
http://localhost:8080/student/{id}/

```

## Notes ##
* Use H2 in memory data base
* Spring boot as base project


## Bugs ##
* Need to fix JSON recursively created

## License ##

The content here is licensed under the [MIT License](https://opensource.org/licenses/MIT)


