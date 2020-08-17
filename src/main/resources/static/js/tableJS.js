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
            methods: {
                send(item) {
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

