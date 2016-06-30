drop database if exists aula;
create database aula;
use aula;

create table professor(
    codprofessor        integer         auto_increment      primary key,
    nome                varchar(50)     not null
);

create table turma(
    codturma            integer         auto_increment      primary key,
    nome                varchar(35)     not null,
    datainicio          date            not null,
    descricao           text            not null,
    codprofessor        integer         not null
);

alter table turma add constraint fk_professor
foreign key(codprofessor) references professor(codprofessor);

insert into professor(nome) values('Sergio Mendes');
insert into professor(nome) values('Edson Belem');
insert into professor(nome) values('Rodrigo NetCat');

select * from professor;
