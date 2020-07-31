<%@page import="dto.KardexCabeceraDTO"%>
<%@page import="java.util.List"%>
<%@page import="entity.Producto"%>
<!-- Main content -->
<section class="content">
    <div class="row">
        <div class="col-xs-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title"></h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <table id="example2" class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>FECHA REC.</th>
                                <th>ALMACÉN</th>
                                <th>MOTIVO</th>
                                <th>PROVEEDOR</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>

                            <%
                                List<KardexCabeceraDTO> dataParte = (List<KardexCabeceraDTO>) request.getAttribute("lsParte");
                                int i=1;
                                if (dataParte.size()>0) {
                                    for (KardexCabeceraDTO x : dataParte) {%>
                            <tr class="grilla_campo">
                                <td><%= x.getIdKdxcab()  %></td>
                                <td><%=x.getKacFecha() %></td>
                                <td><%=x.getAlmDescripcion() %></td>
                                <td><%=x.getMmoDescripcion() %></td>
                                <td><%=x.getProRazsoc() %></td>

                                <td>
                                    <a id="lnkEliminar" reg="<%=x.getIdKdxcab()%>" href="#">
                                        <img alt="Eliminar" src="images/Delete.gif">
                                    </a>

                                    <a id="lnkEditar" reg="<%=x.getIdKdxcab()%>" href="#">
                                        <img alt="Actualiza" src="images/Edit.gif">
                                    </a>

                                </td>     


                            </tr>
                            <% i++;
                                    }
                                }else{%>
                            
                                <tr><td colspan="8" align="center"><b>No se encontraron registros.</b></td></tr>
                            <%}
                            %>

                        </tbody>
                        <tfoot>
                            <tr>
                                <th>ID</th>
                                <th>FECHA REC.</th>
                                <th>ALMACÉN</th>
                                <th>MOTIVO</th>
                                <th>PROVEEDOR</th>
                                <th></th>
                            </tr>
                        </tfoot>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->

        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</section>
<!-- /.content -->