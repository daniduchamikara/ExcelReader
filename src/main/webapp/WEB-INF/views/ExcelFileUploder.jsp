<%--
  Created by IntelliJ IDEA.
  User: danid
  Date: 5/17/2019
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>File Uploader</title>

    <!-- CSS for Bootstrap -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- JQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script type="text/javascript">
        $(function() {

            function getFileType(){
                var fileName = $("#uploder").val();
                var exttension=extentionRead(fileName);
                $("#uploder").val(exttension);
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


            $('button[type=submit]').click(function(e) {
                e.preventDefault();
                //Disable submit button
                $(this).prop('disabled',true);

                var form = document.forms[0];
                var formData = new FormData(form);

                // Ajax call for file uploaling
                var ajaxReq = $.ajax({
                    url : 'upload',
                    type : 'POST',
                    data : formData,
                    cache : false,
                    contentType : false,
                    processData : false,
                    xhr: function(){
                        //Get XmlHttpRequest object
                        var xhr = $.ajaxSettings.xhr() ;

                        //Set onprogress event handler
                        xhr.upload.onprogress = function(event){
                            var perc = Math.round((event.loaded / event.total) * 100);
                            $('#progressBar').text(perc + '%');
                            $('#progressBar').css('width',perc + '%');
                        };
                        return xhr ;
                    },
                    beforeSend: function( xhr ) {
                        //Reset alert message and progress bar
                        $('#alertMsg').text('');
                        $('#progressBar').text('');
                        $('#progressBar').css('width','0%');
                    }
                });

                // Called on success of file upload
                ajaxReq.done(function(msg) {
                    $('#alertMsg').text(msg);
                    $('input[type=file]').val('');
                    $('button[type=submit]').prop('disabled',false);
                });
            });
        });
    </script>
</head>
<body>

<div class="container">
    <h2>Excel File Uploader</h2>
    <hr>
    <!-- File Upload From -->
    <form method="POST" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
        <div class="form-group">
            <label>Select File</label>
            <input class="form-control" type="file" id="uploder" name="file"  onchange="getFileType()">
        </div>
        <div class="form-group">
            <button class="btn btn-primary" type="submit">Upload</button>
        </div>
    </form>
    <br />

    <!-- Bootstrap Progress bar -->
    <div class="progress">
        <div id="progressBar" class="progress-bar progress-bar-success" role="progressbar"
             aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width: 0%">0%</div>
    </div>
</div>

</body>
</html>
