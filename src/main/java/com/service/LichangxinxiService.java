package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.LichangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.LichangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.LichangxinxiView;


/**
 * 离场信息
 *
 * @author 
 * @email 
 * @date 2024-05-08 20:55:39
 */
public interface LichangxinxiService extends IService<LichangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<LichangxinxiVO> selectListVO(Wrapper<LichangxinxiEntity> wrapper);
   	
   	LichangxinxiVO selectVO(@Param("ew") Wrapper<LichangxinxiEntity> wrapper);
   	
   	List<LichangxinxiView> selectListView(Wrapper<LichangxinxiEntity> wrapper);
   	
   	LichangxinxiView selectView(@Param("ew") Wrapper<LichangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<LichangxinxiEntity> wrapper);

   	

}

