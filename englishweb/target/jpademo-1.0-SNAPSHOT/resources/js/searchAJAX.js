$(document).ready(function() {
        $('#srch-term').keyup(function () {
            var username = $('#srch-term').val();
            search(username);

        })
    function search(username) {
        $.ajax({

            type        : 'PUT', // define the type of HTTP verb we want to use (POST for our form)
            url         : '/search/username', // the url where we want to POST
         data        : username, // our data object
            dataType    : 'json', // what type of data do we expect back from the server
        })
        // using the done promise callback
            .done(function(data) {
                if(data.length!=0) {
                    forEach(data, function (user) {
                        var s = '   <a  href="javascript:loadM();">\n' +
                            '                    <li>\n' +
                            '                        <div class="chat-left-img" >\n' +
                            '                            <img src="/resources/image/1499345224_female1.png">\n' +
                            '                        </div>\n' +
                            '                        <div class="chat-left-detail">\n' +
                            '                            <p>${user.username}</p>\n' +
                            '                            <span><i class="fa fa-circle orange" aria-hidden="true"></i> ${user.timeUpdate}</span>\n' +
                            '                        </div>\n' +
                            '                    </li>\n' +
                            '                    </a>';
                        $(' div .left-chat ul').append(s);
                    })
                }
                // alert(data);



                // log data to the console so we can see


                // here we will handle errors and validation messages
            });

    }



});