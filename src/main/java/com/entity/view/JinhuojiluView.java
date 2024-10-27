package com.entity.view;

import com.entity.JinhuojiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 进货记录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
@TableName("jinhuojilu")
public class JinhuojiluView  extends JinhuojiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JinhuojiluView(){
	}
 
 	public JinhuojiluView(JinhuojiluEntity jinhuojiluEntity){
 	try {
			BeanUtils.copyProperties(this, jinhuojiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
