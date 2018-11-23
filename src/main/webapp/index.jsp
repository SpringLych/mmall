<html>
<%@page language="java" contentType="text/html;charset=utf-8"  pageEncoding="UTF-8"%>
<body>
<h2 style="text-align: center;color: red">SpringMVC上传文件</h2>

<form name="form1" action="/manage/product/upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file">
    <input type="submit" value="上传文件">
</form>

<form name="form1" action="/manage/product/richtext_img_upload.do.do" method="post" enctype="multipart/form-data">
    <input type="file" name="upload_file">
    <input type="submit" value="上传文件">
</form>
</body>
</html>
