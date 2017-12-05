function alertError() {
    var url = location.search;
    if (url.indexOf("?") !== -1) {
        layer.open({
            type: 0,
            shade: 0,
            closeBtn: 0,
            title: '',
            time: 2000,
            offset: 'rt',
            content: '用户名或者密码错误'
        })
    }
}