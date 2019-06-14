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
    inventoryCategory INTEGER, //FK
    quantity INTEGER,
    price DOUBLE,
    itemName VARCHAR2(55),

    PRIMARY KEY (id));
 */

INSERT INTO INVENTORY_ITEMS VALUES(01, 'small', 'shirt', '', 'women', 15, 25.00, 'Womens Test shirt');
INSERT INTO INVENTORY_ITEMS VALUES(02, 'small', 'shirt', '', 'men', 15, 25.00, 'Mens test shirt');
INSERT INTO INVENTORY_ITEMS VALUES(03, '12', 'shoes', '', 'accessory', 15, 25.00, 'Test Accessory');
INSERT INTO INVENTORY_ITEMS VALUES(04, 'small', 'shirt', '', 'sale', 15, 25.00, 'Sale test shirt');

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