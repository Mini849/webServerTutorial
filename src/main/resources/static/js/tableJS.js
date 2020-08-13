window.onload = function () {
    document.documentElement.style
        .setProperty('--maxWidth', '1120px');

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
                    if (item.progress === true) {
                        checkboxF.progress = false;
                    } else if (item.progress === false) {
                        checkboxF.progress = true;
                    }

                    axios.post('http://localhost:8080/api/saveFeedback', checkboxF)
                        .catch(error => {
                        });
                    // checkboxF.progress = item.progress ? "1" : "0";

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
    var vm = new Vue({
        el: '#app',
        // data: {
        //     currentSort: 'pn',
        //     currentSortDir: 'asc',
        //     search: '',
        //     columns: [
        //         { label: 'P/N', shortcode: 'pn' },
        //         /// more columns ...
        //     ], // columns
        //     products: [
        //         //.... objects
        //     ], // products
        // },
        data() {
            return {
                tableData: [],
            }
        },
        computed: {
            showProducts() {
                return this.item()
                    .sort((a, b) => {
                        if (this.currentSortDir === 'asc') {
                            return a[this.currentSort] >= b[this.currentSort];
                        }
                        return a[this.currentSort] <= b[this.currentSort];
                    })
            },
        },
        methods: {
            sort:function(col) {
                // if you click the same label twice
                if(this.currentSort == col){
                    this.currentSortDir = this.currentSortDir === 'asc' ? 'desc' : 'asc';
                }else{
                    this.currentSort = col;
                    console.log( 'diff col: '+col );
                } // end if

            }, // sort

        }, // methods
    }); // vue
}

