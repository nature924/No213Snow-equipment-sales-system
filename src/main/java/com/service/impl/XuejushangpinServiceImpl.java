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


import com.dao.XuejushangpinDao;
import com.entity.XuejushangpinEntity;
import com.service.XuejushangpinService;
import com.entity.vo.XuejushangpinVO;
import com.entity.view.XuejushangpinView;

@Service("xuejushangpinService")
public class XuejushangpinServiceImpl extends ServiceImpl<XuejushangpinDao, XuejushangpinEntity> implements XuejushangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XuejushangpinEntity> page = this.selectPage(
                new Query<XuejushangpinEntity>(params).getPage(),
                new EntityWrapper<XuejushangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XuejushangpinEntity> wrapper) {
		  Page<XuejushangpinView> page =new Query<XuejushangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XuejushangpinVO> selectListVO(Wrapper<XuejushangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XuejushangpinVO selectVO(Wrapper<XuejushangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XuejushangpinView> selectListView(Wrapper<XuejushangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XuejushangpinView selectView(Wrapper<XuejushangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<XuejushangpinEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<XuejushangpinEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<XuejushangpinEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
