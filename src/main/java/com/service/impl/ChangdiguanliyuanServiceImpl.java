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


import com.dao.ChangdiguanliyuanDao;
import com.entity.ChangdiguanliyuanEntity;
import com.service.ChangdiguanliyuanService;
import com.entity.vo.ChangdiguanliyuanVO;
import com.entity.view.ChangdiguanliyuanView;

@Service("changdiguanliyuanService")
public class ChangdiguanliyuanServiceImpl extends ServiceImpl<ChangdiguanliyuanDao, ChangdiguanliyuanEntity> implements ChangdiguanliyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChangdiguanliyuanEntity> page = this.selectPage(
                new Query<ChangdiguanliyuanEntity>(params).getPage(),
                new EntityWrapper<ChangdiguanliyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChangdiguanliyuanEntity> wrapper) {
		  Page<ChangdiguanliyuanView> page =new Query<ChangdiguanliyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChangdiguanliyuanVO> selectListVO(Wrapper<ChangdiguanliyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChangdiguanliyuanVO selectVO(Wrapper<ChangdiguanliyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChangdiguanliyuanView> selectListView(Wrapper<ChangdiguanliyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChangdiguanliyuanView selectView(Wrapper<ChangdiguanliyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
