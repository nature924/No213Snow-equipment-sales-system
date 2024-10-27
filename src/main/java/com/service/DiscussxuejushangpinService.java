package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussxuejushangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussxuejushangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussxuejushangpinView;


/**
 * 雪具商品评论表
 *
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
public interface DiscussxuejushangpinService extends IService<DiscussxuejushangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxuejushangpinVO> selectListVO(Wrapper<DiscussxuejushangpinEntity> wrapper);
   	
   	DiscussxuejushangpinVO selectVO(@Param("ew") Wrapper<DiscussxuejushangpinEntity> wrapper);
   	
   	List<DiscussxuejushangpinView> selectListView(Wrapper<DiscussxuejushangpinEntity> wrapper);
   	
   	DiscussxuejushangpinView selectView(@Param("ew") Wrapper<DiscussxuejushangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxuejushangpinEntity> wrapper);
   	

}

