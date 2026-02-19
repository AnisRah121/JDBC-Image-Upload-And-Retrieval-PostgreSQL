# JDBC Image Upload and Fetch using PostgreSQL

This project demonstrates how to:

- Insert image into PostgreSQL database
- Fetch image from database
- Save retrieved image back to system

## Technologies Used
- Java
- JDBC
- PostgreSQL
- pgAdmin

## Database Table

CREATE TABLE image_table (
    id SERIAL PRIMARY KEY,
    image_data BYTEA
);

## How It Works

1. Reads image using FileInputStream
2. Converts image into byte array
3. Stores in PostgreSQL using PreparedStatement
4. Retrieves image using SELECT query
5. Writes image using FileOutputStream

## Author
Anis
