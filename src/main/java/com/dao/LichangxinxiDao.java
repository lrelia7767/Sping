package com.dao;

import com.entity.LichangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.LichangxinxiVO;
import com.entity.view.LichangxinxiView;


/**
 * 离场信息
 * 
 * @author 
 * @email 
 * @date 2024-05-08 20:55:39
 */
public interface LichangxinxiDao extends BaseMapper<LichangxinxiEntity> {
	
	List<LichangxinxiVO> selectListVO(@Param("ew") Wrapper<LichangxinxiEntity> wrapper);
	
	LichangxinxiVO selectVO(@Param("ew") Wrapper<LichangxinxiEntity> wrapper);
	
	List<LichangxinxiView> selectListView(@Param("ew") Wrapper<LichangxinxiEntity> wrapper);

	List<LichangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<LichangxinxiEntity> wrapper);

	
	LichangxinxiView selectView(@Param("ew") Wrapper<LichangxinxiEntity> wrapper);
	

}
