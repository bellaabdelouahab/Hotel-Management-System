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


CREATE TABLE reservation(
    id_reserv Number(3) constraint pk_reser primary Key, 
    id_emp NUMBER(4) CONSTRAINT emp_fk REFERENCES employee,
    date_de_sortir Date ,
    date_de_reserver Date,
    cin Varchar2(8) 
);

alter table reservation DISABLE constraint client_fk;
alter table reservation add CONSTRAINT client_fk foreign key(cin) REFERENCES client(cin);

insert into reservation values (1,2,to_date('03/10/2021' , 'dd/mm/yyyy'), to_date('03/09/2021', 'dd/mm/yyyy'),2);
insert into reservation values (2,2,'13-1-2021','3-12-2020',3);
insert into reservation values (3,2,'30-7-2021','3-6-2021',3);
insert into reservation values (4,3,'3-11-2021','3-10-2021',1);
insert into reservation values (5,3,'13-2-2020','9-2-2020',1);
insert into reservation values (6,4,'25-8-2021','3-7-2021',3);
insert into reservation values (7,4,'15-12-2021','3-9-2021',2);
insert into reservation values (8,4,'13-12-2021','3-12-2021',3);
insert into reservation values (9,2,'30-7-2020','3-6-2020',1);
select * from reservation;

alter table reservation ENABLE constraint client_fk;


CREATE TABLE rooms(
    ID_ROOM NUMBER,
    DATE_ENTRE DATE,
    DATE_SORTIE DATE,
    NUM_ADUL NUMERIC ,
    NUM_CHILD NUMERIC ,
    CLASSE NUMERIC ,
    PRIX NUMERIC,
    id_reserv Number(3) 
);

alter table rooms drop column NUM_ROOM;
insert into rooms values (1,to_date('03/10/2021' , 'dd/mm/yyyy'),to_date('03/11/2021' , 'dd/mm/yyyy'),2,1,3,500,1);
insert into rooms values (2,to_date('13/12/2020' , 'dd/mm/yyyy'),to_date('03/01/2021' , 'dd/mm/yyyy'),3,0,4,1000,1);
insert into rooms values (3,to_date('10/01/2020' , 'dd/mm/yyyy'),to_date('05/05/2021' , 'dd/mm/yyyy'),3,0,4,1000,1);
insert into rooms values (4,to_date('09/11/2020' , 'dd/mm/yyyy'),to_date('18/07/2021' , 'dd/mm/yyyy'),3,0,4,1000,1);
insert into rooms values (5,to_date('19/11/2020' , 'dd/mm/yyyy'),to_date('09/10/2021' , 'dd/mm/yyyy'),3,0,4,1000,1);


alter table rooms add constraint reserv_fk FOREIGN key(id_reserv) REFERENCES reservation(id_reserv);
select * from rooms;

create table client(
    cin Varchar2(8) CONSTRAINT client_pk primary key,
    first_name varchar2(12),
    last_name  varchar2(17),
    nationality varchar2(10),
    gender varchar2(3),
    etat_civil varchar2(10),
    age number(2),
    id_reserv Number(3) 
);

alter table client add CONSTRAINT reserver_fk foreign key(id_reserv) REFERENCES reservation(id_reserv);
savepoint A;
commit ;

select Distinct B.cin,B.last_name||b.first_name,C.ID_ROOM,C.CLASSE,C.DATE_ENTRE,C.prix 
from reservation A,client B,rooms C, employee D
where  C.id_reserv in (select id_reserv from reservation where id_emp=(select id_emp from employee where lower(email)='yassine@gmail.com'))
and B.id_reserv in (select id_reserv from reservation where id_emp=(select id_emp from employee where lower(email)='yassine@gmail.com'))
and A.id_emp= (select id_emp from employee where lower(email)='yassine@gmail.com');

insert into client values (1,'omar','hhh','francaise','h','clebatair',20,1);
insert into client values (2,'ilham','bbb','marocian','f','marie',22,1);
insert into client values (3,'khalid','jjjj','tunisie','f','devorce',35,1);

select DATE_ENTRE , PRIX 
from rooms 
ORDER BY DATE_ENTRE DESC;