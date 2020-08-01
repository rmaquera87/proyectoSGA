<%@page import="entity.Producto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="entity.Clase"%>
<!-- form start -->
<% String strMetodo = (String) request.getAttribute("metodo");%>
<% Producto dataProd = (Producto) request.getAttribute("dataProd");%>
<form id="frmProducto" class="form-horizontal">
    <input type="hidden" name="metodo" value="<%= strMetodo %>" />
    <input type="hidden" name="id" value="<%= (dataProd!=null?dataProd.getProducto():"") %>" />
    <div class="box-body">
        <div class="form-group">
            <label class="col-sm-2 control-label">Código</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtCodigo" name="txtCodigo" placeholder="" value="<%= (dataProd!=null?dataProd.getProducto():"") %>" readonly="">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">Descripción</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtDescripcion" name="txtDescripcion" placeholder="Descripción" value="<%= (dataProd!=null?dataProd.getDescripcion():"") %>">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Costo</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtcosto" name="txtcosto" placeholder="costo" value="<%= (dataProd!=null?dataProd.getCosto():"")%>">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">Precio</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtprecio" name="txtprecio" placeholder="Precio" value="<%= (dataProd!=null?dataProd.getPreciov():"")%>" >
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">Stock minimo</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtstkmin" name="txtstkmin" placeholder="Stock minimo" value="<%= (dataProd!=null?dataProd.getStkmin():"")%>">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">Stock maximo</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtstkmax" name="txtstkmax" placeholder="Stock maximo" value="<%= (dataProd!=null?dataProd.getStkmax():"")%>">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">Peso</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtpeso" name="txtpeso" placeholder="Peso" value="<%= (dataProd!=null?dataProd.getPeso():"")%>">
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">Estado</label>

            <div class="col-sm-10">
                <input type="text" class="form-control" id="txtestado" name="txtestado" placeholder="Estado" value="<%= (dataProd!=null?dataProd.getEstado():"")%>">
            </div>
        </div>
        <%--
        <div class="form-group">
            <label  class="col-sm-2 control-label">Clasificación</label>

            <div class="col-sm-10">
                <select class="form-control"  id="sltClasificacion" name="sltClasificacion">
                    <option value="0">--Seleccione--</option>

                    <%
                        List<Clase> data = (List<Clase>) request.getAttribute("lsClase");
                        if (data != null) {
                            for (Clase cl : data) {
                                if (dataProd!=null && cl.getIdClase() == dataProd.getIdClase()) {
                    %>


                    <option value="<%=cl.getIdClase()%>" selected><%=cl.getDescripcion()%></option>
                    <%} else {

                        }%>
                    <option value="<%=cl.getIdClase()%>"><%=cl.getDescripcion()%></option>
                    <% }
                        }%>
                </select>

            </div>
        </div>--%>
    </div>
    <!-- /.box-body -->
    <div class="box-footer">
        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Cancelar</button>
        <button id="btnGuardarProd" type="button" class="btn btn-primary pull-right">Guardar</button>
    </div>
    <!-- /.box-footer -->
</form>
