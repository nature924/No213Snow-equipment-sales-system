package com.entity.model;

import com.entity.JinhuojiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 进货记录
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
public class JinhuojiluModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品图片
	 */
	
	private String shangpintupian;
		
	/**
	 * 进货价格
	 */
	
	private Integer jinhuojiage;
		
	/**
	 * 商品数量
	 */
	
	private Integer alllimittimes;
		
	/**
	 * 订单金额
	 */
	
	private Integer dingdanjine;
		
	/**
	 * 进货日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jinhuoriqi;
		
	/**
	 * 信息备注
	 */
	
	private String xinxibeizhu;
		
	/**
	 * 销售工号
	 */
	
	private String xiaoshougonghao;
		
	/**
	 * 回复内容
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：商品图片
	 */
	 
	public void setShangpintupian(String shangpintupian) {
		this.shangpintupian = shangpintupian;
	}
	
	/**
	 * 获取：商品图片
	 */
	public String getShangpintupian() {
		return shangpintupian;
	}
				
	
	/**
	 * 设置：进货价格
	 */
	 
	public void setJinhuojiage(Integer jinhuojiage) {
		this.jinhuojiage = jinhuojiage;
	}
	
	/**
	 * 获取：进货价格
	 */
	public Integer getJinhuojiage() {
		return jinhuojiage;
	}
				
	
	/**
	 * 设置：商品数量
	 */
	 
	public void setAlllimittimes(Integer alllimittimes) {
		this.alllimittimes = alllimittimes;
	}
	
	/**
	 * 获取：商品数量
	 */
	public Integer getAlllimittimes() {
		return alllimittimes;
	}
				
	
	/**
	 * 设置：订单金额
	 */
	 
	public void setDingdanjine(Integer dingdanjine) {
		this.dingdanjine = dingdanjine;
	}
	
	/**
	 * 获取：订单金额
	 */
	public Integer getDingdanjine() {
		return dingdanjine;
	}
				
	
	/**
	 * 设置：进货日期
	 */
	 
	public void setJinhuoriqi(Date jinhuoriqi) {
		this.jinhuoriqi = jinhuoriqi;
	}
	
	/**
	 * 获取：进货日期
	 */
	public Date getJinhuoriqi() {
		return jinhuoriqi;
	}
				
	
	/**
	 * 设置：信息备注
	 */
	 
	public void setXinxibeizhu(String xinxibeizhu) {
		this.xinxibeizhu = xinxibeizhu;
	}
	
	/**
	 * 获取：信息备注
	 */
	public String getXinxibeizhu() {
		return xinxibeizhu;
	}
				
	
	/**
	 * 设置：销售工号
	 */
	 
	public void setXiaoshougonghao(String xiaoshougonghao) {
		this.xiaoshougonghao = xiaoshougonghao;
	}
	
	/**
	 * 获取：销售工号
	 */
	public String getXiaoshougonghao() {
		return xiaoshougonghao;
	}
				
	
	/**
	 * 设置：回复内容
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：回复内容
	 */
	public String getShhf() {
		return shhf;
	}
			
}
