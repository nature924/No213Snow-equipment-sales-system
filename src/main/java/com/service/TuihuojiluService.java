package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TuihuojiluEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TuihuojiluVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TuihuojiluView;


/**
 * 退货记录
 *
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
public interface TuihuojiluService extends IService<TuihuojiluEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TuihuojiluVO> selectListVO(Wrapper<TuihuojiluEntity> wrapper);
   	
   	TuihuojiluVO selectVO(@Param("ew") Wrapper<TuihuojiluEntity> wrapper);
   	
   	List<TuihuojiluView> selectListView(Wrapper<TuihuojiluEntity> wrapper);
   	
   	TuihuojiluView selectView(@Param("ew") Wrapper<TuihuojiluEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TuihuojiluEntity> wrapper);
   	

}

