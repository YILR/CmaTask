var mealAjaxUrl = "rest/";

$.ajaxSetup({
    converters: {
        "text json": function (stringData) {
            var json = JSON.parse(stringData);
            $(json).each(function () {
                this.date = this.date.replace('T', ' ').substr(0, 16);
            });
            return json;
        }
    }
});

var ctx = {
    ajaxUrl: mealAjaxUrl,
    updateTable: function () {
        $.ajax({
            type: "GET",
            url: mealAjaxUrl,
            data: $("#datatable").serialize()
        }).done(updateTableByData);
    }
}

$(function () {
    makeEditable({
        "columns": [
            {
                "data": "lastname"
            },
            {
                "data": "firstname"
            },
            {
                "data": "middlename"
            },
            {
                "data": "date"
            },
            {
                "data": "group"
            },
            {
                "render": renderDeleteBtn,
                "defaultContent": "",
                "orderable": false
            }
        ],
        "order": [
            [
                0,
                "desc"
            ]
        ],
        "createdRow": function (row, data, dataIndex) {
            $(row).attr("data-mealExcess", data.excess);
        },
    });

    var date = $('#date');
    date.datetimepicker({
        timepicker: false,
        format: 'Y-m-d',
        formatDate: 'Y-m-d'
    });

});