create table part(
partid int not null auto_increment,
partdescription varchar(25),
partspecification varchar(25),
stockinhand int,
primary key (partid) 
);

create table demand(
demandid int not null auto_increment,
demandcount int,
demandraiseddate date,
partid int not null,
primary key (demandid),
foreign key (partid) references part(partid)
);

create table reorderrules(
rrid int not null auto_increment,
demandid int,
minquantity int,
maxquantity int,
reorderfrequency int,
partid int not null,
primary key (demandid),
foreign key (partid) references part(partid)
);


create table plantreorderdetails(
prdid int not null auto_increment,
reorderstatus varchar(25),
reorderdate date,
partid int not null,
primary key (prdid),
foreign key (partid) references part(partid)
);