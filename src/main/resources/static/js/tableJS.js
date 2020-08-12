window.onload = function () {

    axios.defaults.headers.common[$('meta[name="csrf_header"]').attr('content')] = $('meta[name="csrf"]').attr('content');

    const app = new Vue(
        {
            el: '#app',
            data() {
                return {
                    tableData: [],
                }
            },
            methods: {
                send(item) {
                    let checkboxF = {...item};
                    checkboxF.progress = item.progress ? "1" : "0";

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
                    for (let x = 0; x < that.tableData.length; x++) {
                        that.tableData[x].progress = !!parseInt(that.tableData[x].progress);
                    }
                })
            }

        });
}

