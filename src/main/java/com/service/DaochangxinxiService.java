package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DaochangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DaochangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DaochangxinxiView;


/**
 * 到场信息
 *
 * @author 
 * @email 
 * @date 2024-05-08 20:55:39
 */
public interface DaochangxinxiService extends IService<DaochangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DaochangxinxiVO> selectListVO(Wrapper<DaochangxinxiEntity> wrapper);
   	
   	DaochangxinxiVO selectVO(@Param("ew") Wrapper<DaochangxinxiEntity> wrapper);
   	
   	List<DaochangxinxiView> selectListView(Wrapper<DaochangxinxiEntity> wrapper);
   	
   	DaochangxinxiView selectView(@Param("ew") Wrapper<DaochangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DaochangxinxiEntity> wrapper);

   	

}

