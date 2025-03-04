package com.dao;

import com.entity.ChangdiguanliyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChangdiguanliyuanVO;
import com.entity.view.ChangdiguanliyuanView;


/**
 * 场地管理员
 * 
 * @author 
 * @email 
 * @date 2024-05-08 20:55:39
 */
public interface ChangdiguanliyuanDao extends BaseMapper<ChangdiguanliyuanEntity> {
	
	List<ChangdiguanliyuanVO> selectListVO(@Param("ew") Wrapper<ChangdiguanliyuanEntity> wrapper);
	
	ChangdiguanliyuanVO selectVO(@Param("ew") Wrapper<ChangdiguanliyuanEntity> wrapper);
	
	List<ChangdiguanliyuanView> selectListView(@Param("ew") Wrapper<ChangdiguanliyuanEntity> wrapper);

	List<ChangdiguanliyuanView> selectListView(Pagination page,@Param("ew") Wrapper<ChangdiguanliyuanEntity> wrapper);

	
	ChangdiguanliyuanView selectView(@Param("ew") Wrapper<ChangdiguanliyuanEntity> wrapper);
	

}
