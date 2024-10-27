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


import com.dao.DiscussxuejushangpinDao;
import com.entity.DiscussxuejushangpinEntity;
import com.service.DiscussxuejushangpinService;
import com.entity.vo.DiscussxuejushangpinVO;
import com.entity.view.DiscussxuejushangpinView;

@Service("discussxuejushangpinService")
public class DiscussxuejushangpinServiceImpl extends ServiceImpl<DiscussxuejushangpinDao, DiscussxuejushangpinEntity> implements DiscussxuejushangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxuejushangpinEntity> page = this.selectPage(
                new Query<DiscussxuejushangpinEntity>(params).getPage(),
                new EntityWrapper<DiscussxuejushangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxuejushangpinEntity> wrapper) {
		  Page<DiscussxuejushangpinView> page =new Query<DiscussxuejushangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussxuejushangpinVO> selectListVO(Wrapper<DiscussxuejushangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussxuejushangpinVO selectVO(Wrapper<DiscussxuejushangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussxuejushangpinView> selectListView(Wrapper<DiscussxuejushangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxuejushangpinView selectView(Wrapper<DiscussxuejushangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
