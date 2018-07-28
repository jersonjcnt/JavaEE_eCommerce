/*Procedimiento Almacenado que carga la tabla EMPLEADO*/
DELIMITER //
create or replace procedure usp_cargarListProducto(
	mon varchar(3)
)
begin
	if mon = 'MXN' then /*<>, means not equal to, != also means not equal to*/
		select     p.IDPRO,p.NOM_PRO,p.DES_PRO,p.PRE_PRO,p.PRENUE_PRO,p.STO_PRO,m.NOM_MAR,c.NOM_CAT,p.NUE_PRO,p.REC_PRO,p.EST_PRO,p.IMG_PRO				   
		from       producto as p		
		inner join marca as m on p.IDMAR = m.IDMAR
		inner join categoria as c on p.IDCAT = c.IDCAT
		where      p.EST_PRO = 1 and m.EST_MAR = 1 and c.EST_CAT = 1
		order by   p.IDPRO;			
    else		
		select     p.IDPRO,p.NOM_PRO,p.DES_PRO,p.PRE_PRO,p.PRENUE_PRO,p.STO_PRO,m.NOM_MAR,c.NOM_CAT,p.NUE_PRO,p.REC_PRO,p.EST_PRO,p.IMG_PRO,
				   mon.NOM_MON,mon.PRE_PRO,mon.PRENUE_PRO
		from       producto as p
		inner join moneda as mon on p.IDPRO = mon.IDPRO
		inner join marca as m on p.IDMAR = m.IDMAR
		inner join categoria as c on p.IDCAT = c.IDCAT
		where      p.EST_PRO = 1 and m.EST_MAR = 1 and c.EST_CAT = 1 and mon.NOM_MON = mon
		order by   p.IDPRO;
	end if;
end; //
DELIMITER &&

/*Procedimiento Almacenado que carga la tabla EMPLEADO*/
DELIMITER //
create or replace procedure usp_cargarListProductoPorCategoria(
	mon varchar(3),
    cat varchar(50)
)
begin
	if mon = 'MXN' then /*<>, means not equal to, != also means not equal to*/
		select     p.IDPRO,p.NOM_PRO,p.DES_PRO,p.PRE_PRO,p.PRENUE_PRO,p.STO_PRO,m.NOM_MAR,c.NOM_CAT,p.NUE_PRO,p.REC_PRO,p.EST_PRO,p.IMG_PRO				   
		from       producto as p		
		inner join marca as m on p.IDMAR = m.IDMAR
		inner join categoria as c on p.IDCAT = c.IDCAT
		where      p.EST_PRO = 1 and m.EST_MAR = 1 and c.EST_CAT = 1 and c.NOM_CAT = cat
		order by   p.IDPRO;			
    else		
		select     p.IDPRO,p.NOM_PRO,p.DES_PRO,p.PRE_PRO,p.PRENUE_PRO,p.STO_PRO,m.NOM_MAR,c.NOM_CAT,p.NUE_PRO,p.REC_PRO,p.EST_PRO,p.IMG_PRO,
				   mon.NOM_MON,mon.PRE_PRO,mon.PRENUE_PRO
		from       producto as p
		inner join moneda as mon on p.IDPRO = mon.IDPRO
		inner join marca as m on p.IDMAR = m.IDMAR
		inner join categoria as c on p.IDCAT = c.IDCAT
		where      p.EST_PRO = 1 and m.EST_MAR = 1 and c.EST_CAT = 1 and mon.NOM_MON = mon and c.NOM_CAT = cat
		order by   p.IDPRO;
	end if;
end; //
DELIMITER &&

/*Procedimiento Almacenado que inserta un nuevo registro en la tabla PRODUCTO y nuevos registros en la tabla MONEDA*/
DELIMITER //
create or replace procedure usp_insertProductoMoneda(		
    nom    varchar(50),  
	des    varchar(250),
	mxn    decimal(19,2),
	nuemxn decimal(19,2),
    sto    int,
    idm	   int,
    idc    int,    
    nue    tinyint(1),
    rec    tinyint(1),
    est    tinyint(1),
    img    varchar(250),
    
    nomusd varchar(3),
    usd    decimal(19,2),
    nueusd decimal(19,2),
    
    nomcop varchar(3),
    cop    decimal(19,2),    
    nuecop decimal(19,2),
    
    nompen varchar(3),
    pen    decimal(19,2),
    nuepen decimal(19,2)
)
begin		
    declare idp int; /*Las variable se deben declarar después del begin*/
    
    insert into producto values(null,nom,des,mxn,nuemxn,sto,idm,idc,nue,rec,est,img);
        	
    set idp = (select last_insert_id()); /*Le asignamos a la variable idp el ultimo idpro generado*/            
    insert into moneda values(nomusd,idp,usd,nueusd);
    insert into moneda values(nomcop,idp,cop,nuecop);
    insert into moneda values(nompen,idp,pen,nuepen);    
end; //
DELIMITER &&

call usp_cargarListProducto('MXN');
call usp_cargarListProductoPorCategoria('MXN','NIKE');
call usp_insertProductoMoneda("a","b",0,0,1,1,1,1,1,1,"0123456789.png","PEN",0,0,"COP",0,0,"USD",0,0);