$(document).ready(function () {
    function loadMassge() {
        $.ajax({
            type        : 'GET', // define the type of HTTP verb we want to use (POST for our form)
            url         : '/massage?id='+'5a9c28c56ec14eccb92a6bf0', // the url where we want to POST
            // data        : formData, // our data object
            dataType    : 'json', // what type of data do we expect back from the server
            encode          : true
        }).done(function (data) {
            alert("dmm"+data[1].content);
            
        })
    }


})
function loadMessage(email) {

    $.ajax({
        type        : 'GET', // define the type of HTTP verb we want to use (POST for our form)
        url         : '/getuser?email='+email, // the url where we want to POST
        // data        : formData, // our data object
        dataType    : 'json', // what type of data do we expect back from the server
        encode          : true
    }).done(function (data) {
        var  s='  <div class="right-header-img">\n' +
            '                        <img src="/resources/image/businessman.png">\n' +
            '                    </div>\n' +
            '                    <div class="right-header-detail">\n' +
            '                        <p>'+data.username+'</p>\n' +
            '                        <span>${user.timeUpdate}</span>\n' +
            '                    </div>';
        $(' div[class="col-md-12 right-header"]').val(s);

    })
}