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

import com.entity.JinhuojiluEntity;
import com.entity.view.JinhuojiluView;

import com.service.JinhuojiluService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 进货记录
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-21 08:53:15
 */
@RestController
@RequestMapping("/jinhuojilu")
public class JinhuojiluController {
    @Autowired
    private JinhuojiluService jinhuojiluService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JinhuojiluEntity jinhuojilu,
		HttpServletRequest request){
        EntityWrapper<JinhuojiluEntity> ew = new EntityWrapper<JinhuojiluEntity>();

		PageUtils page = jinhuojiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinhuojilu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JinhuojiluEntity jinhuojilu, 
		HttpServletRequest request){
        EntityWrapper<JinhuojiluEntity> ew = new EntityWrapper<JinhuojiluEntity>();

		PageUtils page = jinhuojiluService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jinhuojilu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JinhuojiluEntity jinhuojilu){
       	EntityWrapper<JinhuojiluEntity> ew = new EntityWrapper<JinhuojiluEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jinhuojilu, "jinhuojilu")); 
        return R.ok().put("data", jinhuojiluService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JinhuojiluEntity jinhuojilu){
        EntityWrapper< JinhuojiluEntity> ew = new EntityWrapper< JinhuojiluEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jinhuojilu, "jinhuojilu")); 
		JinhuojiluView jinhuojiluView =  jinhuojiluService.selectView(ew);
		return R.ok("查询进货记录成功").put("data", jinhuojiluView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JinhuojiluEntity jinhuojilu = jinhuojiluService.selectById(id);
        return R.ok().put("data", jinhuojilu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JinhuojiluEntity jinhuojilu = jinhuojiluService.selectById(id);
        return R.ok().put("data", jinhuojilu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JinhuojiluEntity jinhuojilu, HttpServletRequest request){
    	jinhuojilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jinhuojilu);
        jinhuojiluService.insert(jinhuojilu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JinhuojiluEntity jinhuojilu, HttpServletRequest request){
    	jinhuojilu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jinhuojilu);
        jinhuojiluService.insert(jinhuojilu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JinhuojiluEntity jinhuojilu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jinhuojilu);
        jinhuojiluService.updateById(jinhuojilu);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jinhuojiluService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<JinhuojiluEntity> wrapper = new EntityWrapper<JinhuojiluEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = jinhuojiluService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	









}
