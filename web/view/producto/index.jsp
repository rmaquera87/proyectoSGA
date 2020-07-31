<%@page import="java.util.List"%>
<%@page import="entity.Clase"%>
<script src="js/producto.js"></script>

<!-- /.modal -->
<section class="content-header">
    <h1>
        Producto 
        <button id="btnNuevoProd" type="button" class="btn btn-primary btn-lg">Nuevo</button>
        <button id="btnBuscarProd" type="button" class="btn btn-warning btn-lg">Buscar</button>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Logística</li>
    </ol>
</section>
<div class="modal fade" id="modal-producto">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Registro producto nuevo</h4>
            </div>
            <div class="modal-body">





            </div>
            <!--<div class="modal-footer">

            </div>-->
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<div class="modal fade" id="modal-buscaprod">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Buscar producto</h4>
            </div>
            <div class="modal-body">





            </div>
            <!--<div class="modal-footer">

            </div>-->
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<div id="divResultado" style="overflow: auto">
</div>