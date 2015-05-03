package com.hs.json.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.hs.json.service.IrequestHandler;
import com.opensymphony.xwork2.Action;

public class HelloWorldJsonAction implements Action {
	private static Logger logger = Logger.getLogger(HelloWorldJsonAction.class);

	private Map<String, String> JSONResult;//结果 struts框架调用直接返回格式化字符串
	
	IrequestHandler reqHandler;//spring注入的处理逻辑

	public void setReqHandler(IrequestHandler reqHandler) {
		this.reqHandler = reqHandler;
	}

	public String execute() throws Exception {
		logger.debug("test in !!!!!");
		this.JSONResult = reqHandler.result(ServletActionContext.getRequest());
		return SUCCESS;
	}

	public Map<String, String> getJSONResult() {
		return JSONResult;
	}

	public void setJSONResult(Map<String, String> jSONResult) {
		JSONResult = jSONResult;
	}
}
