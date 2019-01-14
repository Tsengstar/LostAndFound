function checkImg(){
    url = "url('../createImg?randomNum="+Math.random()+"')";
    $("#verify").css("background-image",url);
}
function login(){
    $.ajax({
        type:"post",
        url:"/login",
        data:{ user:$("#user").val(),pwd:$("#pwd").val()},
        success: function (data) {
            if(data === true){
                window.location.href = "/";
            }else{
                alert("用户名或密码错误！");
                $("#verify").val("");
            }
        }
    });
    checkImg();
}
$(function () {
    $("#formOne").validate({
        rules:{
            user:{
                required:true
            },
            pwd:{
                required:true
            },
            verify:{
                required:true,
                remote: "/checkVerifyIsTrue?"+$("#verify").val()
            }
        },
        messages:{
            user:{
                required:"用户名不能为空！"
            },
            pwd:{
                required:"密码不能为空！"
            },
            verify:{
                required:"验证码不能为空！",
                remote:"验证码错误！"
            }
        },
        errorPlacement: function(error, element) {
            $( element )
                .closest( "form" )
                .find( "#"+element.attr( "id" )+"_pass" )
                .append( error );
        },
        onkeyup:false,
        submitHandler: function() {
            login();
        }
    });
    checkImg();
});


// //获取input的所有id
// var user = document.getElementById("user");
// var pwd = document.getElementById("pwd");
// var verify = document.getElementById("verify");
//
//
// //获取span的所有id
// var user_pass = document.getElementById("user_pass");
// var pwd_pass = document.getElementById("pwd_pass");
// var verify_pass = document.getElementById("verify_pass");
// function checkUser(){
//     //如果昵称未输入，则提示输入昵称
//     if(!user.value){
//         user_pass.style.fontSize = "13px";
//         user_pass.style.width="31%";
//         user_pass.style.height="2em";
//         user_pass.style.textAlign="center";
//         user_pass.style.lineHeight="2em";
//         user_pass.style.marginTop='0.05%'
//         user_pass.innerHTML = '你还没有填写用户名哦。';
//         user_pass.style.display="block";
//     }
//     else if(user.value){
//         user_pass.style.display="none";
//     }
// }
//
// //输入密码提示
// function checkUser1(){
//     //如果未输入密码，则提示请输入密码
//     if(!pwd.value){
//         pwd_pass.style.fontSize = "13px";
//         pwd_pass.style.width="31%";
//         pwd_pass.style.height="2em";
//         pwd_pass.style.textAlign="center";
//         pwd_pass.style.lineHeight="2em";
//         pwd_pass.innerHTML = '你还没有填写密码哦。';
//         pwd_pass.style.display="block";
//     }
//     else{
//         pwd_pass.innerHTML ='';
//         // pwd_pass.style.backgroundColor= "#fff";
//         pwd_pass.style.border="none";
//         pwd_pass.style.display="none";
//
//     }
//
// }
//
// //确认密码提示
// function checkUser2(){
//     //再次确认密码
//     if(!verify.value){
//         verify_pass.style.fontSize = "13px";
//         verify_pass.style.width="31%";
//         verify_pass.style.height="2em";
//         verifypass.style.textAlign="center";
//         verify_pass.style.lineHeight="2em";
//         verify_pass.innerHTML = '你还没有填写验证码哦';
//         verify_pass.style.display="block";
//     }
//
//     else{
//         verify_pass.innerHTML ='';
//         // verify_pass.style.backgroundColor= "#fff";
//         verify_pass.style.border="none";
//         verify_pass.style.display="none";
//     }
// }
// function checkVerify() {
//
// }
// function  login(){
//
//     if(!user.value){
//         user_pass.style.fontSize = "13px";
//         user_pass.style.width="31%";
//         user_pass.style.height="2em";
//         user_pass.style.textAlign="center";
//         user_pass.style.lineHeight="2em";
//         user_pass.innerHTML = '请填写您的用户名。';
//         user.focus();
//         return false;
//     }
//     if(!pwd.value){
//         pwd_pass.style.fontSize = "13px";
//         pwd_pass.style.width="31%";
//         pwd_pass.style.height="2em";
//         pwd_pass.style.textAlign="center";
//         pwd_pass.style.lineHeight="2em";
//         pwd_pass.innerHTML = '请填写您的用户密码。';
//         pwd.focus();
//         return false;
//     }
//
//     if(!verify.value){
//         verify_pass.style.fontSize = "13px";
//         verify_pass.style.width="31%";
//         verify_pass.style.height="2em";
//         verify_pass.style.textAlign="center";
//         verify_pass.style.lineHeight="2em";
//         verify_pass.innerHTML = '请填写您的登录验证。';
//         verify_pass.focus();
//         return false;
//     }
//     else{
//         alert(user.value+pwd.value+verify.value);
//         return false;
//         // $.ajax({
//         //
//         // });
//     }
// }
//
