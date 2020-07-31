<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="lib/plantillaLogin/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="lib/plantillaLogin/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="lib/plantillaLogin/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="lib/plantillaLogin/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="lib/plantillaLogin/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="lib/plantillaLogin/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="lib/plantillaLogin/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="lib/plantillaLogin/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="lib/plantillaLogin/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="lib/plantillaLogin/css/util.css">
	<link rel="stylesheet" type="text/css" href="lib/plantillaLogin/css/main.css">
<!--===============================================================================================-->
</head>
<body>
<% String strError = (String) request.getAttribute("data");%>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/almacen_login.jpg');">
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
					Login
				</span>
                            <form class="login100-form validate-form p-b-33 p-t-5" action="?" method="POST">
                                        <input type="hidden" name="metodo" value="loguear">
                                        <center><span style="color:red; font-weight: bold"><%= ((strError!="" && strError!= null)?strError:"") %></span></center>
					<div class="wrap-input100 validate-input" data-validate = "Ingrese un usuario">
						<input class="input100" type="text" name="username" placeholder="Usuario">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Ingrese una clave">
						<input class="input100" type="password" name="pass" placeholder="Clave">
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>

					<div class="container-login100-form-btn m-t-32">
						<button class="login100-form-btn">
							Ingresar
						</button>

					</div>

				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="lib/plantillaLogin/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="lib/plantillaLogin/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="lib/plantillaLogin/vendor/bootstrap/js/popper.js"></script>
	<script src="lib/plantillaLogin/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="lib/plantillaLogin/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="lib/plantillaLogin/vendor/daterangepicker/moment.min.js"></script>
	<script src="lib/plantillaLogin/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="lib/plantillaLogin/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="lib/plantillaLogin/js/main.js"></script>

</body>
</html>