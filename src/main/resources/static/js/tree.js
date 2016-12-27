var tree = {
    "id": 1,
    "name": "顶级目录",
    "type": "dir",
    "children": {
        "id": 2,
        "name": "二级目录A",
        "type": "dir",
        "children": {
            "id": 3,
            "name": "三级文件",
            "type": "file"
        }
    }
};


function tree_parse(tree,upper_tree){
    if(tree.type == "dir"){
        var ul = document.createElement("ul");
        ul.innerHTML = '<li><span><i class="icon-plus-sign"></i> '+tree.name+'</span></li>';
        upper_tree.appendChild(ul);
        tree_parse(tree.children,ul);
    }else{
        var li = document.createElement("li");
//        li.style.display = "none";
        li.innerHTML = "<span><i class=\"icon-leaf\"></i> 文件节点</span>"
        upper_tree.appendChild(li);
    }

};
