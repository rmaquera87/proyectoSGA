<%@page import="entity.Producto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="entity.Clase"%>
<!-- form start -->
<% String strMetodo = (String) request.getAttribute("metodo");%>
<% Producto dataProd = (Producto) request.getAttribute("dataProd");%>
<form id="frmBproducto" class="form-horizontal">
    <input type="hidden" name="metodo" value="<%= strMetodo %>" />
    <input type="hidden" name="id" value="<%= (dataProd!=null?dataProd.getProducto():"") %>" />
    <div class="box-body">
        <div class="form-group">
            <label class="col-sm-2 control-label">Código</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtCodigo" name="txtCodigo" placeholder="Código" value="<%= (dataProd!=null?dataProd.getProducto():"") %>">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">Descripción</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtDescripcion" name="txtDescripcion" placeholder="Descripción" value="<%= (dataProd!=null?dataProd.getDescripcion():"") %>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Marca</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtcosto" name="txtmarca" placeholder="Marca" value="<%= (dataProd!=null?dataProd.getMarca():"")%>">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">Estado</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtestado" name="txtestado" placeholder="Estado" value="<%= (dataProd!=null?dataProd.getEstado():"")%>">
            </div>
        </div>
    </div>
    <!-- /.box-body -->
    <div class="box-footer">
        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Cancelar</button>
        <button id="btnBuscar" type="button" class="btn btn-primary pull-right">Buscar</button>
    </div>
    <!-- /.box-footer -->
</form>
