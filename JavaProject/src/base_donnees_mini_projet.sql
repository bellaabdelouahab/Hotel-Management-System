-- Create a user
CREATE USER hotel_bd IDENTIFIED BY hotel;
--Grant permissions
GRANT CONNECT, RESOURCE, DBA TO hotel_bd;

create table employee(
    id_emp NUMBER(4) constraint pk_emp primary Key,  
    full_name VARCHAR2(45) ,
    adresse VARCHAR2(40),
    email VARCHAR2(40) constraint email_unique UNIQUE not null,
    password VARCHAR2(11) not null,
    nationnality VARCHAR2(20),
    sex VARCHAR2(2),
    age NUMBER(2),
    phone_number VARCHAR2(16),
    salaire NUMBER(6),
    commission NUMBER(4),
    type_travaille VARCHAR2(15)
);

insert into employee values (1,'admin',null,'test@gmail.com','admin',null,null,null,null,null,null,'admin');
insert into employee values (2,'yassine boujrada','casa','yassine@gmail.com','yassine2','marocaine','h',18,null,1000.00,2,'reserve');
insert into employee values (3,'bella abdelwahab','taroudanet','abdo@gmail.com','abdelwahab','marocaine','h',21,'0765432847',1100.00,1.7,'reserve');
insert into employee values (4,'bousslama hamza','khouribga','hamza@gmail.com','hamza2002','marocaine','h',18,'0645739874',1500.00,3,'reserve');
insert into employee values (5,'el_bazzi hiba','essaouira','hiba@gmail.com','hiiba2002','marocaine','f',18,'0765342310',1500.00,2,'reserve');
insert into employee values (6,'test omar','essaouira','omar@gmail.com','test2002','tunisiene','h',20,'0645789374',5000,1.2,'menage');
insert into employee values (7,'test2 khadija','agadir','khadija@gmail.com','khadija2','france','f',25,'0719738492',4500,0,'menage'); 

select * from employee;
select email,password from employee where lower(email)='yassine@gmail.com';

select id_emp,password from employee where lower(email)='yassine@gmail.com';


create table reservation(
    id_reserv Number(3) constraint pk_reser primary Key, 
    id_emp NUMBER(4) CONSTRAINT emp_fk REFERENCES employee,
    date_de_sortir Date ,
    date_de_reserver Date,
    cin Varchar2(8) CONSTRAINT client_fk REFERENCES client,
    ID_ROOM NUMBER CONSTRAINT room_fk REFERENCES rooms
);

CREATE TABLE rooms(
    ID_ROOM NUMBER,
    DATE_ENTRE DATE,
    DATE_SORTIE DATE,
    NUM_ADUL NUMERIC ,
    NUM_ROOM NUMERIC ,
    NUM_CHILD NUMERIC ,
    CLASSE NUMERIC ,
    PRIX NUMERIC,
    id_reserv Number(3) CONSTRAINT reserv_fk REFERENCES reservation
);

create table client(
    cin Varchar2(8) CONSTRAINT client_pk primary key,
    first_name varchar2(12),
    last_name  varchar2(17),
    nationality varchar2(10),
    gender varchar2(3),
    etat_civil varchar2(10),
    age number(2),
    id_reserv Number(3) CONSTRAINT reserver_fk REFERENCES reservation
);




update employee
set FULL_NAME = 'ADMIN BBBE',
    EMAIL = 'admin@gmail.com',
    PASSWORD = 'admin',
    PHONE_NUMBER = 0682975957
WHERE ID_EMP = 1;

UPDATE employee SET FULL_NAME = 'asdasdasd',EMAIL = 'asdasd',PASSWORD = 'asdasd',PHONE_NUMBER = '068846554' WHERE ID_EMP = 1;

SELECT SUM(SALAIRE)
FROM EMPLOYEE;
INSERT INTO EMPLOYEE VALUES((SELECT COUNT(*) FROM EMPLOYEE) + 1 , 'ASDASD' , 'ASDASD', 'ASDASSD' , 'SDFSDFF', 'SDFSDF' , 'F' , 15 , '6546546554' , 1500 , 12 , resserve);  

insert into employee values ((SELECT COUNT(*) FROM EMPLOYEE) + 1,'yassine boujrada','casa','yassine@gmail.com','yassine2','marocaine','h',18,null,1000.00,2,'reserve');
