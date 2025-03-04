package com.dao;

import com.entity.XinyupingjiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XinyupingjiaVO;
import com.entity.view.XinyupingjiaView;


/**
 * 信誉评价
 * 
 * @author 
 * @email 
 * @date 2024-05-08 20:55:40
 */
public interface XinyupingjiaDao extends BaseMapper<XinyupingjiaEntity> {
	
	List<XinyupingjiaVO> selectListVO(@Param("ew") Wrapper<XinyupingjiaEntity> wrapper);
	
	XinyupingjiaVO selectVO(@Param("ew") Wrapper<XinyupingjiaEntity> wrapper);
	
	List<XinyupingjiaView> selectListView(@Param("ew") Wrapper<XinyupingjiaEntity> wrapper);

	List<XinyupingjiaView> selectListView(Pagination page,@Param("ew") Wrapper<XinyupingjiaEntity> wrapper);

	
	XinyupingjiaView selectView(@Param("ew") Wrapper<XinyupingjiaEntity> wrapper);
	

}
