/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    //var lstProd = new Array();

    //Date picker
    $('#txtBusFecha').datepicker({
        autoclose: true,
        format: 'dd/mm/yyyy'
    })
    //Initialize Select2 Elements
    $('.select2').select2();

    loadListaParte();
    function loadListaParte() {
        var prm = $("#frmBuscarParte").serialize();
        $.post("parteSalida", prm, function (data) {

            $("#divResultado").html(data)


        });


    }

    $("#btnBuscarParteIng").click(function (e) {
        e.preventDefault();

        loadListaParte();
    });
    $("#btnCanBuscarParteIng").click(function (e) {
        e.preventDefault();
        $("#frmBuscarParte")[0].reset();
        $("#cboBusProveedor").select2({placeholder: ''});
    });


    $("#btnNuevoParteIng").click(function (e) {
        e.preventDefault();
        var prm = {
            "metodo": "load"
        };
        $.post("parteSalida", prm, function (data) {

            //loadListaParteDetalle();
            $("#modal-parte-ingreso .modal-body").html(data);
            $("#modal-parte-ingreso").modal('show');
        });


    });




    $("#divResultado").on("click", "#lnkEditar", function (e) {

        e.preventDefault();
        var idreg = $(this).attr("reg");
        var prm = {
            "metodo": "load",
            "id": idreg
        };

        $.ajax({
            async: false,
            type: 'post',
            url: 'parteSalida',
            data: prm,
            success: function (data) {
                //loadListaParteDetalle(idreg);

                $("#modal-parte-ingreso .modal-body").html(data);
                $("#modal-parte-ingreso").modal('show');
            }
        });




    });

    $("#divResultado").on("click", "#lnkEliminar", function (e) {

        e.preventDefault();
        var idreg = $(this).attr("reg");
        var prm = {
            "metodo": "elimina",
            "id": idreg
        };



        $.post("parteSalida", prm, function (data) {
            if (data.estado == "OK") {
                loadListaParte();
                $("#modal-alert-mensaje").html(data.mensaje);
                $("#modal-alert").modal('show');
            }


        }, "json");


    });


});

