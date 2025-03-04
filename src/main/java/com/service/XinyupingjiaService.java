package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XinyupingjiaEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XinyupingjiaVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XinyupingjiaView;


/**
 * 信誉评价
 *
 * @author 
 * @email 
 * @date 2024-05-08 20:55:40
 */
public interface XinyupingjiaService extends IService<XinyupingjiaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinyupingjiaVO> selectListVO(Wrapper<XinyupingjiaEntity> wrapper);
   	
   	XinyupingjiaVO selectVO(@Param("ew") Wrapper<XinyupingjiaEntity> wrapper);
   	
   	List<XinyupingjiaView> selectListView(Wrapper<XinyupingjiaEntity> wrapper);
   	
   	XinyupingjiaView selectView(@Param("ew") Wrapper<XinyupingjiaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinyupingjiaEntity> wrapper);

   	

}

