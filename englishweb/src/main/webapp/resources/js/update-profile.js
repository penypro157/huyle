$(document).ready(function() {
$('#updateinfo').submit(function(e) {

 // the script where you handle the form input.
    var loginForm = $('#updateinfo').serializeArray();
    var loginFormObject = {};
    $.each(loginForm,
        function(i, v) {
            loginFormObject[v.name] = v.value;
        });
    var request= $.ajax({
        type: 'POST',
        url: '/profile',
        data: JSON.stringify(loginFormObject), // serializes the form's elements.
        contentType: "application/json"
    }).done(function (data) {
        if(data==true) {
            $('#status-updateinfo').text('Đã lưu');
            setTimeout(function () {
                $('#status-updateinfo').text('');
            },2000);

        }
        else alert('that bai');
    })


    e.preventDefault(); // avoid to execute the actual submit of the form.
});

    $('#changepasswordform').submit(function (e) {
        var matkhaumoi=$(' input[name="matkhaumoi"]').val();
        var matkhaumoi1=$(' input[name="matkhaumoi1"]').val();
        if(matkhaumoi!=matkhaumoi1){
            e.preventDefault();
            alert('Nhập lại mật khẩu bị sai, hoặc có lỗi xảy ra !!')
        }
    });
    $('#fileimage-avatar').on('change',function () {
        var fileInput = document.getElementById('fileimage-avatar');
        var filePath = fileInput.value;
        var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;
        if(!allowedExtensions.exec(filePath)){
            alert('Định dạng không hỗ trợ')


        }
        else  $('#fileimage-avatar').submit();

    });
        // $('#upload-avatar').click();
    $('#upload-avatar').submit(function(e) {
        $('#alertMsg').text("Đang tải vui lòng chờ");
        // the script where you handle the form input.
        var form = $('#upload-avatar');
      var formData= new FormData(form[0]);
        var request= $.ajax({
            type: 'POST',
            url: '/uploadimage',
            data: formData,
            cache : false,// serializes the form's elements.
            contentType: false,
            processData: false,
        }).done(function (data) {
            if(data!="") {
                $('#avatar').attr("src","/resources/image/"+data);
                $('#alertMsg').text("Đã thay đổi ảnh đại diện");
                setTimeout(function () {
                    $('#alertMsg').text('');
                },2000);
            }
            else   $('#alertMsg').text("Đã có lỗi xảy ra");
        })


        e.preventDefault(); // avoid to execute the actual submit of the form.
    });


})
