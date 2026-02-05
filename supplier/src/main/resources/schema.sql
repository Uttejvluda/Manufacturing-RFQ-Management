create table supplier(
supplier_id int  auto_increment,
name varchar(25) not null,
email varchar(25) not null,
phone varchar(25) not null,
location varchar(20) not null,
feedback int not null,
primary key (supplier_id) 
);

create table supplier_part(
id int not null auto_increment,
partid int not null auto_increment,
partname varchar(20) not null,
quantity int not null,
timeperiod int not null,
sid int not null,
primary key (id),
foreign key (sid) references supplier(supplier_id)
);