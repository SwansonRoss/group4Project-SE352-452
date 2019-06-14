CREATE TABLE Account (
    account_Id INT AUTO_INCREMENT,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    email VARCHAR(255),
    password VARCHAR(20),

    PRIMARY KEY (account_Id)
);

CREATE TABLE Customer_Shipments (
    shipping_Id Integer  AUTO_INCREMENT NOT NULL,
    transaction_Id VARCHAR(50) NOT NULL,
    item_Id VARCHAR(50) NOT NULL,
    quantity VARCHAR(255) NOT NULL,

    PRIMARY KEY (shipping_Id)
);

CREATE TABLE Images (
    item_Id INTEGER, //FK
    image BLOB,


    PRIMARY KEY (item_Id)
);

CREATE TABLE Inventory_Category (
    id INTEGER,
    category VARCHAR2(255),

    PRIMARY KEY (id)
);

CREATE TABLE Inventory_Items (
    id LONG,            // PK
    size VARCHAR2(255),         // FK
    itemType VARCHAR2(255),     // FK
    image_Id VARCHAR2(255),      // FK
    inventoryCategory VARCHAR2(255), //FK
    quantity INTEGER,
    price DOUBLE,
    itemName VARCHAR2(55),

    PRIMARY KEY (id)
);

CREATE TABLE Inventory_Type (
    id       INTEGER,
    name_Type VARCHAR2(255),

    PRIMARY KEY (id)
);

CREATE TABLE Item_Purchased (
    transaction_Id LONG, //PK, FK
    item_Id LONG,    //FK
    price_Purchased DOUBLE,

    PRIMARY KEY (transaction_Id)
);

CREATE TABLE Manager (
    id LONG,
    code VARCHAR2(255),
    first_Name VARCHAR2(255),
    last_Name VARCHAR2(255),
    email   VARCHAR2(255),
    password VARCHAR2(255)
);

CREATE TABLE Transactions (
    transaction_Id LONG, // PK.
    transactions_Total DOUBLE, // small money
    total_Items INTEGER,
    order_Date DATE,

    PRIMARY KEY(transaction_Id)
);

CREATE TABLE Purchase_History (
    purchase_Id LONG,
    transaction_Id LONG,
    item_ID LONG,

    PRIMARY KEY(purchase_Id),
    FOREIGN KEY (purchase_Id) REFERENCES Account(account_Id),
    FOREIGN KEY (transaction_Id) references  Transactions(transaction_Id)
);

CREATE TABLE Vendor (
    vendor_ID LONG,
    country VARCHAR2(255),
    city VARCHAR2(255),
    state VARCHAR2(255),

    PRIMARY KEY(vendor_ID)
);

CREATE TABLE Size_Chart(
    size_ID VARCHAR2(3),
    size_name VARCHAR(20),

    PRIMARY KEY (size_ID)
);