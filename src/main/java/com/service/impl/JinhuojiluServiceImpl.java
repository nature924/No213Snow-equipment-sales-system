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


import com.dao.JinhuojiluDao;
import com.entity.JinhuojiluEntity;
import com.service.JinhuojiluService;
import com.entity.vo.JinhuojiluVO;
import com.entity.view.JinhuojiluView;

@Service("jinhuojiluService")
public class JinhuojiluServiceImpl extends ServiceImpl<JinhuojiluDao, JinhuojiluEntity> implements JinhuojiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JinhuojiluEntity> page = this.selectPage(
                new Query<JinhuojiluEntity>(params).getPage(),
                new EntityWrapper<JinhuojiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JinhuojiluEntity> wrapper) {
		  Page<JinhuojiluView> page =new Query<JinhuojiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JinhuojiluVO> selectListVO(Wrapper<JinhuojiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JinhuojiluVO selectVO(Wrapper<JinhuojiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JinhuojiluView> selectListView(Wrapper<JinhuojiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JinhuojiluView selectView(Wrapper<JinhuojiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
