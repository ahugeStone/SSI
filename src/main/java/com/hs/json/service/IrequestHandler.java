package com.hs.json.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IrequestHandler {
	public Map<String, String> result(HttpServletRequest req);
}
