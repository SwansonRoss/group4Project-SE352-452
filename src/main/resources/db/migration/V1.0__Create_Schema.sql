-- CREATE DATABASE IF NOT EXISTS GUCCl;
--
CREATE TABLE IF NOT EXISTS account (
  accountId Integer  AUTO_INCREMENT NOT NULL,
  firstName VARCHAR(50) NOT NULL,
  lastName VARCHAR(50) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(20) NOT NULL,
  accountCreated TIMESTAMP default CURRENT_DATE,
  PRIMARY KEY (accountID)

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
