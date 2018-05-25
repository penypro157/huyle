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

    function submitImage() {
        var data= $()
        
    }


})
