# Sales Taxes Problem

This project is intended to solve the Sales Taxes Problem. 


Problem Description
-------------------

Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions. When I purchase items, I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax. Write an application that prints out the receipt details for these shopping baskets: 
 
INPUTS:

	Input 1:
	1 book at 12.49
	1 music CD at 14.99
	1 chocolate bar at 0.85
				
	Input 2:
	1 imported box of chocolates at 10.00
	1 imported bottle of perfume at 47.50
		
	Input 3:
	1 imported bottle of perfume at 27.99
	1 bottle of perfume at 18.99
	1 packet of headache pills at 9.75
	1 box of imported chocolates at 11.25

OUTPUTS:

	Output 1:
	1 book : 12.49
	1 music CD: 16.49
	1 chocolate bar: 0.85
	Sales Taxes: 1.50
	Total: 29.83
		
	Output 2:
	1 imported box of chocolates: 10.50
	1 imported bottle of perfume: 54.65
	Sales Taxes: 7.65
	Total: 65.15
		
	Output 3:
	1 imported bottle of perfume: 32.19
	1 bottle of perfume: 20.89
	1 packet of headache pills: 9.75
	1 imported box of chocolates: 11.85
	Sales Taxes: 6.70
	Total: 74.68

Solution
-------------------
For each input data, the application loads the shopping list items, calculates the total cost and sales taxes, and prints out the receipt details.

Assumptions
-------------------
- Every input data must be placed in a separated text file, containing multiple items to be processed.
- Every line item in the input data must respect the following pattern: "**quantity imported name** at **value**"
  - "**quantity**" is an integer greater than zero.
  - "**imported**" is an optional key name to indicate weather or not the item is imported.
  - "**name**" is the description of the item.
  - "**value**" is a non-negative double representing it's unit price.
- The application can only recognize the items specified in the problem description.
  
Project Structure
-------------------
The source code is structered in three main packages, based on the different domains of the application:

- **Products:** represents the items that can be found in the store shelf.
  - **Product**: an abstract class which represents all products.
  - **BookProduct, FoodProduct, MedicalProduct, MiscellaneousProduct**: implementations of the different kinds of products. They differ on the tax rate associated with them.
  - **ProductType**: enum responsible for determining the type of the product.
  - **ProductFactory**: responsible for creating the products based on their type.
  
- **Billing**: relates to the receipt generation
  - **PaymentCounter**: handles the receipt generation given a list of products.
  - **TaxCalculator**: responsible for calculating the tax value of a product.
  - **Receipt**: represents a receipt, containing the list of products, total cost, and tax values.
  - **TaxType**: represents the different types of taxes. 

- **Shopping**: responsible for processing the input data and converting it to the application structure
  - **ShoppingStore**: singleton representing the store application. It delegates the order processing and receipt generation to other classes. 
  - **StoreShelf**: responsible for managing which items are available in the application. 
  - **OrderReader**: abstract class that reads the input files and returns the corresponding order list.
  - **FileOrderReader**: extends the OrderReader class, reading the input data from a text file.
  - **ProductNotAvailableException**: represents an exception when the product name is not recognized by the application

Tests
-------------------
The test files are placed under the "test" directory, with the same structure as the source files.

Input Files
-------------------
The input files are in the "input-files" folder in the root directory.

Run Instructions
-------------------
The Main class runs the application for each input text file.

Dependencies
-------------------
- Java JDK 10
- JUnit 5
