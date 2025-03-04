package com.entity.view;

import com.entity.XinyupingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 信誉评价
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-05-08 20:55:40
 */
@TableName("xinyupingjia")
public class XinyupingjiaView  extends XinyupingjiaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XinyupingjiaView(){
	}
 
 	public XinyupingjiaView(XinyupingjiaEntity xinyupingjiaEntity){
 	try {
			BeanUtils.copyProperties(this, xinyupingjiaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
