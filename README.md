# BankBridge: Your Complete Banking Management System

BankBridge is a powerful banking management system that makes use of Java SWING graphical interfaces and a robust MySQL database. It is designed to handle all data and records related to bank accounts and customers, with a wide range of features for customers, bankers, and administrators.

Customers can easily view their account balances and banking accounts linked to them, while bankers have access to all banking accounts in the database and can perform various banking operations such as deposits, withdrawals, and transfers. Administrators have complete control over the system, allowing them to manage both banking accounts and user accounts. They can search through them, modify them, delete them, or add new ones as needed.

## Getting Started with BankBridge

Follow these simple steps to get started with BankBridge:

### Prerequisites

Before you start, make sure that you have the following software installed on your machine:

```
  Java IDE (We recommend IntelliJ IDEA)
  MySQL Workbench (already configured and running server)
```

### Installation

1. Import the bank.sql database schema into your MySQL server.
2. Verify that the values in conf.properties match your local MySQL server configuration.
3. Open the project folder in your preferred IDE.
4. Test the connection to the database from the IDE. If the conf.properties file was configured correctly, you should receive a successful connection message.

## Using BankBridge

Once you have the development environment set up and the project is running, you can start using BankBridge. The following is a quick guide to the system's main features:

### Customer Interface

After logging in (using login: client / pw:1511), customers will have access to the following features:

* View account balances
* View banking accounts linked to their profile

### Banker Interface

After logging in (using login: banker / pw:1511), bankers will have access to the following features:

* View all banking accounts in the database
* Search through banking accounts by account number or customer name or account type
* Perform banking operations such as deposits, withdrawals, and transfers

### Admin Interface

After logging in (using login: admin / pw:1511), administrators will have access to the following features:

* View all banking accounts and user accounts in the database
* Search through banking accounts and user accounts by account number, customer name, or username
* Modify banking accounts and user accounts by double clicking on the columns in the table and then pressing the save button to commit the changes.
* Delete banking accounts and user accounts
* Add new banking accounts and user accounts

That's it! We hope this guide helps you get started with using BankBridge. If you have any questions or encounter any issues, please refer to the documentation or reach out to us for support.

## Built With

BankBridge was built using the following technologies:

* Java SWING - The GUI widget toolkit used
* [JFormDesigner](https://www.formdev.com/) - The Java GUI designer used
* [MySQL](https://www.mysql.com/products/workbench/) - Used for the database management

## Author

BankBridge was created by Yassin Manita, a passionate Computer Science Student, who has put in countless hours to make this project a success. Check out my [LinkedIn](https://tn.linkedin.com/in/yassin-manita12) for more information.

## License

This project is licensed under the MIT License. See the [LICENSE.md](LICENSE.md) file for details.

## Acknowledgments

I would like to thank all the individuals whose code was used, as well as those who provided inspiration and support.
