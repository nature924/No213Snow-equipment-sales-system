package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XuejushangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XuejushangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XuejushangpinView;


/**
 * 雪具商品
 *
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
public interface XuejushangpinService extends IService<XuejushangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XuejushangpinVO> selectListVO(Wrapper<XuejushangpinEntity> wrapper);
   	
   	XuejushangpinVO selectVO(@Param("ew") Wrapper<XuejushangpinEntity> wrapper);
   	
   	List<XuejushangpinView> selectListView(Wrapper<XuejushangpinEntity> wrapper);
   	
   	XuejushangpinView selectView(@Param("ew") Wrapper<XuejushangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XuejushangpinEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<XuejushangpinEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<XuejushangpinEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<XuejushangpinEntity> wrapper);



}

