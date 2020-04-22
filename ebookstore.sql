CREATE TABLE books (
  BookID int(11) Primary Key,
  BookName varchar(50),
  AuthorName`varchar(50),
  Categories`varchar(50),
  Price float,
  status varchar(10),
  amount int(11)
)
CREATE TABLE customers (
  CusID int(11) Primary Key,
  CusName varchar(50),
  Address varchar(50),
  email varchar(50),
  phone varchar(10),
  birthday datetime
)
CREATE TABLE orderdetails (
  OrderID int(11) Primary Key,
  CusID int(11),
  BookID int(11),
  price float,
  amount int(11)
)
CREATE TABLE orderstatus(
  OrderID int(11) Primary Key,
  status int(11)
)

INSERT INTO books VALUES
(1, 'harry potter1', 'J. K. Rowling1', 'mystery', 20.5, 'true', 10),
(2, 'harry potter2', 'J. K. Rowling2', 'novel', 17.5, 'true', 20),
(3, 'harry potter3', 'J. K. Rowling3', 'detective', 14.5, 'no', 30),
(4, 'harry potter4', 'J. K. Rowling4', 'fiction', 19.5, 'no', 40),
(5, 'harry potter5', 'J. K. Rowling5', 'technology', 22.5, 'true', 50);
INSERT INTO customers VALUES
(1, 'trương thanh tú', 'huế', 'truongthanhtu@gmail.com', '123456789', '2020-05-14 00:00:00'),
(2, 'nguyễn đình hiếu', 'vinh', 'nguyendinhhieu@gmail.com', '123456987', '2020-04-13 00:00:00'),
(3, 'phạm thanh tùng', 'hà nội', 'phamthanhtung@gmail.com', '123654789', '2020-03-12 00:00:00'),
(4, 'nhữ hoàng minh đức', 'hà nội', 'nhuhoangminhduc@gmail.com', '321456789', '2020-02-11 00:00:00'),
(5, 'nguyễn văn thuận', 'việt nam', 'nguyenvanthuan@gmail.com', '987654321', '2020-01-10 00:00:00');
INSERT INTO orderdetails VALUES
(1, 1, 2, 20.123, 2),
(2, 1, 3, 19.654, 3),
(3, 2, 1, 21.215, 4),
(4, 2, 4, 15.543, 5),
(5, 3, 5, 65.511, 1),
(6, 5, 5, 11.215, 6),
(7, 4, 2, 91.121, 8);
INSERT INTO orderstatus VALUES
(1, 5),
(2, 4),
(3, 3),
(4, 2),
(5, 1),
(6, 0);
