package com.dao;

import com.entity.XuejushangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XuejushangpinVO;
import com.entity.view.XuejushangpinView;


/**
 * 雪具商品
 * 
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
public interface XuejushangpinDao extends BaseMapper<XuejushangpinEntity> {
	
	List<XuejushangpinVO> selectListVO(@Param("ew") Wrapper<XuejushangpinEntity> wrapper);
	
	XuejushangpinVO selectVO(@Param("ew") Wrapper<XuejushangpinEntity> wrapper);
	
	List<XuejushangpinView> selectListView(@Param("ew") Wrapper<XuejushangpinEntity> wrapper);

	List<XuejushangpinView> selectListView(Pagination page,@Param("ew") Wrapper<XuejushangpinEntity> wrapper);
	
	XuejushangpinView selectView(@Param("ew") Wrapper<XuejushangpinEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XuejushangpinEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XuejushangpinEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XuejushangpinEntity> wrapper);



}
