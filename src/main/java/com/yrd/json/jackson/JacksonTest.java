package com.yrd.json.jackson;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 1.java 转 json  ：writeValue,writeValueAsString
 * 2.json 转 java  :readValue(json字符串数据，Class)
 * @ClassName:JacksonTest
 * @Description:
 *
 * @author:Yrd
 * @date:2021-6-20 20:32:41
 *
 */
public class JacksonTest {
	
	//java对象转为JSON字符串
	public static void java_to_json() throws IOException {
		//1.创建Person对象
		Person objPerson = new Person();
		objPerson.setName("张三");
//		objPerson.setAge(11);
		objPerson.setGender("男");
//		objPerson.setId(2);
		
		Person objPerson1 = new Person();
		objPerson1.setName("李四");
		objPerson1.setAge(22);
		objPerson1.setGender("男");
		
		Person objPerson2 = new Person();
		objPerson2.setName("王五");
		objPerson2.setAge(33);
		objPerson2.setGender("男");
		
		//2.创建jackson的核心对象   ,  ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		
		//3.转换
		/*
		 * .转换方法：  writeValue(参数1，obj)
		 * 				参数1：File:将obj对象转换为json字符串，并保持到指定的文件中
		 * 						Writer:将obj对象转换为json字符串，并将json数据填充到字符输出流中
		 * 						OutputStream:将obj对象转换为json字符串，并将json数据填充到字节输出流中
		 * 			  writeValueAsString(obj):将对象转为json字符串
		 * 
		 * .注解：
		 * 		1.@jsonIgnore：排除属性,忽略该属性(person.java)
		 * 		2.@JsonFormat:属性值的格式化
		 */
		String jsonString = mapper.writeValueAsString(objPerson);
		mapper.writeValue(new File("./java-to-json.txt"), objPerson);
		System.out.println(jsonString);
	}
	
	
	
	//java对象转为JSON字符串,,，person.java加注解
		public void java_to_json_annotion() throws IOException {
			//1.创建Person对象
			Person objPerson = new Person();
			objPerson.setName("张三");
			objPerson.setAge(33);
			objPerson.setGender("男");
			//时间输出格式化（person.java中）
			objPerson.setBirthday(new Date());
			
			//2.创建jackson的核心对象   ,  ObjectMapper
			ObjectMapper mapper = new ObjectMapper();
			
			//3.转换
			String jsonString = mapper.writeValueAsString(objPerson);
			System.out.println(jsonString);
		}
	
	
		//java对象转为JSON字符串
		public void javaList_to_json() throws IOException {
			//1.创建Person对象
			Person objPerson = new Person();
			objPerson.setName("张三");
			objPerson.setAge(11);
			objPerson.setGender("男");
			
			Person objPerson1 = new Person();
			objPerson1.setName("李四");
			objPerson1.setAge(22);
			objPerson1.setGender("男");
			
			Person objPerson2 = new Person();
			objPerson2.setName("王五");
			objPerson2.setAge(33);
			objPerson2.setGender("男");
			
			
			//创建list集合
			List<Person> ps = new ArrayList<Person>();
			ps.add(objPerson);
			ps.add(objPerson1);
			ps.add(objPerson2);
			
			//2.创建jackson的核心对象   ,  ObjectMapper
			ObjectMapper mapper = new ObjectMapper();
			
			String jsonString = mapper.writeValueAsString(ps);
			mapper.writeValue(new File("./java-to-json.txt"), ps);
			System.out.println(jsonString);
		}
	
		//java对象转为JSON字符串
		public void javaMap_to_json() throws IOException {
			//1.创建map对象
			Map<String, Object> map = new ConcurrentHashMap<String, Object>();
			map.put("name", "神兽");
			map.put("age",22);
			map.put("gender", "女");
			
			//2.创建jackson的核心对象   ,  ObjectMapper
			ObjectMapper mapper = new ObjectMapper();
			
			String jsonString = mapper.writeValueAsString(map);
			mapper.writeValue(new File("./java-to-json.txt"), map);
			System.out.println(jsonString);
		}
		
		//java对象转为JSON字符串
				public void javaListMap_to_json() throws IOException {
					
					List<Map<String, Object>> mapList = new LinkedList<Map<String,Object>>();
					List<Map<String, Object>> mapList2 = new LinkedList<Map<String,Object>>();
					
					for (int i = 0; i < 3; i++) {
						//1.创建map对象
						Map<String, Object> map = new ConcurrentHashMap<String, Object>();
						map.put("name", "神兽"+(i+1));
						map.put("age",22);
						map.put("gender", "女");
						mapList.add(map);
//						System.out.println(map);
					}
					mapList2.addAll(mapList);
//					System.out.println(mapList2);
					
					//2.创建jackson的核心对象   ,  ObjectMapper
					ObjectMapper mapper = new ObjectMapper();
					
					String jsonString = mapper.writeValueAsString(mapList);
					mapper.writeValue(new File("./java-to-json.txt"),mapList);
					System.out.println(jsonString);
					
//					mapper.readValue(p, valueType)
				}
		
		//============================================================================
		//json--> object
		public void json_to_java() throws IOException {
			//1.初始化json字符串
			String json = "{\"name\":\"神兽\",\"age\":292,\"gender\":\"女\"}";
			
			//2.创建jackson的核心对象   ,  ObjectMapper
			ObjectMapper mapper = new ObjectMapper();
			
			 Person readValue = mapper.readValue(json, Person.class);
			Person readValue2 = mapper.readValue(new File("./java-to-json.txt"), Person.class);
			System.out.println(readValue);
			System.out.println(readValue2);
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			cal.add(Calendar.DAY_OF_MONTH, -1);
			System.out.println(dateFormat.format(cal.getTime()));
			
		}
		
		//json-->map
		public static void json_to_map() {
			String jsonString = "{\"gender\":\"女\",\"name\":\"神兽\",\"age\":22}";
			
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				Map<String, Object> map = mapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {});
				System.out.println(map);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
		
		//json-->list
		public static void json_to_list() {
			String jsonString ="[{\"gender\":\"女\",\"name\":\"神兽1\",\"age\":22},{\"gender\":\"女\",\"name\":\"神兽2\",\"age\":22},{\"gender\":\"女\",\"name\":\"神兽3\",\"age\":22}]";
			
			ObjectMapper mapper = new ObjectMapper();
			
			try {
				List<Map<String,Object>> readValue = mapper.readValue(jsonString, new TypeReference<List<Map<String, Object>>>() {});
				System.out.println(readValue);
				//[{gender=女, name=神兽1, age=22}, {gender=女, name=神兽2, age=22}, {gender=女, name=神兽3, age=22}]
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		
		
		//java-->JSON    日期格式化
		public static void java_to_json_dateformat() throws IOException {
			//1.创建Person对象
			Person objPerson = new Person();
			objPerson.setName("张三");
			objPerson.setAge(33);
			objPerson.setId(2);
			objPerson.setGender("男");
			//时间输出格式化（person.java中）
			objPerson.setBirthday(new Date());
			
			//2.创建jackson的核心对象   ,  ObjectMapper
			ObjectMapper mapper = new ObjectMapper();
			
			mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			
			//3.转换
			String jsonString = mapper.writeValueAsString(objPerson);
			System.out.println(jsonString);
		}
	
	public static void main(String[] args) throws Exception {
		
	
			

			java_to_json_dateformat();
			
		
	}

}
