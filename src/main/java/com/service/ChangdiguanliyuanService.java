package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChangdiguanliyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChangdiguanliyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChangdiguanliyuanView;


/**
 * 场地管理员
 *
 * @author 
 * @email 
 * @date 2024-05-08 20:55:39
 */
public interface ChangdiguanliyuanService extends IService<ChangdiguanliyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChangdiguanliyuanVO> selectListVO(Wrapper<ChangdiguanliyuanEntity> wrapper);
   	
   	ChangdiguanliyuanVO selectVO(@Param("ew") Wrapper<ChangdiguanliyuanEntity> wrapper);
   	
   	List<ChangdiguanliyuanView> selectListView(Wrapper<ChangdiguanliyuanEntity> wrapper);
   	
   	ChangdiguanliyuanView selectView(@Param("ew") Wrapper<ChangdiguanliyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChangdiguanliyuanEntity> wrapper);

   	

}

