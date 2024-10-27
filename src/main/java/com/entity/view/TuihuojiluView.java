package com.entity.view;

import com.entity.TuihuojiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 退货记录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
@TableName("tuihuojilu")
public class TuihuojiluView  extends TuihuojiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TuihuojiluView(){
	}
 
 	public TuihuojiluView(TuihuojiluEntity tuihuojiluEntity){
 	try {
			BeanUtils.copyProperties(this, tuihuojiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
