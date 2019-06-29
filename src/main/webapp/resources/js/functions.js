function deleteDiscipline() {
    var items = $("input[type=checkbox]:checked")
    if (items.length == 0) {
        alert("Please select at least one discipline!");
        return;
    }

    var idsSelected = "";
    for (var i = 0; i < items.length; ++i) {
        idsSelected = idsSelected + $(items[i]).attr("value") + ",";
    }

    $("#idDelete").val(idsSelected);
    $('#delete-discipline-form').submit();

}
function modifyDiscipline() {
    var items =  $("input[type=checkbox]:checked")
    if (items.length == 0) {
        alert("Please select at least one discipline!");
        return;
    }
    if(items.length > 1){
        alert("select only one discipline");
        return;
    }

    var idSelected = $(items[0]).attr("value");

    $("#modifyId").val(idSelected);
    $('#discipline-modify-form').submit();
}