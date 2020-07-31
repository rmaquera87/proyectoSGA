<%-- 
    Document   : listaCliente
    Created on : 27/07/2020, 10:21:33 PM
    Author     : VAIO
--%>

<%@page import="entity.Cliente" %>
<%@page import="entity.TipoDocId" %>
<%@page import="java.util.List" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
    </head>
    <body>
        <section class="content-header">
        <h1>
            Cliente <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Nuevo</button> <button type="button" class="btn btn-warning btn-lg" data-toggle="modal" data-target="#myModalSearch">Buscar</button>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Logística</li>
        </ol>
    </section>
 <section class="content">
    <div class="row">
        <div class="col-xs-12">
        <div class="box">
        <div class="box-body">
        
        <br>
        <table class="table table-bordered table-hover">
            
            <tr class="grilla_cabecera">
                <th>Id</th><th>Tipo Doc.</th><th>Nro Documento</th><th>Nombres</th><th>Apellidos</th><th>Razón social</th><th>Dirección</th><th>Teléfono</th><th>Email</th><th>Eliminar</th><th>Editar</th>
            </tr>
            
            <% 
                List<Cliente> data = (List<Cliente>)request.getAttribute("data");
                if (data!=null) {
                        for(Cliente x: data){
                        %>
                       <tr class="grilla_campo">
                          <td><%= x.getId_cliente()%></td>
                            <td><%= x.getId_tipodoc()%></td>
                            <td><%= x.getCli_nrodoc()%></td>
                            <td><%= x.getCli_nombres()%></td>
                            <td><%= x.getCli_apellidos()%></td>
                            <td><%= x.getCli_rzasoc()%></td>
                            <td><%= x.getCli_direccion()%></td>
                            <td><%= x.getCli_telefono()%></td>
                            <td><%= x.getCli_email()%></td>
                            <td>
                                <a href="cliente?metodo=elimina&id=<%= x.getId_cliente()%>">
                                    <img alt="Elimina" src="images/Delete.gif">
                                </a>
                            </td>
                            <td>
                                <a href="cliente?metodo=busca&id=<%= x.getId_cliente()%>">
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
       
      <!-- Modal - agregar -->
      <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Insertar Nuevo Cliente</h4>
            </div>
            <div class="modal-body">
              <form action="cliente" method="post" class="form-horizontal">
                <input type="hidden" name="metodo" value="registra">
                <div class="box-body">
                 <div class="form-group">
                    <label  class="col-sm-2 control-label">TIPO DOCUMENTO</label>
                    <div class="col-sm-10">
                            <input type="text" class="form-control" name="tipodoc" placeholder="Inserta el Tipo documento" required>
                    </div>
                 </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">NRO_DOCUMENTO</label>
                    <div class="col-sm-10">
                            <input type="text" class="form-control" maxlength="12" name="nrodoc" placeholder="Inserta el nro de documento" required>
                        </div>                      
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">NOMBRES</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="nombres" placeholder="Inserta la razon social" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">APELLIDOS</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="apellidos" placeholder="Inserta la razon social" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">RAZON SOCIAL</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="razonSocial" placeholder="Inserta la razon social">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">DIRECCION</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="direccion" placeholder="Inserta la direccion" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">TELEFONO</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" maxlength="9" name="telefono" placeholder="Inserta el telefono" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">EMAIL</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="email" placeholder="Inserta email" required>
                        </div>
                    </div>
                
                    <div class="modal-footer">
                      <button type="submit" class="btn btn-success">Guardar</button>
                      <button type="reset" class="btn btn-warning">Limpiar</button>
                    </div>
            </form>
            </div>
          </div>

        </div>
      </div>
      </div>
      <!--Modal agregar - fin-->
      <!-- Modal - busqueda -->
      <div class="modal fade" id="myModalSearch" role="dialog">
        <div class="modal-dialog">

          <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">&times;</button>
              <h4 class="modal-title">Buscar Proveedores</h4>
            </div>
            <div class="modal-body">
              <form action="cliente" method="post" class="form-horizontal">
                <input type="hidden" name="metodo" value="ubica">
                <div class="box-body">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">NRO DOCUMENTO</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" maxlength="12" name="nrodoc" placeholder="Ingresa un numero">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">NOMBRES</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="nombres" placeholder="Ingresa una letra">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">APELLIDOS</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="apellidos" placeholder="Ingresa una letra">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">RAZON SOCIAL</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="razonSocial" placeholder="Ingresa una letra">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">DIRECCION</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="direccion" placeholder="Ingresa una letra">
                        </div>
                    </div> 
                    <div class="form-group">
                        <label class="col-sm-2 control-label">TELEFONO</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" maxlength="9" name="telefono" placeholder="Ingresa un numero">
                        </div>
                    </div>         
                    <div class="modal-footer">
                      <button type="submit" class="btn btn-success">Buscar</button>
                      <button type="reset" class="btn btn-warning">Limpiar</button>
                    </div>
            </form>
            </div>
          </div>

        </div>
      </div>
      </div>
      <!--Modal busqueda - fin-->
    </body>
</html>
