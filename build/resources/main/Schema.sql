drop database umuzi; -- dropping a database if exits
create database umuzi; -- creatint the umuzi database

--\l -- list all database
\c umuzi -- connecting to umuzi database

create table customer (
id serial not null primary key,
first_name varchar(50) not null,
last_name varchar(50) not null,
gender varchar(6) not null,
address varchar(200) not null,
phone varchar(20) not null,
email varchar(100),
city varchar(20) not null,
country varchar(50) not null
);
create table employees(
id serial primary key not null,
first_name varchar(50) not null,
last_name varchar(50) not null,
email varchar(100),
job_title varchar(50) not null
);
create table payments(
customer_id bigint references customer(id) unique (customer_id) not null,
payment_id bigint not null,
payment_date date not null,
amount numeric(19,2) not null
);
create table products(
product_id serial not null,
product_name  varchar(100) not null,
description varchar(300) not null,
buy_price numeric(19, 2) not null
);
create table orders(
id serial primary key not null,
product_id bigint references products(product_id) unique (product_id) not null,
payment_id bigint references payments(payment_id) unique(payment_id) not null,
fulfilled_by_employee_id bigint references employees(id) unique (fulfilled_by_employee_id) not null,
date_required date not null,
date_shipped date,
status varchar(20) not null
);

-- Inserting queries into table
insert into customer (first_name,last_name,gender,address,phone,email,city,country) values ('John','Hibert','Male','284 chaucer st','084789657','john@gmail.com','Johannesburg','South Africa');
insert into customer (first_name,last_name,gender,address,phone,email,city,country) values ('Thando','Sithole','Female','240 Sect 1','0794445584','thando@gmail.com','Cape Town','South Africa');
insert into customer (first_name,last_name,gender,address,phone,email,city,country) values ('Leon','Glen','Male','81 Everton Rd,Gillits','0820832830','Leon@gmail.com','Durban','South Africa');
insert into customer (first_name,last_name,gender,address,phone,email,city,country) values ('Charl','Muller','Male','290A Dorset Ecke','+44856872553','Charl.muller@yahoo.com','Berlin','Germany');
insert into customer (first_name,last_name,gender,address,phone,email,city,country) values ('Julia','Stein','Female','2 Wernerring','+448672445058','Js234@yahoo.com','Frankfurt','Germany');

insert into employees (first_name,last_name,email,job_title) values ('Kani','Matthew','mat@gmail.com','manager');
insert into employees (first_name,last_name,email,job_title) values ('Lesly','Cronje','LesC@gmail.com','Clerk');
insert into employees (first_name,last_name,email,job_title) values ('Gideon','Maduku','m@gmail.com','Accountant');

insert into orders (product_id,payment_id,fulfilled_by_employee_id,date_required,status) values (1,1,2,'05-09-2018','Not shipped');
insert into orders (product_id,payment_id,fulfilled_by_employee_id,date_required,date_shipped,status) values (1,2,2,'04-09-2018','04-09-2018','Shipped');
insert into orders (product_id,payment_id,fulfilled_by_employee_id,date_required,status) values (3,3,3,'05-09-2018','Not shipped');

insert into payments (customer_id,payment_id,payment_date,amount) values (1,1,'01-09-2018','150.75');
insert into payments (customer_id,payment_id,payment_date,amount) values (5,2,'03-09-2018','150.75');
insert into payments (customer_id,payment_id,payment_date,amount) values (4,3,'03-09-2018','700.60');

insert into products (product_name,description,buy_price) values ('Harley Davidson Chopper','This replica features working kickstand,front suspension, gear-shift lever','150.75');
insert into products (product_name,description,buy_price) values ('Classic Car','Turnable front wheels, steering function','550.75');
insert into products (product_name,description,buy_price) values ('Sports car','Turnable front wheels, steering function','700.60');




select * from customer;  --SELECT ALL records from table Customers.
select * from employees; --SELECT ALL records from table Employees.
select first_name from customer; --SELECT records only from the name column in the Customers table.
select * from customer where id = 1; --Show the name of the Customer whose CustomerID is 1.
update customer set first_name = 'Lerato' , last_name = 'Mabitso' where id = 1; --UPDATE the record for CustomerID = 1 on the Customer table so that the name is “Lerato Mabitso”.
select * from customer; --SELECT ALL records from table Customers.
delete from customer where id = 2; -- DELETE the record from the Customers table for customer 2 (CustomerID = 2).
select * from customer; --SELECT ALL records from table Customers.
select * from orders; --SELECT ALL records from table Orders.
select distinct , count(*) from orders; \d person--Select all unique statuses from the Orders table and get a count of the number of orders for each unique status.
select * from payments;--SELECT ALL records from table Payments.
select max(amount) from payments; -- Return the MAXIMUM payment made on the PAYMENTS table.
select * from customer order by country; --Select all customers from the “Customers” table, sorted by the “Country” column.
select * from products; -- SELECT ALL records from table Products.
select * from products where buy_price between 100 and 600; --Select all products with a price BETWEEN R100 and R600.
select * from customer where country ='Germany' and city ='Berlin';--Select all fields from “Customers” where country is “Germany” AND city is “Berlin”.
select * from customer where (city = 'Cape Town' or city = 'Durban');--Select all fields from “Customers” where city is “Cape Town” OR “Durban”.
select * from products where buy_price > 500;--Select all records from Products where the Price is GREATER than R500.
select sum(amount) from payments;--Return the sum of the Amounts on the Payments table.
select status , count(*) from orders group by status;--Count the number of shipped orders in the Orders table.
select avg(buy_price), avg(buy_price*12) from products;--Return the average price of all Products, in Rands and in Dollars (assume the exchange rate is R12 to the Dollar).
select  * from customer --Using INNER JOIN create a query that selects all Payments with Customer information.
select * from products where description = 'Turnable front wheels, steering function';--Select all products that have turnable front wheels.



