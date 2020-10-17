/*
 * @author zhujunhan
 * @date 2020/6/7
 */
/**
 * 把zui的提示封装一下
 */
(function ($) {
    window.confirm = function (msg, action) {
        new $.zui.Messager(msg, {
            type: 'warning',
            icon: 'warning-sign',
            time: 0,
            actions: [{
                text: '确定',
                action: action
            }]
        }).show();
    };
    window.tip = {
        suc: function (msg) {
            new $.zui.Messager(msg, {
                type: 'success',
                placement: 'top',
                time: 2000
            }).show();
        },
        info: function (msg) {
            new $.zui.Messager(msg, {
                type: 'info',
                placement: 'top',
                time: 2000
            }).show();
        },
        err: function (msg) {
            new $.zui.Messager(msg, {
                type: 'danger',
                placement: 'top',
                time: 2000
            }).show();
        }
    };
})(jQuery);

axios.defaults.timeout = 0;
axios.interceptors.response.use(
    response => {
        return Promise.resolve(response.data)
    },
    error => {
        if (typeof error.response.data === 'string') {
            tip.err(error.response.data);
        }
        console.error(error);
        return Promise.reject(error.response);
    }
);

