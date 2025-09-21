

📇 Contact Manager (Spring Boot + Thymeleaf + PostgreSQL)
📌 Description

This project is a simple Contact Manager web application built with the latest Spring Boot framework.
It demonstrates Clean Architecture principles using Thymeleaf for the frontend, MyBatis for database interaction, and PostgreSQL as the database.

The application provides an interface where users can input contact details through a web form.
When the user clicks Save, the data is persisted into the PostgreSQL database.
Static assets such as CSS & JavaScript are included to enhance the UI and interactivity.

🚀 Features

Add new contacts via a web form

Save data into PostgreSQL using MyBatis

Responsive UI with Thymeleaf + CSS (Flowbite + custom styles)

Clean Architecture design with Controller → Service → Repository → Database separation

Easily extensible for future CRUD operations (Update, Delete, List, Search)

🛠️ Tech Stack

Spring Boot (Latest Version)

Thymeleaf (UI templating engine)

PostgreSQL (Database)

MyBatis (Database mapper)

Flowbite CSS + Custom CSS/JS (Frontend styling and interactivity)

📂 Project Structure

src/
├── main/
│   ├── java/
│   │   └── com/example/contactmanager/
│   │       ├── config/        # Configuration classes (DB, MyBatis, etc.)
│   │       ├── controller/    # Web controllers (Thymeleaf / REST)
│   │       │   └── ContactController.java
│   │       ├── service/       # Service layer (business logic)
│   │       │   ├── ContactService.java
│   │       │   └── impl/
│   │       │       └── ContactServiceImpl.java
│   │       ├── repository/    # Data access layer (MyBatis Mappers)
│   │       │   └── ContactMapper.java
│   │       ├── model/         # Domain models (Entities / DTOs)
│   │       │   └── Contact.java
│   │       └── Application.java   # Spring Boot entry point
│   │
│   ├── resources/
│   │   ├── mapper/            # MyBatis XML mapping files
│   │   │   └── ContactMapper.xml
│   │   ├── templates/         # Thymeleaf templates
│   │   │   └── contact_form.html
│   │   ├── static/            # Static resources (CSS, JS, Images)
│   │   │   ├── css/
│   │   │   │   └── style.css
│   │   │   ├── js/
│   │   │   │   └── script.js
│   │   ├── application.properties # Spring Boot configuration
│   │   └── schema.sql         # Database schema (PostgreSQL)
│   │
└── test/                      # Unit & Integration tests

📧 Contact

Email: ponchannarith@gmail.com

Tel: 098 232 478
