<%@page import="entity.Usuarios"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% Usuarios dataMain = (Usuarios) request.getAttribute("dataMain");%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>SGA :: Sistema Gestión Almacén</title>
        <!-- Tell the browser to be responsive to screen width -->
        <!--<base href="/JavaWebSGA/">-->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.7 -->
        <link rel="stylesheet" href="lib/plantilla/bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="lib/plantilla/bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="lib/plantilla/bower_components/Ionicons/css/ionicons.min.css">
        <!-- DataTables -->
        <link rel="stylesheet" href="lib/plantilla/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="lib/plantilla/dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <link rel="stylesheet" href="lib/plantilla/dist/css/skins/_all-skins.min.css">
        <!-- Morris chart -->
        <link rel="stylesheet" href="lib/plantilla/bower_components/morris.js/morris.css">
        <!-- jvectormap -->
        <link rel="stylesheet" href="lib/plantilla/bower_components/jvectormap/jquery-jvectormap.css">
        <!-- Date Picker -->
        <link rel="stylesheet" href="lib/plantilla/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
        <!-- Daterange picker -->
        <link rel="stylesheet" href="lib/plantilla/bower_components/bootstrap-daterangepicker/daterangepicker.css">
        <!-- bootstrap wysihtml5 - text editor -->
        <link rel="stylesheet" href="lib/plantilla/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

        <link rel="stylesheet" href="css/sga.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Google Font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

        <!-- jQuery 3 -->
        <script src="lib/plantilla/bower_components/jquery/dist/jquery.min.js"></script>
        <!-- jQuery UI 1.11.4 -->
        <script src="lib/plantilla/bower_components/jquery-ui/jquery-ui.min.js"></script>
        <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
        <script>
            $.widget.bridge('uibutton', $.ui.button);
        </script>
        <!-- Bootstrap 3.3.7 -->
        <script src="lib/plantilla/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- DataTables -->
        <script src="lib/plantilla/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
        <script src="lib/plantilla/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
        <!-- Morris.js charts -->
        <script src="lib/plantilla/bower_components/raphael/raphael.min.js"></script>
        <script src="lib/plantilla/bower_components/morris.js/morris.min.js"></script>
        <!-- Sparkline -->
        <script src="lib/plantilla/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
        <!-- jvectormap -->
        <script src="lib/plantilla/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="lib/plantilla/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
        <!-- jQuery Knob Chart -->
        <script src="lib/plantilla/bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
        <!-- daterangepicker -->
        <script src="lib/plantilla/bower_components/moment/min/moment.min.js"></script>
        <script src="lib/plantilla/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
        <!-- datepicker -->
        <script src="lib/plantilla/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
        <!-- Bootstrap WYSIHTML5 -->
        <script src="lib/plantilla/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
        <!-- Slimscroll -->
        <script src="lib/plantilla/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
        <!-- FastClick -->
        <script src="lib/plantilla/bower_components/fastclick/lib/fastclick.js"></script>
        <!-- AdminLTE App -->
        <script src="lib/plantilla/dist/js/adminlte.min.js"></script>
        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <!--<script src="lib/plantilla/dist/js/pages/dashboard.js"></script>-->
        <!-- AdminLTE for demo purposes -->
        <script src="lib/plantilla/dist/js/demo.js"></script>

        <!-- Select2 -->
        <link rel="stylesheet" href="lib/plantilla/bower_components/select2/dist/css/select2.min.css">

        <!-- Select2 -->
        <script src="lib/plantilla/bower_components/select2/dist/js/select2.full.min.js"></script>


        <script src="js/sga.js"></script>
    </head>
    <body class="hold-transition skin-blue sidebar-mini">
        <div class="wrapper">

            <header class="main-header">
                <!-- Logo -->
                <a href="/JavaWebSGA" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b>SGA</b></span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b>SGA</b></span>
                </a>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>

                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">

                            <!-- User Account: style can be found in dropdown.less -->
                            <li class="dropdown user user-menu">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img src="lib/plantilla/dist/img/user1.jpg" class="user-image" alt="User Image">
                                    <span class="hidden-xs" ><%= ((dataMain != null) ? dataMain.getUsuUsername() : "")%></span>
                                </a>
                                <ul class="dropdown-menu">
                                    <!-- User image -->
                                    <li class="user-header">
                                        <img src="lib/plantilla/dist/img/user1.jpg" class="img-circle" alt="User Image">

                                        <p>
                                            <%= ((dataMain != null) ? dataMain.getUsuNombre() + " " + dataMain.getUsuApellidos() : "")%>
                                            <small></small>
                                        </p>
                                    </li>
                                    <!-- Menu Body -->
                                    <!--<li class="user-body">
                                        <div class="row">
                                            <div class="col-xs-4 text-center">
                                                <a href="#">Seguidores</a>
                                            </div>
                                            <div class="col-xs-4 text-center">
                                                <a href="#">Ventas</a>
                                            </div>
                                            <div class="col-xs-4 text-center">
                                                <a href="#">Amigos</a>
                                            </div>
                                        </div>
                                        
                                    </li>-->
                                    <!-- Menu Footer-->
                                    <li class="user-footer">
                                        <div class="pull-left">
                                            <!--<a href="#" class="btn btn-default btn-flat">Perfil</a>-->
                                        </div>
                                        <div class="pull-right">
                                            <a id="lnkCerrarSesion" href="main?metodo=cerrarSesion" class="btn btn-default btn-flat">Cerrar Sesión</a>
                                        </div>
                                    </li>
                                </ul>
                            </li>
                            <!-- Control Sidebar Toggle Button -->
                            <!--<li>
                              <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                            </li>-->
                        </ul>
                    </div>
                </nav>
            </header>
            <!-- Left side column. contains the logo and sidebar -->
            <aside class="main-sidebar">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="lib/plantilla/dist/img/user1.jpg" class="img-circle" alt="User Image">
                        </div>
                        <div class="pull-left info">
                            <p><%= ((dataMain != null) ? dataMain.getUsuUsername() : "")%></p>
                            <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                        </div>
                    </div>
                    <!-- search form -->
                    <!--<form action="#" method="get" class="sidebar-form">
                      <div class="input-group">
                        <input type="text" name="q" class="form-control" placeholder="Search...">
                        <span class="input-group-btn">
                              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
                              </button>
                            </span>
                      </div>
                    </form>-->
                    <!-- /.search form -->
                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu" data-widget="tree">
                        <li class="header">BIENVENIDO</li>

                        <li class="active treeview">
                            <a href="#">
                                <i class="fa fa-edit"></i> <span>Tablas Maestras</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="almacen"><i class="fa fa-circle-o"></i> Almacen</a></li>
                                <li><a href="producto"><i class="fa fa-circle-o"></i> Producto</a></li>
                                <li><a href="proveedor"><i class="fa fa-circle-o"></i> Proveedor</a></li>
                                <li><a href="cliente"><i class="fa fa-circle-o"></i> Clientes</a></li>       
                                <li><a href="marca"><i class="fa fa-circle-o"></i> Marca</a></li>
                                <li><a href="unimedida"><i class="fa fa-circle-o"></i> Unidad de Medida</a></li>
                                <li><a href="tipoDocId"><i class="fa fa-circle-o"></i> Tipo Documento Identidad</a></li>
                                <li><a href="motivo"><i class="fa fa-circle-o"></i> Motivo Movimientos</a></li>
                                <li><a href="moneda"><i class="fa fa-circle-o"></i> Tipo de Moneda</a></li>
                                <li><a href="TipoDoc"><i class="fa fa-circle-o"></i> Tipo Documento</a></li>
                            </ul>
                            <a href="#">
                                <i class="fa fa-edit"></i> <span>Transacciones</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span>
                            </a>
                            <ul class="treeview-menu">
                                <li><a href="parteIngreso"><i class="fa fa-circle-o"></i> Partes de Ingreso</a></li>
                                <li><a href="parteSalida"><i class="fa fa-circle-o"></i> Partes de Salida</a></li>
                            </ul>
                            <a href="#">
                                <i class="fa fa-edit"></i> <span>Consultas</span>
                                <span class="pull-right-container">
                                    <i class="fa fa-angle-left pull-right"></i>
                                </span> 
                            </a>
                            <ul class="treeview-menu">
                                <li><a href=""><i class="fa fa-circle-o"></i> Consulta de Stock</a></li>
                                <li><a href=""><i class="fa fa-circle-o"></i> Movimientos</a></li>
                            </ul>
                        </li>

                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <%
                    if (request.getAttribute("view") != null) {
                        String vw = (String) request.getAttribute("view");
                %>    

                <jsp:include page="<%=vw%>"/>
                <%
                    }
                %>

                <!-- /.content -->
            </div>
            <!-- /.content-wrapper -->
            <footer class="main-footer">
                <div class="pull-right hidden-xs">
                    <b>Version</b> 1.0.0
                </div>
                <strong>Copyright &copy; 2020 <a href="#">Grupo Curso Integrador</a>.</strong> All rights
                reserved.
            </footer>


        </div>
        <!-- ./wrapper -->

        <div class="modal fade" id="modal-alert">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Producto</h4>
                    </div>
                    <div class="modal-body">
                        <p id="modal-alert-mensaje"></p>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary pull-right" data-dismiss="modal">Aceptar</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>

    </body>
</html>
