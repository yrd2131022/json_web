package com.yrd.json.fast_json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class TestFastJson {
	
	public static Date getDate() {
		Date date = new Date();
		return date;
	}
	
	//java中的集合List，序列化为Json格式字符串
	public static void testListToJson() {
		//集合list，存储Student对象
		List<Student> list = new ArrayList<Student>();
		
		Student student = new Student();
		student.setName("张三");
		student.setId(1);
		student.setAge(23);
		student.setEmail("zs@sina.com");
		student.setBirthday(getDate());
		
		Student student2 = new Student();
		student2.setName("凤飞飞是");
		student2.setId(2);
		student2.setAge(33);
		student2.setEmail("zs@sina.com");
		student2.setBirthday(getDate());
		
		list.add(student);
		list.add(student2);
		
		String jsonString = JSON.toJSONString(list);
		System.out.println(jsonString);
		//转换之后的结果，是数组。数组的元素是对象
		//[{"age":23,"birthday":1624350920626,"email":"zs@sina.com","id":1,"name":"张三"},
		//{"age":33,"birthday":1624350920626,"email":"zs@sina.com","id":2,"name":"凤飞飞是"}]
		
		
		
	}
	
	//Java中的对象，Student对象，序列化为Json格式字符串
	public static void testObjectToJson() {
		Student student = new Student();
		student.setName("张三");
		student.setId(1);
		student.setAge(23);
		student.setEmail("zs@sina.com");
		student.setBirthday(getDate());
		//student 对象，转到json格式字符串
		
		String jsonString = JSON.toJSONString(student);
		System.out.println(jsonString);
		//{"age":23,"birthday":1624350428613,"email":"zs@sina.com","id":1,"name":"张三"}
	}
	
	//java中的集合map，序列化为json格式字符串
	public static void testMapToJson() {
		Map<String, Student> map = new ConcurrentHashMap<String, Student>();
		Student student = new Student();
		student.setName("张三");
		student.setId(1);
		student.setAge(23);
		student.setEmail("zs@sina.com");
		student.setBirthday(getDate());
		
		Student student2 = new Student();
		student2.setName("凤飞飞是");
		student2.setId(2);
		student2.setAge(33);
//		student2.setEmail("zs@sina.com");
		student2.setBirthday(getDate());
		map.put("student1",student);
		map.put("student2", student2);
		
		String jsonString = JSON.toJSONString(map);
		System.out.println(jsonString);
		//{"student2":{"age":33,"birthday":1624351275643,"email":"zs@sina.com","id":2,"name":"凤飞飞是"},"student1":{"age":23,"birthday":1624351275643,"email":"zs@sina.com","id":1,"name":"张三"}}
		
	}
	
	//Json格式字符串，反序列化回到java对象
	//json-->object
	public  static void testJsonToObject() {
		String jsonString = "{\"age\":23,\"birthday\":1624350428613,\"email\":\"zs@sina.com\",\"id\":1,\"name\":\"张三\"}";
		
		//Json类的静态方法 parseObject
		//传递要反序列化的json字符串，传递java对象的class
		Student student = JSON.parseObject(jsonString,Student.class);
		System.out.println(student);
		
	}
	
	//json-->list
	public static void testJsonToList() {
		String jsonString = "[{\"age\":23,\"birthday\":1624350920626,\"email\":\"zs@sina.com\",\"id\":1,\"name\":\"张三\"},{\"age\":33,\"birthday\":1624350920626,\"email\":\"zs@sina.com\",\"id\":2,\"name\":\"凤飞飞是\"}]";
		
		List<Student> parseArray = JSON.parseArray(jsonString, Student.class);
		List<Student> list = JSON.parseObject(jsonString,new TypeReference<List<Student>>() {});
		System.out.println(list);
		System.out.println(parseArray);
//		for (Student student : parseArray) {
//			System.out.println(student);
//		}
	}
	
	//json-->map
	public static void testJsonToMap() {
		String jsonString ="{\"student2\":{\"age\":33,\"birthday\":1624351275643,\"email\":\"zs@sina.com\",\"id\":2,\"name\":\"凤飞飞是\"},\"student1\":{\"age\":23,\"birthday\":1624351275643,\"email\":\"zs@sina.com\",\"id\":1,\"name\":\"张三\"}}";
		
		//直接进行反序列化，Map集合没有泛型的,没有泛型是不安全的
		//转换后的集合，必须要有集合
		//调用parseObject,传递参数，TypeReference类型
		//new TypeReference<Map<String, Student>>(){}这里加上大括号
		Map<String, Student> map = JSON.parseObject(jsonString, new TypeReference<Map<String, Student>>(){});
		for (String key : map.keySet()) {
			System.out.println(key+":"+map.get(key));
		}
	}
	
	public static void main(String[] args) {
		testMapToJson();
	}

}
