CREATE DATABASE PhoneStore 

go
use PhoneStore 
go 


CREATE TABLE Accounts
(

   UserId INT IDENTITY(1,1) PRIMARY KEY , 
   UserName VARCHAR(20) UNIQUE NOT NULL , 
   UserPassword VARCHAR(20) , 
   UserGmail VARCHAR(50 ) ,
   UserAvatar VARBINARY(MAX) 

) 



CREATE TABLE Phones 
(
   idPhone INT IDENTITY(1,1) PRIMARY KEY,
   namePhone VARCHAR(30) not null ,
   brandPhone VARCHAR(30),
   pricePhone MONEY , 
   quantity INT ,
   operatingSystem VARCHAR(30) ,
   imagePhone VARBINARY(MAX) ,
   descriptionPhone NVARCHAR(50) , 
   statusPhone BIT not null
)


CREATE TABLE Bills
(
    BillId INT IDENTITY(1,1) PRIMARY KEY,
    UserId INT NOT NULL,
    idPhone INT NOT NULL,
    BillDate DATETIME DEFAULT GETDATE(),
    Quantity INT,
    Price MONEY,
    PaymentStatus BIT DEFAULT 0 , 
    TotalAmount AS (Quantity * Price) PERSISTED,
    
    CONSTRAINT FK_Bill_User FOREIGN KEY (UserId) REFERENCES Accounts(UserId),
    CONSTRAINT FK_Bill_Product FOREIGN KEY (idPhone) REFERENCES Phones(idPhone)
)


select * From Accounts 

select * From Phones 

select * From Bills 


INSERT INTO Phones (namePhone, brandPhone, pricePhone, quantity , operatingSystem ,descriptionPhone , statusPhone )
values ('IPhone12' , 'VietNam' , 400000 , 10 , 'IOS', '12GB'  , 1 )



INSERT INTO Accounts (UserName, UserPassword, UserGmail  )
values ('admin' , 'admin' , 'admin@gmail.com')

UPDATE Accounts SET UserName = 'viendeptrai' WHERE UserName = 'viennguyen'

INSERT INTO Bills (UserId, idPhone, BillDate ,Quantity  , Price  , PaymentStatus  )
values (3 , 6, '6-2-2025' , 2 , 400000 , 1 )


delete from Bills

SELECT idPhone, Quantity FROM Bills

SELECT b.BillId, u.UserName, p.namePhone, b.Quantity, b.Price, b.TotalAmount, b.BillDate , b.PaymentStatus
                FROM Bills b
                JOIN Accounts u ON b.UserId = u.UserId
                JOIN Phones p ON b.idPhone = p.idPhone