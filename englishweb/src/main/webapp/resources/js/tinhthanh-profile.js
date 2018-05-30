$(document).ready(function() {
    $('#tinhthanh').on('change',function () {
    var tentinhthanh= $('#tinhthanh :selected').text();
        $('#quanhuyen').text('');
    $.ajax({
        type: 'GET',
        url: '/tinhthanh?tentinhthanh='+tentinhthanh,
        dataType : 'json'
    }).done(function (data) {

        if(data!=null){

           $.each(data, function (index , item) {
                   var s = ' <option value="' + item.tenquanhuyen + '"\n' +
                       '                                            selected>' + item.tenquanhuyen + '</option>';
                   $('#quanhuyen').append(s);

               
           })

        }


    });
    });


});
function choiceaddress() {
    var tentinhthanh= $('#tinhthanh :selected').text();
    var tenquanhuyen= $('#quanhuyen :selected').text();
    $.ajax({
        type: 'GET',
        url: '/noisong?tentinhthanh='+tentinhthanh+'&tenquanhuyen='+tenquanhuyen,
        dataType : 'json'
    }).done(function (data) {

        if(data==true){
            alert('đã cập nhật');



        }
        else alert('có lỗi');


    });

}