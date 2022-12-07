# Online bookstore

## Running the application

### Requirements
- Maven
- Java 17

### How to start it

Clone the repository, navigate to that folder, open the terminal and run `mvn spring-boot:run`

## API documentation

`http://localhost:8080/api/books`

### POST

Initiating a `POST` call on this endpoint adds a book to the database, which is run in memory.

An example payload JSON object to try:
```
{
    "barcode": 9780812224696,
    "name": "A Medieval Life: Cecilia Penifader and the World of English Peasants Before the Plague",
    "author": "Judith M. Bennett",
    "quantity": 81,
    "pricePerUnit": 19.99
}
```

### PUT

Initiating a `PUT` method call on this endpoint edits a record in the database, based the barcode.

An example payload JSON object to try:
```
{
    "barcode": 9780812224696,
    "name": "A Medieval Life: Cecilia Penifader and the World of English Peasants Before the Plague",
    "author": "Judith M. Bennett",
    "quantity": 20,
    "pricePerUnit": 19.99
}
```
> Changes the quantity from 81 to 20.

### GET

Executing a `GET` call on this endpoint retrieves all the existing book records from the database.

The application is seeded with records by default, so a call on this link would return these values:

```
[
    {
        "barcode": 9780486220437,
        "name": "The Merry Adventures of Robin Hood",
        "author": "Howard Pyle",
        "quantity": 57,
        "pricePerUnit": 12.99,
        "releaseYear": "1883"
    },
    {
        "barcode": 9786099619002,
        "name": "Silkė, Menkė Ir Banginis: Ir maži gali būti galingi",
        "author": "Jón Baldvin Hannibalsson",
        "quantity": 10,
        "pricePerUnit": 14.99
    },
    {
        "barcode": 9780300216103,
        "name": "The Hundred Years War: A People's History",
        "author": "David Green",
        "quantity": 1,
        "pricePerUnit": 11.99
    },
    {
        "barcode": 9781617298691,
        "name": "Spring Start Here: Learn what you need and learn it well",
        "author": "Laurentiu Spilca",
        "quantity": 1,
        "pricePerUnit": 36.99,
        "scienceIndex": 10
    }
]
```
<br />

`http://localhost:8080/api/books/{barcode}`

### GET

Calling the endpoint using the `GET` method will return the book you are looking for, based on the barcode present in the URL.

So, initiating such a call like this from the client `http://localhost:8080/api/books/9780486220437` will return you this exact result:

```
{
    "barcode": 9780486220437,
    "name": "The Merry Adventures of Robin Hood",
    "author": "Howard Pyle",
    "quantity": 57,
    "pricePerUnit": 12.99,
    "releaseYear": "1883"
}
```
<br />

`http://localhost:8080/books/{barcode}/total-price`

### GET

Returns a particular book's total price, as a result of multiplying the quantity by the price.

Running this line `http://localhost:8080/api/books/9786099619002/total-price` in your client of choice will return:

`149.90`
