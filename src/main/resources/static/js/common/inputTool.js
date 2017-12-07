/**
 * 输入节点ID和执行的方法，即可enter提交
 * @param nodeName
 * @param target
 */
function enterSubmit(nodeName, target) {
    $("#"+nodeName).on('keydown', function (e) {
        // console.log(e.keyCode)
        if (e.keyCode === 13){
            target()
        }
    })
}
