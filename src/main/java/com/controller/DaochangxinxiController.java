package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DaochangxinxiEntity;
import com.entity.view.DaochangxinxiView;

import com.service.DaochangxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 到场信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-08 20:55:39
 */
@RestController
@RequestMapping("/daochangxinxi")
public class DaochangxinxiController {
    @Autowired
    private DaochangxinxiService daochangxinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DaochangxinxiEntity daochangxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			daochangxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DaochangxinxiEntity> ew = new EntityWrapper<DaochangxinxiEntity>();

		PageUtils page = daochangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daochangxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DaochangxinxiEntity daochangxinxi, 
		HttpServletRequest request){
        EntityWrapper<DaochangxinxiEntity> ew = new EntityWrapper<DaochangxinxiEntity>();

		PageUtils page = daochangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daochangxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DaochangxinxiEntity daochangxinxi){
       	EntityWrapper<DaochangxinxiEntity> ew = new EntityWrapper<DaochangxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( daochangxinxi, "daochangxinxi")); 
        return R.ok().put("data", daochangxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DaochangxinxiEntity daochangxinxi){
        EntityWrapper< DaochangxinxiEntity> ew = new EntityWrapper< DaochangxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( daochangxinxi, "daochangxinxi")); 
		DaochangxinxiView daochangxinxiView =  daochangxinxiService.selectView(ew);
		return R.ok("查询到场信息成功").put("data", daochangxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DaochangxinxiEntity daochangxinxi = daochangxinxiService.selectById(id);
        return R.ok().put("data", daochangxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DaochangxinxiEntity daochangxinxi = daochangxinxiService.selectById(id);
        return R.ok().put("data", daochangxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DaochangxinxiEntity daochangxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(daochangxinxi);
        daochangxinxiService.insert(daochangxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DaochangxinxiEntity daochangxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(daochangxinxi);
        daochangxinxiService.insert(daochangxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DaochangxinxiEntity daochangxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(daochangxinxi);
        daochangxinxiService.updateById(daochangxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        daochangxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
