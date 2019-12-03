function hit_table(table,name_list,pattern_list,hit_style,miss_style,flag) {
    var cell_name=table.rows[0];
    var cell_id=[];
    var result_row=[];

    for (var name_i in name_list){
        for(var cell_i=0;cell_i< cell_name.cells.length;cell_i++){
            if(name_list[name_i]===cell_name.cells[cell_i].id){

                cell_id[name_i]=cell_i;
                break;
            }
        }
    }
    for(var i in pattern_list){
        for(var j=0;j< table.rows.length;j++){
            if(table.rows[j].cells[cell_id[i]].innerText===pattern_list[i]){
                result_row.push(j);
            }
        }
    }
    // for(var i=0;i<result_row.length;i++){
    //     table.rows[result_row[i]].bgColor="green";
    // }
    for(var i=1;i<table.rows.length;i++){

        if(table.rows[i].getAttribute("_old")===null){
            table.rows[i].setAttribute("_old",table.rows[i].style.cssText)
        }
        // if(table.rows[i].getAttribute("_new")===null){
        //     table.rows[i].setAttribute("_new","")
        // }
        if(flag==="reset_first"){
            table.rows[i].style.cssText=table.rows[i].getAttribute("_old");
        }

        if(result_row.indexOf(i)!==-1) {
            table.rows[i].style.cssText = hit_style +" "+ table.rows[i].style.cssText;
        }
        else {
            if (miss_style !== "origin")
                table.rows[i].style.cssText= miss_style+" "+ table.rows[i].style.cssText;
        }
        if(!table.rows[i].style.cssText.endsWith(";")){
            table.rows[i].style.cssText=table.rows[i].style.cssText+";";
        }
    }
}