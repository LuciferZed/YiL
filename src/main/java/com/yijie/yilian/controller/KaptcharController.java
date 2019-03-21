package com.yijie.yilian.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.impl.DefaultKaptcha;

@Controller
public class KaptcharController {

	@Resource
	private DefaultKaptcha defaultKaptcha;  	
	
	/**
	 * @描述 Kaptcha验证码生成
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws Exception
	 */
	@RequestMapping("/defaultKaptcha")
	public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		byte[] captchaChallengeAsJpeg = null;
		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		try {
			// 生产验证码字符串并保存到session中
			String createText = defaultKaptcha.createText();
			httpServletRequest.getSession().setAttribute("verifyCode", createText);
			// 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
			BufferedImage challenge = defaultKaptcha.createImage(createText);
			ImageIO.write(challenge, "jpg", jpegOutputStream);
		} catch (IllegalArgumentException e) {
			httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		// 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
		captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
		httpServletResponse.setHeader("Cache-Control", "no-store");
		httpServletResponse.setHeader("Pragma", "no-cache");
		httpServletResponse.setDateHeader("Expires", 0);
		httpServletResponse.setContentType("image/jpeg");
		ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
		responseOutputStream.write(captchaChallengeAsJpeg);
		responseOutputStream.flush();
		responseOutputStream.close();
	}
	
	
	/**
	 * @描述 Kaptcha验证
	 * @param request
	 * @param existCode
	 * @return
	 */
	@RequestMapping("/kaptchaExist")
	@ResponseBody
	public Map<String,Object> kaptchaExist(HttpServletRequest request,@RequestBody String existCode){
		Map<String,Object> result = new HashMap<String,Object>();
		Integer code = 0;
		if(existCode != null && !existCode.equals("")){
			//取出生成的验证码
			String verifyCode = (String)request.getSession().getAttribute("verifyCode");
			if(existCode.equals(verifyCode)){
				code = 1;
				//若验证通过，清除session中验证码参数
				request.getSession().removeAttribute("verifyCode");
			}
		}
		result.put("code", code);
		return result;
	}
}
