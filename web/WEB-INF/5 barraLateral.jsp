                                        <%@page import="dao.daoCategoria"%> <%-- Metodo Pro --%>
                                        <%@page import="modelos_JavaBeans.categoria"%> <%-- Metodo Pro --%>
                                        <%! daoCategoria objCat = new daoCategoria(); %> <%-- Metodo Pro --%>                                        
                                        <div class="left-sidebar">
                                                <h2>Categorías</h2>
						<div class="panel-group category-products" id="accordian"><!--category-products-->
                                                        <%! int idCategoriaSuperior; %>
                                                        <%                                                             
                                                            for (categoria cs:objCat.cargarListCategoriaSuperior()) { 
                                                                idCategoriaSuperior = cs.getIdcat();
                                                        %>
                                                                <div class="panel panel-default">
                                                                        <div class="panel-heading">
                                                                                <h4 class="panel-title">
                                                                                        <a                                                                                                 
                                                                                                <%  if (objCat.getNumeroSubCategoria(idCategoriaSuperior) > 0) { %>
                                                                                                        data-toggle="collapse" data-parent="accordian" <%-- El enlace podra colapsarse --%>
                                                                                                <%  } %>  
                                                                                                        href="#<%= idCategoriaSuperior %>"> <%-- Al presionar los enlaces de Categoria Superior hace referencia href="#KKK" a la etiqueta que tiene id="KKK" --%>
                                                                                                <%  if (objCat.getNumeroSubCategoria(idCategoriaSuperior) > 0) { %>
                                                                                                        <span class="badge pull-right"><i class="fa fa-plus"></i></span> <%-- En enlace tendra un icono --%>                                                                                                                                                                                          
                                                                                                <%  } %>        
                                                                                                <%= cs.getNom() %>
                                                                                                <%-- 
                                                                                                ROPA DEPORTIVA
                                                                                                HOMBRE
                                                                                                NIÑOS
                                                                                                MUJERES
                                                                                                --%>
                                                                                        </a>                                                                                                                                                                                
                                                                                </h4>
                                                                        </div>
                                                                        <div id="<%= idCategoriaSuperior %>" class="panel-collapse collapse">
                                                                                <div class="panel-body">
                                                                                        <ul>
                                                                                                <%! int idSubCategoria; %>
                                                                                                <%
                                                                                                    for (categoria sb:objCat.cargarListSubCategoria(idCategoriaSuperior)) {
                                                                                                        idSubCategoria = sb.getIdcat();
                                                                                                %>
                                                                                                        <li><a href="#<%= idSubCategoria %>"><%= sb.getNom() %> </a></li> <%-- Al presiona los enlaces de Sub Categoria aparecerá en la url #idSubCategoria
                                                                                                        <%-- 
                                                                                                        <li><a href="#">Nike </a></li>
                                                                                                        <li><a href="#">Under Armour </a></li>
                                                                                                        <li><a href="#">Adidas </a></li>
                                                                                                        <li><a href="#">Puma</a></li>
                                                                                                        <li><a href="#">ASICS </a></li>
                                                                                                        --%>
                                                                                                <%  } %>
                                                                                        </ul>
                                                                                </div>
                                                                        </div>
                                                                </div>
                                                        <%  } %>
						</div><!--/category-products-->
					
						<div class="brands_products"><!--brands_products-->
							<h2>Marcas</h2>
							<div class="brands-name">
								<ul class="nav nav-pills nav-stacked">
									<li><a href="#"> <span class="pull-right">(56)</span>Nike</a></li>
									<li><a href="#"> <span class="pull-right">(27)</span>Adidas</a></li>
									<li><a href="#"> <span class="pull-right">(32)</span>Polo</a></li>
									<li><a href="#"> <span class="pull-right">(5)</span>Puma</a></li>
									<li><a href="#"> <span class="pull-right">(9)</span>Boude</a></li>
									<li><a href="#"> <span class="pull-right">(4)</span>ACB</a></li>
								</ul>
							</div>
						</div><!--/brands_products-->

						<div class="shipping text-center"><!--shipping-->
							<img src="images/home/shipping.jpg" alt="" />
						</div><!--/shipping-->
                                        </div>
