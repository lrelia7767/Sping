package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DaochangxinxiDao;
import com.entity.DaochangxinxiEntity;
import com.service.DaochangxinxiService;
import com.entity.vo.DaochangxinxiVO;
import com.entity.view.DaochangxinxiView;

@Service("daochangxinxiService")
public class DaochangxinxiServiceImpl extends ServiceImpl<DaochangxinxiDao, DaochangxinxiEntity> implements DaochangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DaochangxinxiEntity> page = this.selectPage(
                new Query<DaochangxinxiEntity>(params).getPage(),
                new EntityWrapper<DaochangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DaochangxinxiEntity> wrapper) {
		  Page<DaochangxinxiView> page =new Query<DaochangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DaochangxinxiVO> selectListVO(Wrapper<DaochangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DaochangxinxiVO selectVO(Wrapper<DaochangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DaochangxinxiView> selectListView(Wrapper<DaochangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DaochangxinxiView selectView(Wrapper<DaochangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
