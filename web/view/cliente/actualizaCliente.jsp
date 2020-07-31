<%-- 
    Document   : actualizaCliente
    Created on : 27/07/2020, 10:21:48 PM
    Author     : VAIO
--%>

<%@page import="entity.Cliente" %>
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
            Mantenimiento de Clientes
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Logística</li>
        </ol>
    </section>
    <section class="content">
    <div class="container">
        <div class="col-xs-12">        
        <br>        
        <% Cliente a = (Cliente) request.getAttribute("data"); %>
        
        <form action="cliente" method="post" class="form-horizontal">
            <input type="hidden" name="metodo" value="actualiza">
            <input type="hidden" name="id" value="<%= a.getId_cliente()%>"
            <div class="box-body">
                <div class="form-group">
                    <label class="col-sm-2 control-label">ID</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="id" placeholder="" value="<%= a.getId_cliente()%>" readonly="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">NRO DOCUMENTO</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" maxlength="12" name="nrodoc" placeholder="" value="<%= a.getCli_nrodoc()%>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">NOMBRES</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="nombres" placeholder="" value="<%= a.getCli_nombres()%>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">APELLIDOS</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="apellidos" placeholder="" value="<%= a.getCli_apellidos()%>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">RAZON SOCIAL</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="razonSocial" placeholder="" value="<%= a.getCli_rzasoc()%>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">DIRECCION</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="direccion" placeholder="" value="<%= a.getCli_direccion()%>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">TELEFONO</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" maxlength="9" name="telefono" placeholder="" value="<%= a.getCli_telefono()%>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">EMAIL</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="email" placeholder="" value="<%= a.getCli_email()%>">
                    </div>
                </div>
                    <div class="form-group" style="text-align: center;">
                    <button type="submit" value="guardar" class="btn btn-primary navbar-btn">Actualizar Cliente</button>
                </div>
        </form>
        </div>
    </div>
    </section>
    </body>
</html>
