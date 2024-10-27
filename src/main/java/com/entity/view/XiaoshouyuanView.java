package com.entity.view;

import com.entity.XiaoshouyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 销售员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
@TableName("xiaoshouyuan")
public class XiaoshouyuanView  extends XiaoshouyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XiaoshouyuanView(){
	}
 
 	public XiaoshouyuanView(XiaoshouyuanEntity xiaoshouyuanEntity){
 	try {
			BeanUtils.copyProperties(this, xiaoshouyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
