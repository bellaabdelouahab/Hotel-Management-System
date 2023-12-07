alter session set "_ORACLE_SCRIPT"=true; 

-- Create a common user in the CDB
CREATE USER hotelbd IDENTIFIED BY hotel CONTAINER = ALL;
--give all permisions to new user
GRANT CONNECT, RESOURCE, DBA TO hotelbd;

/*////////////////////////////////////////////////////////*/

-- create table
create table client(
    id_client Varchar2(8) CONSTRAINT client_pk primary key,
    first_name varchar2(12),
    last_name  varchar2(17),
    nationality varchar2(10),
    gender varchar2(3),
    etat_civil varchar2(10),
    age number(2)
);
alter table client add constraint client_check check(age between 1 and 120); 

CREATE TABLE rooms(
    ID_ROOM NUMBER ,
    NUM_ADUL NUMERIC ,
    NUM_CHILD NUMERIC ,
    CLASSE NUMERIC ,
    PRIX NUMERIC,
    contents_of_room VARCHAR2(170)
);
alter table rooms add constraint room_pk primary key(ID_ROOM);

CREATE TABLE reservation(
    id_reserv Number(3) constraint pk_reser primary Key, 
    date_de_reserver Date,
    date_de_sortir Date ,
    id_client Varchar2(8) CONSTRAINT client_fk REFERENCES client, 
    id_emp NUMBER(4) CONSTRAINT emp_fk REFERENCES employee,
    ID_ROOM NUMBER  CONSTRAINT room_fk REFERENCES rooms
);
alter table reservation add constraint date_check check(date_de_reserver<date_de_sortir);
--some hidden code
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
alter table employee add constraint employe_check check(age between 18 and 70); 

CREATE table sign_up(
    id Number(4),
    first_name VARCHAR2(45),
    last_name VARCHAR2(45),
    adresse VARCHAR2(40),
    email VARCHAR2(40),
    nationality VARCHAR2(45),
    sex VARCHAR2(2),
    age NUMBER(2),
    phone_number VARCHAR2(16)
);

insert into sign_up values ((select count(*)+1 from sign_up),'Hamza','Bouslama','Khouribga','email@gmail.com' ,'Maroc','h',19,'069383');


-- Drop Table sign_up;

/*  insert informations to the table  */

-- client table
insert into client values (1,'omar','mohamed','francaise','h','clebatair',20);
insert into client values (2,'ilham','inconnu','marocian','f','marie',22);
insert into client values (3,'khalid','tajine','tunisie','h','devorce',35);
insert into client values (4,'siham','bnin','algerienne','f','celebatair',17);
insert into client values (5,'hassan','serdine','chinaise','h','celebatair',40);

--rooms table
insert into rooms values (1,2,1,3,500,'Cushion Wifi_5G coffee Morning');
insert into rooms values (2,3,0,4,1000,'Cushion Wifi_5G');
insert into rooms values (3,1,0,1,250,'Television Tea set Cushion');
insert into rooms values (4,4,3,5,4000,'End table Tea set Fireplace Floor lamp Tableet Blinds');
insert into rooms values (5,2,3,2,3000,'Cushion Television Speaker End_table Tea_set');
insert into rooms values (6,4,6,3,5000,'coffee Morning Wifi_5G Cushion Television Speaker End table Tea set Fireplace Floor lamp Tableet Blinds');
insert into rooms values (7,1,0,5,6000,'Tea set Fireplace coffee_Morning');
insert into rooms values (8,2,0,3,2000,'coffee Morning Wifi_5G');
insert into rooms values (9,3,1,2,1000,'Television Speaker');
INSERT INTO ROOMS VALUES((SELECT COUNT(*) FROM ROOMS) + 1 , 2 , 2,4 , 520 , 'WIFI');

-- employee table 
insert into employee values (1,'admin',null,'Admin@gmail.com','admin',null,null,null,null,null,null,'admin');
insert into employee values (2,'yassine boujrada','casa','yassine@gmail.com','yassine2','marocaine','h',18,null,1000.00,2,'reserve');
insert into employee values (3,'bella abdelwahab','taroudanet','abdo@gmail.com','abdelwahab','marocaine','h',21,'0765432847',1100.00,1.7,'reserve');
insert into employee values (4,'bousslama hamza','khouribga','hamza@gmail.com','hamza2002','marocaine','h',18,'0645739874',1500.00,3,'reserve');
insert into employee values (5,'el_bazzi hiba','essaouira','hiba@gmail.com','hiiba2002','marocaine','f',18,'0765342310',1500.00,2,'reserve');
insert into employee values (6,'test omar','essaouira','omar@gmail.com','test2002','tunisiene','h',20,'0645789374',5000,1.2,'menage');
insert into employee values (7,'test2 khadija','agadir','khadija@gmail.com','khadija2','france','f',25,'0719738492',4500,0,'menage'); 

--  reservation table
insert into reservation values (1,to_date('03/09/2021','DD/MM/YYYY'),to_date('3-10-2021','DD/MM/YYYY'),2,2,1);
insert into reservation values (2,to_date('7-10-2021','DD/MM/YYYY'),to_date('9-10-2021','DD/MM/YYYY'),2,2,3);
insert into reservation values (3,to_date('9-9-2021','DD/MM/YYYY'),to_date('11-9-2021','DD/MM/YYYY'),3,4,3);
insert into reservation values (4,to_date('13-9-2021','DD/MM/YYYY'),to_date('3-10-2021','DD/MM/YYYY'),4,4,1);
insert into reservation values (5,to_date('23-4-2021','DD/MM/YYYY'),to_date('1-5-2021','DD/MM/YYYY'),5,3,1);
insert into reservation values (6,to_date('9-1-2021','DD/MM/YYYY'),to_date('12-1-2021','DD/MM/YYYY'),3,5,3);
insert into reservation values (7,to_date('20-8-2021','DD/MM/YYYY'),to_date('23-8-2021','DD/MM/YYYY'),1,3,2);
insert into reservation values (8,to_date('6-2-2021','DD/MM/YYYY'),to_date('15-2-2021','DD/MM/YYYY'),1,4,3);
insert into reservation values (9,to_date('30-9-2021','DD/MM/YYYY'),to_date('3-10-2021','DD/MM/YYYY'),1,5,1);

savepoint A;
commit ;

/*    */
select Distinct A.id_client ,A.first_name||A.last_name as full_name, D.ID_ROOM,D.CLASSE,D.contents_of_room,D.prix,B.date_de_reserver,B.date_de_sortir
from client A,rooms D,reservation B,employee C
where B.id_room = D.id_room and B.id_client =A.id_client
and B.id_emp=C.id_emp and lower(C.email)='yassine@gmail.com'
order by A.id_client;

SELECT * FROM EMPLOYEE WHERE LOWER(EMAIL) = 'yassine@gmail.com' AND LOWER(PASSWORD) = 'yassine2';

select id_room,num_adul,num_child,prix from rooms where (PRIX between 300 and 3000) and classe=3 and (num_child between 0 and 2) and (num_adul between 1 and 2);
select * from reservation;
select * from client ;
delete from client where id_client=20;
delete from reservation where id_reserv=10;
select id_emp from employee where lower(email)='yassine@gmail.com';

insert into reservation values (10,to_date('3-4-2021','DD/MM/YYYY'),to_date('5-4-2021','DD/MM/YYYY'),5,3,1);

SELECT R.DATE_DE_RESERVER , P.PRIX
FROM RESERVATION R , ROOMS P
WHERE R.ID_ROOM = P.ID_ROOM
ORDER BY R.DATE_DE_RESERVER DESC;

SELECT * FROM ROOMS;

SELECT ID_ROOM 
FROM ROOMS 
ORDER BY ID_ROOM DESC OFFSET 10 ROWS  ;

SELECT *
FROM ROOMS
FETCH ID_ROOM 1 ROW;

select * from client;
delete from reservation where id_reserv=9;
alter table sign_up add nationality varchar2(20);
select * from reservation;
desc reservation;

insert into reservation values ((select count(id_reserv)+1 as co from reservation),TO_DATE('17-JUN-1987', 'dd-MON-yyyy'),TO_DATE('21-SEP-1989', 'dd-MON-yyyy'),5,(select id_emp from employee where lower(email)='yassine@gmail.com'),3);

update reservation set id_reserv=7 where id_reserv=9;

(select count(id_reserv)+1 as co from reservation)


-- create LOGINLOG table
CREATE TABLE LOGINLOG (
    EMAIL VARCHAR2(100)
);

INSERT INTO LOGINLOG (EMAIL) VALUES ('admin@gmail.com');





-- drop all previous tables
drop table client;
drop table rooms;
drop table reservation;
drop table employee;
drop table sign_up;
