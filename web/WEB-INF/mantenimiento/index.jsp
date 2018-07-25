<%-- 
    Document   : index
    Created on : 17/07/2018, 09:50:50 PM
    Author     : Jorge Baez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.daoMarca"%>
<%@page import="modelos_JavaBeans.marca"%>
<%@page import="dao.daoCategoria"%>
<%@page import="modelos_JavaBeans.categoria"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Mantenimiento de Productos | Crea e-Commerce JAVA EE con pagos Online Paypal y Payu</title>
    <%@include file="../../WEB-INF/1 css.jsp" %> <%-- <%@include file="../1 css.jsp" %> --%>
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
                
                                <div class="col-sm-9 padding-right">
                                    
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
                                    ${ mensajeExito }
                                    ${ mensajeError }
                                    ${ insertProductoMoneda_SQLException }
                                    ${ mensajeError2 }
                                    ${ Datos }                                    
                                    <form action="controladorProducto" method="post" enctype="multipart/form-data"> <!-- Vamos a redireccionar a un servlet llamado controlProducto.java vamos a pasar como parametro una variable llamada moneda -->
                                        <div class="row form-group">
                                            <label for="nombre" class="col-form-label col-md-4">Nombre:</label>
                                            <div class="col-md-7">                                        
                                                <input type="text" name="nombre" value="" id="nombre" class="form-control" required>                                           
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>     
                                        <div class="row form-group">
                                            <label for="descripcion" class="col-form-label col-md-4">Descripción:</label>
                                            <div class="col-md-7">
                                                <textarea rows="3" name="descripcion" id="descripcion" class="form-control" required></textarea>
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>
                                        <div class="row form-group">
                                            <label for="precio-mxn" class="col-form-label col-md-4">Precio (MXN):</label>
                                            <div class="col-md-5">
                                                <input type="number" name="precio-mxn" value="0" id="precio-mxn" class="form-control" min="0" required>
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>                                
                                        <div class="row form-group">
                                            <label for="precio-nuevo-mxn" class="col-form-label col-md-4">Precio Nuevo (MXN):</label>
                                            <div class="col-md-5">
                                                <input type="number" name="precio-nuevo-mxn" value="0" id="precio-nuevo-mxn" class="form-control" min="0" required>
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>                                        
                                        <div class="row form-group">
                                            <label for="precio-usd" class="col-form-label col-md-4">Precio (USD):</label>
                                            <div class="col-md-5">
                                                <input type="number" name="precio-usd" value="0" id="precio-usd" class="form-control" min="0" required>
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>                                
                                        <div class="row form-group">
                                            <label for="precio-nuevo-usd" class="col-form-label col-md-4">Precio Nuevo (USD):</label>
                                            <div class="col-md-5">
                                                <input type="number" name="precio-nuevo-usd" value="0" id="precio-nuevo-usd" class="form-control" min="0" required>
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>
                                        <div class="row form-group">
                                            <label for="precio-cop" class="col-form-label col-md-4">Precio (COP):</label>
                                            <div class="col-md-5">
                                                <input type="number" name="precio-cop" value="0" id="precio-cop" class="form-control" min="0" required>
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>                                
                                        <div class="row form-group">
                                            <label for="precio-nuevo-cop" class="col-form-label col-md-4">Precio Nuevo (COP):</label>
                                            <div class="col-md-5">
                                                <input type="number" name="precio-nuevo-cop" value="0" id="precio-nuevo-cop" class="form-control" min="0" required>
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>
                                        <div class="row form-group">
                                            <label for="precio-pen" class="col-form-label col-md-4">Precio (PEN):</label>
                                            <div class="col-md-5">
                                                <input type="number" name="precio-pen" value="0" id="precio-pen" class="form-control" min="0" required>
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>                                
                                        <div class="row form-group">
                                            <label for="precio-nuevo-pen" class="col-form-label col-md-4">Precio Nuevo (PEN):</label>
                                            <div class="col-md-5">
                                                <input type="number" name="precio-nuevo-pen" value="0" id="precio-nuevo-pen" class="form-control" min="0" required>
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>                                        
                                        <div class="row form-group">
                                            <label for="cantidad" class="col-form-label col-md-4">Cantidad:</label>
                                            <div class="col-md-5">
                                                <input type="number" name="cantidad" value="1" id="cantidad" class="form-control" min="1" required>
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>
                                        <%! daoMarca objMar = new daoMarca(); %>
                                        <div class="row form-group">
                                            <label for="marca" class="col-form-label col-md-4">Marca:</label>                               
                                            <div class="col-md-5">
                                                <select name="marca" id="marca" class="form-control" required>
                                                    <option value="" selected>Seleccionar marca</option>
                                                    <% for (marca m:objMar.cargarListMarca()){ %>
                                                        <option value="<%= m.getIdmar()%>"><%= m.getNom() %></option>
                                                    <% } %>
                                                    
                                                    <!--
                                                    <select name="marca" id="marca" class="form-control" required>
                                                        option value="" selected>Seleccionar marca</option>
							<option value="1">Opción 1</option>
							<option value="2">Opción 2</option>
							<option value="3">Opción 3</option>
                                                    </select>
                                                    -->
                                                </select>
                                            </div>
                                        </div>
                                        <%! daoCategoria objCat = new daoCategoria(); %>
                                        <div class="row form-group">                                            
                                            <label for="categoria" class="col-form-label col-md-4">Categoría:</label>                               
                                            <div class="col-md-5">
                                                <select name="categoria" id="categoria" class="form-control" required>
                                                    <option value="" selected>Seleccionar categoría</option>
                                                    <% for (categoria c:objCat.cargarListCategoria()) { %>
                                                        <option value="<%= c.getIdcat() %>"><%= c.getNom() %></option>
                                                    <% } %>
                                                    
                                                    <!--
                                                    <select name="categoria" id="categoria" class="form-control" required>
                                                        option value="" selected>Seleccionar categoría</option>
							<option value="1">Opción 1</option>
							<option value="2">Opción 2</option>
							<option value="3">Opción 3</option>
                                                    </select>
                                                    -->
                                                </select>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <label for="opciones" class="col-form-label col-md-4">Opciones:</label> 
                                            <div class="col-md-5">                                        
                                                <div class="form-check">
                                                    <label class="form-check-label">
                                                        <input type="checkbox" name="nuevo" value="ON" id="nuevo" class="form-check-input mr-2 mb-3" checked="checked"> Nuevo
                                                    </label>
                                                </div>

                                                <div class="form-check">
                                                    <label class="form-check-label">
                                                        <input type="checkbox" name="recomendado" value="ON" id="recomendado" class="form-check-input mr-2 mb-3"> Recomendado
                                                    </label>
                                                </div>

                                                <div class="form-check">
                                                    <label class="form-check-label">
                                                        <input type="checkbox" name="visible" value="ON" id="visible" class="form-check-input mr-2 mb-3" checked="checked"> Visible
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <label for="imagen" class="col-form-label col-md-4">Imágen:</label>
                                            <div class="col-md-7">
                                                <input type="file" name="imagen" value="imagen" id="imagen" class="form-control" required>
                                            </div>
                                            <p class="text-danger small pt-0 mt-0">*</p>
                                        </div>
                                        <button type="submit" name="action" value="Enviar" class="btn btn-info">Enviar</button>
                                        <button type="submit" name="action" value="Consultar" class="btn btn-info">Consultar</button>
                                        <button type="submit" name="action" value="Actualizar" class="btn btn-info">Actualizar</button>
                                        <button type="submit" name="action" value="Borrar" class="btn btn-info">Borrar</button>
                                    </form>
                                </div>
                                <div class="tab-pane" id="tab2" role="tabpanel">
                                    <h1 class="display-4">Productos</h1>
                                    <!-- <hr class="bg-info"> -->
                                    <p class="pb-0 mb-0">Formulario para el mantenimiento de productos.</p>
                                    <p class="text-danger small pt-0 mt-0">*Todos los campos son obligatorios</p>
                                </div>                                
                            </div>                                                                                    
                            <br /><br /><br /><br /><br />
                        </div><!-- .col -->
                    </div><!-- .row -->
                </div><!-- .container -->
	</section>
			
        <%@include file="../../WEB-INF/6 footer.jsp" %>
  
        <%@include file="../../WEB-INF/7 js.jsp" %>
</body>
</html>
