package com.entity.vo;

import com.entity.DaochangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 到场信息
 * @author 
 * @email 
 * @date 2024-05-08 20:55:39
 */
public class DaochangxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 分类
	 */
	
	private String fenlei;
		
	/**
	 * 类型
	 */
	
	private String leixing;
		
	/**
	 * 地址
	 */
	
	private String dizhi;
		
	/**
	 * 预约时间
	 */
	
	private String yuyueshijian;
		
	/**
	 * 账号
	 */
	
	private String zhanghao;
		
	/**
	 * 姓名
	 */
	
	private String xingming;
		
	/**
	 * 手机号码
	 */
	
	private String shoujihaoma;
		
	/**
	 * 备注
	 */
	
	private String beizhu;
		
	/**
	 * 到场时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date daochangshijian;
		
	/**
	 * 离场状态
	 */
	
	private String lichangzhuangtai;
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：分类
	 */
	 
	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}
	
	/**
	 * 获取：分类
	 */
	public String getFenlei() {
		return fenlei;
	}
				
	
	/**
	 * 设置：类型
	 */
	 
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	
	/**
	 * 获取：类型
	 */
	public String getLeixing() {
		return leixing;
	}
				
	
	/**
	 * 设置：地址
	 */
	 
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	
	/**
	 * 获取：地址
	 */
	public String getDizhi() {
		return dizhi;
	}
				
	
	/**
	 * 设置：预约时间
	 */
	 
	public void setYuyueshijian(String yuyueshijian) {
		this.yuyueshijian = yuyueshijian;
	}
	
	/**
	 * 获取：预约时间
	 */
	public String getYuyueshijian() {
		return yuyueshijian;
	}
				
	
	/**
	 * 设置：账号
	 */
	 
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
				
	
	/**
	 * 设置：姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：手机号码
	 */
	 
	public void setShoujihaoma(String shoujihaoma) {
		this.shoujihaoma = shoujihaoma;
	}
	
	/**
	 * 获取：手机号码
	 */
	public String getShoujihaoma() {
		return shoujihaoma;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
	/**
	 * 获取：备注
	 */
	public String getBeizhu() {
		return beizhu;
	}
				
	
	/**
	 * 设置：到场时间
	 */
	 
	public void setDaochangshijian(Date daochangshijian) {
		this.daochangshijian = daochangshijian;
	}
	
	/**
	 * 获取：到场时间
	 */
	public Date getDaochangshijian() {
		return daochangshijian;
	}
				
	
	/**
	 * 设置：离场状态
	 */
	 
	public void setLichangzhuangtai(String lichangzhuangtai) {
		this.lichangzhuangtai = lichangzhuangtai;
	}
	
	/**
	 * 获取：离场状态
	 */
	public String getLichangzhuangtai() {
		return lichangzhuangtai;
	}
			
}
