package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.TuihuojiluDao;
import com.entity.TuihuojiluEntity;
import com.service.TuihuojiluService;
import com.entity.vo.TuihuojiluVO;
import com.entity.view.TuihuojiluView;

@Service("tuihuojiluService")
public class TuihuojiluServiceImpl extends ServiceImpl<TuihuojiluDao, TuihuojiluEntity> implements TuihuojiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TuihuojiluEntity> page = this.selectPage(
                new Query<TuihuojiluEntity>(params).getPage(),
                new EntityWrapper<TuihuojiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TuihuojiluEntity> wrapper) {
		  Page<TuihuojiluView> page =new Query<TuihuojiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TuihuojiluVO> selectListVO(Wrapper<TuihuojiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TuihuojiluVO selectVO(Wrapper<TuihuojiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TuihuojiluView> selectListView(Wrapper<TuihuojiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TuihuojiluView selectView(Wrapper<TuihuojiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
