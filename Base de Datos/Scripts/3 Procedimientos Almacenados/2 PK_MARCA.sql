/*Procedimiento Almacenado que carga la tabla MARCA*/
DELIMITER //
create or replace procedure usp_cargarListMarca()
begin
	select   m.IDMAR,m.NOM_MAR,m.EST_MAR
	from     marca m
    where	 m.EST_MAR = 1
 	order by m.IDMAR;
end; //
DELIMITER &&
call usp_cargarListMarca();