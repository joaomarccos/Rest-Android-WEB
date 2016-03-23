function filter(input) {
    var cont = 0;
    var key = $(input).val();
    var text = "";
    $(".media").each(function () {
        cont++;
        $(this).show();
        text += $(this).find("h4").html();
        $(this).find("span").each(function () {
            text += $(this).html();
        });

        if (key !== "" && text.toLowerCase().indexOf(key.toLowerCase()) === -1) {
            $(this).hide();
            cont--;
        }
    });
    
    $("#nresults").empty().html("Exibindo " + cont + " resultados(s)");
}