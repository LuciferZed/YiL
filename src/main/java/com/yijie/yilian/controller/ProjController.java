package com.yijie.yilian.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.yilian.model.Proj;
import com.yijie.yilian.model.ProjPic;

/**
 * @描述 项目功能块
 * @author Lucifer
 *
 */
@RestController
@RequestMapping("/projhandle")
public class ProjController {
	
	@RequestMapping("/test")
	@ResponseBody
	public void test(@RequestBody Proj proj){
		System.err.println(proj);
		for(ProjPic pc : proj.getProjPic()){
			System.err.println(pc);
		}
	}

}
