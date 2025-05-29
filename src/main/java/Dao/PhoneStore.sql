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
   namePhone VARCHAR(30) UNIQUE not null ,
   brandPhone VARCHAR(30),
   pricePhone MONEY, 
   quantity INT,
   operatingSystem VARCHAR(30),
   imagePhone VARBINARY(MAX),
   descriptionPhone NVARCHAR(50)
)


CREATE TABLE Bills
(
    BillId INT IDENTITY(1,1) PRIMARY KEY,
    UserId INT NOT NULL,
    idPhone INT NOT NULL,
    BillDate DATETIME DEFAULT GETDATE(),
    Quantity INT,
    Price MONEY,
    TotalAmount AS (Quantity * Price) PERSISTED,
    
    CONSTRAINT FK_Bill_User FOREIGN KEY (UserId) REFERENCES Accounts(UserId),
    CONSTRAINT FK_Bill_Product FOREIGN KEY (idPhone) REFERENCES Phones(idPhone)
)


select * From Accounts 

select * From Phones 

select * From Bills 



INSERT INTO Phones (namePhone, brandPhone, pricePhone, quantity , operatingSystem ,descriptionPhone )
values ('ViV1o1211' , 'VietNam' , 400000 , 10 , 'Android', '12GB' )


INSERT INTO Accounts (UserName, UserPassword, UserGmail  )
values ('vien' , 'vien' , 'vien@gmail.com')