/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    
    //$("#frmParteIng")[0].reset();

    var lstProd = new Array();

    //Date picker
    $('#fecha').datepicker({
        autoclose: true,
        format: 'dd/mm/yyyy'
    })
    //$("#fecha").datepicker().datepicker("setDate", new Date());
    //Initialize Select2 Elements
    $('.select2').select2();


    function loadListaParteDetalle() {

        var prm = {
            metodo: "listaDetalle",
            id: $("#id").val()
        }
        $.post("parteSalida", prm, function (data) {

            $("#divListaDetalle").html();
            var strData = JSON.stringify(data)
            var jsonData = JSON.parse(strData);
            var obj = jsonData.result;
            if (obj != null && obj != "") {
                for (var x = 0; x < obj.length; x++) {
                    var dataProd = {"id": "", "idprod": obj[x].idProducto, "prod": obj[x].prdDescripcion, "cant": obj[x].kadCantidad};
                    lstProd.push(dataProd);
                }
            }



            //console.log(lstProd);
            listarDetalleProd();

        });


    }

    loadListaParteDetalle();


    $("#btnGuardarParteIng").on("click", function (e) {
        e.preventDefault();

        if ($("#fecha").val() == null || $("#fecha").val() == "") {

            $("#modal-alert-mensaje").html("Debe ingresar una fecha");
            $("#modal-alert").modal('show');
            return;
        }
        if ($("#cboAlmacen").val() == null || $("#cboAlmacen").val() == 0) {

            $("#modal-alert-mensaje").html("Debe seleccionar un almacén");
            $("#modal-alert").modal('show');
            return;
        }
        if ($("#cboMotivo").val() == null || $("#cboMotivo").val() == 0) {

            $("#modal-alert-mensaje").html("Debe seleccionar un motivo");
            $("#modal-alert").modal('show');
            return;
        }
        if ($("#cboCliente").val() == null || $("#cboCliente").val() == 0) {

            $("#modal-alert-mensaje").html("Debe seleccionar un cliente");
            $("#modal-alert").modal('show');
            return;
        }
        if ($("#cboTipDocRef").val() == null || $("#cboTipDocRef").val() == 0) {

            $("#modal-alert-mensaje").html("Debe seleccionar un tipo de documento ref");
            $("#modal-alert").modal('show');
            return;
        }
        if ($("#txtNroDocRef").val() == null || $("#txtNroDocRef").val() == "") {

            $("#modal-alert-mensaje").html("Debe seleccionar un nro de documento ref");
            $("#modal-alert").modal('show');
            return;
        }
        //var prm = $("#frmParteIng").serialize();

        var strLsProd = JSON.stringify(lstProd);
        var prm = {
            "metodo": $("#metodo").val(),
            "id": $("#id").val(),
            "fecha": $("#fecha").val(),
            "cboAlmacen": $("#cboAlmacen").val(),
            "cboMotivo": $("#cboMotivo").val(),
            "cboCliente": $("#cboCliente").val(),
            "cboTipDocRef": $("#cboTipDocRef").val(),
            "txtNroDocRef": $("#txtNroDocRef").val(),
            "txtGlosa": $("#txtGlosa").val(),
            "detalle": strLsProd
        }



        $.post("parteSalida", prm, function (data) {
            if (data.estado == "OK") {

                var prm = $("#frmBuscarParte").serialize();
                $.post("parteSalida", prm, function (data) {

                    $("#divResultado").html(data)


                });

                
                $("#modal-parte-ingreso").modal('hide');
                //loadListaParteDetalle();
                //alert(data.mensaje);
            } else {
                //alert(data.mensaje);
            }
            $("#modal-alert-mensaje").html(data.mensaje);
            $("#modal-alert").modal('show');
            $("#frmParteIng")[0].reset();

        }, "json");


    });

    $("#btnAgregarProd").on("click", function (e) {
        e.preventDefault();

        var prod = $("#cboProducto").val();
        var cant = $("#txtCantidad").val();
        var prodname = $('#cboProducto').select2('data');

        if (prod == null || prod == "" || prod == 0) {

            $("#modal-alert-mensaje").html("Debe seleccionar un producto");
            $("#modal-alert").modal('show');
            return;
        }
        if (cant == null || cant == "" || cant == 0) {

            $("#modal-alert-mensaje").html("Debe ingresar una cantidad");
            $("#modal-alert").modal('show');
            return;
        }

        var dataProd = {"id": "", "idprod": prod, "prod": prodname[0].text, "cant": cant};
        lstProd.push(dataProd);

        //console.log(lstProd);

        $("#cboProducto").val(0);

        $("#cboProducto").select2({placeholder: ''});
        $("#txtCantidad").val("");

        listarDetalleProd();

    });
    $("#btnCancelarProd").on("click", function (e) {
        e.preventDefault();
        $("#cboProducto").val(0);

        $("#cboProducto").select2({placeholder: ''});
        $("#txtCantidad").val("");
    });
    $("#listaParteDetalle").on("click", "#lnkElimProd", function (e) {
        e.preventDefault();

        var idreg = $(this).attr("reg");
        var idregelim = idreg - 1;
        //console.log(idreg);

        lstProd.splice(idregelim, 1);
        //$("#reg"+idreg).remove();
        //console.log(lstProd);
        listarDetalleProd();
    });

    function listarDetalleProd() {
        console.log("listarDetalleProd");
        console.log(lstProd);

        if (lstProd != null) {
            if (lstProd.length > 0) {

                $("#listaParteDetalle tbody tr").remove();

                for (var x = 0; x < lstProd.length; x++) {
                    var reg = x + 1;
                    var filaHtml = "<tr class='grilla_campo' id='reg" + reg + "'>";
                    filaHtml += "<td>" + reg + "</td>";
                    filaHtml += "<td id-prod='" + lstProd[x]['idprod'] + "'>" + lstProd[x]['prod'] + "</td>";
                    filaHtml += "<td>" + lstProd[x]['cant'] + "</td>";
                    filaHtml += "<td><a id='lnkElimProd' reg='" + reg + "' href='#'><img alt='Eliminar' src='images/Delete.gif'></a></td>";
                    filaHtml += "</tr>";

                    $("#listaParteDetalle").append(filaHtml);
                }

            }
        }




    }

});