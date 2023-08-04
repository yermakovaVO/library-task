
curl --location 'http://localhost:8080/api/v1/authors/1'


curl --location 'http://localhost:8080/api/v1/authors' \
--header 'Content-Type: application/json' \
--data '{
"nickname": "test_9f678f1694c9",
"name": "test_9b343ebb7233",
"surname": "test_556b58d84e83",
"midname": "test_e2379bf76b71"
}'

curl --location --request PUT 'http://localhost:8080/api/v1/authors/1' \
--header 'Content-Type: application/json' \
--data '{
"id":1,
"nickname": "test_9f678f1694c9",
"name": "test_9b343ebb7233",
"surname": "111",
"midname": "test_e2379bf76b71"
}'


-- books
curl --location 'http://localhost:8080/api/v1/books' \
--data ''

curl --location 'http://localhost:8080/api/v1/books?page=2&size=5' \
--data ''

curl --location 'http://localhost:8080/api/v1/books?page=0&size=2&author=1' \
--data ''

curl --location 'http://localhost:8080/api/v1/books?page=0&size=2&authorId=4&genreId=3' \
--data ''



curl --location --request DELETE 'http://localhost:8080/api/v1/books/1' \
--data ''


curl --location 'http://localhost:8080/api/v1/books' \
--header 'Content-Type: application/json' \
--data '{
"id": 20,
"name": "Преступление и наказание",
"year": "2023-08-04",
"authors": [
3
],
"genres": [
2,
3
]
}'
