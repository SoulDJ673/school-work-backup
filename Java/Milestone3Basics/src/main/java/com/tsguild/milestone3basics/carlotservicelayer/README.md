# Car Lot Service Layer Exercise

This was a basic exercise creating a service layer implementation.  There was no provided DAO implementation, and creating one wasn't required.  Because this exercise only dealt with this part of an MVC application, this won't properly compile and execute without extra work.

### This program can do the following:

* Given a VIN, it will get a single Car.

* It will get all the cars, and return them in a List.

* Given a color, it will return all the available cars of that color in a List.

* Given a max Price, it will return all available cars at or under that price.

* Given a VIN and a discount, it will discount the car, and return the price.

* If there is no car that matches, it will throw a NoSuchCarException

* Given a VIN and a cash Amount, it will 'buy' - checking if the price matches, removing the car from the lot, and returning the associated CarKey.

* If they gave too much money, it will throw an OverpaidPriceException

* If they gave too little money, it will throw an UnderpaidPriceException


##### Devin Lloyd