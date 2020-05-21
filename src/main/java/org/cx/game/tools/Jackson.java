package org.cx.game.tools;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import lombok.SneakyThrows;

@Component
public class Jackson {

	private ObjectMapper mapper;
	private SimpleFilterProvider filterProvider;
	
	public Jackson() {
		// TODO Auto-generated constructor stub
		mapper = new ObjectMapper();
		
		mapper.findAndRegisterModules();        //自动搜索所有模块
		mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);      //允许序列化没有属性的空对象
		//mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);   //当JSON和java类不完全对应时，需要禁用
		
		filterProvider = new SimpleFilterProvider();
		mapper.setFilterProvider(filterProvider);      //添加过滤器
	}
	
	/**
	 * 添加过滤器
	 * @param filterName 过滤器名称
	 * @param properties 需要保留的属性
	 * @return
	 */
	public Jackson addFilter(String filterName, String...properties) {
		filterProvider.addFilter(filterName, SimpleBeanPropertyFilter.filterOutAllExcept(properties));
		return this;
	}
	
	@SneakyThrows
	public String toJson(Object obj) {
		return mapper.writeValueAsString(obj);
	}
	
	@SneakyThrows
	public <T> T parseObject(String content, Class<T> type) {
		return mapper.readValue(content, type);
	}
	
	@SneakyThrows
	public <T> T parseObject(String content, TypeReference<T> typeRef) {
		return mapper.readValue(content, typeRef);
	}
	
	@SneakyThrows
	public Map<String, Object> parseObject(String content) {
		return mapper.readValue(content, Map.class);
	}
	
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		Boolean f = Boolean.FALSE;
		map.put("bool", f);
		Jackson j = new Jackson();
		System.out.println(j.toJson(map));
	}
}
