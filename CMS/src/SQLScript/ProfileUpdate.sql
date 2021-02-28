CREATE OR REPLACE
PROCEDURE profileupdate_prc1(
    memberidvariable               VARCHAR2,
    firstnamevariable              VARCHAR2,
    lastnamevariable               VARCHAR2,
    gendervariable                 VARCHAR2,
    dateofbirthvariable            DATE,
    emailaddressvariable           VARCHAR2,
    contactnumbervariable          VARCHAR2,
    addressvariable                VARCHAR2,
    zipcodevariable                VARCHAR2,
    cityvariable                   VARCHAR2,
    statevariable                  VARCHAR2,
    insurancetypevariable          VARCHAR2,
    maximumclaimableamountvariable NUMBER)
AS
  insurancetypeidlocal VARCHAR2(1);
 
BEGIN
  SELECT insurancetype.insurancetypeid
  INTO insurancetypeidlocal
  FROM insurancetype
  WHERE insurancetype.insurancetype=insurancetypevariable;
  memberinsurancetype_prc1(memberidvariable,insurancetypeidlocal,maximumclaimableamountvariable);
  address_prc1(memberidvariable,to_number(zipcodevariable),statevariable,cityvariable,addressvariable);
  registration_prc1( memberidvariable , firstnamevariable , lastnamevariable , gendervariable , dateofbirthvariable , emailaddressvariable , to_number(contactnumbervariable));
  COMMIT;
END;
/
CREATE OR REPLACE
PROCEDURE profileupdate_prc2(
    memberidvariable               VARCHAR2,
    firstnamevariable              VARCHAR2,
    lastnamevariable               VARCHAR2,
    gendervariable                 VARCHAR2,
    dateofbirthvariable            DATE,
    emailaddressvariable           VARCHAR2,
    contactnumbervariable          VARCHAR2,
    addressvariable                VARCHAR2,
    zipcodevariable                VARCHAR2,
    cityvariable                   VARCHAR2,
    statevariable                  VARCHAR2,
    insurancetypevariable          VARCHAR2,
    maximumclaimableamountvariable NUMBER )
AS
  insurancetypeidlocal NUMBER(1);
BEGIN
  SELECT insurancetype.insurancetypeid
  INTO insurancetypeidlocal
  FROM insurancetype
  WHERE insurancetype.insurancetype=insurancetypevariable;
  memberinsurancetype_prc2(memberidvariable,insurancetypeidlocal,maximumclaimableamountvariable);
  address_prc2(memberidvariable,to_number(zipcodevariable),statevariable,cityvariable,addressvariable);
  registration_prc1(memberidvariable,firstnamevariable,lastnamevariable,gendervariable,dateofbirthvariable,emailaddressvariable,to_number(contactnumbervariable));
  COMMIT;
END;
/
COMMIT;