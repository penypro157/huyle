var action
function showMessage(message) {
    // Nếu message không được truyền vào hoặc giá trị nó là rỗng
    // thì sẽ được thay thế bằng giá trị 'Không có tin nhắn'
    message = message || 'Không có tin nhắn <br/>';
    document.getElementById('show').innerHTML=message;

}
function display(message) {
    alert(message);
}
function validate()
{

    // Lấy giá trị
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var re_password = document.getElementById("re-password").value;

    // Kiểm tra các giá trị
    if (username == ""){
        alert("Bạn chưa nhập tên đăng nhập");
        return false;
    }

    if (password == ""){
        alert("Bạn chưa nhập mật khẩu");
        return false;
    }


    if (password != re_password){
        alert("Mật khẩu nhập lại không đúng");
        return false;
    }

    return true;
}