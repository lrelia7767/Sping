package com.dao;

import com.entity.DaochangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DaochangxinxiVO;
import com.entity.view.DaochangxinxiView;


/**
 * 到场信息
 * 
 * @author 
 * @email 
 * @date 2024-05-08 20:55:39
 */
public interface DaochangxinxiDao extends BaseMapper<DaochangxinxiEntity> {
	
	List<DaochangxinxiVO> selectListVO(@Param("ew") Wrapper<DaochangxinxiEntity> wrapper);
	
	DaochangxinxiVO selectVO(@Param("ew") Wrapper<DaochangxinxiEntity> wrapper);
	
	List<DaochangxinxiView> selectListView(@Param("ew") Wrapper<DaochangxinxiEntity> wrapper);

	List<DaochangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DaochangxinxiEntity> wrapper);

	
	DaochangxinxiView selectView(@Param("ew") Wrapper<DaochangxinxiEntity> wrapper);
	

}
