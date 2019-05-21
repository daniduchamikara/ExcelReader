<%--
  Created by IntelliJ IDEA.
  User: danid
  Date: 5/14/2019
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Excel To DB File Uploader</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>

</head>
<body>



<h1>File Uploader</h1>
<form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
    <div style="background-color: darkslategrey ;padding: 20px">
    <input id="fileuploader" type="file" name="file" value="Select Excell" onchange="getFileType()"/><br/>
    <input id="submit" style="color: black;margin-top: 8px;font-size: 16px" type="submit" value="Upload" />
    </div>
</form>

<script>
    $(document).ready(

    );

    function getFileType(){
        var fileName = $("#fileuploader").val();
        var exttension=extentionRead(fileName);
    }

    function extentionRead(fileName){
       alert(fileName+"First Stage")
       var ufileName=fileName.split('.').pop();
        if (ufileName=="xls"){
            alert(ufileName+" 1")
        }else if (ufileName=="xlsx"){
            alert(ufileName+" 2")
        }else {
            alert(ufileName+" 3")
        }
        return ufileName;
    }



</script>
</body>
</html>
