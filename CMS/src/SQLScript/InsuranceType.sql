DROP TABLE InsuranceType CASCADE CONSTRAINTS;
CREATE TABLE InsuranceType
  (
    insurancetypeid NUMBER(1) NOT NULL,
    insurancetype   VARCHAR2(50) NOT NULL,
    insuredamount   NUMBER(7) NOT NULL,
    CONSTRAINT pk2 PRIMARY KEY (insurancetypeid),
    CONSTRAINT uk2 UNIQUE (insurancetype)
  );

INSERT INTO insurancetype VALUES
  (1, 'Home',800000
  );
INSERT INTO insurancetype VALUES
  (2, 'Life',400000
  );
INSERT INTO insurancetype VALUES
  (3, 'Vechile',200000
  );
COMMIT;