/**
 * Created by zxh on 16/9/27.
 */
function responseHandler(res) {
    if(res.total > 0) {
        return {
            "rows": res.rows,
            "total": res.total
        }
    } else {
        return {
            "rows": [],
            "total": 0
        }
    }
}
function getStudentDetails(start,end,pageNum){
    var branch = $("#comboOrg").val();
    var stuName = $("#stuName").val();
    var userType = $("#userType").val();
    if($("#pagination").data("twbs-pagination")){
        $("#pagination").twbsPagination("destroy");
    }
    $.ajax({
        type: "post",
        url: "/student/list/data",
        data:{start:start,end:end,branch:branch,stuName:stuName,userType:userType,pageNum:pageNum,pageSize:10},
        dataType: "json",
        success: function (data) {
            var status = data.data.status;
            if("success" == status){
                var datas = data.data.page.list;
                var startRow = data.data.page.startRow;
                var pages = data.data.page.pages;
                var pageNum = data.data.page.pageNum;
                initPagination(start,end,pages,pageNum);
                $('#studentListTable tbody').empty();
                var out = "";
                for (var i = 0; i < datas.length; i++){
                    out += '<tr>';
                    out += '<td>' + (i + startRow) + '</td>';
                    out += '<td id="stuInfoTd" data-container="body" data-toggle="popover" data-placement="right" title="姓名:' + datas[i].stuname + '" data-content = "性别:' + datas[i].sex + '&#10;' +
                        '年龄:' + datas[i].age + ' &#13;琴龄:' + datas[i].playyears + ' &#13;&#10;注册时间: ' + datas[i].registday + '">' + datas[i].stuname + '</td>';
                    out += '<td>' + $.isNullOrUndefined(datas[i].playtimes) + '</td>';
                    out += '<td>' + $.isNullOrUndefined(datas[i].studytimes) + '</td>';
                    out += '<td>' + $.isNullOrUndefined(datas[i].playsongs) + '</td>';
                    out += '<td>' + $.isNullOrUndefined(datas[i].ownsongs) + '</td>';
                    out += '<td>' + $.isNullOrUndefined(datas[i].lastplaytime,'string') + '</td>';
                    out += '<td><button class="btn btn-info btn-sm" data-toggle="modal" name="infoBtn" id="' + datas[i].stid +'">查看报告</button></td>';
                    out += '</tr>';
                }
                $('#studentListTable tbody').html(out);
                $("button[name='infoBtn']").bind("click", function () {
                    window.location.href = "/student/playReport?studentId=" + this.id;
                });
                $("td[id='stuInfoTd']").bind("mouseover", function () {
                    $(this).popover('toggle');
                });
                $("td[id='stuInfoTd']").bind("mouseleave", function () {
                    $(this).popover('hide');
                });
            }else{
                console.error("/student/list/data get data fail.");
            }
        }
    });
}

function initPagination(start,end,totalPages,startPage) {
    var visiblePages = totalPages > 5?5:totalPages;
    $('#pagination').twbsPagination({
        totalPages: totalPages,
        visiblePages: visiblePages,
        first:'首页',
        prev:'前一页',
        next:'后一页',
        last:'末页',
        startPage: startPage,
        initiateStartPageClick: false,
        onPageClick: function (event, page) {
            getStudentDetails(start, end, page);
        }
    });
}
function getStudentGeneral(start,end){
    var branch = $("#comboOrg").val();
    var userType = $("#userType").val();
    $.ajax({
        type: "post",
        url: "/student/general/data",
        data:{beginDate: start, endDate: end, userType: userType, orgId: branch},
        dataType: "json",
        success: function (data) {
            var status = data.data.status;
            if("success" == status){
                var datas = data.data.list;
                var out = "";
                studentGeneralChartData.length = datas.length;
                for (var i = 0; i < datas.length; i++){
                    studentGeneralChartData[i] = datas[i];
                    out += '<tr>';
                    out += '<td>' + $.isNullOrUndefined(datas[i].day_str,'string') + '</td>';
                    out += '<td>' + $.isNullOrUndefined(datas[i].playusers) + '</td>';
                    out += '<td>' + $.isNullOrUndefined(datas[i].playtimes) + '</td>';
                    out += '<td>' + $.isNullOrUndefined(datas[i].playsongs) + '</td>';
                    out += '<td>' + $.isNullOrUndefined(datas[i].studytimes) + '</td>';
                    out += '<td><button class="btn btn-info btn-sm" data-toggle="modal" onclick="gotoStudentGeneralDetail(\'' + datas[i].day_str + '\');">查看明细</button></td>';
                    out += '</tr>';
                }
                $('#studentGeneralTableData').html(out);
                studentGeneralChart($("li.switch.selected").html());
            }else{
                console.error("/student/general/data get data fail.");
            }
        }
    });
}
function gotoStudentGeneralDetail(day) {
	window.location.href = '/student/generalDetail?day=' + day + '&userType=' + $('#userType').val() + '&orgId=' + $("#comboOrg").val();
}

function studentGeneralChart(type) {
    var j = 0;
    var categories=new Array(),data=new Array();
    for(var i = 0; i < studentGeneralChartData.length; i++) {
        categories[j] = $.isNullOrUndefined(studentGeneralChartData[i].day_str,'string');
        if("练习时长" == type){
            data[j++] = $.isNullOrUndefined(studentGeneralChartData[i].playtimes);
        }else if("练习曲目数" == type){
            data[j++] = $.isNullOrUndefined(studentGeneralChartData[i].playsongs);
        }else if("学习时长" == type){
            data[j++] = $.isNullOrUndefined(studentGeneralChartData[i].studytimes);
        }else{
            data[j++] = $.isNullOrUndefined(studentGeneralChartData[i].playusers);
        }
    }
    var studentGeneralChart = echarts.init(document.getElementById("studentGeneralChart"),'macarons');
    studentGeneralChart.setOption(getEChartConfig('练习人数','用户数',categories,data));
}

function gradingChartData(stuId,start,end) {
    $.ajax({
        type: "post",
        url: "/student/grading/chart/data",
        data:{beginDate: start, endDate: end, stuId:stuId},
        dataType: "json",
        success: function (data) {
            var status = data.data.status;
            if("success" == status){
                var datas = data.data.list;
                studentGradingChartData.length = datas.length;
                for (var i = 0; i < datas.length; i++){
                    studentGradingChartData[i] = datas[i];
                }
                studentGradingChart($("li.switch.selected").html());
            }else{
                console.error("/student/grading/chart/data get data fail.");
            }
        }
    });
}
function studentGradingChart(type) {
    console.log(type);
    var j = 0;
    var categories=new Array(),data=new Array();
    for(var i = studentGradingChartData.length -1; i >= 0; i--){
        categories[j] = $.isNullOrUndefined(studentGradingChartData[i].dayStr,'string');
        if("练习时长" == type){
            data[j++] = $.isNullOrUndefined(studentGradingChartData[i].playTime);
        }else if("掌握曲目数" == type){

        }else if("练习曲目数" == type){
            data[j++] = $.isNullOrUndefined(studentGradingChartData[i].playSongCount);
        }else if("练习遍数" == type){
            data[j++] = $.isNullOrUndefined(studentGradingChartData[i].playCount);
        }else if("学习时长" == type){
            data[j++] = $.isNullOrUndefined(studentGradingChartData[i].studyTime);
        }else{
            data[j++] = $.isNullOrUndefined(studentGradingChartData[i].playScore);
        }
    }
    var studentGeneralChart = echarts.init(document.getElementById("pageChart"),'macarons');
    studentGeneralChart.setOption(getEChartConfig('练习人数','用户数',categories,data));
}

function goGradingSongReport(stuId,start,end) {
    window.location.href = "/student/gradingSongReport?studentId=" + stuId + "&beginDate=" + start + "&endDate=" + end;
}

function getMessage(flagStr,item) {
    if('偏高' == flagStr){
        if('playTimes' == item){
            return '<span>偏高－想想弹钢琴可以在班上为同学表演，并由此受大家欢迎身体里就充满了洪荒之力。</span>'
        }else if('playAccTime' == item){
            return '<span>偏高－一点门槛都没有的事情做起来又有什么意思？累计练琴时间最长的吉尼斯纪录就等你打破了。</span>'
        }else if('playAvgTime' == item){
            return '<span>偏高－恭喜你已经获得“练琴小能手”称号，给你专注练琴的样子点个赞！</span>'
        }else if('playLastTime' == item){
            return '<span></span>'
        }else if('playSongs' == item){
            return '<span>偏高－练了那么多曲目，史上最炫技巧的十大钢琴练习曲目是否已经全部攻克了呢？看好你哦~</span>'
        }else if('gradingProgress' == item){
            return '<span>偏高－先将考级曲目学会，进而给精练留有余地。考级时注重着装、礼仪，做到遇错不慌。看好你哦！</span>'
        }else if('passRate' == item){
            return '<span>偏高－考级可以给你提供互相交流、学习及上台历练的机会，而你离成功越来越近了。</span>'
        }else if('avgSingleFinishTime' == item){
            return '<span>偏高－棒棒哒，你能很快完成一首乐曲的练习。多对比大师示范视频和自己的录音回放，还能提高的更快哦！</span>'
        }else if('playAvgStar' == item){
            return '<span>偏高－你优秀的成绩就像天上的繁星一样璀璨，加油获得更多的星星让你的星空更加绚烂多姿吧！</span>'
        }else if('equipments' == item){
            return '<span>偏高－音乐笔记智能腕带在手，练琴问题都没有，妈妈再也不用担心我练琴了！</span>'
        }else{
            return '<span></span>'
        }
    }else if('偏低' == flagStr){
        if('playTimes' == item){
            return '<span>偏低－每天至少1－2小时的高效率练琴并且持之以恒是练琴的王道，不要掉队哦小朋友！</span>'
        }else if('playAccTime' == item){
            return '<span>偏低－只有保证练琴时间，才能熟练地掌握弹奏技巧。学会制定切实可行的练琴计划，合理地分配时间哦~</span>'
        }else if('playAvgTime' == item){
            return '<span>偏低－在学琴阶段要尽量做到天天练琴，绝不能三天打鱼，两天晒网哦~</span>'
        }else if('playLastTime' == item){
            return '<span></span>'
        }else if('playSongs' == item){
            return '<span>偏低－曲目的选择要追求艺术与技术两方面的多样性，不能太单一哦~</span>'
        }else if('gradingProgress' == item){
            return '<span>偏低－如果差的太远，建议一步一个脚印，稳扎稳打，不要急于参加考级太过跳进。</span>'
        }else if('passRate' == item){
            return '<span>偏低－拔苗助长硬着头皮上战场可不是考级推崇的，再多学多练一段时间一定可以驾驭它的，加油！</span>'
        }else if('avgSingleFinishTime' == item){
            return '<span>偏低－每天练琴的时间要相对集中，练琴时要精力高度集中，目标明确，力求每天都有进步！</span>'
        }else if('playAvgStar' == item){
            return '<span>偏低－检查演奏质量是否过关最基本的是连贯没有错音，然后才是有一定的表现力。</span>'
        }else if('equipments' == item){
            return '<span>偏低－音乐笔记钢琴智能陪练系统个性教学完胜每周一次作业，每日练习目标不明确、效果难衡量的传统教学，这么厉害的神器快快戴起来吧！</span>'
        }else{
            return '<span></span>'
        }
    }else{
        if('playTimes' == item){
            return '<span>标准－弹钢琴并非是一件特别困难的事，只要付出一定的努力就可能做到，你还可以再多练几次。</span>'
        }else if('playAccTime' == item){
            return '<span>标准－贝多芬童年时，严厉的父亲要求他每天练习钢琴和小提琴8个小时以上，即使寒冬也不例外。算算你离大师还有多远呢？</span>'
        }else if('playAvgTime' == item){
            return '<span>标准－一遍又一遍的弹奏，当你能够熟练地驾驭这首钢琴曲的时候，你就赢了！</span>'
        }else if('playLastTime' == item){
            return '<span></span>'
        }else if('playSongs' == item){
            return '<span>标准－大音乐家巴克豪斯八十岁手指还是灵活异常，他说“这就是每天练音阶、琶音的结果”，所以别忘了每日必练的保留曲目哦~</span>'
        }else if('gradingProgress' == item){
            return '<span>标准－盲目跳进是考级中常见的问题，任何知识的学习都要按照一定的程序，循序渐进。</span>'
        }else if('passRate' == item){
            return '<span>标准－考级是学生钢琴学习历程的一个阶段性记录，直接反应学生的钢琴学习程度及音乐素养，你还要再加油一点点哦！</span>'
        }else if('avgSingleFinishTime' == item){
            return '<span>标准－练琴的效率高低与练琴的方法有直接的关系，要培养分手练习、分段练习、难点练习的好习惯，这样才能达到事半功倍的效果！</span>'
        }else if('playAvgStar' == item){
            return '<span>标准－建立一个良好的质量观念，同时养成一个良好的学习习惯是为了在今后的学习中更好的提高。</span>'
        }else if('equipments' == item){
            return '<span>标准－音乐笔记钢琴智能陪练系统自动纠错与在线点评结合，练习结果实时指导，不戴多可惜啊！</span>'
        }else{
            return '<span></span>'
        }
    }
}
jQuery.extend({
    isNullOrUndefined:function (src,type) {
        if(null == src || typeof(src) == "undefined"){
            return 'string' == type ? '' : 0;
        }else{
            return src;
        }
    }
});
