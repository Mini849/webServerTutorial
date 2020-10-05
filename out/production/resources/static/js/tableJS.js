window.onload = function () {
    document.documentElement.style
        .setProperty('--maxWidth', '1120px');

    axios.defaults.headers.common[$('meta[name="csrf_header"]').attr('content')] = $('meta[name="csrf"]').attr('content');

    const app = new Vue(
        {
            el: '#app',
            data() {
                return {
                    tableData: []
                }
            },
            computed: {
                sortedTableData() {
                    return [...this.tableData].sort((a, b) => {
                        return a.progress ? 1 : -1
                    })
                }
            },
            methods: {
                send(item) {
                    let checkboxF = {...item};
                    if (item.progress === true) {
                        checkboxF.progress = false;
                    } else if (item.progress === false) {
                        checkboxF.progress = true;
                    }
                    axios.post('http://localhost:9000/api/saveFeedback', checkboxF)
                        .catch(error => {
                        });
                    console.log(checkboxF.progress);
                },
                priorityClass(item) {
                    switch (item.priority) {
                        case "high":
                            return 'text-danger'
                        case "medium":
                            return 'text-warning'
                        case "low":
                            return 'text-primary'
                        case "very-low":
                            return 'text-success'
                    }
                }
            },
            async created() {
                console.log('test');
                let that = this;
                await $.getJSON('http://localhost:9000/api/db', function (data) {
                    that.tableData = data;
                })
            }
        });
}

