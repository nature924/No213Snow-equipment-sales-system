package com.dao;

import com.entity.DiscussxuejushangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussxuejushangpinVO;
import com.entity.view.DiscussxuejushangpinView;


/**
 * 雪具商品评论表
 * 
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
public interface DiscussxuejushangpinDao extends BaseMapper<DiscussxuejushangpinEntity> {
	
	List<DiscussxuejushangpinVO> selectListVO(@Param("ew") Wrapper<DiscussxuejushangpinEntity> wrapper);
	
	DiscussxuejushangpinVO selectVO(@Param("ew") Wrapper<DiscussxuejushangpinEntity> wrapper);
	
	List<DiscussxuejushangpinView> selectListView(@Param("ew") Wrapper<DiscussxuejushangpinEntity> wrapper);

	List<DiscussxuejushangpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxuejushangpinEntity> wrapper);
	
	DiscussxuejushangpinView selectView(@Param("ew") Wrapper<DiscussxuejushangpinEntity> wrapper);
	

}
