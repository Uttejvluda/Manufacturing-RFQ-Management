create table rfq(
rfqid int not null auto_increment,
demandid int,
partid int,
quantity int,
partname varchar(25),
timetosupply int,
specification varchar(25),
primary key (rfqid)
);