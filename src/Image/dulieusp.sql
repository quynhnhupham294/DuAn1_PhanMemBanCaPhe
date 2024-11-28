USE phanMemBanCaPhe;

ALTER TABLE Product
ALTER COLUMN image NVARCHAR(MAX); 
UPDATE Product SET image = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSnUFSDJF2VpQd5wnufLXAHne8bqzv1I6sXTQ&s' WHERE idProduct = 'SP01';
UPDATE Product SET image = 'https://thuytinhluminarc.com/wp-content/uploads/2022/08/ly-tach-va-hat-ca-phe.jpg' WHERE idProduct = 'SP02';
UPDATE Product SET image = 'https://cdn2.tmbi.com/TOH/Images/Photos/37/1200x1200/exps41063_SD163614D12_01_3b.jpg' WHERE idProduct = 'SP03';
UPDATE Product SET image = 'https://tse1.mm.bing.net/th?id=OIP.D4lCG7dGjMJwO07EHm1uIQHaHa&pid=Api&P=0&h=220' WHERE idProduct = 'SP04';
UPDATE Product SET image = 'https://d2t3trus7wwxyy.cloudfront.net/catalog/product/p/o/pocari-sweat-ion-drink-2l_2.jpg' WHERE idProduct = 'SP05';
UPDATE Product SET image = 'https://tse3.mm.bing.net/th?id=OIP.iXRbGpweoIA4PClVFeoPJwHaFj&pid=Api&P=0&h=220' WHERE idProduct = 'SP06';
UPDATE Product SET image = 'https://tse2.mm.bing.net/th?id=OIP.o8KNyhe-VPL6odYbxqEdSQHaE6&pid=Api&P=0&h=220' WHERE idProduct = 'SP07';
UPDATE Product SET image = 'https://tse1.mm.bing.net/th?id=OIP.PAEROvE-d217iFUPAzFcnwHaHa&pid=Api&P=0&h=220' WHERE idProduct = 'SP08';
UPDATE Product SET image = 'https://tse2.mm.bing.net/th?id=OIP.73vIabj1DRGYrU7mFQbqNwHaE8&pid=Api&P=0&h=220' WHERE idProduct = 'SP09';
UPDATE Product SET image = 'https://tse3.mm.bing.net/th?id=OIP.sDxQqsFxM9ca2HQsf1EWaQHaFN&pid=Api&P=0&h=220' WHERE idProduct = 'SP10';
UPDATE Product SET image = 'https://tse4.mm.bing.net/th?id=OIP.Y6Xqv0RqD3bot1uP8Z92fAHaHa&pid=Api&P=0&h=220' WHERE idProduct = 'SP011';
UPDATE Product SET image = 'https://tse4.mm.bing.net/th?id=OIP.2QziW6sVSy3FaClyjnp1gwHaH1&pid=Api&P=0&h=220' WHERE idProduct = 'SP12';

UPDATE Product SET image = 'https://tse3.mm.bing.net/th?id=OIP.ej9sTBr7DbPhFemTJEd4dwHaFi&pid=Api&P=0&h=220' WHERE idProduct = 'SP13';
UPDATE Product SET image = 'https://tse3.mm.bing.net/th?id=OIP.OEWIWXsivFczMnLVkYUPZgHaGQ&pid=Api&P=0&h=220' WHERE idProduct = 'SP14';

CREATE OR ALTER VIEW V_DoanhThu 
AS
    SELECT 
        p.idProduct AS MaSanPham, 
        p.productName AS TenSanPham,
        pt.productTypeName AS TenLoai,  
        od.quantity AS SoLuong, 
        p.price AS Gia,
        SUM(od.quantity * p.price  ) AS 'TongTien', 
        o.dateTimeOrder AS NgayLap
    FROM [Order] AS o
    INNER JOIN OrderDetail AS od
        ON o.idOrder = od.idOrder
    INNER JOIN Product AS p
        ON od.idProduct = p.idProduct
    INNER JOIN ProductType AS pt
        ON p.idProductType = pt.idProductType
    LEFT JOIN Discount AS d
        ON o.idDiscount = d.idDiscount
    GROUP BY 
        o.dateTimeOrder, 
        p.idProduct, 
        p.productName, 
        pt.productTypeName, 
        od.quantity, 
        p.price
        

		select * from V_DoanhThu 
		  ORDER BY 
        YearOrder DESC;
		drop view V_DoanhThu


		CREATE OR ALTER VIEW V_DoanhThu1 
AS
    SELECT 
        p.idProduct AS MaSanPham, 
        p.productName AS TenSanPham,
        pt.productTypeName AS TenLoai,  
        od.quantity AS SoLuong, 
        p.price AS Gia,
        --SUM(od.quantity * p.price * (1 - d.discountPercentage / 100) ) AS 'TongTien', 
		SUM(od.quantity * p.price ) AS 'TongTien', 
        o.dateTimeOrder AS NgayLap,
        YEAR(o.dateTimeOrder) AS YearOrder  
    FROM [Order] AS o
    INNER JOIN OrderDetail AS od
        ON o.idOrder = od.idOrder
    INNER JOIN Product AS p
        ON od.idProduct = p.idProduct
    INNER JOIN ProductType AS pt
        ON p.idProductType = pt.idProductType
    LEFT JOIN Discount AS d
        ON o.idDiscount = d.idDiscount
    GROUP BY 
        o.dateTimeOrder, 
        p.idProduct, 
        p.productName, 
        pt.productTypeName, 
        od.quantity, 
        p.price,
        --d.discountPercentage
    ORDER BY 
        YearOrder DESC;