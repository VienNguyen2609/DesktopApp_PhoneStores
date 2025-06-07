

CREATE DATABASE PhoneStores


go
use PhoneStores
go



create table Clients(
	idClient INT IDENTITY(1,1) not null primary key,
	nameClient nvarchar(20) not null,
	telClient nvarchar(12) not null unique,
	addressClient nvarchar(50) not null  ,
	gmailClient nvarchar(50)   
)



create table Staffs(
	idStaff INT IDENTITY(1,1) not null primary key,
	nameStaff nvarchar(20) not null unique,
	passwordStaff nvarchar(10) not null , 
	emailStaff nvarchar(50) not null ,
	positionStaff NVARCHAR(50) , 
	statusStaff BIT not null DEFAULT 1,
	avatarStaff VARBINARY(MAX)
)





create table Phones(
	idPhone INT IDENTITY(1,1) not null primary key,
	namePhone nvarchar(30) not null,
	brandPhone nvarchar(30),
	pricePhone money,
	quantityPhone int ,
	operatingSystemPhone VARCHAR(30) ,
	imagePhone VARBINARY(MAX),
	descriptionPhone nvarchar(100),
	statusPhone BIT not null
)

create table Orders(
	idOrder INT IDENTITY(1,1) not null primary key,
	timeOfBookingOrder datetime,
	statusOrder nvarchar(20),
	totalOrder money,
	addressOrder nvarchar(30),
	idClient INT not null,
	idStaff INT not null,
	constraint FK_DH foreign key(idClient) references Clients(idClient),
	constraint FK_NV foreign key(idStaff) references Staffs(idStaff)
)

create table OrderDetails
(
	idOrder INT not null,
	idPhone INT not null,
	quantity int,
	constraint PK primary key(idOrder,idPhone),
	constraint FK_D foreign key(idOrder) references Orders(idOrder),
	constraint FK_S foreign key(idPhone) references Phones(idPhone)
)


select * from Clients 

select * from Staffs


select * from Phones

select * from Orders

select * from OrderDetails


insert into Phones(namePhone , brandPhone , operatingSystemPhone , quantityPhone, pricePhone , descriptionPhone , statusPhone) values 
('IPHONE16' , 'APPLE' , 'IOS' ,20 , 200000 , '521GB-12in-144hz-4K' , 1  ),
('SAMSUNG GALAXY 25' , 'SAMSUNG' , 'ANDROID' ,20 , 15000 , '126GB-10IN-144hz-4K' , 1  ),
('VIVO A10' , 'VIVO' , 'ANDROID' ,20 , 9000 , '64GB-9IN-60HZ-1080HD' , 1  )


insert into Staffs(nameStaff , passwordStaff  , emailStaff  , positionStaff ) 
values 
('admin' , 'admin'  , 'admin@gmail.com' , 'admin')


insert into Staffs( nameStaff, passwordStaff  , emailStaff  , positionStaff ) 
values 
('staff1' , 'staff1'  , 'staff1@gmail.com' , 'employee'),
('staff2' , 'staff2'  , 'staff2@gmail.com' , 'employee')


insert into Clients values
('Viendeptrai' , '0363537601' , 'Ha Noi- VietNam' , 'viendeptrai@gmail.com'),
('thao' , '0963579114' , 'Ha Noi- VietNam' , 'thao@gmail.com')

insert into Orders (statusOrder , totalOrder , idClient , idStaff)
values(  'Confirmed' , 200000.00  , 15 , 15),
(  'Confirmed' , 200000.00  , 15 , 15)



insert into OrderDetails values
(14 , 9 ,  1)


delete From OrderDetails

delete From Orders

delete from Phones

delete From Clients

delete From Staffs

