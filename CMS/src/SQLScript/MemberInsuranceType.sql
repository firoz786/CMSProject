DROP TABLE memberinsurancetype CASCADE CONSTRAINTS;
CREATE TABLE memberinsurancetype
  (
    memberid               VARCHAR2(10) NOT NULL,
    insurancetypeid        NUMBER(1) NOT NULL,
    maximumclaimableamount NUMBER(20,3) NOT NULL,
    CONSTRAINT fk6 FOREIGN KEY (memberid) REFERENCES Registration (memberid),
    CONSTRAINT fk7 FOREIGN KEY (insurancetypeid) REFERENCES InsuranceType (insurancetypeid)
  );
CREATE OR REPLACE
PROCEDURE memberinsurancetype_prc1
  (
    memberidvariable               VARCHAR2,
    insurancetypeidvariable        NUMBER,
    maximumclaimableamountvariable NUMBER
  )
AS
BEGIN
  UPDATE memberinsurancetype
  SET insurancetypeid     =insurancetypeidvariable,
    maximumclaimableamount=maximumclaimableamountvariable
  WHERE memberid          =memberidvariable;
  COMMIT;
END;
/
CREATE OR REPLACE
PROCEDURE memberinsurancetype_prc2(
    memberidvariable               VARCHAR2,
    insurancetypeidvariable        NUMBER,
    maximumclaimableamountvariable NUMBER )
AS
BEGIN
  INSERT
  INTO memberinsurancetype
    (
      memberid,
      insurancetypeid,
      maximumclaimableamount
    )
    VALUES
    (
      memberidvariable,
      insurancetypeidvariable,
      maximumclaimableamountvariable
    );
  COMMIT;
END;
/