# Contact Book Application

A simple Contact Book web application built with Spring Boot, Spring Data JPA, Thymeleaf, Validation, and PostgreSQL.

## Features

- Add contacts
- View all contacts
- Search by name, phone, or email
- Edit contacts
- Delete contacts
- Form validation
- PostgreSQL persistence
- Responsive HTML/CSS UI

## Requirements

- Java 27
- Maven 3.9+ (or use your IDE's Maven support)
- PostgreSQL

## PostgreSQL setup

Create the database:

```sql
CREATE DATABASE contact_book;
```

The application expects these defaults:

- Host: localhost
- Port: 5432
- Database: contact_book
- Username: postgres
- Password: postgres

If your PostgreSQL username/password is different, update `src/main/resources/application.properties`, or use environment variables:

```text
DB_URL=jdbc:postgresql://localhost:5432/contact_book
DB_USERNAME=postgres
DB_PASSWORD=your_password
```

Hibernate will create/update the `contacts` table automatically because `spring.jpa.hibernate.ddl-auto=update` is enabled.

## Run

From the project root:

```bash
mvn spring-boot:run
```

Or run `ContactDetailsApplication.java` from IntelliJ IDEA / VS Code.

Then open:

```text
http://localhost:8080
```

## Project structure

```text
src/main/java/com/campus/contact_details/
├── controller/
│   └── ContactController.java
├── entity/
│   └── Contact.java
├── exception/
│   ├── ContactNotFoundException.java
│   └── GlobalExceptionHandler.java
├── repository/
│   └── ContactRepository.java
├── service/
│   └── ContactService.java
└── ContactDetailsApplication.java

src/main/resources/
├── static/
│   └── css/
│       └── style.css
├── templates/
│   ├── index.html
│   ├── contacts.html
│   ├── add-contact.html
│   ├── edit-contact.html
│   └── error.html
└── application.properties
```
