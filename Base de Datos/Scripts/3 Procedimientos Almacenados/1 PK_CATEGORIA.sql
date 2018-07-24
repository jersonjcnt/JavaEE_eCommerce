/*Procedimiento Almacenado que carga la tabla CATEGORIA*/
/*Cuando el idcat y cat_sup de una categoria son iguales significa que esa categoria es una categoria principal*/
DELIMITER //
create or replace procedure usp_cargarListCategoriaSuperior()
begin
	select   c.IDCAT,c.NOM_CAT,c.EST_CAT,c.CATSUP_CAT
	from     categoria c
    where	 c.IDCAT = c.CATSUP_CAT and c.EST_CAT = 1
 	order by c.IDCAT;
end; //
DELIMITER &&
call usp_cargarListCategoriaSuperior();

/*Procedimiento Almacenado que carga la tabla CATEGORIA*/
/*Cuando el idcat y cat_sup de una categoria no son iguales significa que esa categoria es una subcategoria, solo se mostraran las subcategorias de la categoria principal que se especifique*/
/*<> means not equal to !=*/
DELIMITER //
create or replace procedure usp_cargarListSubCategoria(
	catsup int
)
begin
	select   c.IDCAT,c.NOM_CAT,c.EST_CAT,c.CATSUP_CAT
	from     categoria c
    where	 c.IDCAT <> c.CATSUP_CAT and c.EST_CAT = 1 and c.CATSUP_CAT = catsup
 	order by c.IDCAT;
end; //
DELIMITER &&
call usp_cargarListSubCategoria(5);

/*Procedimiento Almacenado que obtiene la cantidad de subcategorias por categorias superiores de la tabla CATEGORIA*/
DELIMITER //
create or replace procedure usp_getNumeroSubCategoria(
	catsup int
)
begin
	select count(*) as idc
	from   categoria c
    where  c.CATSUP_CAT = catsup and c.IDCAT <> catsup;
end; //
DELIMITER &&
call usp_getNumeroSubCategoria(5);

/*Procedimiento Almacenado que carga la tabla CATEGORIA*/
DELIMITER //
create or replace procedure usp_cargarListCategoria()
begin
	select   c.IDCAT,c.NOM_CAT,c.EST_CAT,c.CATSUP_CAT
	from     categoria c
    where	 c.EST_CAT = 1
 	order by c.IDCAT;
end; //
DELIMITER &&
call usp_cargarListCategoria();