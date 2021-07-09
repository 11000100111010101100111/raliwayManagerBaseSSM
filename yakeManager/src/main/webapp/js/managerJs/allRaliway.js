// <tr>
// <th>班次</th>
// <th>发车时间</th>
// <th>起点</th>
// <th>终点</th>
// <th>行车时间</th>
// <th>载客量</th>
// <th>已订票人数</th>
// </tr>
// <tr>
// <td>G15695</td>
// <td>2021-07-02&nbsp;&nbsp;12:32:59</td>
// <td>上海虹桥站</td>
// <td>上海虹桥站</td>
// <td>两天28小时24分钟</td>
// <td>1000</td>
// <td>1000</td>
// </tr>
// 动态向表格中添加一行元素
        function add_table0(index,arr){
            arr[0]="G2314";
            arr[1]="2021-07-02&nbsp;&nbsp;12:32:59";
            arr[2]="上海虹桥站";
            arr[3]="上海虹桥站";
            arr[4]=" 两天28小时24分钟";
            arr[5]="1000";
            arr[6]="1000";
            arr[7]="已发出";
            arr[8]="color:green;";

            $("#tab").append("<tr> <td>"+
                arr[0]+"</td> <td>"+
                arr[1]+"</td> <td>"+
                arr[2]+"</td> <td>"+
                arr[3]+"</td> <td>"+
                arr[4]+"</td> <td>"+
                arr[5]+"</td> <td>"+
                arr[6]+"</td> </tr style="+
                arr[8]+">"+
                arr[7]+"</td> </tr>");

            // arr_end[index]=arr[13];
            // arr_star[index]=arr[12];
        }
        addTab();
        function addTab() {
            var array=new Array();
            for (i=0;i<20;i++){
                add_table0(i,array);
            }
        }