create databeses if not exists jogoCerto;
use jogoCerto;

create table if not exists concurso
(
    codConcurso int not null auto_increment,
    numero int not null,
    dataConcurso date not null, 
    primary key (codCurso)
);

create table if not exists numeros 
(
    codNumero int not null auto_increment,
    codConcurso int not null,
    numero int,
    primary key (codNumero),
    foreign key (codConcurso) references concurso (codConcurso) on delete cascade
);
