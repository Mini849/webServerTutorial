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
                    // item.progress = !item.progress
                    let checkboxF = {...item};
                    if (item.progress === true) {
                        checkboxF.progress = false;
                    } else if (item.progress === false) {
                        checkboxF.progress = true;
                    }
                    axios.post('http://localhost:8080/api/saveFeedback', checkboxF)
                        .catch(error => {
                        });
                    console.log(checkboxF.progress);
                },
                priorityClass(item) {
                    if (item.priority === "1") {
                        return 'text-danger'
                    }

                    return 'text-success'
                }
            },
            async created() {
                console.log('test');
                let that = this;
                await $.getJSON('http://localhost:8080/api/db', function (data) {
                    that.tableData = data;
                })
            }
        });
}

