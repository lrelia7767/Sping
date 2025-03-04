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
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="名称" prop="mingcheng">
					<el-input v-model="ruleForm.mingcheng" placeholder="名称" clearable  :readonly="ro.mingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="名称" prop="mingcheng">
					<el-input v-model="ruleForm.mingcheng" placeholder="名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="upload" v-if="type!='info' && !ro.tupian" label="图片" prop="tupian">
					<file-upload
						tip="点击上传图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.tupian?ruleForm.tupian:''"
						@change="tupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="upload" v-else-if="ruleForm.tupian" label="图片" prop="tupian">
					<img v-if="ruleForm.tupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.tupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="分类" prop="fenlei">
					<el-input v-model="ruleForm.fenlei" placeholder="分类" clearable  :readonly="ro.fenlei"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="分类" prop="fenlei">
					<el-input v-model="ruleForm.fenlei" placeholder="分类" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="地址" prop="dizhi">
					<el-input v-model="ruleForm.dizhi" placeholder="地址" clearable  :readonly="ro.dizhi"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="地址" prop="dizhi">
					<el-input v-model="ruleForm.dizhi" placeholder="地址" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="预约时间" prop="yuyueshijian">
					<el-input v-model="ruleForm.yuyueshijian" placeholder="预约时间" clearable  :readonly="ro.yuyueshijian"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="预约时间" prop="yuyueshijian">
					<el-input v-model="ruleForm.yuyueshijian" placeholder="预约时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="账号" prop="zhanghao">
					<el-input v-model="ruleForm.zhanghao" placeholder="账号" clearable  :readonly="ro.zhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="账号" prop="zhanghao">
					<el-input v-model="ruleForm.zhanghao" placeholder="账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="姓名" prop="xingming">
					<el-input v-model="ruleForm.xingming" placeholder="姓名" clearable  :readonly="ro.xingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="姓名" prop="xingming">
					<el-input v-model="ruleForm.xingming" placeholder="姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-if="type!='info'"  label="手机号码" prop="shoujihaoma">
					<el-input v-model="ruleForm.shoujihaoma" placeholder="手机号码" clearable  :readonly="ro.shoujihaoma"></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="手机号码" prop="shoujihaoma">
					<el-input v-model="ruleForm.shoujihaoma" placeholder="手机号码" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="date" v-if="type!='info'" label="评价时间" prop="pingjiashijian">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.pingjiashijian" 
						type="datetime"
						:readonly="ro.pingjiashijian"
						placeholder="评价时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="input" v-else-if="ruleForm.pingjiashijian" label="评价时间" prop="pingjiashijian">
					<el-input v-model="ruleForm.pingjiashijian" placeholder="评价时间" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="select" v-if="type!='info'"  label="满意度" prop="manyidu">
					<el-select :disabled="ro.manyidu" v-model="ruleForm.manyidu" placeholder="请选择满意度" >
						<el-option
							v-for="(item,index) in manyiduOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else class="input" label="满意度" prop="manyidu">
					<el-input v-model="ruleForm.manyidu"
						placeholder="满意度" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' class="textarea" v-if="type!='info'" label="评价内容" prop="pingjianeirong">
					<el-input
					  style="min-width: 200px; max-width: 600px;"
					  type="textarea"
					  :rows="8"
					  placeholder="评价内容"
					  v-model="ruleForm.pingjianeirong" >
					</el-input>
				</el-form-item>
				<el-form-item :style='{"border":"0px solid #eee","padding":"0","margin":"0 30px 20px 0","color":"inherit","borderRadius":"0px","width":"100%","fontSize":"inherit"}' v-else-if="ruleForm.pingjianeirong" label="评价内容" prop="pingjianeirong">
					<span :style='{"fontSize":"14px","lineHeight":"40px","minWidth":"640px","color":"inherit","fontWeight":"500","display":"inline-block"}'>{{ruleForm.pingjianeirong}}</span>
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
export default {
	data() {
		return {
			id: '',
			type: '',
			
			
			ro:{
				mingcheng : false,
				tupian : false,
				fenlei : false,
				dizhi : false,
				yuyueshijian : false,
				zhanghao : false,
				xingming : false,
				shoujihaoma : false,
				pingjiashijian : false,
				manyidu : false,
				pingjianeirong : false,
				crossuserid : false,
				crossrefid : false,
			},
			
			
			ruleForm: {
				mingcheng: '',
				tupian: '',
				fenlei: '',
				dizhi: '',
				yuyueshijian: '',
				zhanghao: '',
				xingming: '',
				shoujihaoma: '',
				pingjiashijian: '',
				manyidu: '',
				pingjianeirong: '',
				crossuserid: '',
				crossrefid: '',
			},
		
			manyiduOptions: [],

			
			rules: {
				mingcheng: [
				],
				tupian: [
				],
				fenlei: [
				],
				dizhi: [
				],
				yuyueshijian: [
				],
				zhanghao: [
				],
				xingming: [
				],
				shoujihaoma: [
				],
				pingjiashijian: [
				],
				manyidu: [
				],
				pingjianeirong: [
				],
				crossuserid: [
				],
				crossrefid: [
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
		this.ruleForm.pingjiashijian = this.getCurDateTime()
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
						if(o=='mingcheng'){
							this.ruleForm.mingcheng = obj[o];
							this.ro.mingcheng = true;
							continue;
						}
						if(o=='tupian'){
							this.ruleForm.tupian = obj[o];
							this.ro.tupian = true;
							continue;
						}
						if(o=='fenlei'){
							this.ruleForm.fenlei = obj[o];
							this.ro.fenlei = true;
							continue;
						}
						if(o=='dizhi'){
							this.ruleForm.dizhi = obj[o];
							this.ro.dizhi = true;
							continue;
						}
						if(o=='yuyueshijian'){
							this.ruleForm.yuyueshijian = obj[o];
							this.ro.yuyueshijian = true;
							continue;
						}
						if(o=='zhanghao'){
							this.ruleForm.zhanghao = obj[o];
							this.ro.zhanghao = true;
							continue;
						}
						if(o=='xingming'){
							this.ruleForm.xingming = obj[o];
							this.ro.xingming = true;
							continue;
						}
						if(o=='shoujihaoma'){
							this.ruleForm.shoujihaoma = obj[o];
							this.ro.shoujihaoma = true;
							continue;
						}
						if(o=='pingjiashijian'){
							this.ruleForm.pingjiashijian = obj[o];
							this.ro.pingjiashijian = true;
							continue;
						}
						if(o=='manyidu'){
							this.ruleForm.manyidu = obj[o];
							this.ro.manyidu = true;
							continue;
						}
						if(o=='pingjianeirong'){
							this.ruleForm.pingjianeirong = obj[o];
							this.ro.pingjianeirong = true;
							continue;
						}
						if(o=='crossuserid'){
							this.ruleForm.crossuserid = obj[o];
							this.ro.crossuserid = true;
							continue;
						}
						if(o=='crossrefid'){
							this.ruleForm.crossrefid = obj[o];
							this.ro.crossrefid = true;
							continue;
						}
				}
			}
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					var json = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
            this.manyiduOptions = "很不满意,不满意,一般,满意,很满意".split(',')
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `pingjiaxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
	if(this.ruleForm.tupian!=null) {
		this.ruleForm.tupian = this.ruleForm.tupian.replace(new RegExp(this.$base.url,"g"),"");
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
					url: "pingjiaxinxi/page", 
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
								url: `pingjiaxinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
											this.parent.pingjiaxinxiCrossAddOrUpdateFlag = false;
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
				url: `pingjiaxinxi/${!this.ruleForm.id ? "save" : "update"}`,
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
							this.parent.pingjiaxinxiCrossAddOrUpdateFlag = false;
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
      this.parent.pingjiaxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    tupianUploadChange(fileUrls) {
	    this.ruleForm.tupian = fileUrls;
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
