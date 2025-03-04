package com.entity.view;

import com.entity.ChangdiguanliyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 场地管理员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-08 20:55:39
 */
@TableName("changdiguanliyuan")
public class ChangdiguanliyuanView  extends ChangdiguanliyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChangdiguanliyuanView(){
	}
 
 	public ChangdiguanliyuanView(ChangdiguanliyuanEntity changdiguanliyuanEntity){
 	try {
			BeanUtils.copyProperties(this, changdiguanliyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
