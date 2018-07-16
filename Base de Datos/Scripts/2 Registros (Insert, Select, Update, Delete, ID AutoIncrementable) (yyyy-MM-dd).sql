insert into categoria values(1,'ROPA DEPORTIVA',1,1);
insert into categoria values(2,'NIKE',1,1);
insert into categoria values(3,'ADIDAS',1,1);
insert into categoria values(4,'PUMA',1,1);
insert into categoria values(5,'HOMBRE',1,5);
insert into categoria values(6,'SACOS',1,5);
insert into categoria values(7,'PANTALONES',1,5);

/*Es mejor especificar el ID y no depender de la propiedad AutoIncrementable*/
/*Si se especifica el ID, la propiedad AutoIncrementable no se ejecuta, esto conlleva a crear tu propio Procedimiento Almacenado para generar los ID*/
insert into marca values(1,'MARCA 1',1);
insert into marca values(2,'MARCA 2',1);
insert into marca values(3,'MARCA 3',1);

/*Si no se especifica el ID, la propiedad AutoIncrementable se ejecuta*/
insert into marca (nom_mar) values('MARCA 1',1);
insert into marca (nom_mar) values('MARCA 2',1);
insert into marca (nom_mar) values('MARCA 3',1);

commit;