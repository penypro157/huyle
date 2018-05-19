$(document).ready(function() {
    function check() {
        $.ajax({
            type        : 'POST', // define the type of HTTP verb we want to use (POST for our form)
            url         : '/checkonline', // the url where we want to POST
            // data        : formData, // our data object
            dataType    : 'json', // what type of data do we expect back from the server
            encode          : true
        })
        // using the done promise callback
            .done(function(data) {


                // alert(data);

                    var content='';
                for(var i=0;i<data.length;i++){
                     content+= '<li>\n' +
                        '<div class="chat-left-img">\n' +
                        '<img src="/resources/image/1499345224_female1.png">\n' +
                        '</div>\n' +
                        '<div class="chat-left-detail">\n' +
                        '<p>'+data[i].username+'</p>\n' +
                        '<span><i class="fa fa-circle orange" aria-hidden="true"></i> offline</span>\n' +
                        '</div>\n' +
                        '</li>\n';


                }
                $('.left-chat').html(content);


                // log data to the console so we can see


                // here we will handle errors and validation messages
            });

    }

    setInterval(check, 2000);


});