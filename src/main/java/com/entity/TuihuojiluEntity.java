package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 退货记录
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
@TableName("tuihuojilu")
public class TuihuojiluEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TuihuojiluEntity() {
		
	}
	
	public TuihuojiluEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 商品名称
	 */
					
	private String shangpinmingcheng;
	
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
	 * 退货日期
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date tuihuoriqi;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：商品名称
	 */
	public void setShangpinmingcheng(String shangpinmingcheng) {
		this.shangpinmingcheng = shangpinmingcheng;
	}
	/**
	 * 获取：商品名称
	 */
	public String getShangpinmingcheng() {
		return shangpinmingcheng;
	}
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
	 * 设置：退货日期
	 */
	public void setTuihuoriqi(Date tuihuoriqi) {
		this.tuihuoriqi = tuihuoriqi;
	}
	/**
	 * 获取：退货日期
	 */
	public Date getTuihuoriqi() {
		return tuihuoriqi;
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
