/*
CREATE TABLE Account (
    account_Id INT AUTO_INCREMENT,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    email VARCHAR(255),
    password VARCHAR(20),

    PRIMARY KEY (account_Id)
 */
INSERT INTO account VALUES (1, 'tuan', 'nguyen', 'tnguyen@gmail.com', 'pw123');
INSERT INTO account VALUES (2, 'ross', 'swanson', 'rswanson@gmail.com', 'pw456');
INSERT INTO account VALUES (3, 'heather', 'duke', 'hduke@gmail.com', 'pw789');
INSERT INTO account VALUES (4, 'jessica', 'bender', 'jbender@gmail.com', 'pw102');
INSERT INTO account VALUES (5, 'alexander', 'reyes', 'areyes@gmail.com', 'pw103');

/*
CREATE TABLE Manager (
    id LONG,
    code VARCHAR2(255),
    first_Name VARCHAR2(255),
    last_Name VARCHAR2(255),
    email   VARCHAR2(255),
    password VARCHAR2(255),

    PRIMARY KEY (id)
 */
 INSERT INTO manager VALUES (1, 'manager', 'ken', 'yu', 'kyu@gmail.com', 'password');
