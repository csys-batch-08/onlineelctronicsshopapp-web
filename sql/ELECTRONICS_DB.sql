



create table user_details(user_id number generated always as identity(start with 1 increment by 1),
user_name varchar2(20) not null,
email_id varchar2(30) not null,
password varchar2(20) not null,
contact_number number(20) not null,
address varchar2(200),
constraint pk_user primary key(user_id));

alter table user_details add role varchar2(10);
alter table user_details drop column wallet;
 
alter table user_details modify(wallet number(10,2) default '50000');
update user_details set wallet=0 where role='admin';
select *from user_details;
alter table user_details add wallet number(10,2) default 50000;

alter table user_details modify role varchar2(10) default 'user';
insert into user_details (user_name,email_id,password,contact_number,address,role) values('atchaya','atchu23@gmail.com','atchu465',9773412098,'23/2teachers colony,madurai','admin');
insert into user_details(user_name,email_id,password,contact_number,address,role)values('soniya','soniya123@gmail.com','sonyvrvs',9747837279,'55/3jeeva nagar,madurai.','user');
select*from user_details;
select * from user_details where role='user';

desc user_details;
select * from component_info;
select component_id,component_name,category_name,description,total_price,status,picture from component_info;
commit;
update component_info set total_price=12  where component_id=300;
select * from  user_details;
delete from user_details where user_id=126; 

-----component table 
 create table component_info(component_id number generated always as identity(start with 300 increment by 1),
component_name varchar2(100),
category_name varchar2(30),
description varchar2(500),
 total_price number(10,2),
 constraint pk_comid primary key(component_id));
 desc component_info;
 select *from component_info;
 desc component_info;
 
 
 
 
 
 select*from component_info where component_name like '%tem%';
 update component_info set status='not available' where component_id=361;
 
 insert into component_info (component_name,category_name,description,total_price)
 values('Logic Ic','Integrated circuit',' 5V 3-State Output Quad Buffer 14-Pin SOIC',10.54);
 insert into component_info (component_name,category_name,description,total_price)
 values('Biomedical sensor','Sensor','Digital Bidirectional Proximal Flow Sensor single-use',4930.00);
 insert into component_info (component_name,category_name,description,total_price)
 values('Current sensor','sensors','Hall Effect based Linear Current Sensor (0-35A)',278.78);

 insert into component_info (component_name,category_name,description,total_price)
 values('green led','Opto electronics','5mm green led kit',20.54);
 insert into component_info (component_name,category_name,description,total_price)
 values('Thyristors','Discrete semiconductors','600V 16A Standard Triac Thyristor Through Hole TO-220AB',10.54);
 insert into component_info (component_name,category_name,description,total_price)
 values('ARM Cortex M3 Microcontroller','Integrated circuit','32bit ARM Cortex M3 Microcontroller 72MHz 64kB Flash 48-Pin LQFP',767.00);
 desc component_info;
 
 insert into component_info (component_name,category_name,description,total_price)
 values('Finger print','Communication','Capacitive Fingerprint Reader with onboard processor',3975.00);
 insert into component_info (component_name,category_name,description,total_price)
 values('Fiber optic connectors','Connectors','DH24 Series Male Plug Double-Mode LC IP67 Waterproof Fibre Optic Connector 3M Cable',2549.40);

insert into component_info (component_name,category_name,description,total_price)
values('Universal Thermocouple amplifiers','Boards,kits,programmers','evalution board Universal Thermocouple Amplifier  Breakout',1655.00);
insert into component_info (component_name,category_name,description,total_price)
values('Slow Blow Glass Cartridge Fuse','circuit protection','0.5A 5x20mm Slow Blow Glass Cartridge Fuse kit',59.00);
insert into component_info (component_name,category_name,description,total_price)
values(' Test and Measuring Instruments','Tools and Hardwares','PC-Oscilloscope 20MHz 48MSa/s USB 2Channel Small Size Plug and Play',6659.63);

 insert into component_info (component_name,category_name,description,total_price)
 values('AVR RISC Microcontroller','Integrated circuites','8-bit AVR RISC Microcontroller 256KB Flash TQFP-100',1056.10);

delete from component_info where component_id=360;
select*from component_info;
select component_name from component_info where component_id=340;
select * from component_info where category_name='circuit protection';
alter table component_info add picture varchar2(2000);
update component_info set description='DH24 Series Male Plug Double-Mode LC IP67 Waterproof' where component_id=341;
update component_info set picture='test tool.jpg' where component_id=344;




select * from  user_details;

create table cart(cart_id number generated always as identity(start with 1000 increment by 1),
user_id number,
component_id number,
constraint pk_iid primary key(cart_id),
constraint fk_user foreign key(user_id) references user_details (user_id),
constraint fk_comid foreign key(component_id) references component_info(component_id));
drop table cart;
select cart_id,user_id,component_id from cart;
select*from cart;
select *from cart where user_id=102;

delete from cart where cart_id=1017;
select *from user_details;
select*from orders_table where user_id=125;

select component_name,category_name,description,total_price,status from component_info where component_id in(select component_id from cart where user_id=121);
		    

create table orders_table(order_id number generated always as identity(start with 500 increment by 1) primary key,
user_id number,
component_id number,
quantity int,
total_price number(10,2),
address varchar2(200),
order_date date default sysdate, 
constraint fk_userid foreign key(user_id) references user_details (user_id));
drop table orders_table;
select * from orders_table;
alter table orders_table modify order_date timestamp;
drop table orders_table;
select*from orders_table where user_id=102;
update orders_table set order_status='delivered' where order_id=500;
select *from orders_table where user_id=124 order by order_date desc;

select component_id,sum(total_price) from orders_table where order_status='delivered' and order_date between '06-01-22' and '13-01-22' group by component_id; 


alter table orders_table add order_status varchar2(100) default'Not delivered';
alter table orders_table modify order_status default 'not delivered';
alter table orders_table drop column order_status;
commit;



commit;

select * from user_details where role='user' and email_id='sneka37@gmail.com'  and password='snek73892';
select user_name,email_id,password,contact_number,address,wallet from user_details where user_id=123;
select * from user_details;


delete from cart where user_id=360;

         select u.user_name,c.component_name,o.quantity,o.total_price,o.order_date from user_details
         u join orders_table o on u.user_id=o.user_id
         join component_info c on c.component_id=o.component_id where o.user_id=141 order by o.order_id desc;
            
            
            
            
  select *from user_details;
  select*from component_info;
  select*from cart;
  select*from orders_table;
            
            
            