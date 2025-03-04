<template>
<div class="content" :style='{"minHeight":"100vh","padding":"20px 30px 20px","alignItems":"flex-start","flexWrap":"wrap","background":"url() no-repeat center top / cover","display":"block","fontSize":"14px","height":"auto"}'>
	<!-- notice -->
	<!-- title -->
	<div class="text" :style='{"margin":"0px auto 40px","color":"rgb(51, 51, 51)","textAlign":"center","display":"none","width":"100%","fontSize":"32px","fontWeight":"600"}'>欢迎使用 {{this.$project.projectName}}</div>
	<!-- statis -->
	<div :style='{"border":"0px solid #bababa","padding":"40px 0 30px","margin":"10px 0 20px","alignItems":"center","color":"#333","display":"flex","justifyContent":"center","overflow":"hidden","borderRadius":"0px","flexWrap":"wrap","background":"#f9f9f9","width":"100%","fontSize":"14px","order":"0"}'>
		<div :style='{"padding":"0","margin":"0 1% 12px 0","borderColor":"#ddd","alignItems":"center","textAlign":"center","display":"flex","float":"left","justifyContent":"space-between","borderRadius":"0px","background":"none","borderWidth":"0 1px 0 0","width":"19%","position":"relative","borderStyle":"solid"}' v-if="isAuth('yonghu','首页总数')">
			<div :style='{"alignItems":"center","borderRadius":"0","background":"none","display":"none","width":"auto","justifyContent":"center","height":"auto","order":"0"}'>
				<span class="icon iconfont icon-xiaoliang2" :style='{"color":"#5ab6df","fontSize":"32px"}'></span>
			</div>
			<div :style='{"margin":"0","alignItems":"center","textAlign":"left","flexWrap":"wrap","background":"none","display":"flex","width":"auto"}'>
				<div :style='{"padding":"0 10px","margin":"8px auto 0","color":"#666","textAlign":"center","minWidth":"80px","borderRadius":"30px","background":"none","width":"auto","lineHeight":"1","fontSize":"26px","fontWeight":"600","height":"auto","order":"2"}'>{{yonghuCount}}</div>
				<div :style='{"margin":"0","color":"#999","textAlign":"center","width":"100%","lineHeight":"24px","fontSize":"14px","height":"24px"}'>用户总数</div>
			</div>
		</div>
		<div :style='{"padding":"0","margin":"0 1% 12px 0","borderColor":"#ddd","alignItems":"center","textAlign":"center","display":"flex","float":"left","justifyContent":"space-between","borderRadius":"0px","background":"none","borderWidth":"0 1px 0 0","width":"19%","position":"relative","borderStyle":"solid"}' v-if="isAuth('changguanxinxi','首页总数')">
			<div :style='{"alignItems":"center","background":"none","display":"none","width":"auto","justifyContent":"center","height":"auto","order":"0"}'>
				<span class="icon iconfont icon-qita7" :style='{"color":"#ff6c60","fontSize":"32px"}'></span>
			</div>
			<div :style='{"width":"auto","margin":"0","textAlign":"left","flexWrap":"wrap","display":"flex"}'>
				<div :style='{"padding":"0 10px","margin":"8px auto 0","color":"#666","borderRadius":"30px","textAlign":"center","background":"none","lineHeight":"1","fontSize":"26px","minWidth":"80px","fontWeight":"600","height":"auto","order":"2"}'>{{changguanxinxiCount}}</div>
				<div :style='{"margin":"0","color":"#999","textAlign":"center","width":"100%","lineHeight":"24px","fontSize":"14px","height":"24px"}'>场馆信息总数</div>
			</div>
		</div>
		<div :style='{"padding":"0","margin":"0 1% 12px 0","borderColor":"#ddd","alignItems":"center","textAlign":"center","display":"flex","float":"left","justifyContent":"center","borderRadius":"0px","background":"none","borderWidth":"0 1px 0 0","width":"19%","position":"relative","borderStyle":"solid"}' v-if="isAuth('yuyuexinxi','首页总数')">
			<div :style='{"alignItems":"center","background":"none","display":"none","width":"auto","justifyContent":"center","height":"auto","order":"0"}'>
				<span class="icon iconfont icon-tongjitu18" :style='{"color":"#b486d8","fontSize":"32px"}'></span>
			</div>
			<div :style='{"width":"auto","margin":"0","textAlign":"left","flexWrap":"wrap","display":"flex"}'>
				<div :style='{"padding":"0 10px","margin":"8px auto 0","color":"#666","borderRadius":"30px","textAlign":"center","background":"none","lineHeight":"1","fontSize":"26px","minWidth":"80px","fontWeight":"600","height":"auto","order":"2"}'>{{yuyuexinxiCount}}</div>
				<div :style='{"margin":"0","color":"#999","textAlign":"center","width":"100%","lineHeight":"24px","fontSize":"14px","height":"24px"}'>预约信息总数</div>
			</div>
		</div>
		<div :style='{"padding":"0","margin":"0 1% 12px 0","borderColor":"#ddd","alignItems":"center","textAlign":"center","display":"flex","float":"left","justifyContent":"center","borderRadius":"0px","background":"none","borderWidth":"0 1px 0 0","width":"19%","position":"relative","borderStyle":"solid"}' v-if="isAuth('pingjiaxinxi','首页总数')">
			<div :style='{"alignItems":"center","background":"none","display":"none","width":"auto","justifyContent":"center","height":"auto","order":"0"}'>
				<span class="icon iconfont icon-shuju19" :style='{"color":"#db993c","fontSize":"32px"}'></span>
			</div>
			<div :style='{"width":"auto","margin":"0","textAlign":"left","flexWrap":"wrap","display":"flex"}'>
				<div :style='{"padding":"0 10px","margin":"8px auto 0","color":"#666","borderRadius":"30px","textAlign":"center","background":"none","lineHeight":"1","fontSize":"26px","minWidth":"80px","fontWeight":"600","height":"auto","order":"2"}'>{{pingjiaxinxiCount}}</div>
				<div :style='{"margin":"0","color":"#999","textAlign":"center","width":"100%","lineHeight":"24px","fontSize":"14px","height":"24px"}'>评价信息总数</div>
			</div>
		</div>
	</div>
	<!-- statis -->
	

	
	<!-- echarts -->
	<!-- 4 -->
	<div class="type4" :style='{"alignContent":"flex-start","padding":"0","borderRadius":"8px","flexWrap":"wrap","background":"none","display":"flex","width":"100%","position":"relative","justifyContent":"space-between","height":"auto","order":"10"}'>
		<div id="yonghuChart1" class="echarts1" v-if="isAuth('yonghu','首页统计')"></div>
		<div id="changguanxinxiChart1" class="echarts2" v-if="isAuth('changguanxinxi','首页统计')"></div>
		<div id="yuyuexinxiChart1" class="echarts3" v-if="isAuth('yuyuexinxi','首页统计')"></div>
		<div id="pingjiaxinxiChart1" class="echarts4" v-if="isAuth('pingjiaxinxi','首页统计')"></div>
	</div>
</div>
</template>
<script>
//4
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
            yonghuCount: 0,
            changguanxinxiCount: 0,
            yuyuexinxiCount: 0,
            pingjiaxinxiCount: 0,
			line: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"#333","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"showSymbol":true,"symbol":"emptyCircle","symbolSize":4},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"}},
			bar: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":12,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#666","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(25,25,25,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#00ff00","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"#333","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"barWidth":"auto","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#666","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"colorBy":"data","barCategoryGap":"20%"},"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"},"base":{"animate":false,"interval":2000}},
			pie: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"borderType":"solid","padding":0,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":600,"textBorderColor":"#666","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#666","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":0,"top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"80%","itemWidth":20,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#666","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#666","color":"#333","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#666","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false}}},
			funnel: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"center","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#666","textShadowColor":"transparent","fontSize":14,"lineHeight":12,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":0,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"vertical","shadowBlur":0,"bottom":"auto","itemHeight":2,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"left","borderWidth":0,"width":"auto","itemWidth":2,"textStyle":{"textBorderWidth":0,"color":"inherit","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":20,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#000","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false}}},
			boardBase: {"funnelNum":8,"lineNum":8,"gaugeNum":8,"barNum":8,"pieNum":8},
			gauge: {"tooltip":{"backgroundColor":"#123","textStyle":{"color":"#fff"}},"backgroundColor":"transparent","color":["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"top":"top","left":"left","textStyle":{"fontSize":14,"lineHeight":24,"color":"#666","fontWeight":600}},"series":{"pointer":{"offsetCenter":[0,"10%"],"icon":"path://M2.9,0.7L2.9,0.7c1.4,0,2.6,1.2,2.6,2.6v115c0,1.4-1.2,2.6-2.6,2.6l0,0c-1.4,0-2.6-1.2-2.6-2.6V3.3C0.3,1.9,1.4,0.7,2.9,0.7z","width":8,"length":"80%"},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"opacity":0.5,"shadowBlur":1,"shadowColor":"#000"},"roundCap":true},"anchor":{"show":true,"itemStyle":{"color":"inherit"},"size":18,"showAbove":true},"emphasis":{"disabled":false},"progress":{"show":true,"roundCap":true,"overlap":true},"splitNumber":25,"detail":{"formatter":"{value}","backgroundColor":"inherit","color":"#fff","borderRadius":3,"width":20,"fontSize":12,"height":12},"title":{"fontSize":12},"animation":true}},
		};
	},
	mounted(){
		this.init();
		this.getyonghuCount();
		this.yonghuChat1();
		this.getchangguanxinxiCount();
		this.changguanxinxiChat1();
		this.getyuyuexinxiCount();
		this.yuyuexinxiChat1();
		this.getpingjiaxinxiCount();
		this.pingjiaxinxiChat1();
	},
	methods:{
		// 统计图动画
		myChartInterval(type, xAxisData, seriesData, myChart) {
			this.$nextTick(() => {
				setInterval(() => {
					let xAxis = xAxisData.shift()
					xAxisData.push(xAxis)
					let series = seriesData.shift()
					seriesData.push(series)
				
					if (type == 1) {
						myChart.setOption({
							xAxis: [{
								data: xAxisData
							}],
							series: [{
								data: seriesData
							}]
						});
					}
					if (type == 2) {
						myChart.setOption({
							yAxis: [{
								data: xAxisData
							}],
							series: [{
								data: seriesData
							}]
						});
					}
				}, 2000);
			})
		},
		init(){
			if(this.$storage.get('Token')){
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code != 0) {
				router.push({ name: 'login' })
				}
			});
			}else{
				router.push({ name: 'login' })
			}
		},
		getyonghuCount() {
			this.$http({
				url: `yonghu/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.yonghuCount = data.data
				}
			})
		},
// 1234 竖
		yonghuChat1() {
			this.$nextTick(()=>{

        var yonghuChart1 = echarts.init(document.getElementById("yonghuChart1"),'macarons');
        this.$http({
            url: `yonghu/value/xingming/xinyufen`,
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
					if(this.boardBase&&i==this.boardBase.barNum){
						break;
					}
                    xAxis.push(res[i].xingming);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].xingming
                    })
                }
                var option = {};
				let titleObj = this.bar.title
				titleObj.text = '信誉分统计'
				
				const legendObj = this.bar.legend
				let tooltipObj = {trigger: 'item',formatter: '{b} : {c}'}
				tooltipObj = Object.assign(tooltipObj , this.bar.tooltip?this.bar.tooltip:{})
				
				let xAxisObj = this.bar.xAxis
				xAxisObj.type = 'category'
				xAxisObj.data = xAxis
				
				let yAxisObj = this.bar.yAxis
				yAxisObj.type = 'value'
				let seriesObj = {
					data: yAxis,
					type: 'bar'
				}
				seriesObj = Object.assign(seriesObj , this.bar.series)
				const gridObj = this.bar.grid
				
                option = {
                    backgroundColor: this.bar.backgroundColor,
                    color: this.bar.color,
                    title: titleObj,
                    legend: legendObj,
					grid: gridObj,
                    tooltip: tooltipObj,
                    xAxis: xAxisObj,
                    yAxis: yAxisObj,
                    series: [seriesObj]
                };
                // 使用刚指定的配置项和数据显示图表。
                yonghuChart1.setOption(option);
				
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    yonghuChart1.resize();
                };
            }
        });
      })
    },


		getchangguanxinxiCount() {
			this.$http({
				url: `changguanxinxi/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.changguanxinxiCount = data.data
				}
			})
		},
// 1234 饼2
		changguanxinxiChat1() {
			this.$nextTick(()=>{

        var changguanxinxiChart1 = echarts.init(document.getElementById("changguanxinxiChart1"),'macarons');
        this.$http({
            url: "changguanxinxi/group/zhuangtai",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
					if(this.boardBase&&i==this.boardBase.pieNum){
						break;
					}
                    xAxis.push(res[i].zhuangtai);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].zhuangtai
                    })
                }
                var option = {};
				let titleObj = this.pie.title
				titleObj.text = '状态统计'
				
				const legendObj = this.pie.legend
				let tooltipObj = {trigger: 'item',formatter: '{b} : {c} ({d}%)'}
				tooltipObj = Object.assign(tooltipObj , this.pie.tooltip?this.pie.tooltip:{})
				
				let seriesObj = {
					type: 'pie',
					radius: ['25%', '55%'],
					center: ['50%', '60%'],
					data: pArray,
					emphasis: {
						itemStyle: {
							shadowBlur: 10,
							shadowOffsetX: 0,
							shadowColor: 'rgba(0, 0, 0, 0.5)'
						}
					}
				}
				seriesObj = Object.assign(seriesObj , this.pie.series)
				const gridObj = this.pie.grid
                option = {
                	backgroundColor: this.pie.backgroundColor,
                	color: this.pie.color,
                	title: titleObj,
                	legend: legendObj,
					grid: gridObj,
                	tooltip: tooltipObj,
                	series: [seriesObj]
                };
                // 使用刚指定的配置项和数据显示图表。
                changguanxinxiChart1.setOption(option);
				
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    changguanxinxiChart1.resize();
                };
            }
        });
      })
    },


		getyuyuexinxiCount() {
			this.$http({
				url: `yuyuexinxi/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.yuyuexinxiCount = data.data
				}
			})
		},
// 1234 折滑
		yuyuexinxiChat1() {
			this.$nextTick(()=>{

        var yuyuexinxiChart1 = echarts.init(document.getElementById("yuyuexinxiChart1"),'macarons');
        this.$http({
            url: "yuyuexinxi/group/shenqingriqi",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
					if(this.boardBase&&i==this.boardBase.lineNum){
						break;
					}
                    xAxis.push(res[i].shenqingriqi);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].shenqingriqi
                    })
                }
                var option = {};
				let titleObj = this.line.title
				titleObj.text = '每日预约人数统计'
				
				const legendObj = this.line.legend
				let tooltipObj = { trigger: 'item',formatter: '{b} : {c}'}
				tooltipObj = Object.assign(tooltipObj , this.line.tooltip?this.line.tooltip:{})
				let xAxisObj = this.line.xAxis
				xAxisObj.type = 'category'
				xAxisObj.boundaryGap = false
				xAxisObj.data = xAxis
				
				let yAxisObj = this.line.yAxis
				yAxisObj.type = 'value'
				const gridObj = this.line.grid
				
				let seriesObj = {
					data: yAxis,
					type: 'line',
					smooth: true
				}
				seriesObj = Object.assign(seriesObj , this.line.series)
                option = {
					backgroundColor: this.line.backgroundColor,
					color: this.line.color,
                    title: titleObj,
					legend: legendObj,
					grid: gridObj,
                    tooltip: tooltipObj,
                    xAxis: xAxisObj,
                    yAxis: yAxisObj,
                    series: [seriesObj]
                };
                // 使用刚指定的配置项和数据显示图表。
                yuyuexinxiChart1.setOption(option);
				
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    yuyuexinxiChart1.resize();
                };
            }
        });
      })
    },


		getpingjiaxinxiCount() {
			this.$http({
				url: `pingjiaxinxi/count`,
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code == 0) {
					this.pingjiaxinxiCount = data.data
				}
			})
		},
// 1234 饼
		pingjiaxinxiChat1() {
			this.$nextTick(()=>{

        var pingjiaxinxiChart1 = echarts.init(document.getElementById("pingjiaxinxiChart1"),'macarons');
        this.$http({
            url: "pingjiaxinxi/group/manyidu",
            method: "get",
        }).then(({ data }) => {
            if (data && data.code === 0) {
                let res = data.data;
                let xAxis = [];
                let yAxis = [];
                let pArray = []
                for(let i=0;i<res.length;i++){
					if(this.boardBase&&i==this.boardBase.pieNum){
						break;
					}
                    xAxis.push(res[i].manyidu);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].manyidu
                    })
                }
                var option = {};
				let titleObj = this.pie.title
				titleObj.text = '满意度统计'
				
				const legendObj = this.pie.legend
				let tooltipObj = {trigger: 'item',formatter: '{b} : {c} ({d}%)'}
				tooltipObj = Object.assign(tooltipObj , this.pie.tooltip?this.pie.tooltip:{})
				
				let seriesObj = {
					type: 'pie',
					radius: '55%',
					center: ['50%', '60%'],
					data: pArray,
					emphasis: {
						itemStyle: {
							shadowBlur: 10,
							shadowOffsetX: 0,
							shadowColor: 'rgba(0, 0, 0, 0.5)'
						}
					}
				}
				seriesObj = Object.assign(seriesObj , this.pie.series)
				const gridObj = this.pie.grid
                option = {
                	backgroundColor: this.pie.backgroundColor,
                	color: this.pie.color,
                	title: titleObj,
                	legend: legendObj,
					grid: gridObj,
                	tooltip: tooltipObj,
                	series: [seriesObj]
                };
                // 使用刚指定的配置项和数据显示图表。
                pingjiaxinxiChart1.setOption(option);
				
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    pingjiaxinxiChart1.resize();
                };
            }
        });
      })
    },


  }
};
</script>
<style lang="scss" scoped>
    .cardView {
        display: flex;
        flex-wrap: wrap;
        width: 100%;

        .cards {
            display: flex;
            align-items: center;
            width: 100%;
            margin-bottom: 10px;
            justify-content: center;
            .card {
                width: calc(25% - 20px);
                margin: 0 10px;
                /deep/.el-card__body{
                    padding: 0;
                }
            }
        }
    }
	
	// 日历
	.calendar td .text {
				border: 1px solid #f6f6f6;
				border-radius: 0px;
				flex-direction: column;
				color: #888;
				background: none;
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				height: 100%;
			}
	.calendar td .text:hover {
				background: none;
			}
	.calendar td .text .new {
				color: inherit;
				font-size: inherit;
				line-height: 1.4;
			}
	.calendar td .text .old {
				color: inherit;
				font-size: inherit;
				line-height: 1.4;
			}
	.calendar td.festival .text {
				border: 0px solid rgba(93, 213, 200, .1);
				border-radius: 0px;
				flex-direction: column;
				color: #666;
				background: #ff5f5f10;
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				height: 100%;
			}
	.calendar td.festival .text:hover {
				background: #ff5f5f10;
			}
	.calendar td.festival .text .new {
				color: inherit;
				font-size: inherit;
				line-height: 1.4;
			}
	.calendar td.festival .text .old {
				color: inherit;
				font-size: inherit;
				line-height: 1.4;
			}
	.calendar td.other .text {
				border-radius: 20px;
				flex-direction: column;
				background: none;
				display: flex;
				width: 100%;
				font-size: inherit;
				justify-content: center;
				align-items: center;
				opacity: 0.6;
				height: 100%;
			}
	.calendar td.other .text:hover {
				background: none;
			}
	.calendar td.other .text .new {
				color: #000;
				font-size: inherit;
				line-height: 1.4;
			}
	.calendar td.other .text .old {
				color: #666;
				font-size: inherit;
				line-height: 1.4;
			}
	.calendar td.today .text {
				border-radius: 2px;
				flex-direction: column;
				color: #fff;
				background: #ff5f5f80;
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				height: 100%;
			}
	.calendar td.today .text:hover {
				background: #ff5f5f80;
			}
	.calendar td.today .text .new {
				font-size: inherit;
				line-height: 1.4;
			}
	.calendar td.today .text .old {
				font-size: inherit;
				line-height: 1.4;
			}
	
	// echarts1
	.type1 .echarts1 {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 10px;
				margin: 0 0 30px;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 360px;
			}
	.type1 .echarts1:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
			}
	// echarts2
	.type2 .echarts1 {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 10px;
				margin: 0 0 30px;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 360px;
			}
	.type2 .echarts1:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
			}
	.type2 .echarts2 {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 10px;
				margin: 0 0 30px;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 360px;
			}
	.type2 .echarts2:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
			}
	// echarts3
	.type3 .echarts1 {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 10px;
				margin: 0 0 30px;
				color: #333;
				background: rgba(255,255,255,.96);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 360px;
			}
	.type3 .echarts1:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
			}
	.type3 .echarts2 {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 10px;
				margin: 0 0 30px;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 360px;
			}
	.type3 .echarts2:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
			}
	.type3 .echarts3 {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 10px;
				margin: 0 0 30px;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 360px;
			}
	.type3 .echarts3:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
			}
	// echarts4
	.type4 .echarts1 {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 10px;
				margin: 0px 0 30px;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 360px;
			}
	.type4 .echarts1:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
			}
	.type4 .echarts2 {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 10px;
				margin: 0px 0 30px;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 360px;
			}
	.type4 .echarts2:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
			}
	.type4 .echarts3 {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 10px;
				margin: 0px 0 30px;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 360px;
			}
	.type4 .echarts3:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
			}
	.type4 .echarts4 {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 10px;
				margin: 0px 0 30px;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 360px;
			}
	.type4 .echarts4:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
			}
	// echarts5
	.type5 .echarts1 {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 10px;
				margin: 0px 0 30px;
				background: rgba(255,255,255,.96);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 360px;
			}
	.type5 .echarts1:hover {
				box-shadow: 0 1px 10px 1px rgba(115,108,203,.1);
				transform: translate3d(0, 0px, 0);
				z-index: 1;
			}
	.type5 .echarts2 {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 10px;
				margin: 0px 0 30px;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 360px;
			}
	.type5 .echarts2:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
			}
	.type5 .echarts3 {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 10px;
				margin: 0px 0 30px;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 360px;
			}
	.type5 .echarts3:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
			}
	.type5 .echarts4 {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 10px;
				margin: 0px 0 30px;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 360px;
			}
	.type5 .echarts4:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
			}
	.type5 .echarts5 {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 10px;
				margin: 0px 0 30px;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 360px;
			}
	.type5 .echarts5:hover {
				transform: translate3d(0, 0px, 0);
				z-index: 1;
			}
	
	.echarts-flag-2 {
	  display: flex;
	  flex-wrap: wrap;
	  justify-content: space-between;
	  padding: 10px 20px;
	  background: rebeccapurple;
	
	  &>div {
	    width: 32%;
	    height: 300px;
	    margin: 10px 0;
	    background: rgba(255,255,255,.1);
	    border-radius: 8px;
	    padding: 10px 20px;
	  }
	}
</style>
