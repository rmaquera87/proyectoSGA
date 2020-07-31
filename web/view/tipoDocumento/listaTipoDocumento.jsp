<%-- 
    Document   : listaTipoDocumento
    Created on : 23/07/2020, 11:20:39 PM
    Author     : VAIO
--%>

<%@page import="entity.TipoDocumento"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <section class="content-header">
        <h1>
            Tipo Documento <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Nuevo</button> <button type="button" class="btn btn-warning btn-lg" data-toggle="modal" data-target="#myModalSearch">Buscar</button>
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
                <th>Id</th><th>Descripción</th><th>Abreviatura</th><th>Eliminar</th><th>Editar</th>
            </tr>
            
            <% 
                List<TipoDocumento> data = (List<TipoDocumento>)request.getAttribute("data");
                if (data!=null) {
                        for(TipoDocumento x: data){
                        %>
                        <tr class="grilla_campo">
                            <td><%= x.getId_tipdoc()%></td>
                            <td><%= x.getTdo_descripcion()%></td>
                            <td><%= x.getTdo_abreviatura()%></td>

                            <td>
                                <a href="TipoDoc?metodo=elimina&id=<%= x.getId_tipdoc()%>">
                                    <img alt="Elimina" src="images/Delete.gif">
                                </a>
                            </td>
                            <td>
                                <a href="TipoDoc?metodo=busca&id=<%= x.getId_tipdoc()%>">
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
              <h4 class="modal-title">Insertar nuevo Tipo de Documento</h4>
            </div>
            <div class="modal-body">
              <form action="TipoDoc" method="post" class="form-horizontal">
                <input type="hidden" name="metodo" value="registra">
                <div class="box-body">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Descripción</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control"  name="descripcion" placeholder="Inserta Descripcion" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Abreviatura</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="abreviatura" placeholder="Inserta Abreviatura" required>
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
              <h4 class="modal-title">Buscar Tipo Documento Identidad</h4>
            </div>
            <div class="modal-body">
              <form action="TipoDoc" method="post" class="form-horizontal">
                <input type="hidden" name="metodo" value="ubica">
                <div class="box-body">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Descripcion</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control"  name="descripcion" placeholder="Ingresa un Descripcion">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Abreviatura</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="abreviatura" placeholder="Ingresa Abreviatura">
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
