/*
 * @author zhujunhan
 * @date 2020/12/11
 */
new Vue({
    el: '#app',
    data: {
        visible: false,
        value2: '1',
        dvalue: false,
        columns1: [
            {
                title: '字段',
                slot: 'field'
            },
            {
                title: '字段名',
                key: 'fieldName'
            },
            {
                title: '数据类型',
                key: 'fieldType'
            },
            {
                title: '说明',
                key: 'remark'
            },
            {
                title: '操作',
                slot: 'action',
                width: 200,
                align: 'center'
            }
        ],
        noindex: ['C_BH', 'C_AH', 'C_BH_AJ', 'DT_CJSJ', 'DT_ZHGXSJ'],
        data1: [
            {
                field: 'C_BH',
                fieldName: '主键',
                fieldType: 'VC(32)',
                remark: '主键,UUID'
            },
            {
                field: 'C_AH',
                fieldName: '案号',
                fieldType: 'VC(300)',
                remark: '案号'
            },
            {
                field: 'C_BH_AJ',
                fieldName: '案件编号',
                fieldType: 'VC(32)',
                remark: '案件编号'
            },
            {
                field: 'C_AJMC',
                fieldName: '案件名称',
                fieldType: 'VC(300)',
                remark: '案件编号'
            },
            {
                field: 'C_JBFY',
                fieldName: '经办法院',
                fieldType: 'VC(100)',
                remark: '经办法院'
            },
            {
                field: 'DT_CJSJ',
                fieldName: '创建时间',
                fieldType: 'DT',
                remark: '增量字段'
            },
            {
                field: 'DT_ZHGXSJ',
                fieldName: '最后更新时间',
                fieldType: 'DT',
                remark: '增量字段'
            }
        ]
    },
    methods: {
        show(index) {
            alert('show-' + index);
            this.$Modal.info({
                title: 'User Info',
                content: `11111`
            })
        },
        remove(index) {
            alert('rm-' + index);
        }
    }
});
