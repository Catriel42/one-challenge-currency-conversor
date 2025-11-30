# ONE Challenge - Currency Converter
<div>

![Java](https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=openjdk)
![Maven](https://img.shields.io/badge/Built%20with-Maven-red?style=for-the-badge&logo=apache-maven)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

</div>

This project is a simple command-line application for currency conversion, developed as part of the "ONE Challenge - Java - Back end" program. It allows users to convert amounts between different currencies using real-time exchange rates from the ExchangeRate-API.

## Features

- **Real-time Currency Conversion:** Converts an amount from one currency to another.
- **Dynamic Exchange Rates:** Fetches the latest exchange rates from an external API.
- **Interactive CLI:** A simple and interactive command-line interface to guide the user.

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
    - Sign up at [ExchangeRate-API](https://www.exchangerate-api.com/) to get a free API key.

3.  **Configure the API Key:**
    - The application expects the API key to be hardcoded in `src/main/java/com/catodev/App.java`. Open this file and replace the placeholder with your actual key.

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

Enjoy!

---
