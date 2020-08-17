//https://stackoverflow.com/questions/55513917/vue-js-2-sort-table-td-on-click-of-th

new Vue({
    el: '#app',
    data: {
        results: {
            toolAttribute: [{attributeName: "Present"}, {attributeName: "Present"}, {attributeName: "Present"}],
            device: [{deviceName: "Device Name 1",
                    info: [{value: true}, {value: false}, {value: true}]},
                {deviceName: "Device Name 2",
                    info: [{value: false}, {value: false}, {value: false}]}]
        },
        currentSort: ['deviceName'],
        currentSortDir: 'asc'
    },
    computed: {
        sortedResults: function () { // to posielas do <tr v-for="(device, index) in sortedResults"  >
            return this.results.device.sort(function (a, b) {
                let modifier = 1;
                if (this.currentSortDir === 'desc') modifier = -1;
                this.currentSort.forEach(x => {
                    a = a[x];
                    b = b[x];
                })
                if (a < b) return -1 * modifier;
                if (a > b) return 1 * modifier;
                return 0;
            }.bind(this));
        }
    },
    methods: {
        flasecond(index) {
            let res = false
            this.results.device[index].info.forEach(info => {
                if (!info.value) res = true
            })
            return res
        },
        sort: function (s) {
            //if s == current sort, reverse
            if (s.join('') === this.currentSort.join('')) {
                this.currentSortDir = this.currentSortDir === 'asc' ? 'desc' : 'asc';
            }
            this.currentSort = s;
        },
    }
})

/*
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <div id="app">
    <table >
    <tr>
    <th rowspan="2" @click="sort(['deviceName'])" class="header">Device Info</th>
</tr>
<tr>
<th v-for="(toolAttribute, index) in results.toolAttribute" :key="index" @click="sort(['info', index, 'value'])" class="header">{{toolAttribute.attributeName}}</th>
</tr>
<tr v-for="(device, index) in sortedResults"  >
    <td :class="{'falseclass' : flasecond(index)}">{{ device.deviceName }}</td>
<td v-for="info in device.info" :class="{'falseclass' : !info.value}">{{info.value}}</td>
</tr>
</table>
</div>*/
