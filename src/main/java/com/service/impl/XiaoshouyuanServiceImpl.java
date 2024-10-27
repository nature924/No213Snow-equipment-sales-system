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


import com.dao.XiaoshouyuanDao;
import com.entity.XiaoshouyuanEntity;
import com.service.XiaoshouyuanService;
import com.entity.vo.XiaoshouyuanVO;
import com.entity.view.XiaoshouyuanView;

@Service("xiaoshouyuanService")
public class XiaoshouyuanServiceImpl extends ServiceImpl<XiaoshouyuanDao, XiaoshouyuanEntity> implements XiaoshouyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XiaoshouyuanEntity> page = this.selectPage(
                new Query<XiaoshouyuanEntity>(params).getPage(),
                new EntityWrapper<XiaoshouyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XiaoshouyuanEntity> wrapper) {
		  Page<XiaoshouyuanView> page =new Query<XiaoshouyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<XiaoshouyuanVO> selectListVO(Wrapper<XiaoshouyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XiaoshouyuanVO selectVO(Wrapper<XiaoshouyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XiaoshouyuanView> selectListView(Wrapper<XiaoshouyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XiaoshouyuanView selectView(Wrapper<XiaoshouyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
