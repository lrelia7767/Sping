package com.dao;

import com.entity.ChangguanxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChangguanxinxiVO;
import com.entity.view.ChangguanxinxiView;


/**
 * 场馆信息
 * 
 * @author 
 * @email 
 * @date 2024-05-08 20:55:39
 */
public interface ChangguanxinxiDao extends BaseMapper<ChangguanxinxiEntity> {
	
	List<ChangguanxinxiVO> selectListVO(@Param("ew") Wrapper<ChangguanxinxiEntity> wrapper);
	
	ChangguanxinxiVO selectVO(@Param("ew") Wrapper<ChangguanxinxiEntity> wrapper);
	
	List<ChangguanxinxiView> selectListView(@Param("ew") Wrapper<ChangguanxinxiEntity> wrapper);

	List<ChangguanxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<ChangguanxinxiEntity> wrapper);

	
	ChangguanxinxiView selectView(@Param("ew") Wrapper<ChangguanxinxiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChangguanxinxiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChangguanxinxiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChangguanxinxiEntity> wrapper);



}
