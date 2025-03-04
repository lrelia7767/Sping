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

import com.entity.XinyupingjiaEntity;
import com.entity.view.XinyupingjiaView;

import com.service.XinyupingjiaService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 信誉评价
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-08 20:55:40
 */
@RestController
@RequestMapping("/xinyupingjia")
public class XinyupingjiaController {
    @Autowired
    private XinyupingjiaService xinyupingjiaService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinyupingjiaEntity xinyupingjia,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xinyupingjia.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XinyupingjiaEntity> ew = new EntityWrapper<XinyupingjiaEntity>();

		PageUtils page = xinyupingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinyupingjia), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinyupingjiaEntity xinyupingjia, 
		HttpServletRequest request){
        EntityWrapper<XinyupingjiaEntity> ew = new EntityWrapper<XinyupingjiaEntity>();

		PageUtils page = xinyupingjiaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinyupingjia), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinyupingjiaEntity xinyupingjia){
       	EntityWrapper<XinyupingjiaEntity> ew = new EntityWrapper<XinyupingjiaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinyupingjia, "xinyupingjia")); 
        return R.ok().put("data", xinyupingjiaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinyupingjiaEntity xinyupingjia){
        EntityWrapper< XinyupingjiaEntity> ew = new EntityWrapper< XinyupingjiaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinyupingjia, "xinyupingjia")); 
		XinyupingjiaView xinyupingjiaView =  xinyupingjiaService.selectView(ew);
		return R.ok("查询信誉评价成功").put("data", xinyupingjiaView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinyupingjiaEntity xinyupingjia = xinyupingjiaService.selectById(id);
        return R.ok().put("data", xinyupingjia);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinyupingjiaEntity xinyupingjia = xinyupingjiaService.selectById(id);
        return R.ok().put("data", xinyupingjia);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XinyupingjiaEntity xinyupingjia, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xinyupingjia);
        xinyupingjiaService.insert(xinyupingjia);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XinyupingjiaEntity xinyupingjia, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xinyupingjia);
        xinyupingjiaService.insert(xinyupingjia);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XinyupingjiaEntity xinyupingjia, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinyupingjia);
        xinyupingjiaService.updateById(xinyupingjia);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xinyupingjiaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
