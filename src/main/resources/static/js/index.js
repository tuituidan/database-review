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
        selectSchema: curSchema,
        schemas: []
    },
    mounted() {
        this.init();
    },
    methods: {
        init() {
            if (curSchema) {
                this.$Spin.show();
                axios.get(`/api/v1/schema/${curSchema}/tables`)
                    .then(res => {
                        this.datas = res.data;
                    })
                    .finally(() => {
                        this.$Spin.hide();
                    });
            }
            axios.get(`/api/v1/schema`)
                .then(res => {
                    this.schemas = res.data;
                });
        },
        changeSchema(schema) {
            if (schema === this.selectSchema) {
                return;
            }
            location.href = '/' + schema;
        },
        remove(index) {
            this.$Message.info('删除字段');
        },
        removeTable(){
            this.$Modal.confirm({
                title: '确认',
                content: '<p>确认删除此表？</p>',
                onOk: () => {
                    this.$Message.info('删除表');
                },
                onCancel: () => {

                }
            });
        },
        clickHandler() {
            this.$Message.info('响应点击事件');
        },
        openTableModal(bh, copy) {
            this.$refs.tableModal.open(bh, copy);
        },
        openColumnModal(bh) {
            this.$refs.columnModal.open(bh);
        },
        openApprovalPrevModal() {
            this.$refs.approvalPrevModal.open();
        }
    }
});
