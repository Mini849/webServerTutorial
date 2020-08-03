window.onload = function () {
    $('#table').bootstrapTable({});

    function load() {
        var data = [{
            id: 1,
            name: 'Item 1',
            price: '$1'
        }, {
            id: 2,
            name: 'Item 2',
            price: '$4'
        }];
        $('#table').bootstrapTable("load", data);
    }

    function reload() {
        var data = [{
            id: 3,
            name: 'Item 3',
            price: '$2'
        }, {
            id: 4,
            name: 'Item 4',
            price: '$6'
        }];
        $('#table').bootstrapTable("load", data);
    }


}
