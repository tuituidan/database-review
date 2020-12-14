/*
 * @author zhujunhan
 * @date 2020/12/11
 */
new Vue({
    el: '#app',
    data: {
        history: [/*{
            color:'green',
            msg: '新增表【t_rw】'
        },{
            color:'green',
            msg: '新增字段【t_ry.c_bh_gx】'
        },{
            color:'red',
            msg: '删除表字段【t_ry.c_bh_gx】'
        },{
            color:'red',
            msg: '删除表【t_dw】'
        },{
            color:'red',
            msg: '表字段改名【t_ry.c_bh_gx】->【t_ry.c_bh_xx】'
        },{
            color:'blue',
            msg: '表字段【t_ry.c_bh_gx】改名【案件编号】->【编号案件】'
        }*/],
        pastes: [],
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
                key: 'columnType',
                maxWidth: 100
            },
            {
                title: '数据长度',
                key: 'columnLength',
                maxWidth: 100
            },
            {
                title: '数据精度',
                key: 'columnPoint',
                maxWidth: 100
            },
            {
                title: '操作',
                slot: 'action',
                width: 300,
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
            this.$Notice.success({
                title: '成功',
                desc: '删除字段'
            });
        },
        removeTable() {
            this.$Modal.confirm({
                title: '确认',
                content: '<p>确认删除此表？</p>',
                onOk: () => {
                    this.$Notice.success({
                        title: '成功',
                        desc: '删除表'
                    });
                },
                onCancel: () => {

                }
            });
        },
        clickHandler() {
            this.$Notice.success({
                title: '成功',
                desc: '响应点击事件'
            });
        },
        openTableModal(bh, copy) {
            this.$refs.tableModal.open(bh, copy);
        },
        openColumnModal(bh) {
            this.$refs.columnModal.open(bh);
        },
        openApprovalPrevModal() {
            this.$refs.approvalPrevModal.open();
        },
        columnCopy(item) {
            this.pastes.push(`${item.columnDesc}（${item.column}）`);
        },
        pasteToTable() {
            if (this.pastes.length === 0) {
                this.$Notice.warning({
                    title: '警告',
                    desc: '请先点击需要复制字段的复制按钮'
                });
                return;
            }
            this.clearPaste();
        },
        clearPaste() {
            // 直接使用length=0无法渲染页面，得一个个弹出
            while (this.pastes.length > 0) {
                this.pastes.pop();
            }
        }
    }
});
