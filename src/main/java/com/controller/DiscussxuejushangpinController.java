package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussxuejushangpinEntity;
import com.entity.view.DiscussxuejushangpinView;

import com.service.DiscussxuejushangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 雪具商品评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
@RestController
@RequestMapping("/discussxuejushangpin")
public class DiscussxuejushangpinController {
    @Autowired
    private DiscussxuejushangpinService discussxuejushangpinService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussxuejushangpinEntity discussxuejushangpin,
		HttpServletRequest request){
        EntityWrapper<DiscussxuejushangpinEntity> ew = new EntityWrapper<DiscussxuejushangpinEntity>();

		PageUtils page = discussxuejushangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxuejushangpin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussxuejushangpinEntity discussxuejushangpin, 
		HttpServletRequest request){
        EntityWrapper<DiscussxuejushangpinEntity> ew = new EntityWrapper<DiscussxuejushangpinEntity>();

		PageUtils page = discussxuejushangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxuejushangpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussxuejushangpinEntity discussxuejushangpin){
       	EntityWrapper<DiscussxuejushangpinEntity> ew = new EntityWrapper<DiscussxuejushangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussxuejushangpin, "discussxuejushangpin")); 
        return R.ok().put("data", discussxuejushangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussxuejushangpinEntity discussxuejushangpin){
        EntityWrapper< DiscussxuejushangpinEntity> ew = new EntityWrapper< DiscussxuejushangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussxuejushangpin, "discussxuejushangpin")); 
		DiscussxuejushangpinView discussxuejushangpinView =  discussxuejushangpinService.selectView(ew);
		return R.ok("查询雪具商品评论表成功").put("data", discussxuejushangpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussxuejushangpinEntity discussxuejushangpin = discussxuejushangpinService.selectById(id);
        return R.ok().put("data", discussxuejushangpin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussxuejushangpinEntity discussxuejushangpin = discussxuejushangpinService.selectById(id);
        return R.ok().put("data", discussxuejushangpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussxuejushangpinEntity discussxuejushangpin, HttpServletRequest request){
    	discussxuejushangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxuejushangpin);
        discussxuejushangpinService.insert(discussxuejushangpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussxuejushangpinEntity discussxuejushangpin, HttpServletRequest request){
    	discussxuejushangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxuejushangpin);
        discussxuejushangpinService.insert(discussxuejushangpin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussxuejushangpinEntity discussxuejushangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussxuejushangpin);
        discussxuejushangpinService.updateById(discussxuejushangpin);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussxuejushangpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<DiscussxuejushangpinEntity> wrapper = new EntityWrapper<DiscussxuejushangpinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussxuejushangpinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
