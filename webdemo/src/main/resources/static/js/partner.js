$(document).ready(function() {
	$('.leftpanel .nav .parent > a').click(function() {
	      
	      var coll = $(this).parents('.collapsed').length;
	      
	      if (!coll) {
	         $('.leftpanel .nav .parent-focus').each(function() {
	            $(this).find('.children').slideUp('fast');
	            $(this).removeClass('parent-focus');
	         });
	         
	         var child = $(this).parent().find('.children');
	         if(!child.is(':visible')) {
	            child.slideDown('fast');
	            if(!child.parent().hasClass('active'))
	               child.parent().addClass('parent-focus');
	         } else {
	            child.slideUp('fast');
	            child.parent().removeClass('parent-focus');
	         }
	      }
	      return false;
	});
	var start = new Date();
	start.setDate(start.getDate() -6);
	var end = new Date();
	$('#date-range').daterangepicker({
		startDate: $.format.date(start,'yyyy-MM-dd'),
		endDate: $.format.date(end,'yyyy-MM-dd'),
		ranges:{
			// '最近7天': [moment().subtract(7, 'days'), moment()],
			'最近一个月': [moment().subtract(1, 'month'), moment()],
			'最近一年': [moment().subtract(1, 'year').add(1,'day'), moment()]
		},
		locale : {
			format : 'YYYY-MM-DD',
			separator : ' 至 ',
			applyLabel : '确定',
			cancelLabel : '取消',
			fromLabel : '起始时间',
			toLabel : '结束时间',
			customRangeLabel : '自定义',
			daysOfWeek : [ '日', '一', '二', '三', '四', '五', '六' ],
			monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月',
				'七月', '八月', '九月', '十月', '十一月', '十二月' ],
			firstDay : 1
		}
	});
});

function getEChartConfig(title,label,categories,data,dataType){
	var yValue = '{value}';
	if(dataType != null && typeof(dataType) != 'undefined'){
		yValue = '{value} %';
	}

	var option = {
		title:{
			text:''
		},
		tooltip : {
			trigger: 'axis'
		},
		legend: {
			data:[label]
		},
		toolbox: {
			show : true,
			feature : {
				mark : {show: false},
				dataView : {show: false, readOnly: false},
				magicType : {show: false, type: ['line', 'bar']},
				restore : {show: false},
				saveAsImage : {show: true}
			}
		},
		calculable : true,
		xAxis : [
			{
				type : 'category',
				boundaryGap : false,
				data : categories
			}
		],
		yAxis : [
			{
				type : 'value',
				axisLabel : {
					formatter: yValue
				}
			}
		],
		series : [
			{
				name:'最高值',
				type:'line',
				data:data,
				markPoint : {
					data : [
						{type : 'max', name: '最大值'},
						{type : 'min', name: '最小值'}
					]
				},
				markLine : {
					data : [
						{type : 'average', name: '平均值'}
					]
				}
			}
		]
	}
	return option;
}