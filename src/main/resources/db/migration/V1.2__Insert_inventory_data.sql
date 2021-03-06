INSERT INTO INVENTORY_CATEGORY VALUES(01, 'men');
INSERT INTO INVENTORY_CATEGORY VALUES(02, 'women');
INSERT INTO INVENTORY_CATEGORY VALUES(03, 'accessories');
INSERT INTO INVENTORY_CATEGORY VALUES(04, 'sale');

INSERT INTO INVENTORY_TYPE VALUES(01, 'shirt');
INSERT INTO INVENTORY_TYPE VALUES(02, 'pants');
INSERT INTO INVENTORY_TYPE VALUES(03, 'dress');
INSERT INTO INVENTORY_TYPE VALUES(04, 'shoes');
INSERT INTO INVENTORY_TYPE VALUES(05, 'belt');
INSERT INTO INVENTORY_TYPE VALUES(06, 'jewelry');


/*********************************************
  CREATE TABLE Inventory_Items (
    id LONG,            // PK
    size VARCHAR2(255),         // FK
    itemType VARCHAR2(255),     // FK
    image_Id INTEGER,      // FK
    inventoryCategory VARCHAR(255), //FK
    quantity INTEGER,
    price DOUBLE,
    itemName VARCHAR2(55),

    PRIMARY KEY (id));
 */

/* Womens T-Shirts*/
INSERT INTO INVENTORY_ITEMS VALUES(01, 'extra small', 'shirt', '', 'women', 15, 25.00, 'Womens Shirt1');
INSERT INTO INVENTORY_ITEMS VALUES(02, 'small', 'shirt', '', 'women', 15, 25.00, 'Womens Shirt2');
INSERT INTO INVENTORY_ITEMS VALUES(03, 'medium', 'shirt', '', 'women', 15, 25.00, 'Womens Shirt3');
INSERT INTO INVENTORY_ITEMS VALUES(04, 'large', 'shirt', '', 'women', 15, 25.00, 'Womens Shirt4');
INSERT INTO INVENTORY_ITEMS VALUES(05, 'extra large', 'shirt', '', 'women', 15, 25.00, 'Womens Shirt5');
INSERT INTO INVENTORY_ITEMS VALUES(06, 'extra extra large', 'shirt', '', 'women', 15, 25.00, 'Womens Shirt6');

INSERT INTO INVENTORY_ITEMS VALUES(07, 'extra small', 'shirt', '', 'sale', 15, 25.00, 'Womens shirt');
INSERT INTO INVENTORY_ITEMS VALUES(08, 'small', 'shirt', '', 'sale', 15, 25.00, 'Womens shirt');
INSERT INTO INVENTORY_ITEMS VALUES(09, 'medium', 'shirt', '', 'sale', 15, 25.00, 'Womens shirt');
INSERT INTO INVENTORY_ITEMS VALUES(10, 'large', 'shirt', '', 'sale', 15, 25.00, 'Womens shirt');
INSERT INTO INVENTORY_ITEMS VALUES(11, 'extra large', 'shirt', '', 'sale', 15, 25.00, 'Womens shirt');
INSERT INTO INVENTORY_ITEMS VALUES(12, 'extra extra large', 'shirt', '', 'sale', 15, 25.00, 'Womens shirt');

/* Mens T-Shirts*/
INSERT INTO INVENTORY_ITEMS VALUES(13, 'small', 'shirt', '', 'men', 15, 25.00, 'Mens Shirt1');
INSERT INTO INVENTORY_ITEMS VALUES(14, 'small', 'shirt', '', 'men', 15, 25.00, 'Mens Shirt2');
INSERT INTO INVENTORY_ITEMS VALUES(15, 'medium', 'shirt', '', 'men', 15, 25.00, 'Mens Shirt3');
INSERT INTO INVENTORY_ITEMS VALUES(16, 'large', 'shirt', '', 'men', 15, 25.00, 'Mens Shirt4');
INSERT INTO INVENTORY_ITEMS VALUES(17, 'extra large', 'shirt', '', 'men', 15, 25.00, 'Mens Shirt5');
INSERT INTO INVENTORY_ITEMS VALUES(18, 'extra extra large', 'shirt', '', 'men', 15, 25.00, 'Mens Shirt6');

INSERT INTO INVENTORY_ITEMS VALUES(19, 'small', 'shirt', '', 'accessory', 15, 25.00, 'Mens t2 shirt');
INSERT INTO INVENTORY_ITEMS VALUES(20, 'small', 'shirt', '', 'accessory', 15, 25.00, 'Mens t2 shirt');
INSERT INTO INVENTORY_ITEMS VALUES(21, 'medium', 'shirt', '', 'accessory', 15, 25.00, 'Mens t2 shirt');
INSERT INTO INVENTORY_ITEMS VALUES(22, 'large', 'shirt', '', 'accessory', 15, 25.00, 'Mens t2 shirt');
INSERT INTO INVENTORY_ITEMS VALUES(23, 'extra large', 'shirt', '', 'accessory', 15, 25.00, 'Mens t2 shirt');
INSERT INTO INVENTORY_ITEMS VALUES(24, 'extra extra large', 'shirt', '', 'accessory', 15, 25.00, 'Mens t2 shirt');


INSERT INTO INVENTORY_ITEMS VALUES(25, '12', 'shoes', '', 'accessory', 15, 25.00, 'Accessory Shoe1');

INSERT INTO INVENTORY_ITEMS VALUES(26, 'small', 'shirt', '', 'sale', 15, 25.00, 'Sale Cheap Shirt');

/*Size Chart*/
/*****************************************
 CREATE TABLE Size_Chart(
                           size_ID VARCHAR2(3),
                           size_name VARCHAR(20),

                           PRIMARY KEY (size_ID));
 *******************************************/

INSERT INTO Size_Chart VALUES ('XS', 'extra small');
INSERT INTO Size_Chart VALUES ('S', 'small');
INSERT INTO Size_Chart VALUES ('M', 'medium');
INSERT INTO Size_Chart VALUES ('L', 'large');
INSERT INTO Size_Chart VALUES ('XL', 'extra large');
INSERT INTO Size_Chart VALUES ('XXL', 'extra extra large');
