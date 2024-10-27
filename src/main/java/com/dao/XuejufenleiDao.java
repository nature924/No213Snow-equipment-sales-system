package com.dao;

import com.entity.XuejufenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XuejufenleiVO;
import com.entity.view.XuejufenleiView;


/**
 * 雪具分类
 * 
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
public interface XuejufenleiDao extends BaseMapper<XuejufenleiEntity> {
	
	List<XuejufenleiVO> selectListVO(@Param("ew") Wrapper<XuejufenleiEntity> wrapper);
	
	XuejufenleiVO selectVO(@Param("ew") Wrapper<XuejufenleiEntity> wrapper);
	
	List<XuejufenleiView> selectListView(@Param("ew") Wrapper<XuejufenleiEntity> wrapper);

	List<XuejufenleiView> selectListView(Pagination page,@Param("ew") Wrapper<XuejufenleiEntity> wrapper);
	
	XuejufenleiView selectView(@Param("ew") Wrapper<XuejufenleiEntity> wrapper);
	

}
