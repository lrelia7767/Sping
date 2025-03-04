<template>
	<div class="main-content" :style='{"minHeight":"100vh","padding":"0px 0px 20px","overflow":"hidden","color":"#666","background":"#fff","fontSize":"14px","position":"relative"}'>
		<!-- 列表页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"border":"0px solid #bababa","padding":"20px 0px 20px 20px","margin":"20px 0 0","overflow":"hidden","borderRadius":"0px","alignItems":"center","flexWrap":"wrap","background":"none","display":"flex","width":"auto","fontSize":"inherit","justifyContent":"space-between"}' :inline="true" :model="searchForm">
				<el-row :style='{"padding":"0 20px","borderColor":"#2a8ba7","color":"#c2c2c2","textAlign":"center","flexDirection":"row","display":"flex","borderRadius":"0px","flexWrap":"wrap","background":"none","borderWidth":"0px 0 0","width":"auto","fontSize":"inherit","borderStyle":"solid","order":"2"}' >
					<div :style='{"margin":"0 10px 10px 0","fontSize":"inherit","flexWrap":"wrap","display":"flex"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#797979","display":"inline-block","lineHeight":"32px","fontSize":"inherit","fontWeight":"500","height":"32px"}' class="item-label">账号</label>
						<el-input v-model="searchForm.zhanghao" placeholder="账号" @keydown.enter.native="search()" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 10px 0","fontSize":"inherit","flexWrap":"wrap","display":"flex"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#797979","display":"inline-block","lineHeight":"32px","fontSize":"inherit","fontWeight":"500","height":"32px"}' class="item-label">姓名</label>
						<el-input v-model="searchForm.xingming" placeholder="姓名" @keydown.enter.native="search()" clearable></el-input>
					</div>
					<el-button class="search" type="success" @click="search()">
						<span class="icon iconfont icon-chakan12" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
						搜索
					</el-button>
				</el-row>

				<el-row class="actions" :style='{"padding":"0 20px","margin":"0px 0 0","borderColor":"#ddd","color":"#fff","textAlign":"left","flexDirection":"row","display":"block","borderRadius":"0px","flexWrap":"wrap","background":"none","borderWidth":"0px 0 0","width":"auto","fontSize":"inherit","borderStyle":"solid"}'>
					<el-button class="add" v-if="isAuth('yonghu','新增')" type="success" @click="addOrUpdateHandler()">
						<span class="icon iconfont icon-tianjia13" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none"}'></span>
						新增
					</el-button>
					<el-button class="del" v-if="isAuth('yonghu','删除')" :disabled="dataListSelections.length?false:true" type="danger" @click="deleteHandler()">
						<span class="icon iconfont icon-shanchu7" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
						删除
					</el-button>



					<el-button class="btn18" v-if="isAuth('yonghu','信誉分统计')" type="success" @click="chartDialog1()">
						<span class="icon iconfont icon-a-fenxiang2" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none"}'></span>
						信誉分统计
					</el-button>
				</el-row>
			</el-form>
			<div :style='{"border":"0px solid #e1e8ee","padding":"0 0px 0 20px","margin":"0px auto","borderColor":"#ddd","borderRadius":"0px","background":"rgba(255,255,255,0)","borderWidth":"0px 0 0","width":"calc(100% - 20px)","borderStyle":"solid"}'>
				<el-table class="tables"
					:stripe='false'
					:style='{"padding":"0","borderColor":"#ddd","color":"inherit","borderRadius":"0px","borderWidth":"0px 0px 0 1px","background":"none","width":"100%","fontSize":"inherit","borderStyle":"solid"}' 
					:border='true'
					v-if="isAuth('yonghu','查看')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='true' label="序号" type="index" width="50" />
					<el-table-column :resizable='true' :sortable='true'  
						prop="zhanghao"
						label="账号">
						<template slot-scope="scope">
							{{scope.row.zhanghao}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="xingming"
						label="姓名">
						<template slot-scope="scope">
							{{scope.row.xingming}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="xingbie"
						label="性别">
						<template slot-scope="scope">
							{{scope.row.xingbie}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="youxiang"
						label="邮箱">
						<template slot-scope="scope">
							{{scope.row.youxiang}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="shoujihaoma"
						label="手机号码">
						<template slot-scope="scope">
							{{scope.row.shoujihaoma}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="xinyufen"
						label="信誉分">
						<template slot-scope="scope">
							{{scope.row.xinyufen}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="touxiang" width="200" label="头像">
						<template slot-scope="scope">
							<div v-if="scope.row.touxiang">
								<img v-if="scope.row.touxiang.substring(0,4)=='http'" :src="scope.row.touxiang.split(',')[0]" width="100" height="100" style="object-fit: cover" @click="imgPreView(scope.row.touxiang.split(',')[0])">
								<img v-else :src="$base.url+scope.row.touxiang.split(',')[0]" width="100" height="100" style="object-fit: cover" @click="imgPreView($base.url+scope.row.touxiang.split(',')[0])">
							</div>
							<div v-else>无图片</div>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="content" label="状态">
						<template slot-scope="scope">
                            <el-switch
								v-model="scope.row.status"
								:width="60"
								active-icon-class="el-icon-edit"
								inactive-icon-class="el-icon-share"
								active-text="开"
								inactive-text="关"
								:active-value="1"
								:inactive-value="0"
								active-color="#4dbce5"
								inactive-color="#ddd"
								@change="(e)=>yonghustatusChange(e,scope.row)">
                            </el-switch>
						</template>
					</el-table-column>
					<el-table-column width="300" label="操作">
						<template slot-scope="scope">
							<el-button class="view" v-if=" isAuth('yonghu','查看')" type="success" @click="addOrUpdateHandler(scope.row.id,'info')">
								<span class="icon iconfont icon-chakan14" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
								查看
							</el-button>
							<el-button class="btn8" v-if="isAuth('yonghu','信誉评价')" @click="xinyupingjiaCrossAddOrUpdateHandler(scope.row,'cross','','','','')" type="success">
								<span class="icon iconfont icon-xihuan" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
								信誉评价
							</el-button>
							<el-button class="edit" v-if=" isAuth('yonghu','修改') " type="success" @click="addOrUpdateHandler(scope.row.id)">
								<span class="icon iconfont icon-xiugai10" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
								修改
							</el-button>




							<el-button class="del" v-if="isAuth('yonghu','删除') " type="primary" @click="deleteHandler(scope.row.id )">
								<span class="icon iconfont icon-guanbi1" :style='{"margin":"0 2px","fontSize":"inherit","color":"inherit","display":"none","height":"40px"}'></span>
								删除
							</el-button>
						</template>
					</el-table-column>
				</el-table>
			</div>
			<el-pagination
				@size-change="sizeChangeHandle"
				@current-change="currentChangeHandle"
				:current-page="pageIndex"
				background
				:page-sizes="[10, 50, 100, 200]"
				:page-size="pageSize"
				:layout="layouts.join()"
				:total="totalPage"
				prev-text="上一页 "
				next-text="下一页 "
				:hide-on-single-page="false"
				:style='{"padding":"8px 20px 4px","margin":"20px auto","borderColor":"#ddd","whiteSpace":"nowrap","color":"inherit","textAlign":"left","clear":"both","borderRadius":"0px","background":"#fff","borderWidth":"0px 0 0","width":"calc(100% - 40px)","fontSize":"inherit","borderStyle":"solid","fontWeight":"500"}'
			></el-pagination>
		</template>
		
		<!-- 添加/修改页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>

		<xinyupingjia-cross-add-or-update v-if="xinyupingjiaCrossAddOrUpdateFlag" :parent="this" ref="xinyupingjiaCrossaddOrUpdate"></xinyupingjia-cross-add-or-update>



		<el-dialog
		  :visible.sync="chartVisiable1"
		  width="800">
			<div id="xinyufenChart1" style="width:100%;height:600px;"></div>
		  <span slot="footer" class="dialog-footer">
			<el-button @click="chartDialog1">返回</el-button>
		  </span>
		</el-dialog>

		<el-dialog title="预览图" :visible.sync="previewVisible" width="50%">
			<img :src="previewImg" alt="" style="width: 100%;">
		</el-dialog>
	</div>
</template>

<script>
import * as echarts from 'echarts'
import chinaJson from "@/components/echarts/china.json";
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
import xinyupingjiaCrossAddOrUpdate from "../xinyupingjia/add-or-update";
	export default {
		data() {
			return {
				searchForm: {
					key: ""
				},
				form:{},
				dataList: [],
				pageIndex: 1,
				pageSize: 10,
				totalPage: 0,
				dataListLoading: false,
				dataListSelections: [],
				showFlag: true,
				chartVisiable1: false,
				addOrUpdateFlag:false,
				xinyupingjiaCrossAddOrUpdateFlag: false,
				layouts: ["pager","jumper"],
				previewImg: '',
				previewVisible: false,
			};
		},
		created() {
			this.init();
			this.getDataList();
			this.contentStyleChange()
		},
		mounted() {
		},
		filters: {
			htmlfilter: function (val) {
				return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
			}
		},
		computed: {
			tablename(){
				return this.$storage.get('sessionTable')
			},
		},
		components: {
			AddOrUpdate,
			xinyupingjiaCrossAddOrUpdate,
		},
		methods: {
			imgPreView(url){
				this.previewImg = url
				this.previewVisible = true
			},
			contentStyleChange() {
				this.contentPageStyleChange()
			},
			// 分页
			contentPageStyleChange(){
				let arr = []

				// if(this.contents.pageTotal) arr.push('total')
				// if(this.contents.pageSizes) arr.push('sizes')
				// if(this.contents.pagePrevNext){
				//   arr.push('prev')
				//   if(this.contents.pagePager) arr.push('pager')
				//   arr.push('next')
				// }
				// if(this.contents.pageJumper) arr.push('jumper')
				// this.layouts = arr.join()
				// this.contents.pageEachNum = 10
			},
			xinyupingjiaCrossAddOrUpdateHandler(row,type,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue){
				this.showFlag = false;
				this.addOrUpdateFlag = false;
				this.xinyupingjiaCrossAddOrUpdateFlag = true;
				this.$storage.set('crossObj',row);
				this.$storage.set('crossTable','yonghu');
				this.$storage.set('statusColumnName',statusColumnName);
				this.$storage.set('statusColumnValue',statusColumnValue);
				this.$storage.set('tips',tips);
				if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o==statusColumnName && obj[o]==statusColumnValue){
							this.$message({
								message: tips,
								type: "success",
								duration: 1500,
								onClose: () => {
									this.getDataList();
								}
							});
							this.showFlag = true;
							this.xinyupingjiaCrossAddOrUpdateFlag = false;
							return;
						}
					}
				}
				this.$nextTick(() => {
					this.$refs.xinyupingjiaCrossaddOrUpdate.init(row.id,type);
				});
			},


//统计接口
    chartDialog1() {
      this.chartVisiable1 = !this.chartVisiable1;
      this.$nextTick(()=>{
        var xinyufenChart1 = echarts.init(document.getElementById("xinyufenChart1"),'macarons');
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
                    xAxis.push(res[i].xingming);
                    yAxis.push(parseFloat((res[i].total)));
                    pArray.push({
                        value: parseFloat((res[i].total)),
                        name: res[i].xingming
                    })
                }
                var option = {};
                option = {
                    title: {
                        text: '信誉分统计',
                        left: 'center'
                    },
                    tooltip: {
                      trigger: 'item',
                      formatter: '{b} : {c}'
                    },
                    xAxis: {
                        type: 'category',
                        data: xAxis,
                        axisLabel : {
                            rotate:40
                        }
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yAxis,
                        type: 'bar'
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                xinyufenChart1.setOption(option);
                  //根据窗口的大小变动图表
                window.onresize = function() {
                    xinyufenChart1.resize();
                };
            }
        });
      })
    },




    init () {
    },
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据列表
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
           if(this.searchForm.zhanghao!='' && this.searchForm.zhanghao!=undefined){
            params['zhanghao'] = '%' + this.searchForm.zhanghao + '%'
          }
           if(this.searchForm.xingming!='' && this.searchForm.xingming!=undefined){
            params['xingming'] = '%' + this.searchForm.xingming + '%'
          }
			let user = JSON.parse(this.$storage.getObj('userForm'))
			console.log(user)
			this.$http({
				url: "yonghu/page",
				method: "get",
				params: params
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.dataList = data.data.list;
					this.totalPage = data.data.total;
				} else {
					this.dataList = [];
					this.totalPage = 0;
				}
				this.dataListLoading = false;
			});
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // 添加/修改
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
	yonghustatusChange(e,row){
		if(row.status==0){
			row.passwordwrongnum = 0
		}
		this.$http({
			url:'yonghu/update',
			method:'post',
			data:row
		}).then(res=>{
			if(row.status==1){
				this.$message.error('该用户已锁定')
			}else{
				this.$message.success('该用户已解除锁定')
			}
		})
	},
    // 删除
    async deleteHandler(id ) {
		var ids = id? [Number(id)]: this.dataListSelections.map(item => {
			return Number(item.id);
		});
		await this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
			confirmButtonText: "确定",
			cancelButtonText: "取消",
			type: "warning"
		}).then(async () => {
			await this.$http({
				url: "yonghu/delete",
				method: "post",
				data: ids
			}).then(async ({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.search();
						}
					});
            
				} else {
					this.$message.error(data.msg);
				}
			});
		});
    },


  }

};
</script>
<style lang="scss" scoped>
	
	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}
	
	.el-input {
	  width: auto;
	}
	
	// form
	.center-form-pv .el-input /deep/ .el-input__inner {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 0 12px;
				outline: none;
				color: inherit;
				background: #fff;
				width: 150px;
				font-size: inherit;
				height: 36px;
			}
	
	.center-form-pv .el-select /deep/ .el-input__inner {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 0 10px;
				outline: none;
				color: inherit;
				background: #fff;
				width: 150px;
				font-size: inherit;
				height: 36px;
			}
	
	.center-form-pv .el-date-editor /deep/ .el-input__inner {
				border: 1px solid #ddd;
				border-radius: 0px;
				padding: 0 10px 0 30px;
				outline: none;
				color: inherit;
				background: #fff;
				width: 150px;
				font-size: inherit;
				height: 36px;
			}
	
	.center-form-pv .search {
				cursor: pointer;
				padding: 0 20px;
				margin: 0 10px;
				color: #333;
				font-size: 14px;
				border-color: #ddd;
				transition: all 0.3s;
				border-radius: 0px;
				box-shadow: 0 0px #61a642;
				outline: none;
				background: #f4f4f4;
				width: auto;
				border-width: 1px;
				border-style: solid;
				min-width: 80px;
				height: 36px;
			}
	
	.center-form-pv .search:hover {
			}
	
	.center-form-pv .actions .add {
				border: 0px solid #03a9f4;
				cursor: pointer;
				border-radius: 20px;
				padding: 0px 20px;
				box-shadow: 0 2px #1caadc;
				margin: 0 8px 10px 0;
				color: #fff;
				background: #58c9f3;
				width: auto;
				font-size: inherit;
				height: 32px;
			}
	
	.center-form-pv .actions .add:hover {
				color: #fff;
				background: #4dbce5;
			}
	
	.center-form-pv .actions .del {
				border: 0px solid #ed5564;
				cursor: pointer;
				border-radius: 20px;
				padding: 0 20px;
				box-shadow: 0 2px #d1595a;
				margin: 0 8px 10px 0;
				color: #fff;
				background: #ff6c60;
				width: auto;
				font-size: inherit;
				height: 32px;
			}
	
	.center-form-pv .actions .del:hover {
				color: #fff;
				background: #ef665b;
			}
	
	.center-form-pv .actions .statis {
				border: 0px solid #7dc855;
				cursor: pointer;
				border-radius: 20px;
				padding: 0 10px;
				box-shadow: 0 2px #61a642;
				margin: 0 8px 10px 0;
				color: #fff;
				background: #78CD51;
				width: auto;
				font-size: inherit;
				min-width: 66px;
				height: 32px;
			}
	
	.center-form-pv .actions .statis:hover {
				background: #70be4d;
			}
	
	.center-form-pv .actions .btn18 {
				border: 1px solid #cecece;
				cursor: pointer;
				border-radius: 20px;
				padding: 0 10px;
				box-shadow: 0 2px #9c9c9c;
				margin: 0 8px 10px 0;
				color: #ACA9A9;
				background: #fff;
				width: auto;
				font-size: inherit;
				min-width: 66px;
				height: 32px;
			}
	
	.center-form-pv .actions .btn18:hover {
				background: #ececec;
			}
	
	// table
	.el-table /deep/ .el-table__header-wrapper thead {
				color: inherit;
				background: #ff6565;
				width: 100%;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: none;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 12px 0;
				color: #fff;
				background: none;
				border-color: #ddd;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: 600;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}

	
	.el-table /deep/ .el-table__body-wrapper tbody {
				padding: 0;
				width: 100%;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
				background: none;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 5px 0 0;
				color: inherit;
				background: none;
				font-size: inherit;
				border-color: #ddd;
				border-width: 0 1px 1px 0px;
				border-style: solid;
				text-align: left;
			}
	
		
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 5px 0 0;
				color: inherit;
				background: #ff656510;
				border-color: #ddd;
				border-width: 0 1px 1px 0px;
				border-style: solid;
				text-align: left;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 5px 0 0;
				color: inherit;
				background: none;
				font-size: inherit;
				border-color: #ddd;
				border-width: 0 1px 1px 0px;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				color: inherit;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .view {
				border: 1px solid #ddd;
				cursor: pointer;
				padding: 0 16px;
				margin: 0 5px 5px 0;
				color: #666;
				font-size: 12px;
				border-radius: 0px;
				box-shadow: 0 0px #1caadc;
				outline: none;
				background: #fff;
				width: auto;
				min-width: 40px;
				height: 26px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .view:hover {
				border: 1px solid #ff5f5f50;
				color: #ff5f5f;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .add {
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .add:hover {
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .edit {
				border: 1px solid #ddd;
				cursor: pointer;
				padding: 0 16px;
				margin: 0 5px 5px 0;
				color: #666;
				font-size: 12px;
				border-radius: 0px;
				box-shadow: 0 0px #61a642;
				outline: none;
				background: #fff;
				width: auto;
				min-width: 40px;
				height: 26px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .edit:hover {
				border: 1px solid #ff5f5f50;
				color: #ff5f5f;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .del {
				border: 1px solid #ddd;
				cursor: pointer;
				border-radius: 0px;
				padding: 0 16px;
				box-shadow: 0 0px #d1595a;
				margin: 0 5px 5px 0;
				outline: none;
				color: #666;
				background: #fff;
				width: auto;
				font-size: 12px;
				height: 26px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .del:hover {
				border: 1px solid #ff5f5f50;
				color: #ff5f5f;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .btn8 {
				border: 1px solid #ddd;
				cursor: pointer;
				border-radius: 0px;
				padding: 0 10px;
				box-shadow: 0 0px #9c9c9c;
				margin: 0 5px 5px 0;
				color: #666;
				background: #fff;
				width: auto;
				font-size: 12px;
				min-width: 54px;
				height: 26px;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td .btn8:hover {
				border: 1px solid #ff5f5f50;
				color: #ff5f5f;
			}
	
	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: inherit;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev {
				border: none;
				border-radius: 2px;
				padding: 0 5px;
				margin: 0 5px;
				color: inherit;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next {
				border: none;
				border-radius: 2px;
				padding: 0 5px;
				margin: 0 5px;
				color: inherit;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0 5px;
				margin: 0 5px;
				color: #999;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 2px;
				padding: 0 5px;
				margin: 0 5px;
				color: #999;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
			}

	.main-content .el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				border: 1px solid #eee;
				padding: 0 4px;
				margin: 0 5px;
				color: inherit;
				background: none;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				text-align: center;
				height: 24px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				background: #ec6459;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				text-align: center;
				height: 24px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				padding: 0 4px;
				margin: 0 5px;
				color: #fff;
				background: #ec6459;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 24px;
				text-align: center;
				height: 24px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes {
				color: inherit;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				color: inherit;
				width: 100px;
				font-size: inherit;
				position: relative;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 0px solid #ddd;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: inherit;
				display: inline-block;
				font-size: inherit;
				line-height: 28px;
				border-radius: 3px;
				outline: 0;
				background: none;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: inherit;
				display: inline-block;
				vertical-align: top;
				font-size: inherit;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				color: inherit;
				display: inline-block;
				width: 50px;
				font-size: inherit;
				line-height: 18px;
				position: relative;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #eee;
				cursor: pointer;
				padding: 0 0px;
				color: inherit;
				display: inline-block;
				font-size: inherit;
				line-height: 24px;
				border-radius: 3px;
				outline: 0;
				background: none;
				width: auto;
				text-align: center;
				height: 24px;
			}
	
	// list one
	.one .list1-view {
				border: 1px solid #ddd;
				cursor: pointer;
				border-radius: 0px;
				padding: 0 10px;
				box-shadow: 0 0px #1caadc;
				margin: 0px 5px 5px 0;
				outline: none;
				color: #666;
				background: #fff;
				width: auto;
				font-size: inherit;
				height: 26px;
			}
	
	.one .list1-view:hover {
				border: 1px solid #ff5f5f50;
				transform: scale(1);
				color: #ff5f5f;
				opacity: 0.8;
			}
	
	.one .list1-edit {
				border: 1px solid #ddd;
				cursor: pointer;
				border-radius: 0px;
				padding: 0 10px;
				box-shadow: 0 0px #61a642;
				margin: 0px 5px 5px 0;
				outline: none;
				color: #666;
				background: #fff;
				width: auto;
				font-size: inherit;
				height: 26px;
			}
	
	.one .list1-edit:hover {
				border: 1px solid #ff5f5f50;
				transform: scale(1);
				color: #ff5f5f;
				opacity: 0.8;
			}
	
	.one .list1-del {
				border: 1px solid #ddd;
				cursor: pointer;
				border-radius: 0px;
				padding: 0 10px;
				box-shadow: 0 0px #d1595a;
				margin: 0px 5px 5px 0;
				outline: none;
				color: #666;
				background: #fff;
				width: auto;
				font-size: inherit;
				height: 26px;
			}
	
	.one .list1-del:hover {
				border: 1px solid #ff5f5f50;
				transform: scale(1);
				color: #ff5f5f;
				opacity: 0.8;
			}
	
	.one .list1-btn8 {
				border: 1px solid #ddd;
				cursor: pointer;
				border-radius: 0px;
				padding: 0 10px;
				box-shadow: 0 0px #9c9c9c;
				margin: 0px 5px 5px 0;
				outline: none;
				color: #666;
				background: #fff;
				width: auto;
				font-size: inherit;
				height: 26px;
			}
	
	.one .list1-btn8:hover {
				border: 1px solid #ff5f5f50;
				transform: scale(1);
				color: #ff5f5f;
				opacity: 0.8;
			}
	
	.main-content .el-table .el-switch {
				display: inline-flex;
				vertical-align: middle;
				line-height: 30px;
				position: relative;
				align-items: center;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__label--left {
				cursor: pointer;
				margin: 0 10px 0 0;
				color: #333;
				font-weight: 500;
				display: inline-block;
				vertical-align: middle;
				font-size: 16px;
				transition: .2s;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__label--right {
				cursor: pointer;
				margin: 0 0 0 10px;
				color: #333;
				font-weight: 500;
				display: inline-block;
				vertical-align: middle;
				font-size: 16px;
				transition: .2s;
				height: 30px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__core {
				border: 0px solid #188ae2;
				cursor: pointer;
				border-radius: 20px;
				margin: 0;
				outline: 0;
				background: #b0d5f6;
				display: inline-block;
				width: 40px;
				box-sizing: border-box;
				transition: border-color .3s,background-color .3s;
				height: 18px;
			}
	.main-content .el-table .el-switch /deep/ .el-switch__core::after {
				border-radius: 100%;
				top: 1px;
				left: 1px;
				background: #FFF;
				width: 16px;
				position: absolute;
				transition: all .3s;
				height: 16px;
			}
	.main-content .el-table .el-switch.is-checked /deep/ .el-switch__core::after {
				margin: 0 0 0 -17px;
				left: 100%;
			}
	
	.main-content .el-table .el-rate /deep/ .el-rate__item {
				cursor: pointer;
				display: inline-block;
				vertical-align: middle;
				font-size: 0;
				position: relative;
			}
	.main-content .el-table .el-rate /deep/ .el-rate__item .el-rate__icon {
				margin: 0 3px;
				color: #212529;
				display: inline-block;
				font-size: 18px;
				position: relative;
				transition: .3s;
			}

</style>
