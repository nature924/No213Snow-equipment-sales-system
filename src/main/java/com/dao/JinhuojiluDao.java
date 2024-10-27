package com.dao;

import com.entity.JinhuojiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JinhuojiluVO;
import com.entity.view.JinhuojiluView;


/**
 * 进货记录
 * 
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
public interface JinhuojiluDao extends BaseMapper<JinhuojiluEntity> {
	
	List<JinhuojiluVO> selectListVO(@Param("ew") Wrapper<JinhuojiluEntity> wrapper);
	
	JinhuojiluVO selectVO(@Param("ew") Wrapper<JinhuojiluEntity> wrapper);
	
	List<JinhuojiluView> selectListView(@Param("ew") Wrapper<JinhuojiluEntity> wrapper);

	List<JinhuojiluView> selectListView(Pagination page,@Param("ew") Wrapper<JinhuojiluEntity> wrapper);
	
	JinhuojiluView selectView(@Param("ew") Wrapper<JinhuojiluEntity> wrapper);
	

}
