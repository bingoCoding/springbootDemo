var d1 = '<div class="col-sm-12 input-group">';
var wait = '<div class="progress monitor-progress"> <button name="progress" class="progress-bar progress-bar-wait" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" id="';
var tch = '<div class="progress monitor-progress"> <button name="progress" class="progress-bar progress-bar-tch" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" id="';
var stu = '<div class="progress monitor-progress progress-stu"> <button name="progress" class="progress-bar-stu" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" id="';
var normal = '<div class="progress monitor-progress"> <button name="progress" class="progress-bar progress-bar-normal" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" id="';
var over = '<div class="progress monitor-progress"> <button name="progress" class="progress-bar progress-bar-over" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" id="';
var cut = '<div class="progress monitor-progress"> <button name="progress" class="progress-bar progress-bar-cut" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" id="';
var late = '<div class="progress monitor-progress"> <button name="progress" class="progress-bar progress-bar-late" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" id="';
function initMonitorData(dateStr, status) {
    $('#roomTimes').html('');
    $('#totalRoomsCount').html('');
    if(!status){
        status = '';
    }
    $.ajax({
        type: "get",
        url: "/monitor/online?dateStr=" + dateStr + '&status=' + status,
        dataType: "json",
        success: function (data) {
            if("0" == data.code){
                if(data.data.count >= 0){
                    $('#totalRoomsCount').html('&nbsp;&nbsp;&nbsp;共' + data.data.count + '节课');
                    var out = '';
                    $.each(data.data.datas,function(key,values){
                        out += d1 + '<h4>' + key + '&nbsp;&nbsp;'+ values.length +'节课</h4><div style="margin-top: 10px; display:inline;">';
                        $(values).each(function(){
                            if("0" == this.status){
                                out += wait + this.roomNum + '" onclick="showRoom(\'' + this.roomNum + '\')"></button> </div>';
                            }else if("1" == this.status){
                                out += tch + this.roomNum + '" onclick="showRoom(\'' + this.roomNum + '\')"></button> </div>';
                            }else if("2" == this.status){
                                out += stu + this.roomNum + '" onclick="showRoom(\'' + this.roomNum + '\')"></button> </div>';
                            }else if("3" == this.status){
                                out += normal + this.roomNum + '" onclick="showRoom(\'' + this.roomNum + '\')"></button> </div>';
                            }else if("4" == this.status){
                                out += over + this.roomNum + '" onclick="showRoom(\'' + this.roomNum + '\')"></button> </div>';
                            }else if("5" == this.status){
                                out += cut + this.roomNum + '" onclick="showRoom(\'' + this.roomNum + '\')"></button> </div>';
                            }else if("6" == this.status){
                                out += late + this.roomNum + '" onclick="showRoom(\'' + this.roomNum + '\')"></button> </div>';
                            }
                        });
                        out += '</div></div>';
                    });
                    $('#roomTimes').html(out);
                }else{
                    $('#totalRoomsCount').html('&nbsp;&nbsp;&nbsp;共0节课');
                }
            }
        }
    });
}
function showRoom(roomNum) {
    $('#myModalBody').html('');
    $.ajax({
        type: "get",
        url: "/monitor/online/info?roomNum=" + roomNum,
        dataType: "json",
        success: function (data) {
            if("0" == data.code){
                var out = '';
                console.log(data.data.duration);
                out += '<h4 class="modal-title" id="myModalLabel">课程名称: ' + roomNum + ' &nbsp;&nbsp;&nbsp;&nbsp; ' + data.data.duration +'分钟 </h4>';
                out += '<div class="form-group">';
                out += '<label class="col-sm-2 control-label">学生:</label>';
                out += '<div class="col-sm-8">';
                out += '<p class="form-control-static">' + data.data.student;
                out += ' &nbsp;&nbsp;&nbsp;&nbsp; ' + data.data.stuAccount + '</p></div></div>';
                out += '<div class="form-group">';
                out += '<label class="col-sm-2 control-label">老师:</label>';
                out += '<div class="col-sm-8">';
                out += '<p class="form-control-static">' + data.data.teacher;
                out += ' &nbsp;&nbsp;&nbsp;&nbsp; ' + data.data.tchAccount + '</p></div></div>';
                out += '<div class="form-group" style="text-align: center;">'
                out += '<a target="_blank" href="/monitor/onlineClassroom/roomInfo/index?roomNum=' + roomNum + '">查看详情></a>';
                out += '</div>';
            }
            $('#myModalBody').html(out);
        }
    });
    $('#myModal').modal('show');
}