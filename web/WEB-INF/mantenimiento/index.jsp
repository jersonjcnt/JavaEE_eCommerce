<%-- 
    Document   : index
    Created on : 17/07/2018, 09:50:50 PM
    Author     : Jorge Baez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- <%@page import="dao.daoCategoria"%> --%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Mantenimiento de Productos | Crea e-Commerce JAVA EE con pagos Online Paypal y Payu</title>
    <%@include file="../../WEB-INF/1 css.jsp" %>
</head><!--/head-->

<body>
        <%@include file="../../WEB-INF/2 header.jsp" %>
	
        <%-- <%@include file="../../WEB-INF/3 slider.jsp" %> --%>
        
        <%-- <%@include file="../../WEB-INF/4 confianza.jsp" %> --%>
	
        <section>
                <!--
		<div class="container">
			<div class="row">
				<div class="col-sm-3">					
                                        <%-- <%! daoCategoria objCat = new daoCategoria(); %> --%>
                                        <%-- <%@include file="../../WEB-INF/5 barraLateral.jsp" %> --%>
				</div>
								                                                         
                                <div class="col-sm-6 clearfix">
                                    <h3>Mantenimiento de Productos</h3>                                    
                                    <form>
                                        <div class="form-group">
                                            <label for="formGroupExampleInput">Nombre:</label>
                                            <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Nombre">
                                        </div>

                                        <div class="form-group">
                                            <label for="formGroupExampleInput2">Descripción:</label>
                                            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Descripción">
                                        </div>                                      

                                        <div class="form-group">
                                            <label for="formGroupExampleInput3">Precio:</label>
                                            <input type="number" class="form-control" id="formGroupExampleInput3" placeholder="Precio" value="0.0" min="0.0">
                                        </div>   

                                        <div class="form-group">
                                            <label for="formGroupExampleInput4">Precio nuevo:</label>
                                            <input type="number" class="form-control" id="formGroupExampleInput4" placeholder="Precio nuevo" value="0.0" min="0.0">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label for="formGroupExampleInput5">Cantidad:</label>
                                            <input type="number" class="form-control" id="formGroupExampleInput5" placeholder="Cantidad:" value="1" min="1">
                                        </div>
                                    </form>
				</div>
			</div>
		</div>
                -->                                
                
                <div class="container">
                    <div class="row justify-content-center mt-5 pt-5">
                        <div class="col-md-7">                            
                            <ul class="nav nav-tabs">
                                <li class="nav-item active">
                                    <a href="#tab1" class="nav-link active" data-toggle="tab">Matenimiento</a>
                                </li>
                                <li class="nav-item">
                                    <a href="#tab2" class="nav-link" data-toggle="tab">Otras monedas</a>
                                </li>					
                            </ul>

                            <div class="tab-content">
                                <div class="tab-pane active" id="tab1" role="tabpanel">                                                                       
                                    <h1 class="display-4">Productos</h1>
                                    <!-- <hr class="bg-info"> -->
                                    <p class="pb-0 mb-0">Formulario para el mantenimiento de productos.</p>
                                    <p class="text-danger small pt-0 mt-0">*Todos los campos son obligatorios</p>                            
                                    <form action="controlProducto" method="post"> <!-- Vamos a redireccionar a un servlet llamado controlProducto.java vamos a pasar como parametro una variable llamada moneda -->
                                        <div class="row form-group">
                                            <label for="nombre" class="col-form-label col-md-4">Nombre:</label>
                                            <div class="col-md-7">                                        
                                                <input type="text" name="nombre" value="" id="nombre" class="form-control" required>                                           
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>
                                        <!-- 
                                        <div class="row form-group">
                                            <label for="descripcion" class="col-form-label col-md-4">Descricpión:</label>
                                            <div class="col-md-7">
                                                <input type="text" name="descripcion" value="" id="email" class="form-control" required>                                        
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div> 
                                        -->
                                        <div class="row form-group">
                                            <label for="descripcion" class="col-form-label col-md-4">Descripción:</label>
                                            <div class="col-md-7">
                                                <textarea rows="3" class="form-control" id="mensaje" name="descripcion" required></textarea>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <label for="precio" class="col-form-label col-md-4">Precio (MXN):</label>
                                            <div class="col-md-5">
                                                <input type="number" name="precio" value="" id="precio" class="form-control" required value="0" min="0">
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>                                
                                        <div class="row form-group">
                                            <label for="precio-nuevo" class="col-form-label col-md-4">Precio Nuevo (MXN):</label>
                                            <div class="col-md-5">
                                                <input type="number" name="precio-nuevo" value="" id="precio-nuevo" class="form-control" required value="0" min="0">
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>
                                        <div class="row form-group">
                                            <label for="cantidad" class="col-form-label col-md-4">Cantidad:</label>
                                            <div class="col-md-5">
                                                <input type="number" name="cantidad" value="" id="cantidad" class="form-control" required value="1" min="1">
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>
                                        <div class="row form-group">
                                            <label for="cantidad" class="col-form-label col-md-4">Marca:</label>                               
                                            <div class="col-md-5">
                                                <select name="" id="" class="custom-select">
                                                    <option value="1" selected>Opcion 1</option>
                                                    <option value="2">Opcion 2</option>
                                                    <option value="3">Opcion 3</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <label for="categoria" class="col-form-label col-md-4">Categoría:</label>                               
                                            <div class="col-md-5">
                                                <select name="" id="" class="custom-select">
                                                    <option value="1" selected>Opcion 1</option>
                                                    <option value="2">Opcion 2</option>
                                                    <option value="3">Opcion 3</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <label for="categoria" class="col-form-label col-md-4">Opciones:</label> 
                                            <div class="col-md-5">                                        
                                                <div class="form-check">
                                                        <label class="form-check-label">
                                                                <input type="checkbox" name="nuevo" id="nuevo" value="ON" checked="checked"> Nuevo
                                                        </label>
                                                </div>

                                                <div class="form-check">
                                                        <label class="form-check-label">
                                                                <input type="checkbox" name="recomendado" id="recomendado" value="OFF"> Recomendado
                                                        </label>
                                                </div>

                                                <div class="form-check">
                                                        <label class="form-check-label">
                                                                <input type="checkbox" name="visible" id="visible" value="ON" checked="checked"> Visible
                                                        </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <label for="imagen" class="col-form-label col-md-4">Imágen:</label>
                                            <div class="col-md-7">
                                                <input type="file" name="imagen" value="" id="imagen" class="form-control" required>
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>
                                        <button type="submit" class="btn btn-info" value="Registrar">Enviar</button>
                                        <button type="submit" class="btn btn-info" value="Consultar">Consultar</button>
                                        <button type="submit" class="btn btn-info" value="Actualizar">Actualizar</button>
                                        <button type="submit" class="btn btn-info" value="Borrar">Borrar</button>
                                    </form>
                                </div>
                                <div class="tab-pane" id="tab2" role="tabpanel">
                                    <h1 class="display-4">Productos</h1>
                                    <!-- <hr class="bg-info"> -->
                                    <p class="pb-0 mb-0">Formulario para el mantenimiento de productos.</p>
                                    <p class="text-danger small pt-0 mt-0">*Todos los campos son obligatorios</p>                            
                                    <form id="formulario" novalidate>                                        
                                        <div class="row form-group">
                                            <label for="precio-usd" class="col-form-label col-md-4">Precio (USD):</label>
                                            <div class="col-md-5">
                                                <input type="number" name="precio-usd" value="" id="precio" class="form-control" required value="0" min="0">
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>                                
                                        <div class="row form-group">
                                            <label for="precio-nuevo-usd" class="col-form-label col-md-4">Precio Nuevo (USD):</label>
                                            <div class="col-md-5">
                                                <input type="number" name="precio-nuevo-usd" value="" id="precio-nuevo" class="form-control" required value="0" min="0">
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>
                                        <div class="row form-group">
                                            <label for="precio-cop" class="col-form-label col-md-4">Precio (COP):</label>
                                            <div class="col-md-5">
                                                <input type="number" name="precio-cop" value="" id="precio" class="form-control" required value="0" min="0">
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>                                
                                        <div class="row form-group">
                                            <label for="precio-nuevo-cop" class="col-form-label col-md-4">Precio Nuevo (COP):</label>
                                            <div class="col-md-5">
                                                <input type="number" name="precio-nuevo-cop" value="" id="precio-nuevo" class="form-control" required value="0" min="0">
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>
                                        <div class="row form-group">
                                            <label for="precio-pen" class="col-form-label col-md-4">Precio (PEN):</label>
                                            <div class="col-md-5">
                                                <input type="number" name="precio-pen" value="" id="precio" class="form-control" required value="0" min="0">
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>                                
                                        <div class="row form-group">
                                            <label for="precio-nuevo-pen" class="col-form-label col-md-4">Precio Nuevo (PEN):</label>
                                            <div class="col-md-5">
                                                <input type="number" name="precio-nuevo-pen" value="" id="precio-nuevo" class="form-control" required value="0" min="0">
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>
                                    </form>
                                </div>                                
                            </div>                                                                                    
                            <br /><br /><br /><br /><br />
                        </div>
                    </div>
                </div>
	</section>
			
        <%@include file="../../WEB-INF/6 footer.jsp" %>
  
        <%@include file="../../WEB-INF/7 js.jsp" %>
</body>
</html>
