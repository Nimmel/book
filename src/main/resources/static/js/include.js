$(function () {
    $.get("html/header.html",function (data) {
        $("#header").html(data);
    });
});