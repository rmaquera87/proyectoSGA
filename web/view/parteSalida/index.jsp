<%@page import="dto.ClienteDTO"%>
<%@page import="entity.Proveedor"%>
<%@page import="dto.MotivoMovimientoDTO"%>
<%@page import="entity.Almacen"%>
<%@page import="java.util.List"%>
<%@page import="entity.Clase"%>
<script src="js/parteSalida/parteSalida.js"></script>
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        Parte De Salida
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">Logística</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">
    <!-- Small boxes (Stat box) -->
    <div class="row">
        <div class="col-md-12">
            <!-- Horizontal Form -->
            <div class="box box-info">
                <div class="box-header with-border">
                    <h3 class="box-title"></h3>
                </div>
                <!-- /.box-header -->
                <!-- form start -->
                <form id="frmBuscarParte" class="form-horizontal">
                    <input type="hidden" name="metodo" value="lista" />
                    <div class="box-body">
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">Almacén</label>

                            <div class="col-sm-4">
                                <select class="form-control" id="cboBusAlmacen" name="cboBusAlmacen">
                                    <option value="0">--Seleccione--</option>
                                    <%
                                        List<Almacen> dataAlmacen = (List<Almacen>) request.getAttribute("lsAlmacen");
                                        if (dataAlmacen != null) {
                                            for (Almacen a : dataAlmacen) {%>


                                    <option value="<%=a.getIdAlmacen()%>"><%=a.getDescripcion()%></option>
                                    <% }
                                        }%>
                                </select>

                            </div>
                            <label  class="col-sm-2 control-label">Fecha</label>

                            <div class="col-sm-4">

                                <div class="input-group date">
                                    <div class="input-group-addon">
                                        <i class="fa fa-calendar"></i>
                                    </div>
                                    <input type="text" class="form-control pull-right" id="txtBusFecha" name="txtBusFecha">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">Motivo</label>

                            <div class="col-sm-4">
                                <select class="form-control" id="cboBusMotivo" name="cboBusMotivo">
                                    <option value="0">--Seleccione--</option>
                                    <%
                                        List<MotivoMovimientoDTO> dataMotivo = (List<MotivoMovimientoDTO>) request.getAttribute("lsMotivo");
                                        if (dataMotivo != null) {
                                            for (MotivoMovimientoDTO m : dataMotivo) {%>


                                    <option value="<%=m.getIdMotivo()%>"><%=m.getMmoDescripcion()%></option>
                                    <% }
                                        }%>
                                </select>
                            </div>
                            <label  class="col-sm-2 control-label">Cliente</label>

                            <div class="col-sm-4">
                                <select class="form-control select2" id="cboBusCliente" name="cboBusCliente">
                                    <option value="0">--Seleccione--</option>
                                    <%
                                        List<ClienteDTO> dataCliente = (List<ClienteDTO>) request.getAttribute("lsCliente");
                                        if (dataCliente != null) {
                                            for (ClienteDTO cli : dataCliente) {%>

                                    <option value="<%=cli.getIdCliente()%>"><%=cli.getDescripcion()%></option>
                                    <%
                                        }

                                    }%>
                                </select>
                            </div>
                        </div>

                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer">

                        <button id="btnBuscarParteIng" type="submit" class="btn btn-info ">Buscar</button>
                        <button id="btnCanBuscarParteIng" type="reset" class="btn btn-default">Cancelar</button>
                        <button id="btnNuevoParteIng" type="button" class="btn btn-primary pull-right">
                            Nuevo
                        </button>
                    </div>
                    <!-- /.box-footer -->
                </form>
            </div>
        </div>


</section>

<div class="modal fade" id="modal-parte-ingreso">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Parte De Ingreso</h4>
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
<!-- /.modal -->

<div id="divResultado" style="overflow: auto">

</div>

<script>
    $(function () {

        $('#example2').DataTable({
            'paging': true,
            'lengthChange': false,
            'searching': false,
            'ordering': true,
            'info': true,
            'autoWidth': false
        })
    })
</script>