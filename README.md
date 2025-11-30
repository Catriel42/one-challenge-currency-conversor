# ONE Challenge - Currency Converter

![Java](https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=openjdk)
![Maven](https://img.shields.io/badge/Built%20with-Maven-red?style=for-the-badge&logo=apache-maven)
![Gson](https://img.shields.io/badge/Gson-2.13.2-blue?style=for-the-badge&logo=google)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)


This project is a simple command-line application for currency conversion, developed as part of the "ONE Challenge - Java - Back end" program. It allows users to convert amounts between different currencies using real-time exchange rates from the ExchangeRate-API.

## Features

- **Real-time Currency Conversion:** Converts an amount from one currency to another.
- **Dynamic Exchange Rates:** Fetches the latest exchange rates from an external API.
- **Interactive CLI:** A simple and interactive command-line interface to guide the user.
- **Conversion History Logging:** Automatically logs each currency conversion performed by the user into a file named `conversion_history.txt` in the project's root directory.

## How to Run

1.  **Clone the repository:**
    
    With HTTPS protocol:
    ```bash
    git clone https://github.com/your-username/one-challenge-currency-conversor.git
    cd one-challenge-currency-conversor
    ```
    
    With SSH protocol:

    ```bash
    git clone git@github.com:your-username/one-challenge-currency-conversor.git
    cd one-challenge-currency-conversor
    ```

2.  **Get an API Key:**
    - Sign up at [ExchangeRate-API](https://www.exchangerate-api.com/) to get a free API key, you need to create an account.

3.  **Configure the API Key:**
    - Create a file named `config.properties` inside the `src/main/resources/` directory.
    - You can use `src/main/resources/config.properties.example` as a template.
    - Open `config.properties` and replace `your_api_key` with your actual API key obtained from ExchangeRate-API.
    - **Important:** Ensure `config.properties` is added to your `.gitignore` file to prevent committing your API key to version control.

4.  **Build the project:**
    - You need Maven installed. Run the following command from the project's root directory:
    ```bash
    mvn clean package
    ```

5.  **Run the application:**
    ```bash
    java -jar target/one-challenge-currency-conversor-1.0-SNAPSHOT.jar
    ```

## Technologies Used

- **Java 17**
- **Maven**
- **Google Gson:** For parsing JSON responses from the API.

# DEMO!

https://github.com/user-attachments/assets/4c6b8977-7599-4210-9c79-74b3cafdcd00


Enjoy!

---
