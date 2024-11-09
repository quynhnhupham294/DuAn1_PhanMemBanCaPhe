create database phanMemBanCaPhe
go
USE phanMemBanCaPhe;
GO

CREATE TABLE Customer (
    idCustomer char(4) PRIMARY KEY NOT NULL,
    customerName nvarchar(50) NOT NULL,
	point int,
	phone varchar(20),
	status bit,
    description	nvarchar(50)
);
 
GO

CREATE TABLE [User] (
    idUser char(4) PRIMARY KEY NOT NULL,
    userName nvarchar(50) NOT NULL,
	[password] nvarchar(50),
	phone varchar(10),
	[address] nvarchar(50),
	[description] nvarchar(50),
	idRole BIT
);

GO 

CREATE TABLE ProductType (
    idProductType char(5) PRIMARY KEY NOT NULL,
    productTypeName	nvarchar(50) NOT NULL,
	[description]	nvarchar(50)
);

GO 

CREATE TABLE Product (
    idProduct char(4) PRIMARY KEY NOT NULL,
    productName	nvarchar(50) NOT NULL,
	image nvarchar(50),
	status bit,
	description	nvarchar(50),
	price float,
	idProductType char(5),
    FOREIGN KEY (idProductType) REFERENCES ProductType(idProductType)
);

GO

CREATE TABLE Discount(
    idDiscount	char(4) PRIMARY KEY ,
    dateStart date,
	dateEnd date,
	description	 nvarchar(50),
);

GO

CREATE TABLE [Order] (
    idOrder char(4) PRIMARY KEY ,
	dateTimeOrder datetime,
	description	nvarchar(50),
	idUser char(4),
	idCustomer char(4),
	idDiscount char(4),
    FOREIGN KEY (idCustomer) REFERENCES Customer(idCustomer),
    FOREIGN KEY (idUser) REFERENCES [User](idUser),
	FOREIGN KEY (idDiscount) REFERENCES Discount(idDiscount)
);

GO

CREATE TABLE OrderDetail (
    idOrderDetail char(6) PRIMARY KEY ,
	quantity int,
	status bit,
	[description] nvarchar(50),
	idOrder char(4),
	idProduct char(4),
	FOREIGN KEY (idOrder) REFERENCES [Order](idOrder),
    FOREIGN KEY (idProduct) REFERENCES Product(idProduct)
);

GO


INSERT INTO [User](idUser, userName, password, phone, address, idRole, description) VALUES('NV01', 'Quynh', '123', '0339248209', 'HCM', 1, '');
INSERT INTO [User](idUser, userName, password, phone, address, idRole, description) VALUES('NV02', 'Quang', '123', '0976546423', 'HN', 1, '');
INSERT INTO [User](idUser, userName, password, phone, address, idRole, description) VALUES('NV03', 'Nga', '123', '0978678534', 'DAKLAK', 1, '');
INSERT INTO [User](idUser, userName, password, phone, address, idRole, description) VALUES('NV04', 'Nghia', '123', '0976545546', 'TIENGIANG', 0, '');
INSERT INTO [User](idUser, userName, password, phone, address, idRole, description) VALUES('NV05', 'Vu', '123', '0941312332', 'NHATRANG', 0, '');
INSERT INTO [User](idUser, userName, password, phone, address, idRole, description) VALUES('NV06', 'User', '123', '0944444376', 'HCM', 0, '');

INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH01', 'My', '0355581561', 1000, 1, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH02', 'Bao', '0937816789', 5000, 1, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH03', 'Linh', '0578911234', 10000, 0, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH04', 'Vy', '0322144155', 35000, 1, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH05', 'Dung', '0772999333', 20000, 0, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH06', 'Huy', '0416728299', 4000, 1, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH07', 'Tuan', '0903344556', 15000, 1, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH08', 'Lan', '0387778899', 2500, 0, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH09', 'Nam', '0365676789', 4500, 1, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH10', 'Khanh', '0333123456', 7000, 0, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH11', 'Minh', '0345998877', 12000, 1, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH12', 'Phuong', '0377776543', 30000, 0, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH13', 'Quynh', '0399987654', 6000, 1, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH14', 'Anh', '0311234567', 8000, 1, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH15', 'Hoa', '0355566778', 500, 0, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH16', 'Son', '0333444555', 9500, 1, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH17', 'Phat', '0398877665', 11000, 0, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH18', 'Chi', '0367788990', 8000, 1, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH19', 'Hien', '0356677888', 4000, 0, '');
INSERT INTO Customer(idCustomer, customerName, phone, point, status, description) VALUES('KH20', 'Dao', '0321122334', 6000, 1, '');

INSERT INTO Discount(idDiscount, dateStart, dateEnd) VALUES('GG01', '2024-03-10', '2024-03-11');
INSERT INTO Discount(idDiscount, dateStart, dateEnd) VALUES('GG02', '2024-03-30', '2024-03-31');
INSERT INTO Discount(idDiscount, dateStart, dateEnd) VALUES('GG03', '2024-05-01', '2024-05-02');
INSERT INTO Discount(idDiscount, dateStart, dateEnd) VALUES('GG04', '2024-09-02', '2024-09-03');
INSERT INTO Discount(idDiscount, dateStart, dateEnd) VALUES('GG05', '2025-01-29', '2005-02-04');

INSERT INTO [Order](idOrder, dateTimeOrder, description, idUser, idCustomer, idDiscount) VALUES('DH01', '2024-03-10', '', 'NV01', 'KH01', 'GG01');
INSERT INTO [Order](idOrder, dateTimeOrder, description, idUser, idCustomer, idDiscount) VALUES('DH02', '2024-03-10', '', 'NV03', 'KH01', 'GG01');
INSERT INTO [Order](idOrder, dateTimeOrder, description, idUser, idCustomer) VALUES('DH03', '2024-03-11', '', 'NV02', 'KH03');
INSERT INTO [Order](idOrder, dateTimeOrder, description, idUser, idCustomer) VALUES('DH04', '2024-03-11', '', 'NV04', 'KH02');
INSERT INTO [Order](idOrder, dateTimeOrder, description, idUser, idCustomer) VALUES('DH05', '2024-03-11', '', 'NV05', 'KH05');
INSERT INTO [Order](idOrder, dateTimeOrder, description, idUser, idCustomer) VALUES('DH06', '2024-03-11', '', 'NV06', 'KH06');
INSERT INTO [Order](idOrder, dateTimeOrder, description, idUser, idCustomer) VALUES('DH07', '2024-03-12', '', 'NV01', 'KH06');
INSERT INTO [Order](idOrder, dateTimeOrder, description, idUser, idCustomer) VALUES('DH08', '2024-03-13', '', 'NV02', 'KH02');
INSERT INTO [Order](idOrder, dateTimeOrder, description, idUser, idCustomer) VALUES('DH09', '2024-03-14', '', 'NV03', 'KH02');
INSERT INTO [Order](idOrder, dateTimeOrder, description, idUser, idCustomer) VALUES('DH10', '2024-03-15', '', 'NV04', 'KH03');

INSERT INTO ProductType(idProductType, productTypeName, description) VALUES('LSP01', 'Nước khoáng', '');
INSERT INTO ProductType(idProductType, productTypeName, description) VALUES('LSP02', 'Cà phê', '');
INSERT INTO ProductType(idProductType, productTypeName, description) VALUES('LSP03', 'Đồ ăn nhanh', '');
INSERT INTO ProductType(idProductType, productTypeName, description) VALUES('LSP04', 'Qùa tặng', '');
INSERT INTO ProductType(idProductType, productTypeName, description) VALUES('LSP05', 'Nước ép', '');

INSERT INTO product(idProduct, productName, status, description, price, idProductType) VALUES('SP01', 'Aquafina', 1, '', 50, 'LSP01');
INSERT INTO product(idProduct, productName, status, description, price, idProductType) VALUES('SP02', 'Cà Phê Đen Đá', 1, '', 100, 'LSP02');
INSERT INTO product(idProduct, productName, status, description, price, idProductType) VALUES('SP03', 'Burger', 1, '', 150, 'LSP03');
INSERT INTO product(idProduct, productName, status, description, price, idProductType) VALUES('SP04', 'Pizza', 1, '', 150, 'LSP03');
INSERT INTO product(idProduct, productName, status, description, price, idProductType) VALUES('SP05', 'Pocari Sweet', 1, '', 70, 'LSP01');
INSERT INTO product(idProduct, productName, status, description, price, idProductType) VALUES('SP06', 'Nước cam', 1, '', 90, 'LSP05');
INSERT INTO product(idProduct, productName, status, description, price, idProductType) VALUES('SP07', 'Sandwich', 1, '', 30, 'LSP03');
INSERT INTO product(idProduct, productName, status, description, price, idProductType) VALUES('SP08', 'Lavie', 1, '', 60, 'LSP01');
INSERT INTO product(idProduct, productName, status, description, price, idProductType) VALUES('SP09', 'Nước ép dưa hấu', 1, '', 90, 'LSP05');
INSERT INTO product(idProduct, productName, status, description, price, idProductType) VALUES('SP10', 'Nước ép táo', 1, '', 100, 'LSP05');
INSERT INTO product(idProduct, productName, status, description, price, idProductType) VALUES('SP11', 'Hotdog', 1, '', 40, 'LSP03');
INSERT INTO product(idProduct, productName, status, description, price, idProductType) VALUES('SP12', 'Spaghetti', 1, '', 120, 'LSP03');
INSERT INTO product(idProduct, productName, status, description, price, idProductType) VALUES('SP13', 'Bánh gạo', 1, '', 30, 'LSP03');
INSERT INTO product(idProduct, productName, status, description, price, idProductType) VALUES('SP14', 'Khoai tây chiên', 1, '', 55, 'LSP03');
INSERT INTO product(idProduct, productName, status, description, price, idProductType) VALUES('SP15', 'Cà phê sữa', 1, '', 130, 'LSP02');

INSERT INTO orderDetail(idOrderDetail, quantity, description, idOrder, idProduct) VALUES('CTDH01', 2, '', 'DH01', 'SP01');
INSERT INTO orderDetail(idOrderDetail, quantity, description, idOrder, idProduct) VALUES('CTDH02', 3, '', 'DH02', 'SP02');
INSERT INTO orderDetail(idOrderDetail, quantity, description, idOrder, idProduct) VALUES('CTDH03', 1, '', 'DH03', 'SP06');
INSERT INTO orderDetail(idOrderDetail, quantity, description, idOrder, idProduct) VALUES('CTDH04', 1, '', 'DH04', 'SP10');
INSERT INTO orderDetail(idOrderDetail, quantity, description, idOrder, idProduct) VALUES('CTDH05', 10, '', 'DH05', 'SP08');
INSERT INTO orderDetail(idOrderDetail, quantity, description, idOrder, idProduct) VALUES('CTDH06', 2, '', 'DH06', 'SP01');
INSERT INTO orderDetail(idOrderDetail, quantity, description, idOrder, idProduct) VALUES('CTDH07', 1, '', 'DH07', 'SP15');
INSERT INTO orderDetail(idOrderDetail, quantity, description, idOrder, idProduct) VALUES('CTDH08', 4, '', 'DH08', 'SP11');
INSERT INTO orderDetail(idOrderDetail, quantity, description, idOrder, idProduct) VALUES('CTDH09', 9, '', 'DH09', 'SP05');
INSERT INTO orderDetail(idOrderDetail, quantity, description, idOrder, idProduct) VALUES('CTDH10', 1, '', 'DH10', 'SP02');
