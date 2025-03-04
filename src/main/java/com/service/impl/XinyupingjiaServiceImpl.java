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


import com.dao.XinyupingjiaDao;
import com.entity.XinyupingjiaEntity;
import com.service.XinyupingjiaService;
import com.entity.vo.XinyupingjiaVO;
import com.entity.view.XinyupingjiaView;

@Service("xinyupingjiaService")
public class XinyupingjiaServiceImpl extends ServiceImpl<XinyupingjiaDao, XinyupingjiaEntity> implements XinyupingjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinyupingjiaEntity> page = this.selectPage(
                new Query<XinyupingjiaEntity>(params).getPage(),
                new EntityWrapper<XinyupingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinyupingjiaEntity> wrapper) {
		  Page<XinyupingjiaView> page =new Query<XinyupingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<XinyupingjiaVO> selectListVO(Wrapper<XinyupingjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XinyupingjiaVO selectVO(Wrapper<XinyupingjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XinyupingjiaView> selectListView(Wrapper<XinyupingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinyupingjiaView selectView(Wrapper<XinyupingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
