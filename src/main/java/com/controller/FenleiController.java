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

import com.entity.FenleiEntity;
import com.entity.view.FenleiView;

import com.service.FenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-08 20:55:39
 */
@RestController
@RequestMapping("/fenlei")
public class FenleiController {
    @Autowired
    private FenleiService fenleiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FenleiEntity fenlei,
		HttpServletRequest request){
        EntityWrapper<FenleiEntity> ew = new EntityWrapper<FenleiEntity>();

		PageUtils page = fenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FenleiEntity fenlei, 
		HttpServletRequest request){
        EntityWrapper<FenleiEntity> ew = new EntityWrapper<FenleiEntity>();

		PageUtils page = fenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fenlei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FenleiEntity fenlei){
       	EntityWrapper<FenleiEntity> ew = new EntityWrapper<FenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fenlei, "fenlei")); 
        return R.ok().put("data", fenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FenleiEntity fenlei){
        EntityWrapper< FenleiEntity> ew = new EntityWrapper< FenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fenlei, "fenlei")); 
		FenleiView fenleiView =  fenleiService.selectView(ew);
		return R.ok("查询分类成功").put("data", fenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FenleiEntity fenlei = fenleiService.selectById(id);
        return R.ok().put("data", fenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FenleiEntity fenlei = fenleiService.selectById(id);
        return R.ok().put("data", fenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FenleiEntity fenlei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fenlei);
        fenleiService.insert(fenlei);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FenleiEntity fenlei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fenlei);
        fenleiService.insert(fenlei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FenleiEntity fenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fenlei);
        fenleiService.updateById(fenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
