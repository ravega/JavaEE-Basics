# JavaEE-Basics

This basic Java EE example uses MySQL as DB and will be better deployed within an ear file.

Database name: tbdatabase
Database Table: messages_t

+---------+-------------+------+-----+---------+----------------+
| Field   | Type        | Null | Key | Default | Extra          |
+---------+-------------+------+-----+---------+----------------+
| id      | int(5)      | NO   | PRI | NULL    | auto_increment |
| message | varchar(50) | YES  |     | NULL    |                |
+---------+-------------+------+-----+---------+----------------+

Web access: http://localhost:8080/MView/home.xhtml
