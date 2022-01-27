function formCheck(){
    let idValue = $("#login_id").val();
    let pwValue = $("#login_pw").val();
    let sendData = {"id": idValue, "pw":pwValue};
    let result = null;

    $.ajax({
        url:"/login",
        type:"post",
        data:JSON.stringify(sendData),
        dataType:'json',
        contentType:"application/json",
        async:false,
        success:function(data){
            //로그인정보 체크
            if(data == false) {
                $("#login_error").css('display', 'block');
                result = false;
            }else {
                result = true;
            }
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){
            alert("통신실패");
        }

    });
}

function loginCheck(){

}