<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/app/css/wangEditor.min.css">
<script src="/app/js/wangEditor.min.js"></script>
<script type="text/javascript">
    $(function () {
        var editor = new wangEditor('editorContent');
        editor.config.uploadImgUrl = '/user/U_uploadImagesController';
        editor.create();
    });
</script>
