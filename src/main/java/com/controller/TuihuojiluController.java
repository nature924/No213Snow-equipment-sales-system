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

import com.entity.TuihuojiluEntity;
import com.entity.view.TuihuojiluView;

import com.service.TuihuojiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 退货记录
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
@RestController
@RequestMapping("/tuihuojilu")
public class TuihuojiluController {
    @Autowired
    private TuihuojiluService tuihuojiluService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TuihuojiluEntity tuihuojilu,
		HttpServletRequest request){
        EntityWrapper<TuihuojiluEntity> ew = new EntityWrapper<TuihuojiluEntity>();

		PageUtils page = tuihuojiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuihuojilu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TuihuojiluEntity tuihuojilu, 
		HttpServletRequest request){
        EntityWrapper<TuihuojiluEntity> ew = new EntityWrapper<TuihuojiluEntity>();

		PageUtils page = tuihuojiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tuihuojilu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TuihuojiluEntity tuihuojilu){
       	EntityWrapper<TuihuojiluEntity> ew = new EntityWrapper<TuihuojiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tuihuojilu, "tuihuojilu")); 
        return R.ok().put("data", tuihuojiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TuihuojiluEntity tuihuojilu){
        EntityWrapper< TuihuojiluEntity> ew = new EntityWrapper< TuihuojiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tuihuojilu, "tuihuojilu")); 
		TuihuojiluView tuihuojiluView =  tuihuojiluService.selectView(ew);
		return R.ok("查询退货记录成功").put("data", tuihuojiluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TuihuojiluEntity tuihuojilu = tuihuojiluService.selectById(id);
        return R.ok().put("data", tuihuojilu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TuihuojiluEntity tuihuojilu = tuihuojiluService.selectById(id);
        return R.ok().put("data", tuihuojilu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TuihuojiluEntity tuihuojilu, HttpServletRequest request){
    	tuihuojilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tuihuojilu);
        tuihuojiluService.insert(tuihuojilu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TuihuojiluEntity tuihuojilu, HttpServletRequest request){
    	tuihuojilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tuihuojilu);
        tuihuojiluService.insert(tuihuojilu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TuihuojiluEntity tuihuojilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tuihuojilu);
        tuihuojiluService.updateById(tuihuojilu);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tuihuojiluService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<TuihuojiluEntity> wrapper = new EntityWrapper<TuihuojiluEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = tuihuojiluService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
