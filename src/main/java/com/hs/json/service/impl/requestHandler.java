package com.hs.json.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.hs.json.service.IrequestHandler;

public class requestHandler implements IrequestHandler {
	private static Logger logger = Logger.getLogger(requestHandler.class);
	public Map<String, String> result(HttpServletRequest req) {
		try {
			String reqjsonStr = req.getParameter("json");
			JSONObject reqjsonObj = JSONObject.fromObject(reqjsonStr);
			System.out.println("method:" + reqjsonObj.getString("method"));

			JSONObject reqParamsObj = JSONObject.fromObject(reqjsonObj
					.getString("params"));

			Map<String, String> tmp = new HashMap<String, String>();

			tmp.put("roomlist", reqParamsObj.getString("room"));
			tmp.put("memberlist", reqParamsObj.getString("member"));
			JSONObject jo = JSONObject.fromObject(tmp);
//			this.result = jo.toString();
//			this.JSONResult = tmp;
			return tmp;
		} catch (Exception e) {
			// e.printStackTrace();
			logger.debug("no JSON");
		}
		return null;
	}

}
