        <header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href="#"><i class="fa fa-phone"></i> +51 956122169</a></li>
								<li><a href="#"><i class="fa fa-envelope"></i> jorge.cywdt@gmail.com</a></li>
							</ul>
						</div>
					</div>                                    
                                        
					<div class="col-sm-6">
						<div class="social-icons pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-facebook"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter"></i></a></li>
								<li><a href="#"><i class="fa fa-linkedin"></i></a></li>								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="index.jsp"><img src="images/home/logo.png" alt="" /></a>
						</div>

						<div class="btn-group pull-right">
							<div class="btn-group">
								<button type="button" class="btn btn-default dropdown-toggle usa" data-toggle="dropdown">
                                                                        ${ nombreMoneda } (${ tipoMoneda })
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu">
									<li><a href="controladorMoneda?moneda=MXN" href="home?moneda=MXN">Peso Mexicanos (MXN)</a></li> <!-- Vamos a redireccionar a un servlet llamado controladorMoneda.java vamos a pasar como parametro una variable llamada moneda -->
									<li><a href="controladorMoneda?moneda=COP" href="home?moneda=COP">Peso Colombianos (COP)</a></li>                                                                        
									<li><a href="controladorMoneda?moneda=USD" href="home?moneda=USD">Dolar Estadounidenses (USD)</a></li>
									<li><a href="controladorMoneda?moneda=PEN" href="home?moneda=PEN">Sol Peruanos (PEN)</a></li>
								</ul>
							</div>
						</div>
					</div>
					
                                        <div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href="#"><i class="fa fa-user"></i> Mi cuenta</a></li>
								<li><a href="#"><i class="fa fa-shopping-cart"></i> Ver carrito</a></li>
								<li><a href="#"><i class="fa fa-crosshairs"></i> Finalizar compra</a></li>
								<li><a href="mantenimiento"><i class="fa fa-lock"></i> Acceder</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		<div class="header-bottom"><!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Navegación</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
                                            
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="home" class="active">Home</a></li>
                                                                <li><a href="#">Todos los Productos</a></li>
                                                                <li><a href="#">Ropa para Niños</a></li> 
                                                                <li><a href="#">Blog</a></li>
                                                                <li class="dropdown"><a href="#">Mi Compra<i class="fa fa-angle-down"></i></a>
                                                                    <ul role="menu" class="sub-menu">
                                                                        <li><a href="#">Finalizar compra</a></li> 
                                                                        <li><a href="#">Ver carrito</a></li> 
                                                                        <li><a href="#">Iniciar sesión</a></li> 
                                                                    </ul>
                                                                </li>
                                                                <li><a href="#">Contacto</a></li>
							</ul>
						</div>                                            
					</div>                                    
                                        
                                        <div class="col-sm-3">
						<div class="search_box pull-right">
							<input type="text" placeholder="Buscar..."/>
						</div>
					</div>            	
				</div>
			</div>
		</div><!--/header-bottom-->
	</header><!--/header-->
