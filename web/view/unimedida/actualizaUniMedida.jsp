<%-- 
    Document   : actualizaUniMedida
    Created on : 08/07/2020, 10:23:07 PM
    Author     : CMENA
--%>

<%@page import="entity.UniMedida"%>
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
            Mantenimiento de Unidad de Medida
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
        <% UniMedida a = (UniMedida) request.getAttribute("data"); %>
        
        <form action="unimedida" method="post" class="form-horizontal">
            <input type="hidden" name="metodo" value="actualiza">
            <input type="hidden" name="id" value="<%= a.getId_undmed()%>"
            <div class="box-body">
                <div class="form-group">
                    <label class="col-sm-2 control-label">ID</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="id" placeholder="" value="<%= a.getId_undmed()%>" readonly="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">DESCRIPCION</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control"  name="descripcion" placeholder="" value="<%= a.getUme_descripcion()%>">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">ABREVIATURA</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="abreviatura" placeholder="" value="<%= a.getUme_abreviatura()%>">
                    </div>
                </div>
                
                    <div class="form-group" style="text-align: center;">
                    <button type="submit" value="guardar" class="btn btn-primary navbar-btn">Actualizar Und Medida</button>
                </div>
        </form>
        </div>
    </div>
    </section>
    </body>
    </body>
</html>
