DROP USER c##cms;
CREATE USER c##cms IDENTIFIED BY claimmanagementsystem;
  GRANT CONNECT TO c##cms;
  GRANT ALL PRIVILEGES TO c##cms;
  GRANT unlimited TABLESPACE TO c##cms;
  COMMIT; 