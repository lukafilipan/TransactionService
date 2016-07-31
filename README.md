# TransactionService
N26 Coding Challenge

# Synopsis

The project was created as a Maven project using the Jersey framework for RESTful implementation. 
Data is stored in a HashMap which acts as a database, creating Key-Value pairs for each entry. 

# Testing

Testing was done with an Apache Tomcat Server 8.0 and Postman standalone app.
Once the project is running on the server, enter GET http://localhost:8080/transactionservice/transaction in the address bar in Postman. 

This is the default GET request which returns a JSON file with all the entries currently in the "Database". As per specification, the id is not shown as part of the JSON entry. Two entries are hard-coded into the service for testing purposes. 

Returning a specific transaction is done by requesting GET /transactionservice/transaction/$id, where $id is a long value. The returned output is a single JSON entry containing the value from the "Database" whose key matches the $id parameter.

Adding a new transaction uses the PUT method on the same /transactionservice/transaction/$id resource. The body parameter in Postman needs to be of the format specified in the documentation. If the Id doesn't conflict with a value in the HashMap, it will return a "status":ok JSON object, otherwise it wil return "status":failed.

GET /transactionservice/sum/$id returns a JSON object containing a single "sum" value which responds to the total amount of transactions linked to the specific parent_id defined in the $id.

GET /transactionservice/type/$type returns a JSON object containing a list of ids corresponding to keys of the entries in the HashMap which share the same type as specified in the $type parameter.

Update and Delete aren't implemented, but can easily be added.

The postman request collection can be downloaded here: https://www.dropbox.com/s/nusi1r90upgpajn/TransactionService.postman_collection.json?dl=0

# Analysis

The TransactionService class serves as a Data Access Object to manipulate the faux database, namely the HashMap. 

For the functions getAllTransactions(), getTransaction() and addTransaction(), we can assume a complexity of O(1). This is due to the fact that the Java HashMap get/put operations which the functions consist of usually have a complexity of O(1). Only in rare situations, the worst case scenario can be O(log n), as of JDK 8.

The remaining functions getAmountByParentId() and getTransactionsByType() traverse through the entire HashMap to collect data, and as such have a complexity of O(n). 


# Built with

* Eclipse Neon
* Apache Tomcat 8.0
* Apache Maven
* Jersey Framework
