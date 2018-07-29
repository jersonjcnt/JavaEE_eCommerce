insert into categoria values(1,'ROPA DEPORTIVA',1,1);
insert into categoria values(2,'FITNESS',1,1);
insert into categoria values(3,'CAMPING',1,1);
insert into categoria values(4,'ZAPATILLAS',1,1);
insert into categoria values(5,'HOMBRES',1,5);
insert into categoria values(6,'CAMISAS',1,5);
insert into categoria values(7,'SACOS',1,5);
insert into categoria values(8,'PANTALONES',1,5);
insert into categoria values(9,'MUJERES',1,9);
insert into categoria values(10,'BLUSAS',1,9);
insert into categoria values(11,'NIÑOS',1,11);

/*Es mejor especificar el ID y no depender de la propiedad AutoIncrementable*/
/*Si se especifica el ID, la propiedad AutoIncrementable no se ejecuta, esto conlleva a crear tu propio Procedimiento Almacenado para generar los ID*/
insert into marca values(1,'ADIDAS',1);
insert into marca values(2,'LACOSTE',1);
insert into marca values(3,'NIKE',1);
insert into marca values(4,'PUMA',1);
insert into marca values(5,'GIARDINI',1);

/*Si no se especifica el ID, la propiedad AutoIncrementable se ejecuta*/
insert into marca (nom_mar,est_mar) values('ADIDAS',1);
insert into marca (nom_mar,est_mar) values('LACOSTE',1);
insert into marca (nom_mar,est_mar) values('NIKE',1);
insert into marca (nom_mar,est_mar) values('PUMA',1);
insert into marca (nom_mar,est_mar) values('GIARDINI',1);

/*Si no se especifica el ID, la propiedad AutoIncrementable se ejecuta*/
insert into marca values(null,'ADIDAS',1);
insert into marca values(null,'LACOSTE',1);
insert into marca values(null,'NIKE',1);
insert into marca values(null,'PUMA',1);
insert into marca values(null,'GIARDINI',1);

commit;