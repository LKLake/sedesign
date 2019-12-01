function no_empty(element_list) {
    for(var i=0;i<element_list.length;i++){
        var elem=element_list[i];
        if(elem.value ===""){
            return elem.id+"不能为空";
        }
    }
    return "success";
}