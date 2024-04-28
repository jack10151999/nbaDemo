package com.util;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeUtil {
	
	final static Gson gs = new Gson();
	
	public static String toJson(Object obj) {
		return gs.toJson(obj);
	}
	
	
	/**
	 * 物件轉換
	 * 
	 * @param <T>  目的端物件類
	 * @param to   目的端物件類
	 * @param from 來原端物件類
	 * @return
	 */
	public static <T> T objectCovert(Class<T> to, Object from) {
		String json = null;
		if (from == null) {
			log.error("  from Object is null");
			return null;
		}
		json = gs.toJson(from);
		T t = gs.fromJson(json, to);

		return t;
	}
}
