function finduser() {
    var language = $(' select[name="language"]').val();
    var country = $(' select[name="country"]').val();
    searchbycondition(language, country)

}

function searchbycondition(language, country) {
    $.ajax({

        type: 'GET', // define the type of HTTP verb we want to use (POST for our form)
        url: '/search/condition?language=' + language + '&country=' + country, // the url where we want to POST
// our data object
        dataType: 'json', // what type of data do we expect back from the server
    })
    // using the done promise callback
        .done(function (data) {

            var userdom=  $(' div .left-chat ul a');
            if (data.length != 0) {
                data.forEach(function (user, index) {
                    var username=user.username;

                    var offline = '   <a  name="user.email" href="#" onclick="loadMessage('+username+') ">\n' +
                        '                    <li>\n' +
                        '                        <div class="chat-left-img" >\n' +
                        '                            <img src="/resources/image/1499345224_female1.png">\n' +
                        '                        </div>\n' +
                        '                        <div class="chat-left-detail">\n' +
                        '                            <p>' + user.username + '</p>\n' +
                        '                            <span><i class="fa fa-circle orange" aria-hidden="true"></i> </span>\n' +
                        '                        </div>\n' +
                        '                    </li>\n' +
                        '                    </a>';

                    var online = '   <a  name="user.email" href="#" onclick="loadMessage("'+username+'")">\n' +
                        '                    <li>\n' +
                        '                        <div class="chat-left-img" >\n' +
                        '                            <img src="/resources/image/1499345224_female1.png">\n' +
                        '                        </div>\n' +
                        '                        <div class="chat-left-detail">\n' +
                        '                            <p>' + user.username + '</p>\n' +
                        '                            <span><i class="fa fa-circle " aria-hidden="true"></i> </span>\n' +
                        '                        </div>\n' +
                        '                    </li>\n' +
                        '                    </a>';

                    try {
                        if(userdom.length==0) {
                            if (new Date().getTime() - user.timeUpdate < 20000) {
                                $(' div .left-chat ul').append(online);



                            }else $(' div .left-chat ul').append(offline);

                        }
                        else {
                            $(' div .left-chat ul a').forEach(function (element, index) {
                                if (element.attr("name") != user.username) {
                                    if (new Date().getTime() - user.timeUpdate < 20000) {
                                        $(' div .left-chat ul').append(online);


                                    } else $(' div .left-chat ul').append(offline);


                                }
                                else {
                                    if (new Date().getTime() - user.timeUpdate < 20000) {
                                        element.children('i').attr('class').removeClass(' orange');


                                    } else element.children('i').attr('class').hasClass(' orange');

                                }


                            })
                        }
                    }
                    catch(err) {

                    }



                })
            }
            // alert(data);


            // log data to the console so we can see


            // here we will handle errors and validation messages
        });
    function deleteDom(data) {
        data.forEach( function (user,index) {

            $(' div .left-chat ul').forEach( function (element, index) {
                if(element.attr("name")!=user.username)
                    element.val("");
                
            })
        })

    }

}
