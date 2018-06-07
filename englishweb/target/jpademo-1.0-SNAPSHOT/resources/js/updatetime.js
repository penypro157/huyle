    $(document).ready(function() {
    setInterval(update,5000);
    function update() {
        $.ajax({
            type: 'GET', // define the type of HTTP verb we want to use (POST for our form)
            url: '/update', // the url where we want to POST
            // data        : formData, // our data object
            dataType: 'json', // what type of data do we expect back from the server
            encode: true
        }).done(function (data) {

        });


    }
});