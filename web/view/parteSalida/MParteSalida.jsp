<%@page import="dto.ClienteDTO"%>
<%@page import="dto.KardexCabeceraDTO"%>
<%@page import="entity.Proveedor"%>
<%@page import="dto.MotivoMovimientoDTO"%>
<%@page import="entity.Almacen"%>
<%@page import="entity.Producto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="entity.Clase"%>
<script src="js/parteSalida/mparteSalida.js"></script>
<!-- form start -->
<% String strMetodo = (String) request.getAttribute("metodo");%>
<% KardexCabeceraDTO dataParte = (KardexCabeceraDTO) request.getAttribute("dataParte");%>
<form id="frmParteIng" class="form-horizontal">
    <input type="hidden" id="metodo" name="metodo" value="<%= strMetodo%>" />
    <input type="hidden" id="id" name="id" value="<%= (dataParte != null ? dataParte.getIdKdxcab() : "")%>" />
    <div class="box-body">
        <div class="form-group">
            <label class="col-sm-2 control-label">Código</label>

            <div class="col-sm-4">
                <input type="text" class="form-control" id="txtCodigo" name="txtCodigo" placeholder="" value="<%= (dataParte != null ? dataParte.getIdKdxcab() : "")%>" readonly="">
            </div>
            <label class="col-sm-2 control-label">Fecha</label>

            <div class="col-sm-4">
                <div class="input-group date">
                    <div class="input-group-addon">
                        <i class="fa fa-calendar"></i>
                    </div>
                    <input type="text" class="form-control pull-right" id="fecha" name="fecha" value="<%= (dataParte != null ? dataParte.getKacFecha() : "")%>">
                </div>

            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">Almacén</label>

            <div class="col-sm-4">
                <select class="form-control" id="cboAlmacen" name="cboAlmacen">
                    <option value="0">--Seleccione--</option>
                    <%
                        List<Almacen> dataAlmacen = (List<Almacen>) request.getAttribute("lsAlmacen");
                        if (dataAlmacen != null) {
                            for (Almacen a : dataAlmacen) {

                                if (dataParte != null && a.getIdAlmacen() == dataParte.getIdAlmacen()) {%>
                    <option value="<%=a.getIdAlmacen()%>" selected><%=a.getDescripcion()%></option>
                    <%} else {%>
                    <option value="<%=a.getIdAlmacen()%>"><%=a.getDescripcion()%></option>
                    <%}

                                        }
                                    }%>
                </select>
            </div>
            <label class="col-sm-2 control-label">Motivo</label>

            <div class="col-sm-4">
                <select class="form-control" id="cboMotivo" name="cboMotivo">
                    <option value="0">--Seleccione--</option>
                    <%
                        List<MotivoMovimientoDTO> dataMotivo = (List<MotivoMovimientoDTO>) request.getAttribute("lsMotivo");
                        if (dataMotivo != null) {
                            for (MotivoMovimientoDTO m : dataMotivo) {

                                if (dataParte != null && m.getIdMotivo() == dataParte.getIdMotivo()) {%>
                    <option value="<%=m.getIdMotivo()%>" selected><%=m.getMmoDescripcion()%></option>
                    <%} else {%>
                    <option value="<%=m.getIdMotivo()%>"><%=m.getMmoDescripcion()%></option>
                    <%}

                                        }
                                    }%>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">Cliente</label>

            <div class="col-sm-4">
                <select class="form-control select2" id="cboCliente" name="cboCliente" style="width:100%">
                    <option value="0">--Seleccione--</option>
                    <%
                        List<ClienteDTO> dataCliente = (List<ClienteDTO>) request.getAttribute("lsCliente");
                        if (dataCliente != null) {
                            for (ClienteDTO cli : dataCliente) {

                                if (dataParte != null && cli.getIdCliente() == dataParte.getIdCliente()) {%>
                    <option value="<%=cli.getIdCliente()%>" selected><%=cli.getDescripcion() %></option>
                    <%} else {%>
                    <option value="<%=cli.getIdCliente()%>"><%=cli.getDescripcion()%></option>
                    <%}
                                            }

                                    }%>
                </select>
            </div>
            <label class="col-sm-2 control-label">Doc. Ref.</label>

            <div class="col-sm-2">
                <select class="form-control" id="cboTipDocRef" name="cboTipDocRef">
                    <option value="0">--Seleccione--</option>
                    <option value="FAC" <%= ((dataParte != null && dataParte.getKacTdoref1().equals("FAC")) ? "selected" : "")%>>FAC</option>
                    <option value="BVE" <%= ((dataParte != null && dataParte.getKacTdoref1().equals("BVE")) ? "selected" : "")%>>BVE</option>
                    <option value="NCR" <%= ((dataParte != null && dataParte.getKacTdoref1().equals("NCR")) ? "selected" : "")%>>NCR</option>
                    <option value="NDB" <%= ((dataParte != null && dataParte.getKacTdoref1().equals("NDB")) ? "selected" : "")%>>NDB</option>

                </select>
            </div>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="txtNroDocRef" name="txtNroDocRef" placeholder="" value="<%= (dataParte != null ? dataParte.getKacDocref1() : "")%>" >
            </div>
        </div>
        <div class="form-group">

            <label class="col-sm-2 control-label">Glosa</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtGlosa" name="txtGlosa" placeholder="" value="<%= (dataParte != null ? dataParte.getKacGlosa() : "")%>" >
            </div>
        </div>

        <div class="row">
            <label class="col-sm-2 control-label">Producto:</label>
            <div class="col-sm-4">
                <select class="form-control select2" id="cboProducto" name="cboProducto">
                    <option value="0">--Seleccione--</option>
                    <%
                        List<Producto> dataProducto = (List<Producto>) request.getAttribute("lsProducto");
                        if (dataProducto!= null) {
                            for (Producto pro : dataProducto) {%>


                    <option value="<%=pro.getIdProducto()%>"><%=pro.getDescripcion()%></option>
                    <% }
                        }%>
                </select></div>
            <label class="col-sm-2 control-label">Cantidad:</label>
            <div class="col-sm-2"><input type="text" id="txtCantidad" name="txtCantidad" class="form-control"></div>
            <div class="col-sm-2">    
                <button id="btnAgregarProd">Agregar</button>
                <button id="btnCancelarProd">Cancelar</button>
            </div>
        </div>   
                <div id="divListaDetalle" style="overflow: auto">
                    
                </div> 
                <jsp:include page="listaMParteSalida.jsp"/>
    </div>
    <!-- /.box-body -->
    <div class="box-footer">
        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Cancelar</button>
        <button id="btnGuardarParteIng" type="button" class="btn btn-primary pull-right">Guardar</button>
    </div>
    <!-- /.box-footer -->
</form>
