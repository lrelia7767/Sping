package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChangguanxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChangguanxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChangguanxinxiView;


/**
 * 场馆信息
 *
 * @author 
 * @email 
 * @date 2024-05-08 20:55:39
 */
public interface ChangguanxinxiService extends IService<ChangguanxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChangguanxinxiVO> selectListVO(Wrapper<ChangguanxinxiEntity> wrapper);
   	
   	ChangguanxinxiVO selectVO(@Param("ew") Wrapper<ChangguanxinxiEntity> wrapper);
   	
   	List<ChangguanxinxiView> selectListView(Wrapper<ChangguanxinxiEntity> wrapper);
   	
   	ChangguanxinxiView selectView(@Param("ew") Wrapper<ChangguanxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChangguanxinxiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ChangguanxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ChangguanxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ChangguanxinxiEntity> wrapper);



}

