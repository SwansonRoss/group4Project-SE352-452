-- CREATE DATABASE IF NOT EXISTS GUCCl;
--
CREATE TABLE Account (
  account_Id INT AUTO_INCREMENT,
  firstName VARCHAR(50),
  lastName VARCHAR(50),
  email VARCHAR(255),
  password VARCHAR(20),
  PRIMARY KEY (account_Id)
);

CREATE TABLE CustomerShipments (
    shippingId Integer  AUTO_INCREMENT NOT NULL,
    transactionId VARCHAR(50) NOT NULL,
    itemId VARCHAR(50) NOT NULL,
    quantity VARCHAR(255) NOT NULL,
    vendorId VARCHAR(20) NOT NULL,
    orderDate TIMESTAMP default CURRENT_DATE,
    arrivalDate DATE,
    PRIMARY KEY (shippingId)
);

CREATE TABLE Images (
    transactionId INTEGER, // PK, FK
    itemId INTEGER, //FK
    pricePurchased INTEGER,
    PRIMARY KEY (transactionId)
);

CREATE TABLE InventoryCategory (
    id INTEGER,
    category VARCHAR2(255)
);

CREATE TABLE InventoryItems (
    itemsId INTEGER,            // PK
    size VARCHAR2(255),         // FK
    itemType VARCHAR2(255),     // FK
    imageId VARCHAR2(255),      // FK
    inventoryCategory VARCHAR2(255), //FK
    quantity INTEGER,
    price DOUBLE
);

CREATE TABLE InventoryType (
    id       INTEGER,
    nameType VARCHAR2(255)
);

CREATE TABLE ItemPurchased (
    transactionId LONG, //PK, FK
    itemId LONG,    //FK
    pricePurchased DOUBLE
);

CREATE TABLE Manager (
    id LONG,
    code VARCHAR2(255),
    firstName VARCHAR2(255),
    lastName VARCHAR2(255),
    email   VARCHAR2(255),
    password VARCHAR2(255)
);

CREATE TABLE PurchaseHistory (
    accountID LONG,
    transactionID LONG,
    itemID LONG
);

CREATE TABLE Transactions (
    transactionId LONG, // PK.
    transactionsTotal DOUBLE, // small money
    totalItems INTEGER,
    orderDate DATE
);

CREATE TABLE Vendor (
    vendorID LONG,
    country VARCHAR2(255),
    city VARCHAR2(255),
    state VARCHAR2(255)
);
