/**
 * 绑定首页logo的点击事件
 * @param type
 */
function home(type){
    $(".layui-logo").click(function () {
        $("#main_page").attr('src',type+'/init');
    })
    // $(".layui-logo").mouseenter(function () {
    //     $("#main_page").attr('src',type+'/init');
    // })
}
function turn(target) {
    var url = location.href.split('/')
    url = url[url.length-1]
    // console.log(url)
    $("#main_page").attr('src',url+'/'+target);
}
