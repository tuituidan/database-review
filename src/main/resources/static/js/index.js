/*
 * @author zhujunhan
 * @date 2020/12/11
 */
new Vue({
    el: '#app',
    data: {
        showHistory: false,
        columns: [
            {
                title: '字段',
                slot: 'column'
            },
            {
                title: '字段名',
                key: 'columnDesc'
            },
            {
                title: '数据类型',
                key: 'columnType'
            },
            {
                title: '数据长度',
                key: 'columnLength'
            },
            {
                title: '数据精度',
                key: 'columnPoint'
            },
            {
                title: '操作',
                slot: 'action',
                width: 200,
                align: 'center'
            }
        ],
        datas: [],
        selectSchema: '',
        schemas: []
    },
    mounted() {
        this.init();
    },
    methods: {
        init() {
            axios.get(`/api/v1/schema`)
                .then(res => {
                    this.schemas = res.data;
                    this.changeSchema(this.schemas[0])
                })
                .finally(() => {

                });
        },
        changeSchema(schema) {
            this.selectSchema = schema;
            this.$Spin.show();
            axios.get(`/api/v1/schema/${this.selectSchema}/tables`)
                .then(res => {
                    this.datas = res.data;
                })
                .finally(() => {
                    this.$Spin.hide();
                });
        },
        show(index) {
            alert('show-' + index);
            this.$Modal.info({
                title: 'User Info',
                content: `11111`
            })
        },
        remove(index) {
            alert('rm-' + index);
        },
        clickHandler() {
            alert('click');
        },
        openModal(bh) {
            this.$refs.tableModal.open(bh);
        }
    }
});
