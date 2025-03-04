<template>
<div :style='{"width":"100%","padding":"30px 18% 40px","margin":"0px auto","position":"relative","background":"#fff"}'>
    <el-form
	  :style='{"border":"1px solid #eee","padding":"30px 0","alignItems":"flex-start","flexWrap":"wrap","background":"#fff","display":"flex","width":"100%","position":"relative"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="120px"
    >
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="名称" prop="mingcheng">
            <el-input v-model="ruleForm.mingcheng" 
                placeholder="名称" clearable :disabled=" false  ||ro.mingcheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="图片" v-if="type!='cross' || (type=='cross' && !ro.tupian)" prop="tupian">
            <file-upload
            tip="点击上传图片"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.tupian?ruleForm.tupian:''"
            @change="tupianUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' class="upload" v-else label="图片" prop="tupian">
                <img v-if="ruleForm.tupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.tupian.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="分类" prop="fenlei">
            <el-input v-model="ruleForm.fenlei" 
                placeholder="分类" clearable :disabled=" false  ||ro.fenlei"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="类型" prop="leixing">
            <el-input v-model="ruleForm.leixing" 
                placeholder="类型" clearable :disabled=" false  ||ro.leixing"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="地址" prop="dizhi">
            <el-input v-model="ruleForm.dizhi" 
                placeholder="地址" clearable :disabled=" false  ||ro.dizhi"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="预约时间" prop="yuyueshijian">
            <el-input v-model="ruleForm.yuyueshijian" 
                placeholder="预约时间" clearable :disabled=" false  ||ro.yuyueshijian"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="账号" prop="zhanghao">
            <el-input v-model="ruleForm.zhanghao" 
                placeholder="账号" clearable :disabled=" false  ||ro.zhanghao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="姓名" prop="xingming">
            <el-input v-model="ruleForm.xingming" 
                placeholder="姓名" clearable :disabled=" false  ||ro.xingming"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="手机号码" prop="shoujihaoma">
            <el-input v-model="ruleForm.shoujihaoma" 
                placeholder="手机号码" clearable :disabled=" false  ||ro.shoujihaoma"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="备注" prop="beizhu">
            <el-input v-model="ruleForm.beizhu" 
                placeholder="备注" clearable :disabled=" false  ||ro.beizhu"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="到场时间" prop="daochangshijian">
              <el-date-picker
				  :disabled=" false  ||ro.daochangshijian"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.daochangshijian" 
                  type="datetime"
                  placeholder="到场时间">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"width":"48%","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}'  label="离场状态" prop="lichangzhuangtai">
            <el-select v-model="ruleForm.lichangzhuangtai" placeholder="请选择离场状态" :disabled="true  ||ro.lichangzhuangtai" >
              <el-option
                  v-for="(item,index) in lichangzhuangtaiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>

      <el-form-item :style='{"width":"100%","padding":"0","margin":"0","textAlign":"center"}'>
        <el-button :style='{"border":"0px solid #eccc19","cursor":"pointer","padding":"0","margin":"0 20px 0 0","color":"#fff","borderRadius":"20px","background":"linear-gradient(to right,#f67536,#f64d36),#f64d36","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"1px solid #ccc","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#666","borderRadius":"20px","background":"none","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
	  let self = this
      return {
        id: '',
        baseUrl: '',
        ro:{
				mingcheng : false,
				tupian : false,
				fenlei : false,
				leixing : false,
				dizhi : false,
				yuyueshijian : false,
				zhanghao : false,
				xingming : false,
				shoujihaoma : false,
				beizhu : false,
				daochangshijian : false,
				lichangzhuangtai : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          mingcheng: '',
          tupian: '',
          fenlei: '',
          leixing: '',
          dizhi: '',
          yuyueshijian: '',
          zhanghao: '',
          xingming: '',
          shoujihaoma: '',
          beizhu: '',
          daochangshijian: '',
          lichangzhuangtai: '待离场' ,
        },
        lichangzhuangtaiOptions: [],


        rules: {
          mingcheng: [
          ],
          tupian: [
          ],
          fenlei: [
          ],
          leixing: [
          ],
          dizhi: [
          ],
          yuyueshijian: [
            { required: true, message: '预约时间不能为空', trigger: 'blur' },
          ],
          zhanghao: [
          ],
          xingming: [
          ],
          shoujihaoma: [
          ],
          beizhu: [
          ],
          daochangshijian: [
          ],
          lichangzhuangtai: [
          ],
        },
		centerType: false,
      };
    },
    computed: {



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.daochangshijian = this.getCurDateTime()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='mingcheng'){
              this.ruleForm.mingcheng = obj[o];
              this.ro.mingcheng = true;
              continue;
            }
            if(o=='tupian'){
              this.ruleForm.tupian = obj[o].split(",")[0];
              this.ro.tupian = true;
              continue;
            }
            if(o=='fenlei'){
              this.ruleForm.fenlei = obj[o];
              this.ro.fenlei = true;
              continue;
            }
            if(o=='leixing'){
              this.ruleForm.leixing = obj[o];
              this.ro.leixing = true;
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
            if(o=='beizhu'){
              this.ruleForm.beizhu = obj[o];
              this.ro.beizhu = true;
              continue;
            }
            if(o=='daochangshijian'){
              this.ruleForm.daochangshijian = obj[o];
              this.ro.daochangshijian = true;
              continue;
            }
            if(o=='lichangzhuangtai'){
              this.ruleForm.lichangzhuangtai = obj[o];
              this.ro.lichangzhuangtai = true;
              continue;
            }
          }
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });
        this.lichangzhuangtaiOptions = "已离场,待离场".split(',')

		if (localStorage.getItem('raffleType') && localStorage.getItem('raffleType') != null) {
			localStorage.removeItem('raffleType')
			setTimeout(() => {
				this.onSubmit()
			}, 300)
		}
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`daochangxinxi/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {
			//更新跨表属性
			var crossuserid;
			var crossrefid;
			var crossoptnum;
			this.$refs["ruleForm"].validate(valid => {
				if(valid) {
					if(this.type=='cross'){
						var statusColumnName = localStorage.getItem('statusColumnName');
						var statusColumnValue = localStorage.getItem('statusColumnValue');
						if(statusColumnName && statusColumnName!='') {
							var obj = JSON.parse(localStorage.getItem('crossObj'));
							if(!statusColumnName.startsWith("[")) {
								for (var o in obj){
									if(o==statusColumnName){
										obj[o] = statusColumnValue;
									}
								}
								var table = localStorage.getItem('crossTable');
								this.$http.post(table+'/update', obj).then(res => {});
							} else {
								crossuserid=Number(localStorage.getItem('frontUserid'));
								crossrefid=obj['id'];
								crossoptnum=localStorage.getItem('statusColumnName');
								crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
							}
						}
					}
					if(crossrefid && crossuserid) {
						this.ruleForm.crossuserid=crossuserid;
						this.ruleForm.crossrefid=crossrefid;
						var params = {
							page: 1,
							limit: 10,
							crossuserid:crossuserid,
							crossrefid:crossrefid,
						}
						this.$http.get('daochangxinxi/list', {
							params: params
						}).then(res => {
							if(res.data.data.total>=crossoptnum) {
								this.$message({
									message: localStorage.getItem('tips'),
									type: 'error',
									duration: 1500,
								});
								return false;
							} else {
								// 跨表计算


								this.$http.post(`daochangxinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
									if (res.data.code == 0) {
										this.$message({
											message: '操作成功',
											type: 'success',
											duration: 1500,
											onClose: () => {
												this.$router.go(-1);
											}
										});
									} else {
										this.$message({
											message: res.data.msg,
											type: 'error',
											duration: 1500
										});
									}
								});
							}
						});
					} else {


						this.$http.post(`daochangxinxi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
							if (res.data.code == 0) {
								this.$message({
									message: '操作成功',
									type: 'success',
									duration: 1500,
									onClose: () => {
										this.$router.go(-1);
									}
								});
							} else {
								this.$message({
									message: res.data.msg,
									type: 'error',
									duration: 1500
								});
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
			this.$router.go(-1);
		},
      tupianUploadChange(fileUrls) {
          this.ruleForm.tupian = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #666;
	  font-weight: 500;
	  width: 120px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 120px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #ddd;
	  padding: 0 12px;
	  color: #666;
	  font-size: 14px;
	  border-color: #ddd;
	  border-radius: 0px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  background: none;
	  width: auto;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 200px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
	  border: 1px solid #ddd;
	  padding: 0 12px;
	  color: #666;
	  font-size: 14px;
	  border-color: #ddd;
	  border-radius: 0px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  background: none;
	  width: auto;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 200px;
	  height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border-radius: 0px;
	  padding: 0 10px;
	  color: #666;
	  background: none;
	  width: auto;
	  font-size: 14px;
	  border-color: #ddd;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 250px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border-radius: 0px;
	  padding: 0 10px 0 30px;
	  color: #666;
	  background: none;
	  width: auto;
	  font-size: 14px;
	  border-color: #ddd;
	  border-width: 1px;
	  border-style: solid;
	  min-width: 250px;
	  height: 40px;
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
	  color: #999;
	  font-size: 24px;
	  border-color: #ddd;
	  line-height: 54px;
	  border-radius: 2px;
	  background: none;
	  width: auto;
	  border-width: 1px;
	  border-style: solid;
	  text-align: center;
	  min-width: 150px;
	  height: 54px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  cursor: pointer;
	  color: #999;
	  font-size: 24px;
	  border-color: #ddd;
	  line-height: 54px;
	  border-radius: 2px;
	  background: none;
	  width: auto;
	  border-width: 1px;
	  border-style: solid;
	  text-align: center;
	  min-width: 150px;
	  height: 54px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  cursor: pointer;
	  color: #999;
	  font-size: 24px;
	  border-color: #ddd;
	  line-height: 54px;
	  border-radius: 2px;
	  background: none;
	  width: auto;
	  border-width: 1px;
	  border-style: solid;
	  text-align: center;
	  min-width: 150px;
	  height: 54px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #ddd;
	  border-radius: 0px;
	  padding: 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #666;
	  background: none;
	  width: 100%;
	  font-size: 14px;
	  height: 120px;
	}
</style>
