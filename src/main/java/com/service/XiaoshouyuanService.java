package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XiaoshouyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XiaoshouyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XiaoshouyuanView;


/**
 * 销售员
 *
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
public interface XiaoshouyuanService extends IService<XiaoshouyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XiaoshouyuanVO> selectListVO(Wrapper<XiaoshouyuanEntity> wrapper);
   	
   	XiaoshouyuanVO selectVO(@Param("ew") Wrapper<XiaoshouyuanEntity> wrapper);
   	
   	List<XiaoshouyuanView> selectListView(Wrapper<XiaoshouyuanEntity> wrapper);
   	
   	XiaoshouyuanView selectView(@Param("ew") Wrapper<XiaoshouyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XiaoshouyuanEntity> wrapper);
   	

}

