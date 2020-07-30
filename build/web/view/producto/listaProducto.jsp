<%--<%@page import="java.util.List"%>
<%@page import="entity.Producto"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="entity.Producto" %>
<%@page import="java.util.List" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
    </head>
    <body>

    <section class="content">
    <div class="row">
        <div class="col-xs-12">
        <div class="box">
        <div class="box-body">
        
        <br>
        <table class="table table-bordered table-hover">
            
            <tr class="grilla_cabecera">
                <%--<th>Id</th><th>Ruc</th><th>Razón social</th><th>Teléfono</th><th>Dirección</th><th>Email</th><th>Pais</th><th>Eliminar</th><th>Editar</th>
                 --%>
                <th>ID</th>
                <th>DESCRIPCIÓN</th>
                <th>UNIDAD DE MEDIDA</th>
                <th>MARCA</th>
                <th>TIPO DE INVENTARIO</th>
                <th>COSTO</th>
                <th>PRECIO</th>
                <th>STOCK MINIMO</th>
                <th>STOCK MAXIMO</th>
                <th>PESO</th>
                <th>ESTADO</th>
                <th>ELIMINAR</th>
                <th>EDITAR</th>
                <th></th> 
            </tr>
            
            <% 
                List<Producto> data = (List<Producto>)request.getAttribute("data");
                
                if (data!=null) {
                        for(Producto x: data){
                        %>
                        <tr class="grilla_campo">
                            <td><%=x.getProducto()%></td>
                            <td><%=x.getDescripcion()%></td>
                            <td><%=x.getUndmed()%></td>
                            <td><%=x.getMarca()%></td>
                            <td><%=x.getTipinv()%></td>
                            <td><%=x.getCosto()%></td>
                            <td><%=x.getPreciov()%></td>
                            <td><%=x.getStkmin()%></td>
                            <td><%=x.getStkmax()%></td>
                            <td><%=x.getPeso()%></td>
                            <td><%=x.getEstado()%></td>
                            <td>
                                    <a id="lnkEliminar" reg="<%=x.getProducto()%>" href="#">
                                    <img alt="Elimina" src="images/Delete.gif">
                                </a>
                            </td>
                            <td>
                                <a id="lnkEditar" reg="<%=x.getProducto()%>" href="#">
                                    <img alt="Actualiza" src="images/Edit.gif">
                                </a>
                            </td>
                        </tr>
                        <%
                        }
                    }
            %>
        </table>
        </div>
        </div>
        </div>
        </div>
    </section>
<%--
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
                                <th>DESCRIPCIÓN</th>
                                <th>UNIDAD DE MEDIDA</th>
                                <th>MARCA</th>
                                <th>TIPO DE INVENTARIO</th>
                                <th>COSTO</th>
                                <th>PRECIO</th>
                                <th>STOCK MINIMO</th>
                                <th>STOCK MAXIMO</th>
                                <th>PESO</th>
                                <th>ESTADO</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>

                            <%
                                List<Producto> dataProd = (List<Producto>) request.getAttribute("lsProducto");
                                int i=1;
                                if (dataProd.size()>0) {
                                    for (Producto x : dataProd) {%>
                            <tr class="grilla_campo">
                                <td><%= i  %></td>
                                <td><%=x.getDescripcion()%></td>
                                <td><%=x.getUndmed()%></td>
                                <td><%=x.getMarca()%></td>
                                <td><%=x.getTipinv()%></td>
                                <td><%=x.getCosto()%></td>
                                <td><%=x.getPreciov()%></td>
                                <td><%=x.getStkmin()%></td>
                                <td><%=x.getStkmax()%></td>
                                <td><%=x.getPeso()%></td>
                                <td><%=x.getEstado()%></td>
                                <td>
                                    <a id="lnkEliminar" reg="<%=x.getProducto()%>" href="#">
                                        <img alt="Eliminar" src="images/Delete.gif">
                                    </a>

                                    <a id="lnkEditar" reg="<%=x.getProducto()%>" href="#">
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
                                <th>DESCRIPCIÓN</th>
                                <th>UNIDAD DE MEDIDA</th>
                                <th>MARCA</th>
                                <th>TIPO DE INVENTARIO</th>
                                <th>COSTO</th>
                                <th>PRECIO</th>
                                <th>STOCK MINIMO</th>
                                <th>STOCK MAXIMO</th>
                                <th>PESO</th>
                                <th>ESTADO</th>
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
--%>
