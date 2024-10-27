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


import com.dao.XuejufenleiDao;
import com.entity.XuejufenleiEntity;
import com.service.XuejufenleiService;
import com.entity.vo.XuejufenleiVO;
import com.entity.view.XuejufenleiView;

@Service("xuejufenleiService")
public class XuejufenleiServiceImpl extends ServiceImpl<XuejufenleiDao, XuejufenleiEntity> implements XuejufenleiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XuejufenleiEntity> page = this.selectPage(
                new Query<XuejufenleiEntity>(params).getPage(),
                new EntityWrapper<XuejufenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XuejufenleiEntity> wrapper) {
		  Page<XuejufenleiView> page =new Query<XuejufenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XuejufenleiVO> selectListVO(Wrapper<XuejufenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XuejufenleiVO selectVO(Wrapper<XuejufenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XuejufenleiView> selectListView(Wrapper<XuejufenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XuejufenleiView selectView(Wrapper<XuejufenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
