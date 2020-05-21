function preventDefault(){
  return false;
}
function getUrlParam(name) {
  let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
  let r = window.location.search.substr(1).match(reg);  //匹配目标参数
  if (r != null) return unescape(r[2]); return null; //返回参数值
}
function getFormData() {
  let elements = $("#formData > input");
  console.log(elements)
  let length = elements.length;
  // let data = {};
  let data = "{";
  for(let i=0; i< length; i++){
    console.log(elements[i].name,elements[i].value)
    let jump = false;
    if(elements[i].type === "radio"){
      if (elements[i].checked){
        data+="\""+elements[i].name+"\"";
        data+=":\""+elements[i].value+"\""
        // data[elements[i].name] = elements[i].value
      }else {
        jump = true;
      }
    }else {
      data+="\""+elements[i].name+"\"";
      data+=":\""+elements[i].value+"\""
      // data[elements[i].name] = elements[i].value
    }
    if(i !== length-1 && !jump){
      data+=",";
    }else if (!jump) {
      data+="}"
    }
  }
  console.log(data)
  return data;
}
