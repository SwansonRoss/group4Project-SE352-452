/* Inventory categories */
/************************************
  CREATE TABLE Inventory_Category (
                                    id INTEGER,
                                    category VARCHAR2(255),

                                    PRIMARY KEY (id));
 ****************************************/
INSERT INTO Inventory_Category VALUES (1, 'men' );
INSERT INTO Inventory_Category VALUES (2, 'women' );
INSERT INTO Inventory_Category VALUES (3, 'accessories' );
INSERT INTO Inventory_Category VALUES (4, 'sales' );

/*Inventory Item Types */
/*****************************************
  CREATE TABLE Inventory_Type (
                                id       INTEGER,
                                name_Type VARCHAR2(255),

                                PRIMARY KEY (id));

 *******************************************/

INSERT INTO Inventory_Type VALUES (1, 'shirt' );
INSERT INTO Inventory_Type VALUES (2, 'suit' );
INSERT INTO Inventory_Type VALUES (3, 'pants' );
INSERT INTO Inventory_Type VALUES (4, 'dress' );


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

/*Image Inventory*/
/*********************************************
CREATE TABLE Images (
                        item_Id INTEGER, //FK
                        image BLOB,

                        PRIMARY KEY (item_Id)
);
*********************************************/
INSERT INTO Images VALUES( 00001, '00001.png' );

/*Original Inventory*/
/********************************
  CREATE TABLE Inventory_Items (
                                 id LONG,            // PK
                                 size VARCHAR2(255),         // FK
                                 itemType VARCHAR2(255),     // FK
                                 image_Id INTEGER,      // FK
                                 inventoryCategory INTEGER), //FK
                                 quantity INTEGER,
                                 price DOUBLE,
                                 itemName VARCHAR2(55),

                                 PRIMARY KEY (id));
 ******************************/
INSERT INTO Inventory_Items VALUES( 1111111,'XS','shirt', 00001, 2, 50, 10.00, 'TyeDy');




















