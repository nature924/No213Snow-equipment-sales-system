package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XuejufenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XuejufenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XuejufenleiView;


/**
 * 雪具分类
 *
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
public interface XuejufenleiService extends IService<XuejufenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XuejufenleiVO> selectListVO(Wrapper<XuejufenleiEntity> wrapper);
   	
   	XuejufenleiVO selectVO(@Param("ew") Wrapper<XuejufenleiEntity> wrapper);
   	
   	List<XuejufenleiView> selectListView(Wrapper<XuejufenleiEntity> wrapper);
   	
   	XuejufenleiView selectView(@Param("ew") Wrapper<XuejufenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XuejufenleiEntity> wrapper);
   	

}

