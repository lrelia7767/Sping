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


import com.dao.LichangxinxiDao;
import com.entity.LichangxinxiEntity;
import com.service.LichangxinxiService;
import com.entity.vo.LichangxinxiVO;
import com.entity.view.LichangxinxiView;

@Service("lichangxinxiService")
public class LichangxinxiServiceImpl extends ServiceImpl<LichangxinxiDao, LichangxinxiEntity> implements LichangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LichangxinxiEntity> page = this.selectPage(
                new Query<LichangxinxiEntity>(params).getPage(),
                new EntityWrapper<LichangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LichangxinxiEntity> wrapper) {
		  Page<LichangxinxiView> page =new Query<LichangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<LichangxinxiVO> selectListVO(Wrapper<LichangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LichangxinxiVO selectVO(Wrapper<LichangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LichangxinxiView> selectListView(Wrapper<LichangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LichangxinxiView selectView(Wrapper<LichangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
