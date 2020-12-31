var tdata;
var t1;
layui.use('table', function(){
    var table = layui.table;
    t1=table;
    table.render({
        elem: '#test'
        ,data:tdata
        ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
        ,defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
            title: '提示'
            ,layEvent: 'LAYTABLE_TIPS'
            ,icon: 'layui-icon-tips'
        }]
        ,title: '数据表'
        ,height:600
        ,cols: [[
            {type: 'checkbox', fixed: 'left'}
            ,{field: 'sid', title: '商店码', sort: true}
            ,{field: 'name', title: '商店名'}
            ,{field: 'phone', title: '电话'}
            ,{field: 'address', title: '地址'}
            ,{field: 'introduce', title: '介绍'}
            ,{field: 'picture', title: '图片'}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
        ]]
        ,page: true
    });

    //头工具栏事件
    table.on('toolbar(test)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var cdata = checkStatus.data;
        switch(obj.event){
            case 'getAdd':
                layer.open({
                    type: 2 //iframe层类型
                    ,area: ['700px', '400px']
                    ,title: '请输入信息'
                    ,shade: 0.6 //遮罩透明度
                    ,maxmin: false //允许全屏最小化
                    ,anim: 1 //0-6的动画形式，-1不开启
                    ,content:'http://localhost:8080/save'
                });
                break;
            case 'getDel':
                var json=JSON.stringify(cdata);
                console.log(json);
                $.ajax({
                    url:'/deleteRows',
                    type:'post',
                    data:{
                        json:json
                    },
                    success:function () {
                        layer.msg('成功');
                    },
                    error:function () {
                        layer.msg('错误');
                    }
                });
                break;
            case 'getSel':
                layer.alert(JSON.stringify(cdata));
            case 'import':
                layer.alert(JSON.stringify(cdata));
        };
    });

    //监听行工具事件
    table.on('tool(test)', function(obj){
        var data = obj.data;
        if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                $.ajax({
                    url:'/deleteRow',
                    type:'post',
                    data:{
                        sid:data.sid
                    },
                    success:function () {
                        obj.del();
                        layer.close(index);
                        layer.msg('删除成功');
                    },
                    error:function () {
                        layer.msg('错误');
                    }
                });
            });
        } else if(obj.event === 'edit'){
            layer.prompt({
                formType: 2
                ,value: data.email
            }, function(value, index){
                obj.update({
                    email: value
                });
                layer.close(index);
            });
        }
    });
});
load();
function load(){
    $.ajax({
        url:'/loadData',
        type:'post',
        data:null,
        dataType:'json',
        success:function (obj) {
            tdata=obj;
            t1.reload();
        },
        error:function (obj) {

        }
    });
}