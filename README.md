[west-world-calendar.postman_collection.json](https://github.com/aterati/west-world-calendar/files/15271888/west-world-calendar.postman_collection.json)# West World Calendar API
This is a Rest API developed using Spring boot, H2 database. We can add, edit and view list of countries and holidays under each country.

## Technical Details:

	Spring boot 3.2.5, Java, Gradle, lombok, deployed on embedded Tomcat server.
	
## To run the application:

	In order to run the application, clone the project and run the SpringWebApplication.java class. 
	This is will run the spring boot application and deploy it on the embedded tomcat server on port 8090.

  We are using H2 db to save the data. We can login to H2-console during runtime at - http://localhost:8090/h2-console
	
  Swagger link to check the contracts - http://localhost:8090/swagger-ui/index.html
 

## Postman collection:

Please use the postman collections found at - 

[Uploa{
	"info": {
		"_postman_id": "b4f02231-8031-45a4-ba5e-361a410cbf1e",
		"name": "west-world-calendar",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "275551"
	},
	"item": [
		{
			"name": "localhost:8090/addCountry",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json"
					},
					{
						"key": "Accept-Charset",
						"value": "UTF-8"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\"countryName\":\"us\",\n\"countryCode\":\"US\",\n\"description\":\"United states of America\"\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "localhost:8090/addCountry",
					"host": [
						"localhost"
					],
					"port": "8090",
					"path": [
						"addCountry"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost:8090/getCountries",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": ""
				},
				"url": {
					"raw": "localhost:8090/getCountries",
					"host": [
						"localhost"
					],
					"port": "8090",
					"path": [
						"getCountries"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost:8090/getHolidays",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "localhost:8090/getHolidays",
					"host": [
						"localhost"
					],
					"port": "8090",
					"path": [
						"getHolidays"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost:8090/addHoliday",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json"
					},
					{
						"key": "charset",
						"value": "UTF-8"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\"date\":\"2024-01-01\",\n\"name\":\"New year\",\n\"description\":\"New years eve\",\n\"countryId\": \"1\"\n}"
				},
				"url": {
					"raw": "localhost:8090/addHoliday",
					"host": [
						"localhost"
					],
					"port": "8090",
					"path": [
						"addHoliday"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost:8090/updateCountry/1",
			"request": {
				"method": "PUT",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json"
					},
					{
						"key": "charset",
						"value": "UTF-8"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\"countryName\":\"canada\",\n\"countryCode\":\"canada\",\n\"description\":\"United states of America\"\n}"
				},
				"url": {
					"raw": "localhost:8090/updateCountry/1",
					"host": [
						"localhost"
					],
					"port": "8090",
					"path": [
						"updateCountry",
						"1"
					]
				}
			},
			"response": []
		},
		{
			"name": "localhost:8090/updateHoliday/1",
			"request": {
				"method": "PUT",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json"
					},
					{
						"key": "charset",
						"value": "UTF-8"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\"date\":\"2024-01-01\",\n\"name\":\"Christmas\",\n\"description\":\"New years eve\",\n\"countryId\": \"1\"\n}"
				},
				"url": {
					"raw": "localhost:8090/updateHoliday/1",
					"host": [
						"localhost"
					],
					"port": "8090",
					"path": [
						"updateHoliday",
						"1"
					]
				}
			},
			"response": []
		}
	]
}ding west-world-calendar.postman_collection.json…]()
