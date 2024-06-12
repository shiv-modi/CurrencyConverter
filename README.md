# Currency Converter App

This Currency Converter app is a simple web application built with Java Servlets and JSP. It fetches real-time exchange rates from the ExchangeRate-API and allows users to convert currencies seamlessly.

## Features

- **Real-time Updates:** Exchange rates are fetched from the API, ensuring accuracy.
- **User-Friendly Interface:** Intuitive design for hassle-free navigation.
- **Robust Integration:** Efficient handling of API calls and error management.

## Tech Stack

- Java Servlets
- JavaServer Pages (JSP)
- ExchangeRate-API

## How to Run

Follow these steps to run the Currency Converter app locally:

1. **Clone the repository:**

    ```bash
    git clone https://github.com/shiv-modi/CurrencyConverter.git
    ```

2. **Navigate to the project directory:**

    ```bash
    cd currency-converter
    ```

3. **Deploy on Apache Tomcat:**

    Ensure you have Apache Tomcat installed on your machine. If not, download and install it from [the official website](https://tomcat.apache.org/).

4. **Build and run the project:**

   - Build the project using a build tool like Maven.
   - Deploy the WAR file to Apache Tomcat's `webapps` directory.
   - Start the Tomcat server.

5. **Access the application:**

   Once the server is running, access the application by navigating to `http://localhost:8080/CurrencyConverter` in your web browser.

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create your feature branch: `git checkout -b feature/my-feature`.
3. Commit your changes: `git commit -am 'Add my feature'`.
4. Push to the branch: `git push origin feature/my-feature`.
5. Submit a pull request.
