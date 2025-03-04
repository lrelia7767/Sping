<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20231112/6489a7d44f90423ba5a468b087d98a2b.jpg)","display":"flex","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
			<el-form v-if="pageFlag=='register'" :style='{"border":"1px solid rgba(255,255,255,0)","padding":"20px 100px 20px","margin":"20px auto","alignItems":"flex-start","textAlign":"center","display":"block","justifyContent":"flex-start","borderRadius":"4px","flexWrap":"wrap","background":"rgba(0, 0, 0, .5)","width":"550px","position":"relative","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm" :rules="rules">
				<div v-if="true" :style='{"padding":"0 0 10px","margin":"0 0 10px","borderColor":"#d8ae86","color":"#fff","textAlign":"center","display":"inline-block","background":"none","borderWidth":"0 0 0px","width":"100%","lineHeight":"40px","fontSize":"22px","borderStyle":"solid","fontWeight":"600"}' class="title">免费体育馆场地预约系统注册</div>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 10px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#fff","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute","order":"2"}' class="lable" :class="changeRules('zhanghao')?'required':''">账号：</div>
					<el-input  v-model="ruleForm.zhanghao"  autocomplete="off" placeholder="账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 10px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#fff","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 10px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#fff","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 10px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#fff","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute","order":"2"}' class="lable" :class="changeRules('xingming')?'required':''">姓名：</div>
					<el-input  v-model="ruleForm.xingming"  autocomplete="off" placeholder="姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 10px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#fff","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute","order":"2"}' class="lable" :class="changeRules('xingbie')?'required':''">性别：</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="请选择性别" >
                        <el-option
                            v-for="(item,index) in yonghuxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 10px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#fff","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute","order":"2"}' class="lable" :class="changeRules('youxiang')?'required':''">邮箱：</div>
					<el-input  v-model="ruleForm.youxiang"  autocomplete="off" placeholder="邮箱"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 10px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#fff","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute","order":"2"}' class="lable" :class="changeRules('shoujihaoma')?'required':''">手机号码：</div>
					<el-input  v-model="ruleForm.shoujihaoma"  autocomplete="off" placeholder="手机号码"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 10px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='yonghu'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#fff","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute","order":"2"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="yonghutouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 10px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='changdiguanliyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#fff","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute","order":"2"}' class="lable" :class="changeRules('guanlizhanghao')?'required':''">管理账号：</div>
					<el-input  v-model="ruleForm.guanlizhanghao"  autocomplete="off" placeholder="管理账号"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 10px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='changdiguanliyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#fff","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">密码：</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="密码"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 10px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='changdiguanliyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#fff","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute","order":"2"}' class="lable" :class="changeRules('mima')?'required':''">确认密码：</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 10px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='changdiguanliyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#fff","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute","order":"2"}' class="lable" :class="changeRules('guanlixingming')?'required':''">管理姓名：</div>
					<el-input  v-model="ruleForm.guanlixingming"  autocomplete="off" placeholder="管理姓名"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"padding":"0 0px","margin":"0 0 10px","textAlign":"left","flexWrap":"wrap","display":"flex","width":"100%","fontSize":"inherit","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='changdiguanliyuan'">
					<div v-if="true" :style='{"padding":"0 6px","color":"#fff","textAlign":"right","left":"-120px","display":"inline-block","width":"120px","lineHeight":"40px","fontSize":"16px","position":"absolute","order":"2"}' class="lable" :class="changeRules('touxiang')?'required':''">头像：</div>
                    <file-upload
                        tip="点击上传头像"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="changdiguanliyuantouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<button :style='{"border":"0px solid #4FA1D9","cursor":"pointer","padding":"0 24px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"20px 0px 0 0","color":"#fff","display":"inline-block","letterSpacing":"4px","float":"left","outline":"none","borderRadius":"0px","background":"#ff5f5f","width":"320px","fontSize":"16px","height":"40px"}' type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{"cursor":"pointer","padding":"0","margin":"0px 0 0","color":"#fff","textAlign":"left","display":"inline-block","width":"350px","lineHeight":"44px","fontSize":"13px"}' class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
            pageFlag : '',
			tableName:"",
			rules: {},
            yonghuxingbieOptions: [],
		};
	},
	mounted(){
		this.pageFlag = this.$route.query.pageFlag
		if(this.$route.query.pageFlag=='register'){
			
			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if(this.tableName=='yonghu'){
				this.ruleForm = {
					zhanghao: '',
					mima: '',
					xingming: '',
					xingbie: '',
					youxiang: '',
					shoujihaoma: '',
					xinyufen: '10',
					touxiang: '',
					status: '',
				}
			}
			if(this.tableName=='changdiguanliyuan'){
				this.ruleForm = {
					guanlizhanghao: '',
					mima: '',
					guanlixingming: '',
					touxiang: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.zhanghao = [{ required: true, message: '请输入账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.xingming = [{ required: true, message: '请输入姓名', trigger: 'blur' }]
			}
			if ('changdiguanliyuan' == this.tableName) {
				this.rules.guanlizhanghao = [{ required: true, message: '请输入管理账号', trigger: 'blur' }]
			}
			if ('changdiguanliyuan' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('changdiguanliyuan' == this.tableName) {
				this.rules.guanlixingming = [{ required: true, message: '请输入管理姓名', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
		  	},
	methods: {
		changeRules(name){
			if(this.rules[name]){
				return true
			}
			return false
		},
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        yonghutouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        changdiguanliyuantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// 注册
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.zhanghao) && `yonghu` == this.tableName){
						this.$message.error(`账号不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `yonghu` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `yonghu` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.xingming) && `yonghu` == this.tableName){
						this.$message.error(`姓名不能为空`);
						return
					}
					if(`yonghu` == this.tableName && this.ruleForm.youxiang &&(!this.$validate.isEmail(this.ruleForm.youxiang))){
						this.$message.error(`邮箱应输入邮件格式`);
						return
					}
					if(`yonghu` == this.tableName && this.ruleForm.shoujihaoma &&(!this.$validate.isMobile(this.ruleForm.shoujihaoma))){
						this.$message.error(`手机号码应输入手机格式`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					if((!this.ruleForm.guanlizhanghao) && `changdiguanliyuan` == this.tableName){
						this.$message.error(`管理账号不能为空`);
						return
					}
					if((!this.ruleForm.mima) && `changdiguanliyuan` == this.tableName){
						this.$message.error(`密码不能为空`);
						return
					}
					if((this.ruleForm.mima!=this.ruleForm.mima2) && `changdiguanliyuan` == this.tableName){
						this.$message.error(`两次密码输入不一致`);
						return
					}
					if((!this.ruleForm.guanlixingming) && `changdiguanliyuan` == this.tableName){
						this.$message.error(`管理姓名不能为空`);
						return
					}
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20231112/6489a7d44f90423ba5a468b087d98a2b.jpg);

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						color: #666;
						background: #fff;
						width: 320px;
						font-size: 14px;
						border-color: rgba(255,255,255,.5);
						border-width: 0px;
						border-style: solid;
						height: 36px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						color: #666;
						background: #fff;
						width: 320px;
						font-size: 14px;
						border-color: rgba(255,255,255,.5);
						border-width: 2px;
						border-style: solid;
						height: 36px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						color: #666;
						background: #fff;
						width: 320px;
						font-size: 14px;
						border-color: rgba(255,255,255,.5);
						border-width: 2px;
						border-style: solid;
						height: 36px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						color: #666;
						background: #fff;
						width: 320px;
						font-size: 14px;
						border-color: rgba(255,255,255,.5);
						border-width: 2px;
						border-style: solid;
						height: 36px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 2px solid rgba(255,255,255,.5);
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  color: #999;
		  		  background: #fff;
		  		  font-weight: 600;
		  		  object-fit: cover;
		  		  width: 80px;
		  		  font-size: 24px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 2px solid rgba(255,255,255,.5);
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  color: #999;
		  		  background: #fff;
		  		  font-weight: 600;
		  		  object-fit: cover;
		  		  width: 80px;
		  		  font-size: 24px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 2px solid rgba(255,255,255,.5);
		  		  cursor: pointer;
		  		  border-radius: 0px;
		  		  color: #999;
		  		  background: #fff;
		  		  font-weight: 600;
		  		  object-fit: cover;
		  		  width: 80px;
		  		  font-size: 24px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
	}
	.required {
		position: relative;
	}
	.required::after{
				color: red;
				position: absolute;
				right: 3px;
				content: "*";
				order: 3;
			}
	.editor>.avatar-uploader {
		line-height: 0;
		height: 0;
	}
</style>
