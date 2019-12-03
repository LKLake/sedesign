function color(table,name_list,pattern_list,hit_color,miss_color) {
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
    for(var i=0;i<table.rows.length;i++){
        if(result_row.indexOf(i)!==-1)
            table.rows[i].bgColor=hit_color;
        else {
            if (miss_color !== "origin")
                table.rows[i].bgColor = miss_color;
        }
    }
}