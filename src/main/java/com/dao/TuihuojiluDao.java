package com.dao;

import com.entity.TuihuojiluEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TuihuojiluVO;
import com.entity.view.TuihuojiluView;


/**
 * 退货记录
 * 
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
public interface TuihuojiluDao extends BaseMapper<TuihuojiluEntity> {
	
	List<TuihuojiluVO> selectListVO(@Param("ew") Wrapper<TuihuojiluEntity> wrapper);
	
	TuihuojiluVO selectVO(@Param("ew") Wrapper<TuihuojiluEntity> wrapper);
	
	List<TuihuojiluView> selectListView(@Param("ew") Wrapper<TuihuojiluEntity> wrapper);

	List<TuihuojiluView> selectListView(Pagination page,@Param("ew") Wrapper<TuihuojiluEntity> wrapper);
	
	TuihuojiluView selectView(@Param("ew") Wrapper<TuihuojiluEntity> wrapper);
	

}
