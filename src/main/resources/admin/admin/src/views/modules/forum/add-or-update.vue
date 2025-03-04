<template>
	<div class="addEdit-block" :style='{"minHeight":"100vh","padding":"30px","fontSize":"14px","color":"#666","background":"#fff"}'>
		<el-form
			:style='{"padding":"30px 30px 20px","borderColor":"#ddd","borderRadius":"4px","alignItems":"flex-start","flexWrap":"wrap","background":"rgba(255,255,255,1)","borderWidth":"0px 0 0","display":"flex","fontSize":"inherit","borderStyle":"solid"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="帖子标题" prop="title">
					<el-input v-model="ruleForm.title" placeholder="帖子标题" clearable  :readonly="ro.title"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="帖子标题" prop="title">
					<el-input v-model="ruleForm.title" placeholder="帖子标题" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="select" v-if="type!='info'"  label="状态" prop="isdone">
					<el-select :disabled="ro.isdone" v-model="ruleForm.isdone" placeholder="请选择状态" >
						<el-option
							v-for="(item,index) in isdoneOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="状态" prop="isdone">
					<el-input v-model="ruleForm.isdone"
						placeholder="状态" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="是否置顶" prop="istop">
					<el-input v-model.number="ruleForm.istop" placeholder="是否置顶" clearable  :readonly="ro.istop"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="是否置顶" prop="istop">
					<el-input v-model="ruleForm.istop" placeholder="是否置顶" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="date" v-if="type!='info'" label="置顶时间" prop="toptime">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.toptime" 
						type="datetime"
						:readonly="ro.toptime"
						placeholder="置顶时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-else-if="ruleForm.toptime" label="置顶时间" prop="toptime">
					<el-input v-model="ruleForm.toptime" placeholder="置顶时间" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-if="type!='info'"  label="帖子内容" prop="content">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.content" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else-if="ruleForm.content" label="帖子内容" prop="content">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","minWidth":"640px","color":"inherit","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.content"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"0px","margin":"30px 0","alignItems":"center","textAlign":"left","display":"flex","width":"auto","perspective":"320px","-webkitPerspective":"320px","fontSize":"48px","justifyContent":"flex-start"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-tijiao16" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"none"}'></span>
					保存
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-quxiao09" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"none"}'></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui01" :style='{"margin":"0 2px","fontSize":"18px","color":"inherit","display":"none"}'></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
import { 
	isIntNumer,
} from "@/utils/validate";
export default {
	data() {
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				title : false,
				content : false,
				parentid : false,
				userid : false,
				username : false,
				avatarurl : false,
				isdone : false,
				istop : false,
				toptime : false,
			},
			
			
			ruleForm: {
				title: '',
				content: '',
				parentid: '',
				userid: '',
				username: '',
				avatarurl: '',
				isdone: '',
				toptime: '',
			},
		
			isdoneOptions: [],

			
			rules: {
				title: [
				],
				content: [
					{ required: true, message: '帖子内容不能为空', trigger: 'blur' },
				],
				parentid: [
				],
				userid: [
					{ required: true, message: '用户id不能为空', trigger: 'blur' },
				],
				username: [
				],
				avatarurl: [
				],
				isdone: [
				],
				istop: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
				toptime: [
				],
			},
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
	},
	methods: {
		
		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='title'){
							this.ruleForm.title = obj[o];
							this.ro.title = true;
							continue;
						}
						if(o=='content'){
							this.ruleForm.content = obj[o];
							this.ro.content = true;
							continue;
						}
						if(o=='parentid'){
							this.ruleForm.parentid = obj[o];
							this.ro.parentid = true;
							continue;
						}
						if(o=='userid'){
							this.ruleForm.userid = obj[o];
							this.ro.userid = true;
							continue;
						}
						if(o=='username'){
							this.ruleForm.username = obj[o];
							this.ro.username = true;
							continue;
						}
						if(o=='avatarurl'){
							this.ruleForm.avatarurl = obj[o];
							this.ro.avatarurl = true;
							continue;
						}
						if(o=='isdone'){
							this.ruleForm.isdone = obj[o];
							this.ro.isdone = true;
							continue;
						}
						if(o=='istop'){
							this.ruleForm.istop = obj[o];
							this.ro.istop = true;
							continue;
						}
						if(o=='toptime'){
							this.ruleForm.toptime = obj[o];
							this.ro.toptime = true;
							continue;
						}
				}
			}
            this.isdoneOptions = "开放,关闭".split(',')
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `forum/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.content = this.ruleForm.content.replace(reg,'../../../springbootioh35z68/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
	if(this.ruleForm.avatarurl!=null) {
		this.ruleForm.avatarurl = this.ruleForm.avatarurl.replace(new RegExp(this.$base.url,"g"),"");
	}
var objcross = this.$storage.getObj('crossObj');
      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
		this.$refs["ruleForm"].validate(valid => {
			if (valid) {
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid = crossuserid;
					this.ruleForm.crossrefid = crossrefid;
					let params = { 
						page: 1, 
						limit: 10, 
						crossuserid:this.ruleForm.crossuserid,
						crossrefid:this.ruleForm.crossrefid,
					} 
				this.$http({ 
					url: "forum/page", 
					method: "get", 
					params: params 
				}).then(({ 
					data 
				}) => { 
					if (data && data.code === 0) { 
						if(data.data.total>=crossoptnum) {
							this.$message.error(this.$storage.get('tips'));
							return false;
						} else {
							this.$http({
								url: `forum/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.forumCrossAddOrUpdateFlag = false;
											this.parent.search();
											this.parent.contentStyleChange();
										}
									});
								} else {
									this.$message.error(data.msg);
								}
							});

						}
					} else { 
				} 
			});
		} else {
			this.$http({
				url: `forum/${!this.ruleForm.id ? "save" : "update"}`,
				method: "post",
			   data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "操作成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.parent.showFlag = true;
							this.parent.addOrUpdateFlag = false;
							this.parent.forumCrossAddOrUpdateFlag = false;
							this.parent.search();
							this.parent.contentStyleChange();
						}
					});
				} else {
					this.$message.error(data.msg);
			   }
			});
		 }
         }
		});
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.forumCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    avatarurlUploadChange(fileUrls) {
	    this.ruleForm.avatarurl = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 600;
	  	  display: inline-block;
	  	  width: 180px;
	  	  font-size: inherit;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 180px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  color: inherit;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  border-color: e2e2e4;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  min-width: 350px;
	  	  height: 36px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  	  border-radius: 4px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  color: inherit;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  border-color: e2e2e4;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  min-width: 350px;
	  	  height: 36px;
	  	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border-radius: 4px;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  color: inherit;
	  	  background: #fff;
	  	  width: auto;
	  	  font-size: 14px;
	  	  border-color: #e2e2e4;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  min-width: 350px;
	  	  height: 36px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  padding: 0 10px 0 30px;
	  	  color: inherit;
	  	  font-size: 14px;
	  	  border-color: #e2e2e4;
	  	  border-radius: 4px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  background: #fff;
	  	  width: auto;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  min-width: 350px;
	  	  height: 36px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  cursor: pointer;
	  	  color: #ccc;
	  	  object-fit: cover;
	  	  font-size: 24px;
	  	  border-color: #e2e2e4;
	  	  line-height: 80px;
	  	  border-radius: 4px;
	  	  background: #fff;
	  	  width: 120px;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  cursor: pointer;
	  	  color: #ccc;
	  	  object-fit: cover;
	  	  font-size: 24px;
	  	  border-color: #e2e2e4;
	  	  line-height: 80px;
	  	  border-radius: 4px;
	  	  background: #fff;
	  	  width: 120px;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  cursor: pointer;
	  	  color: #ccc;
	  	  object-fit: cover;
	  	  font-size: 24px;
	  	  border-color: #e2e2e4;
	  	  line-height: 80px;
	  	  border-radius: 4px;
	  	  background: #fff;
	  	  width: 120px;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  text-align: center;
	  	  height: 80px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  padding: 12px;
	  	  color: inherit;
	  	  font-size: 14px;
	  	  border-color: #e2e2e4;
	  	  min-height: 120px;
	  	  border-radius: 4px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  background: #fff;
	  	  width: auto;
	  	  border-width: 1px;
	  	  border-style: solid;
	  	  min-width: 480px;
	  	  height: auto;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 0px solid rgba(53, 184, 224, 0.1);
				cursor: pointer;
				padding: 0 10px;
				margin: 0px 10px 0 0;
				color: #fff;
				display: inline-block;
				font-size: 14px;
				line-height: 34px;
				border-radius: 20px;
				box-shadow: 0 4px #29b392;
				outline: none;
				background: #41cac0;
				width: auto;
				height: 34px;
			}
	
	.add-update-preview .btn .btn1:hover {
				transform: translate3d(0px, 6px, 0px);
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn2 {
				border: 0px solid rgba(24, 138, 226, 0.1) ;
				cursor: pointer;
				padding: 0 10px;
				margin: 0px 10px 0 0;
				color: #fff;
				font-size: 14px;
				line-height: 34px;
				border-radius: 20px;
				box-shadow: 0 4px #cab03f;
				outline: none;
				background: #e4ba00;
				width: auto;
				height: 34px;
			}
	
	.add-update-preview .btn .btn2:hover {
				transform: translate3d(0px, 6px, 0px);
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn3 {
				border: 0px solid #0260ad;
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 10px 0 0;
				color: #fff;
				font-size: 14px;
				line-height: 24px;
				border-radius: 20px;
				box-shadow: 0 4px #1caadc;
				outline: none;
				background: #58c9f3;
				width: auto;
				height: 34px;
			}
	
	.add-update-preview .btn .btn3:hover {
				transform: translate3d(0px, 6px, 0px);
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn4 {
				border: 0px solid rgba(126, 96, 16, .2);
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 10px 0 0;
				color: #fff;
				font-size: 14px;
				line-height: 34px;
				border-radius: 20px;
				box-shadow: 0 4px #61a642;
				outline: none;
				background: #78CD51;
				width: auto;
				height: 34px;
			}
	
	.add-update-preview .btn .btn4:hover {
				transform: translate3d(0px, 6px, 0px);
				opacity: 0.8;
			}
	
	.add-update-preview .btn .btn5 {
				border: 1px solid #cecece;
				cursor: pointer;
				padding: 0 20px;
				margin: 0px 10px 0 0;
				color: #ACA9A9;
				font-size: 14px;
				line-height: 34px;
				border-radius: 20px;
				box-shadow: 0 4px #9c9c9c;
				outline: none;
				background: #fff;
				width: auto;
				height: 34px;
			}
	
	.add-update-preview .btn .btn5:hover {
				transform: translate3d(0px, 6px, 0px);
				background: #ececec;
				opacity: 1;
			}
</style>
