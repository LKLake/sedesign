function request(data,url,func){
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function () {
        if(xmlHttp.readyState==4 && xmlHttp.status==200){
            var content = xmlHttp.responseText;
            if(func !=null){
                func(content);
            }
        }
    }
    xmlHttp.open("POST", url,false);
    xmlHttp.setRequestHeader("Content-Type","application/text;charset=utf-8");
    // xmlHttp.setRequestHeader("Accept","application/json");
    xmlHttp.send(JSON.stringify(data));
}