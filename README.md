# Automated Till Checkout System

## About this project
This software has been designed as my assignment submission for my COMP2000 Software Engineering 2 (Object-Oriented Software Engineering with Design Patterns) module in my second year at University. The assignment specification was to create a standalone Java software piece following the MVC pattern as well as at least __two__ other design patterns. It must also provide a GUI for user usage.
<br />
<br />
The software must contain the following:
#### ___Stock Database___
* The stock database must support admin accounts for access
* Admin users require a username and password to access the database
* Upon login, the system will highlight any stock which has fallen below it's minimum stock level for re-ordering
* Admin's can send orders for new stock
* Admin's can log delivery of new stock and stock levels will reflect changes
#### ___Kiosk User Interface___
* Allow the user to scan a code on items and find the item in the stock database.
* Upon payment, update the stock database to reflect the reduction of items.
* Must display the current scanned items with the item's names and prices, as well as the total running price for all.
#### ___Payment Screen___
* Customers are able to pay by either card or cash
* Cash payment amount can be entered and it will calculate then display any change required
* Card payments require a verification screen that displayes either an "Accept" or "Deny" message from their bank
#### ___Receipt___
* The receipt requires a printout of all item names and prices, the total price, and the payment method
* If cash was used to pay, print the change amount
* Receipt display ***must*** be in a seperate GUI panel
* Threading must be used to inject the receipt data into the panel and output like standard receipts
* Receipt must include company name, date, and the information listed above
* The receipt should be generated after the thread has fnished processing the receipt data

## Author
Kieran Wheatley

## External resources used
*To be added as/when used*
