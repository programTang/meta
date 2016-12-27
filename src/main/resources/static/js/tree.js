

function tree_parse(tree,upper_tree){
    for(var i=0;i<tree.length;i++){
        var tree_node = tree[i];
        if(tree_node.type == "dir"){
            var ul = document.createElement("ul");
            var li = document.createElement("li");
            li.innerHTML = '<span><i class="icon-plus-sign"></i> '+tree_node.name+'</span>';
            ul.appendChild(li);
            upper_tree.appendChild(ul);
            tree_parse(tree_node.children,li);
        }else{
            var ul = document.createElement("ul");
            var li = document.createElement("li");
            li.innerHTML = "<span><i class=\"icon-leaf\"></i> 文件节点</span>";
            ul.appendChild(li);
            upper_tree.appendChild(ul);
        }
    }
};

var tree = [{
    "id": 1,
    "name": "顶级目录",
    "type": "dir",
    "children": [{
        "id": 2,
        "name": "二级目录A",
        "type": "dir",
        "children":[{
            "id": 3,
            "name": "三级文件",
            "type": "file"
        }]
    },
        {
            "id": 2,
            "name": "二级目录A",
            "type": "dir",
            "children": [{
                "id": 3,
                "name": "三级文件",
                "type": "file"
            }]
        }]
},{
    "id": 1,
    "name": "顶级目录",
    "type": "dir",
    "children": [{
        "id": 2,
        "name": "二级目录A",
        "type": "dir",
        "children":[{
            "id": 3,
            "name": "三级文件",
            "type": "file"
        }]
    },
        {
            "id": 2,
            "name": "二级目录A",
            "type": "dir",
            "children": [{
                "id": 3,
                "name": "三级文件",
                "type": "file"
            }]
        }]
}];
