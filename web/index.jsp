<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/17
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>ours</title>
</head>
<body>
<h1>hello hongyewell</h1>
<input id="title"  placeholder="title" type="text">
<input id="content" placeholder="content" type="text">
<input type="button" value="提交" onclick="test()">
<div id="contentDiv"></div>
<!-- 引入jq类库 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    $(function () {

        query();

    })

    function test(){
        var title = $("#title").val();
        var content = $("#content").val();

        var oursJson = {'title':title,'content':content,'type':'post'};
        var contextPath = '${pageContext.request.contextPath}';
        var html = "";
        $.ajax({
            type: "post",
            url:   contextPath+"/Servlet",
            data:  oursJson,
            dataType: "json",
            success: function(data){
                query();
            }
        });
    }

    function query(){
        var oursJson = {'type':'get'};
        var contextPath = '${pageContext.request.contextPath}';
        var html = "";
        $.ajax({
            type: "post",
            url:   contextPath+"/Servlet",
            data:  oursJson,
            dataType: "json",
            success: function(data){
                for(var i=0;i<data.length; i++){
                    var title = data[i].title;
                    var content = data[i].content;
                    if(title.length>2){
                        var subtitle = title.substring(0,1)+"...";
                    }else{
                        subtitle = title;
                    }
                    html += '<tr id=\"why\">'
                            +'<td  class=\"Test\" title='+title+' style=\"text-overflow: ellipsis\"> '+subtitle+'</td>'
                            +'<td>'+content+'</td>'
                            +'</tr>';
                }
                $('#contentDiv').html(html);
            }
        });
    }


</script>

</body>
</html>
