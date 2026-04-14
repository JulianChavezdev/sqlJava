📋 Description
--------------

A small shop needs an application to manage its customer database. The system allows for full CRUD operations on customers, as well as advanced filtering, sorting, and statistical queries.

> ⚠️ **Constraint:** Only libraries covered in class may be used.

* * * * *

🗂️ Project Structure
---------------------

```
src/
├── model/
│   └── Cliente.java          # Customer entity POJO
├── dao/
│   └── ClienteDAO.java       # Interface/class containing all data access operations
└── main/
    └── Main.java             # Main class that executes all operations

```

* * * * *

🧩 Entities
-----------

### `Cliente` (Customer)

POJO class representing a shop customer.

| Field | Type | Description |
| --- | --- | --- |
| `id` | `int` | Unique customer identifier |
| `name` | `String` | Customer name |
| `age` | `int` | Customer age |
| `money_spent` | `double` | Total money spent in the shop (€) |
| `products_purchased` | `int` | Total number of products purchased |



* * * * *

⚙️ DAO Operations
-----------------

The `ClienteDAO` implements the following operations:

### Basic CRUD

| # | Method | Description |
| --- | --- | --- |
| 1 | `insertCustomer(Customer c)` | Inserts a new customer |
| 2 | `updateCustomer(int id, ...)` | Updates any customer field (except ID) based on their ID |
| 3 | `deleteCustomer(int id)` | Deletes a customer by their ID |
| 4 | `ogetCustomerById(int id)` | Returns a customer by their ID |
| 5 | `getAllCustomers()` | Returns the full list of customers |



### Filtering Queries

| # | Method | Description |
| --- | --- | --- |
| 6 | `getCustomersOver30()` | Customers older than 30 |
| 7 | `getCustomersSpendingOver500()` | Customers who have spent more than 500 € |
| 8 | `getCustomersOrderBySpending()` | All customers sorted by money spent (highest → lowest) |
| 9 | `getTop3PurchasingCustomers()` | Top 3 customers by number of products purchased |
| 15 | `getCustomersSpendingOver200()` | Customers who spent > 200 €, sorted by products (lowest → highest) |
| 16 | `getYoungestHighSpender()` | The youngest customer who has spent more than 400 € |



### Statistics / Aggregated Queries

| # | Method | Description |
| --- | --- | --- |
| 10 | `getTotalRevenue()` | Total sum of money spent by all customers |
| 11 | `getAverageProductsPurchased()` | Average products purchased per customer |
| 12 | `getAverageSpendingOver25()` | Average money spent by customers > 25 years with > 3 products |
| 13 | `countCustomersSpendingOver100()` | Number of customers who have spent more than 100 € |
| 14 | `countCustomersBetween30And50()` | Number of customers between 30 and 50 years old |



* * * * *

🚀 `Main` Class
---------------

The `Main` class executes **all DAO operations** sequentially.

### Important Considerations

-   For **insertion, update, and deletion** operations, the same `Cliente` object is used for the three consecutive operations.

-   The `Main` class is designed to be **executed multiple times** without the query results varying between runs (query idempotency).

### Suggested Execution Flow

```
1\. Insert test customer
2. Update a field of the inserted customer
3. Delete the updated customer
──────────────────────────────
4. Get customer by ID
5. Get all customers
6. Get customers older than 30
7. Get customers who spent more than 500 €
8. Get customers sorted by money spent
9. Get top 3 by products purchased
10. Get total sum of money spent
11. Get average products purchased
12. Get average money (older than 25 with more than 3 products)
13. Count customers who spent more than 100 €
14. Count customers aged 30 to 50
15. Get customers with > 200 € sorted by products
16. Get the youngest customer with > 400 €

```

* * * * *

🛠️ Technologies
----------------

-   **Language:** Java

-   **Libraries:** Only those covered in class

-   **Design Pattern:** DAO (Data Access Object)
