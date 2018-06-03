
function onClick(btnelement, mabaidang) {
   if($(btnelement).hasClass('active')) {
       $(btnelement).removeClass('active')

   }
   else $(btnelement).addClass('active');
    likeActivity(mabaidang);
   var luotthich= getLuotThich(mabaidang);
    showLuotThich(btnelement,luotthich);
}
function likeActivity(maBaiDang) {
    $.ajax({
        type: 'GET',
        async: false,
        url: '/thich?mabaidang='+maBaiDang,
        cache: false,// serializes the form's elements.
        contentType: 'json',
        processData: false,
    }).done(function (data) {

    });
    
}
function getLuotThich(maBaiDang) {

var luotthich=0;
    $.ajax({
        type: 'GET',
        async : false ,
        url: '/luotthich?mabaidang='+maBaiDang,
        dataType: 'json'
    }).done(function (data) {
        luotthich=data;

    })

return luotthich;
    
}

function showLuotThich( btnthich, luotthich) {
  var x= $(btnthich).children()[1];
  $(x).html(luotthich);
}