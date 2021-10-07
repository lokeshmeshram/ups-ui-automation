package com.ups.automation.utils;

import java.util.List;
import java.util.Map;

public class AutomationUtils {
	
	public  static boolean isEmpty(Object o) {
		if(o == null) {
			return true;
		}
		if(o instanceof String) {
			String s = (String) o;
			return s.isEmpty();
		}
		if(o instanceof List) {
			List s = (List) o;
			return s.isEmpty();
		}
		if(o instanceof Map) {
			Map s = (Map) o;
			return s.isEmpty();
		}
		return false;
	}
	
	public  static boolean isNotEmpty(Object o) {
		return !isEmpty(o);
	}
}
