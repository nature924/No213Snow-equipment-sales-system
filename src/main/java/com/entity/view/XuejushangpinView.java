package com.entity.view;

import com.entity.XuejushangpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 雪具商品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
@TableName("xuejushangpin")
public class XuejushangpinView  extends XuejushangpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XuejushangpinView(){
	}
 
 	public XuejushangpinView(XuejushangpinEntity xuejushangpinEntity){
 	try {
			BeanUtils.copyProperties(this, xuejushangpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
