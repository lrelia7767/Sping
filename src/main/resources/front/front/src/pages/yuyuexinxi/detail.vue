<template>
<div>
	<div :style='{"padding":"20px 0","margin":"0px auto","borderColor":"#ddd","borderRadius":"0px","background":"none","borderWidth":"0 0 0px","width":"64%","borderStyle":"solid"}' class="breadcrumb-preview">
		<el-breadcrumb :separator="'='" :style='{"fontSize":"14px","lineHeight":"1","justifyContent":"flex-start","display":"flex"}'>
			<el-breadcrumb-item class="item1" to="/"><a>首页</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item2" v-for="(item, index) in breadcrumbItem" :key="index" to="/index/yuyuexinxi"><a>{{item.name}}</a></el-breadcrumb-item>
			<el-breadcrumb-item class="item3"><a href="javascript:void(0);">详情</a></el-breadcrumb-item>
		</el-breadcrumb>
	</div>
	<div :style='{"padding":"20px 0","margin":"0px auto","borderColor":"#ddd","borderRadius":"0px","background":"none","borderWidth":"0 0 0px","width":"64%","borderStyle":"solid"}'>
		<el-button size="mini" @click="backClick">返回</el-button>
	</div>
	<div class="detail-preview" :style='{"padding":"40px 18%","margin":"0 auto","alignItems":"flex-start","flexWrap":"wrap","background":"#efeeec","display":"flex","width":"100%","position":"relative","justifyContent":"space-between"}'>
		<div class="attr" :style='{"padding":"0","margin":"0","flexWrap":"wrap","background":"none","flex":"1","display":"flex","width":"51%","position":"relative","justifyContent":"space-between","order":"2"}'>

			<div class="info" :style='{"minHeight":"460px","padding":"20px","margin":"0","borderRadius":"8px","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","order":"2"}'>
				<div class="item" :style='{"padding":"0 8px","margin":"0 0 10px 0","borderColor":"#eccc19","alignItems":"center","display":"flex","justifyContent":"space-between","overflow":"hidden","borderRadius":"0px","background":"none","borderWidth":"0 0 0px","width":"100%","lineHeight":"auto","borderStyle":"solid","height":"50px"}'>
					<div :style='{"padding":"0px","color":"#222","flex":"1","display":"block","width":"calc(100% - 100px)","fontSize":"18px","lineHeight":"1.5","fontWeight":"600"}'>
                    {{detail.mingcheng}}
                    </div>
				</div>
				<div class="item" :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>分类</div>
					<div  :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>{{detail.fenlei}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>类型</div>
					<div  :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>{{detail.leixing}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>容纳人数</div>
					<div  :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>{{detail.rongnarenshu}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>地址</div>
					<div  :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>{{detail.dizhi}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>预约时间</div>
					<div  :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>{{detail.yuyueshijian}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>预约原因</div>
					<div  :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>{{detail.yuyueyuanyin}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>账号</div>
					<div  :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>{{detail.zhanghao}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>姓名</div>
					<div  :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>{{detail.xingming}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>手机号码</div>
					<div  :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>{{detail.shoujihaoma}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>信誉分</div>
					<div  :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>{{detail.xinyufen}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>申请日期</div>
					<div  :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>{{detail.shenqingriqi}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}'>
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>到场状态</div>
					<div  :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>{{detail.daochangzhuangtai}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}' v-if="centerType">
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>审核状态</div>
					<div :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>{{detail.sfsh=='是'?'通过':(detail.sfsh=='否'?'不通过':'待审核')}}</div>
				</div>
				<div class="item" :style='{"padding":"0 0px","margin":"0 0 4px 0","borderColor":"#28890b10","alignItems":"center","background":"#fff","borderWidth":"0px","display":"flex","width":"100%","borderStyle":"solid","justifyContent":"spaceBetween"}' v-if="centerType">
					<div class="lable" :style='{"padding":"0 10px","color":"#333","textAlign":"right","width":"auto","fontSize":"15px","lineHeight":"32px","height":"32px"}'>审核回复</div>
					<div :style='{"padding":"5px 10px 0","fontSize":"15px","lineHeight":"24px","color":"#999","flex":"1","height":"auto"}'>{{detail.shhf}}</div>
				</div>
				<div class="btn" :style='{"width":"100%","padding":"10px 0","flexWrap":"wrap","display":"flex"}'>
					<el-button :style='{"border":"0px solid #009cf530","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#009cf5","borderRadius":"0px","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('yuyuexinxi','修改')&&detail.sfsh!='是'&&detail.sfsh!='否' " @click="editClick">修改</el-button>
					<el-button :style='{"border":"0px solid #f5340030","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#f53400","borderRadius":"0px","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('yuyuexinxi','删除')" @click="delClick">删除</el-button>
					<el-button :style='{"border":"0px solid #f5340030","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#f53400","borderRadius":"0px","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('yuyuexinxi','私聊')&&detail.id!=mid" @click="chatClick">联系TA</el-button>
					<el-button :style='{"border":"0px solid #1abc9e30","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#1abc9e","borderRadius":"0px","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('yuyuexinxi','到场签到')" @click="onAcross('daochangxinxi','是','','daochangzhuangtai','已签到','已到场,未到场'.split(',')[0])" type="warning">到场签到</el-button>
					<el-button :style='{"border":"0px solid #f5340030","cursor":"pointer","padding":"0 10px","margin":"0 5px 0 0","outline":"none","color":"#f53400","borderRadius":"0px","background":"none","width":"auto","lineHeight":"36px","fontSize":"14px","height":"36px"}' v-if="btnAuth('yuyuexinxi','审核') && (detail.sfsh=='待审核'||!detail.sfsh)" @click="onSH" type="warning">审核</el-button>
				</div>
			</div>
		</div>
		
			<div class="swiper3" v-if="detailBanner.length" :style='{"width":"45%","margin":"0 4% 0 0","background":"none","justifyContent":"space-between","display":"flex","height":"auto"}'>
			  <div class="big" :style='{"border":"0px solid #1abc9e50","margin":"0 0 20px","borderRadius":"8px","background":"#fff","width":"calc(100% - 140px)","position":"relative","height":"460px","order":"2"}'>
				<img id="big" :style='{"objectFit":"cover","top":"0px","borderRadius":"8px","left":"0px","display":"block","width":"100%","position":"absolute","height":"100%","zIndex":"1"}' :src="swiperBigUrl" class="image">
			  </div>
			  <div class="samll" :style='{"padding":"0 0px","overflow":"hidden","alignItems":"flex-start","flexWrap":"wrap","background":"none","display":"block","width":"120px","justifyContent":"space-between","height":"auto","order":"2"}'>
			    <div :style='{"border":"0px solid #1abc9e50","margin":"0 0px 20px","borderRadius":"4px","background":"#fff","width":"100%","position":"relative","height":"100px"}' v-for="item in detailBanner" :key="item.id">
				  <img :style='{"border":"0px solid #eee","cursor":"pointer","padding":"4px","objectFit":"cover","top":"0px","left":"0px","display":"block","width":"100%","position":"absolute","height":"100%","zIndex":"1"}' v-if="item.substr(0,4)=='http'" :src="item" @click="swiperClick3(item)" class="image">
				  <img :style='{"border":"0px solid #eee","cursor":"pointer","padding":"4px","objectFit":"cover","top":"0px","left":"0px","display":"block","width":"100%","position":"absolute","height":"100%","zIndex":"1"}' v-else :src="baseUrl + item" @click="swiperClick3(baseUrl + item)" class="image">
			    </div>
			  </div>
			</div>


		

		
		<el-tabs class="detail" :style='{"border":"0px solid #28890b20","minHeight":"250px","boxShadow":"none","padding":"0","margin":"20px auto","borderRadius":"8px","background":"none","display":"block","width":"100%","order":"80"}' v-model="activeName" type="border-card">
		</el-tabs>
		<el-dialog title="审核" :visible.sync="sfshVisiable" width="50%">
			<el-form ref="shForm" :model="shForm" label-width="80px">
				<el-form-item label="审核状态">
					<el-select v-model="shForm.sfsh" placeholder="审核状态">
						<el-option label="通过" value="是"></el-option>
						<el-option label="不通过" value="否"></el-option>
						<el-option label="待审核" value="待审核"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="内容">
					<el-input type="textarea" :rows="8" v-model="shForm.shhf"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="sfshVisiable = false">取 消</el-button>
				<el-button type="primary" @click="shHandler">确 定</el-button>
			</div>
		</el-dialog>
	</div>
	<div class="share_view" :style='{"boxShadow":"0 1px 6px rgba(0,0,0,.3)","position":"fixed","right":"0","bottom":"20%","background":"#fff","zIndex":"11"}'>
	</div>
</div>
</template>

<script>
  import axios from 'axios'
  import Swiper from "swiper";
  
  export default {
    //数据集合
    data() {
      return {
        tablename: 'yuyuexinxi',
        baseUrl: '',
        breadcrumbItem: [
          {
            name: '预约信息'
          }
        ],
        title: '',
        detailBanner: [],
		userid: localStorage.getItem('frontUserid'),
		id: 0,
        detail: {},
        activeName: 'first',
        total: 1,
        pageSize: 5,
        totalPage: 1,
        buynumber: 1,
        sfshVisiable: false,
        shForm: {
			sfsh: '是',
			shhf: ''
        },
		centerType: false,
		shareUrl: location.href,
		swiperBigUrl: null,
      }
    },
    created() {
		if(this.$route.query.centerType) {
			this.centerType = true
		}
		
        this.init();
    },
	mounted() {
	},
    //方法集合
    methods: {
		swiperClick3(src) {
			this.swiperBigUrl = src
		},
        init() {
		  this.id = this.$route.query.id
          this.baseUrl = this.$config.baseUrl;
          this.$http.get(this.tablename + '/detail/'  + this.id, {}).then(res => {
            if (res.data.code == 0) {
              this.detail = res.data.data;
				this.title = this.detail.mingcheng;
				this.detailBanner = this.detail.tupian ? this.detail.tupian.split(",") : [];
				this.$forceUpdate();

				if(localStorage.getItem('frontToken')){
				}

            }
			if (this.detailBanner.length) {
				if (this.detailBanner[0].substr(0,4)=='http') {
					this.swiperBigUrl = this.detailBanner[0]
				} else {
					this.swiperBigUrl = this.baseUrl + this.detailBanner[0]
				}
			}
          });
        },
      async onAcross(acrossTable,crossOptAudit,crossOptPay,statusColumnName,tips,statusColumnValue,type=1){
		if(crossOptAudit=='是'&&this.detail.sfsh!='是') {
			this.$message({
				message: "请审核通过后再操作",
				type: "error",
				duration: 1500,
				onClose: () => {
				}
			});
			return
		}
        localStorage.setItem('crossTable',`yuyuexinxi`);
        localStorage.setItem('crossObj', JSON.stringify(this.detail));
        localStorage.setItem('statusColumnName',statusColumnName);
        localStorage.setItem('statusColumnValue',statusColumnValue);
        localStorage.setItem('tips',tips);
        if(statusColumnName!=''&&!statusColumnName.startsWith("[")) {
            var obj = JSON.parse(localStorage.getItem('crossObj'));
            for (var o in obj){
                if(o==statusColumnName && obj[o]==statusColumnValue){
                    this.$message({
                        type: 'error',
                        message: tips,
                        duration: 1500
                    });
                    return
                }
            }
        }
        this.$router.push({path: '/index/' + acrossTable + 'Add', query: {type: 'cross'}});
      },
      onSH() {
        this.sfshVisiable = true;
      },
      shHandler(){
        this.$confirm(`确定操作?`, "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.detail.sfsh = this.shForm.sfsh;
          this.detail.shhf = this.shForm.shhf;
          this.$http.post(`${this.tablename}/update`, this.detail).then(res => {
            if (res.data.code == 0) {
              this.sfshVisiable = false;
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
              });
            }
          });
        });
      },
      curChange(page) {
        this.getDiscussList(page);
      },
      prevClick(page) {
        this.getDiscussList(page);
      },
      nextClick(page) {
        this.getDiscussList(page);
      },
      sizeChange(size){
        this.pageSize = size
        this.getDiscussList(1);
      },
		// 返回按钮
		backClick(){
			let params = {}
			if(this.centerType){
				params.centerType = 1
			}
			this.$router.push({path: '/index/yuyuexinxi', query: params});
		},
		// 下载
		download(file){
			if(!file) {
				this.$message({
				  type: 'error',
				  message: '文件不存在',
				  duration: 1500,
				});
				return;
			}
		  let arr = file.replace(new RegExp('upload/', "g"), "")
		  axios.get(this.baseUrl + '/file/download?fileName=' + arr, {
		  	headers: {
		  		token: localStorage.getItem("frontToken")
		  	},
		  	responseType: "blob"
		  }).then(({
		  	data
		  }) => {
		  	const binaryData = [];
		  	binaryData.push(data);
		  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
		  		type: 'application/pdf;chartset=UTF-8'
		  	}))
		  	const a = document.createElement('a')
		  	a.href = objectUrl
		  	a.download = arr
		  	// a.click()
		  	// 下面这个写法兼容火狐
		  	a.dispatchEvent(new MouseEvent('click', {
		  		bubbles: true,
		  		cancelable: true,
		  		view: window
		  	}))
		  	window.URL.revokeObjectURL(data)
		  },err=>{
			  axios.get((location.href.split(this.$config.name).length>1 ? location.href.split(this.$config.name)[0] :'') + this.$config.name + '/file/download?fileName=' + arr, {
			  	headers: {
			  		token: localStorage.getItem("frontToken")
			  	},
			  	responseType: "blob"
			  }).then(({
			  	data
			  }) => {
			  	const binaryData = [];
			  	binaryData.push(data);
			  	const objectUrl = window.URL.createObjectURL(new Blob(binaryData, {
			  		type: 'application/pdf;chartset=UTF-8'
			  	}))
			  	const a = document.createElement('a')
			  	a.href = objectUrl
			  	a.download = arr
			  	// a.click()
			  	// 下面这个写法兼容火狐
			  	a.dispatchEvent(new MouseEvent('click', {
			  		bubbles: true,
			  		cancelable: true,
			  		view: window
			  	}))
			  	window.URL.revokeObjectURL(data)
			  })
		  })
      },


		// 权限判断
		btnAuth(tableName,key){
			if(this.centerType){
				return this.isBackAuth(tableName,key)
			}else{
				return this.isAuth(tableName,key)
			}
		},
		// 修改
		editClick(){
			this.$router.push(`/index/yuyuexinxiAdd?type=edit&&id=${this.detail.id}`);
		},
		// 删除
		async delClick(){
			await this.$confirm('是否删除此预约信息？')
			  .then(_ => {
			    this.$http.post('yuyuexinxi/delete', [this.detail.id]).then(async res => {
					if (res.data.code == 0) {
						this.$message({
							type: 'success',
							message: '删除成功!',
							duration: 1500,
							onClose: () => {
								history.back()
							}
						});
					}
			    });
			  }).catch(_ => {});
		},
    },
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.editor /deep/ .avatar-uploader {
		height: 0;
		line-height: 0;
	}
	
	.detail-preview {
	
	  .attr {
	    .el-carousel /deep/ .el-carousel__indicator button {
	      width: 0;
	      height: 0;
	      display: none;
	    }
	
	    .el-input-number__decrease:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled), .el-input-number__increase:hover:not(.is-disabled)~.el-input .el-input__inner:not(.is-disabled) {
	      border-color: none;
	    }
	  }
	
	  .detail {
	    & /deep/ .el-tabs__header .el-tabs__nav-wrap {
	      margin-bottom: 0;
	    }
	
	    & .add .el-textarea {
	      width: auto;
	    }
	  }
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: red;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: red;
	}

	.attr .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li:hover {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 0.7;
		height: 12px;
	}
	
	.attr .el-carousel /deep/ .el-carousel__indicators li.is-active {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 1;
		height: 12px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease {
		cursor: pointer;
		z-index: 1;
		display: flex;
		border-color: #DCDFE6;
		border-radius: 0px 0 0 0px;
		top: 2px;
		left: 1px;
		background: #f5f5f5;
		width: 40px;
		justify-content: center;
		border-width: 0 1px 0 0;
		align-items: center;
		position: absolute;
		border-style: solid;
		text-align: center;
		height: 32px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__decrease i {
		color: #666;
		font-size: 14px;
	}

	.attr .el-input-number /deep/ .el-input-number__increase {
		cursor: pointer;
		z-index: 1;
		display: flex;
		border-color: #DCDFE6;
		right: 1px;
		border-radius: 0 0px 0px 0;
		top: 2px;
		background: #f5f5f5;
		width: 40px;
		justify-content: center;
		border-width: 0 0 0 1px;
		align-items: center;
		position: absolute;
		border-style: solid;
		text-align: center;
		height: 32px;
	}
	
	.attr .el-input-number /deep/ .el-input-number__increase i {
		color: #666;
		font-size: 14px;
	}
	
	.attr .el-input-number /deep/ .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		border-radius: 0px;
		padding: 0 10px;
		outline: none;
		color: #666;
		background: #fff;
		display: inline-block;
		width: 100%;
		font-size: 14px;
		line-height: 34px;
		text-align: center;
		height: 34px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header {
		border-radius: 8px 8px 0 0;
		margin: 0;
		background: none;
		border-color: #f8514b50;
		border-width: 0 0 0px 0;
		border-style: solid;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item {
		border: 0;
		padding: 0 20px;
		margin: 0;
		color: #aaa;
		font-weight: 500;
		display: inline-block;
		font-size: 18px;
		line-height: 40px;
		transition: all 0s;
		background: none;
		position: relative;
		list-style: none;
		height: 40px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
		border: 0;
		border-radius: 8px 8px 0 0;
		color: #fff;
		background: linear-gradient(to right,#f67536,#f64d36),#f64d36;
		font-size: 18px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
		border: 0;
		border-radius: 8px 8px 0 0;
		color: #fff;
		background: linear-gradient(to right,#f67536,#f64d36),#f64d36;
		font-size: 18px;
	}
	
	.detail-preview .detail.el-tabs /deep/ .el-tabs__content {
		padding: 15px;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #666;
		width: 80px;
		font-size: 14px;
		line-height: 40px;
		text-align: right;
	}
	
	.detail-preview .detail.el-tabs .add /deep/ .el-textarea__inner {
	}
	
	.breadcrumb-preview .el-breadcrumb /deep/ .el-breadcrumb__separator {
		margin: 0 9px;
		color: #ccc;
		font-weight: 500;
	}
	
	.breadcrumb-preview .el-breadcrumb .item1 /deep/ .el-breadcrumb__inner a {
		color: #333;
		display: inline-block;
	}
	
	.breadcrumb-preview .el-breadcrumb .item2 /deep/ .el-breadcrumb__inner a {
		color: #666;
		display: inline-block;
	}
		
	.breadcrumb-preview .el-breadcrumb .item3 /deep/ .el-breadcrumb__inner a {
		color: #999;
		display: inline-block;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__total {
		margin: 0 10px 0 0;
		color: #666;
		font-weight: 400;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-prev {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-next {
		border: none;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #666;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		min-width: 35px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-prev:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .btn-next:disabled {
		border: none;
		cursor: not-allowed;
		border-radius: 2px;
		padding: 0;
		margin: 0 5px;
		color: #C0C4CC;
		background: #f4f4f5;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pager {
		padding: 0;
		margin: 0;
		display: inline-block;
		vertical-align: top;
	}
	
	#pagination.el-pagination /deep/ .el-pager .number {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #666;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #f4f4f5;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pager .number:hover {
		cursor: pointer;
		padding: 0 4px;
		margin: 0 5px;
		color: #fff;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #ff3232;
		text-align: center;
		min-width: 30px;
		height: 28px;
}

#pagination.el-pagination /deep/ .el-pager .number.active {
		cursor: default;
		padding: 0 4px;
		margin: 0 5px;
		color: #FFF;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		border-radius: 2px;
		background: #ff3232;
		text-align: center;
		min-width: 30px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes {
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input {
		margin: 0 5px;
		width: 100px;
		position: relative;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
		border: 0px solid #DCDFE6;
		cursor: pointer;
		padding: 0 25px 0 8px;
		color: #606266;
		display: inline-block;
		font-size: 13px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
		top: 0;
		position: absolute;
		right: 0;
		height: 100%;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
		cursor: pointer;
		color: #C0C4CC;
		width: 25px;
		font-size: 14px;
		line-height: 28px;
		text-align: center;
	}

	#pagination.el-pagination /deep/ .el-pagination__jump {
		margin: 0 0 0 24px;
		color: #606266;
		display: inline-block;
		vertical-align: top;
		font-size: 13px;
		line-height: 28px;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__jump .el-input {
		border-radius: 3px;
		padding: 0 2px;
		margin: 0 2px;
		display: inline-block;
		width: 50px;
		font-size: 14px;
		line-height: 18px;
		position: relative;
		text-align: center;
		height: 28px;
	}
	
	#pagination.el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
		border: 1px solid #DCDFE6;
		cursor: pointer;
		padding: 0 3px;
		color: #606266;
		display: inline-block;
		font-size: 14px;
		line-height: 28px;
		border-radius: 3px;
		outline: 0;
		background: #FFF;
		width: 100%;
		text-align: center;
		height: 28px;
	}
	.share_view{
		position: fixed;
		right:0;
		bottom: 20%;
		background: #fff;
		box-shadow: 0 4px 6px rgba(0,0,0,.1);
		.share{
			width: 40px;
			height: 40px;
			display: flex;
			align-items: center;
			justify-content: center;
			border-bottom: 1px solid #eee;
			cursor: pointer;
		}
		.share:last-of-type{
			border:none;
		}
	}


	.detail-preview .el-rate /deep/ .el-rate__item {
				cursor: pointer;
				display: inline-block;
				vertical-align: middle;
				font-size: 0;
				position: relative;
			}
	
	.detail-preview .el-rate /deep/ .el-rate__item .el-rate__icon {
				margin: 0 3px;
				display: block;
				font-size: 18px;
				position: relative;
				transition: .3s;
			}
</style>
