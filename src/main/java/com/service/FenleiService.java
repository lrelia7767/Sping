package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FenleiView;


/**
 * 分类
 *
 * @author 
 * @email 
 * @date 2024-05-08 20:55:39
 */
public interface FenleiService extends IService<FenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FenleiVO> selectListVO(Wrapper<FenleiEntity> wrapper);
   	
   	FenleiVO selectVO(@Param("ew") Wrapper<FenleiEntity> wrapper);
   	
   	List<FenleiView> selectListView(Wrapper<FenleiEntity> wrapper);
   	
   	FenleiView selectView(@Param("ew") Wrapper<FenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FenleiEntity> wrapper);

   	

}

