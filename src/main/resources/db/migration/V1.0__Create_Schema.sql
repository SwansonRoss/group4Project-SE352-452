-- CREATE DATABASE IF NOT EXISTS GUCCl;
--
CREATE TABLE account (
  account_Id INT AUTO_INCREMENT,
  firstName VARCHAR(50),
  lastName VARCHAR(50),
  email VARCHAR(255),
  password VARCHAR(20),
  accountCreated TIMESTAMP default CURRENT_DATE,
  PRIMARY KEY (account_Id)
);

-- CREATE TABLE IF NOT EXISTS CustomerShipments (
--     shippingId Integer  AUTO_INCREMENT NOT NULL,
--     transactionId VARCHAR(50) NOT NULL,
--     itemId VARCHAR(50) NOT NULL,
--     quantity VARCHAR(255) NOT NULL,
--     vendorId VARCHAR(20) NOT NULL,
--     orderDate TIMESTAMP default CURRENT_DATE,
--     arrivalDate DATE,
--     PRIMARY KEY (shippingId)
-- );
--
-- CREATE TABLE IF NOT EXISTS Images (
--     transactionId INTEGER, // PK, FK
--     itemId INTEGER, //FK
--     pricePurchased INTEGER,
--     PRIMARY KEY (transactionId)
-- );
