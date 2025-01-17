# Automated Till Checkout System

## About this project
This software has been designed as my assignment submission for my COMP2000 Software Engineering 2 (Object-Oriented Software Engineering with Design Patterns) module in my second year at University. The assignment specification was to create a standalone Java software piece following the MVC pattern as well as at least __two__ other design patterns. It must also provide a GUI for user usage.
<br />
<br />
The software must contain the following:
#### ___Stock Database___
* The stock database must support admin accounts for access:heavy_check_mark:
* Admin users require a username and password to access the database:heavy_check_mark:
* Upon login, the system will highlight any stock which has fallen below it's minimum stock level for re-ordering:heavy_check_mark:
* Admin's can send orders for new stock:heavy_check_mark:
* Admin's can log delivery of new stock and stock levels will reflect changes:heavy_check_mark:
#### ___Kiosk User Interface___
* Allow the user to scan a code on items and find the item in the stock database.:heavy_check_mark:
* Upon payment, update the stock database to reflect the reduction of items.:heavy_check_mark:
* Must display the current scanned items with the item's names and prices, as well as the total running price for all.:heavy_check_mark:
#### ___Payment Screen___
* Customers are able to pay by either card or cash:heavy_check_mark:
* Cash payment amount can be entered, and it will calculate then display any change required:heavy_check_mark:
* Card payments require a verification screen that displays either an "Accept" or "Deny" message from their bank:heavy_check_mark:
#### ___Receipt___
* The receipt requires a printout of all item names and prices, the total price, and the payment method:heavy_check_mark:
* If cash was used to pay, print the change amount:heavy_check_mark:
* Receipt display ***must*** be in a separate GUI panel:heavy_check_mark:
* Threading must be used to inject the receipt data into the panel and output like standard receipts:heavy_check_mark:
* Receipt must include company name, date, and the information listed above:heavy_check_mark:
* The receipt should be generated after the thread has finished processing the receipt data:heavy_check_mark:
## Using the application
The usage of the program itself is rather straightforward. You can select a product from the stock list and add it or you can use the "Scan Barcode" button to randomly select a product from the Stocks list.
To use the admin section, there are currently two logins:
* Username: sysadmin | password: adminpassword
* Username: a | password: a (*this was used for quick access during development, and I've left it in, so it's easier for anyone using to remember.)*

The project does not currently have a working .jar file due to issues with IntelliJ. I hope to add one after the assignment has been marked but for now, the program will only run in IntelliJ.

Project SDK required: 1.8

## Author
Kieran Wheatley

## External resources used
* **Barcode Scanner Beep** - Can be found [here](https://freesound.org/people/kalisemorrison/sounds/202530/)
* **Receipt Printer Sound** - Can be found [here](https://freesound.org/people/azumarill/sounds/345057/)    *(Note: Clip length was reduced and volume lowered)*
