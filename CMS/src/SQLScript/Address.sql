DROP TABLE Address CASCADE CONSTRAINTS;
CREATE TABLE Address
  (
    memberid VARCHAR2(10) NOT NULL,
    zipcode  NUMBER(6) NOT NULL,
    state    VARCHAR2(20) NOT NULL,
    city     VARCHAR2(20) NOT NULL,
    address  VARCHAR2(255) NOT NULL,
    CONSTRAINT fk5 FOREIGN KEY (memberid) REFERENCES Registration (memberid)
  );
COMMIT;
CREATE OR REPLACE
PROCEDURE address_prc1
  (
    memberidvariable VARCHAR2,
    zipcodevariable  NUMBER,
    statevariable    VARCHAR2,
    cityvariable     VARCHAR2,
    addressvariable  VARCHAR2
  )
AS
BEGIN
  UPDATE Address
  SET ZIPCODE   =zipcodevariable,
    CITY        =cityvariable,
    STATE       =statevariable,
    address     =addressvariable
  WHERE MEMBERID=memberidvariable;
  COMMIT;
END;
/
CREATE OR REPLACE
PROCEDURE address_prc2(
    memberidvariable VARCHAR2,
    zipcodevariable  NUMBER,
    statevariable    VARCHAR2,
    cityvariable     VARCHAR2,
    addressvariable  VARCHAR2 )
AS
BEGIN
  INSERT
  INTO address
    (
      MEMBERID,
      CITY,
      state,
      zipcode,
      address
    )
    VALUES
    (
      memberidvariable,
      cityvariable,
      statevariable,
      zipcodevariable,
      addressvariable
    );
  COMMIT;
END;
/
COMMIT;