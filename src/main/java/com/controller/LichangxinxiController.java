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

import com.entity.LichangxinxiEntity;
import com.entity.view.LichangxinxiView;

import com.service.LichangxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 离场信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-08 20:55:39
 */
@RestController
@RequestMapping("/lichangxinxi")
public class LichangxinxiController {
    @Autowired
    private LichangxinxiService lichangxinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LichangxinxiEntity lichangxinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			lichangxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<LichangxinxiEntity> ew = new EntityWrapper<LichangxinxiEntity>();

		PageUtils page = lichangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lichangxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LichangxinxiEntity lichangxinxi, 
		HttpServletRequest request){
        EntityWrapper<LichangxinxiEntity> ew = new EntityWrapper<LichangxinxiEntity>();

		PageUtils page = lichangxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lichangxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LichangxinxiEntity lichangxinxi){
       	EntityWrapper<LichangxinxiEntity> ew = new EntityWrapper<LichangxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lichangxinxi, "lichangxinxi")); 
        return R.ok().put("data", lichangxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LichangxinxiEntity lichangxinxi){
        EntityWrapper< LichangxinxiEntity> ew = new EntityWrapper< LichangxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lichangxinxi, "lichangxinxi")); 
		LichangxinxiView lichangxinxiView =  lichangxinxiService.selectView(ew);
		return R.ok("查询离场信息成功").put("data", lichangxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LichangxinxiEntity lichangxinxi = lichangxinxiService.selectById(id);
        return R.ok().put("data", lichangxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LichangxinxiEntity lichangxinxi = lichangxinxiService.selectById(id);
        return R.ok().put("data", lichangxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LichangxinxiEntity lichangxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(lichangxinxi);
        lichangxinxiService.insert(lichangxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LichangxinxiEntity lichangxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(lichangxinxi);
        lichangxinxiService.insert(lichangxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LichangxinxiEntity lichangxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lichangxinxi);
        lichangxinxiService.updateById(lichangxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lichangxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
