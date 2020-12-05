create table EMPLOYEE_ENTITY (
   ID_EMP BIGINT AUTO_INCREMENT PRIMARY KEY,
   CH_NAME_EMP varchar(100) NOT NULL,
   COVID19_STATUS_EMP BOOL DEFAULT TRUE,
   DISABILITY_EMP char(1) DEFAULT 1,
   --AGE_EMP NUMBER(2),
   DOB_EMP TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   
   --CONSTRAINT dobcons CHECK (DOB_EMP <= CURRENT_TIMESTAMP),
   --CONSTRAINT chncons CHECK (CH_NAME_EMP like 'CH%')
);
