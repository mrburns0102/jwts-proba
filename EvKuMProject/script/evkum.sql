create table grad (
	ptt_broj int,
    naziv varchar(45) not null,
    primary key (ptt_broj) 
);

create table km (
	km_id int auto_increment,
    naziv varchar(60) not null unique,
	br_posetilaca int not null,
    grad int not null,
    primary key (km_id),
    foreign key (grad) references grad(ptt_broj)
);

insert into grad (ptt_broj, naziv) values (11000, 'Beograd');
insert into grad (ptt_broj, naziv) values (21000, 'Novi Sad');
insert into grad (ptt_broj, naziv) values (24000, 'Subotica');
insert into grad (ptt_broj, naziv) values (34000, 'Kragujevac');
insert into grad (ptt_broj, naziv) values (22320, 'Inđija');

insert into km(naziv, br_posetilaca, grad) values ('Beer Fest', 600000, 11000);
insert into km(naziv, br_posetilaca, grad) values ('Exit', 140000, 21000);
insert into km(naziv, br_posetilaca, grad) values ('Scena Fest', 7000, 22320);

