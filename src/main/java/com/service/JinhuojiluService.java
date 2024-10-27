package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JinhuojiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JinhuojiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JinhuojiluView;


/**
 * 进货记录
 *
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
public interface JinhuojiluService extends IService<JinhuojiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JinhuojiluVO> selectListVO(Wrapper<JinhuojiluEntity> wrapper);
   	
   	JinhuojiluVO selectVO(@Param("ew") Wrapper<JinhuojiluEntity> wrapper);
   	
   	List<JinhuojiluView> selectListView(Wrapper<JinhuojiluEntity> wrapper);
   	
   	JinhuojiluView selectView(@Param("ew") Wrapper<JinhuojiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JinhuojiluEntity> wrapper);
   	

}

