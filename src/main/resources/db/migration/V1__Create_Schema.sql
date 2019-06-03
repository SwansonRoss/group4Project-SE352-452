CREATE SCHEMA IF NOT EXISTS GUCCl;

CREATE TABLE IF NOT EXISTS account (
  accountID Integer  AUTO_INCREMENT NOT NULL,
  firstName VARCHAR(50) NOT NULL,
  lastName VARCHAR(50) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(20) NOT NULL,

  PRIMARY KEY (accountID)

);

INSERT INTO ACCOUNT VALUES(1,'2010-04-29', 'tng.onw@gmail.com', 'tuan', 'Nguyen', 'chicken');
