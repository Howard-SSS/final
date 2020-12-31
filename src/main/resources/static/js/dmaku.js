function toLog() {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";
  document.querySelector('.cont_form_login').style.display = "block";
  document.querySelector('.cont_form_sign_up').style.opacity = "0";
  setTimeout(function(){
    document.querySelector('.cont_form_login').style.opacity = "1";
  },400);
  setTimeout(function(){
    document.querySelector('.cont_form_sign_up').style.display = "none";
  },200);
}
function cambiar_login(phone,password) {
  var json=JSON.stringify({
    "phone":phone,
    "password":password
  });
  $.ajax({
    url:'/login',
    type:'post',
    data:{
      'json':json
    },
    resultType:'text',
    success:function (ret) {
      if(ret == 'administrator') {
        window.location.href = '/toManage';
      }
      else if(ret == 'common') {
        window.location.href = '/toIndex';
      }else
        layer.msg('错误')
    },
    error:function (ret) {
      layer.msg('登录失败');
    }
  });

  }
function toReg() {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
  document.querySelector('.cont_form_sign_up').style.display = "block";
  document.querySelector('.cont_form_login').style.opacity = "0";

  setTimeout(function(){  document.querySelector('.cont_form_sign_up').style.opacity = "1";
  },100);

  setTimeout(function(){   document.querySelector('.cont_form_login').style.display = "none";
  },400);
}

function cambiar_sign_up(phone,name,password) {
  var json=JSON.stringify({
    "phone":phone,
    "name":name,
    "password":password
  });
  $.ajax({
    url:'/register',
    type:'post',
    data:{
      'json':json
    },
    success:function () {
      console.log(123);
    },
    error:function () {
      console.log(456);
    }
  });
}    



function ocultar_login_sign_up() {

document.querySelector('.cont_forms').className = "cont_forms";  
document.querySelector('.cont_form_sign_up').style.opacity = "0";               
document.querySelector('.cont_form_login').style.opacity = "0"; 

setTimeout(function(){
document.querySelector('.cont_form_sign_up').style.display = "none";
document.querySelector('.cont_form_login').style.display = "none";
},500);  
  
  }