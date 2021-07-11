package com.yrd.json.fast_json;

import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/*
 * 
 * SerializerFeature枚举：进行序列化时，可以自己定义特殊需求
 * json静态方法  toJSONString()
 *   方法的参数：第一个是要序列化的对象
 *   方法的参数：第二个参数SerializerFeature枚举类型的可变参数
 * 
 * SerializerFeature枚举的常量，做序列化的个性需求
 * 
 */
public class TestFastJson2 {
	
	public static Date getDate() {
		Date date = new Date();
		return date;
	}
	
	//WriteMapNullValue枚举中的常量，序列化null值得字段,
	
	public static void testWriteMapNullValue() {
		Student student = new Student();
		student.setName("张三");
//		student.setId(3);
		student.setAge(23);
		student.setEmail("zs@sina.com");
		student.setBirthday(getDate());
		//空值，不会被序列化
		//{"age":23,"birthday":1624358385223,"email":"zs@sina.com","name":"张三"}
		String jsonString = JSON.toJSONString(student);
		//方法得参数上，添加枚举类型
		//{"age":23,"birthday":1624358385223,"email":"zs@sina.com","id":null,"name":"张三"}
		String jsonString2 = JSON.toJSONString(student,SerializerFeature.WriteMapNullValue);
		
		System.out.println(jsonString);
		System.out.println(jsonString2);
	}
	
	//WriteNullStringAsEmpty枚举中的常量，序列化null字段,值序列化为""
	public static void testWriteNullStringAsEmpty() {
		Student student = new Student();
		student.setName("张三");
		student.setId(3);
		student.setAge(23);
//		student.setEmail("zs@sina.com");
		student.setBirthday(getDate());
		//空值，不会被序列化
		//{"age":23,"birthday":1624358775742,"id":3,"name":"张三"}
		String jsonString = JSON.toJSONString(student);
		//方法得参数上，添加枚举类型
		//{"age":23,"birthday":1624358775742,"email":"","id":3,"name":"张三"}
		String jsonString2 = JSON.toJSONString(student,SerializerFeature.WriteNullStringAsEmpty);
		
		System.out.println(jsonString);
		System.out.println(jsonString2);
	}
	
	//WriteNullNumberAsZero枚举中的常量，序列化字段值为null,值序列化为0
		public static void testWriteNullNumberAsZero() {
			Student student = new Student();
			student.setName("张三");
//			student.setId(3);
			student.setAge(23);
			student.setEmail("zs@sina.com");
			student.setBirthday(getDate());
			//空值，不会被序列化
			//{"age":23,"birthday":1624358972205,"email":"zs@sina.com","name":"张三"}
			String jsonString = JSON.toJSONString(student);
			//方法得参数上，添加枚举类型
			//{"age":23,"birthday":1624358972205,"email":"zs@sina.com","id":0,"name":"张三"}
			String jsonString2 = JSON.toJSONString(student,SerializerFeature.WriteNullNumberAsZero);
			
			System.out.println(jsonString);
			System.out.println(jsonString2);
		}
		
		//WriteNullBooleanAsFalse枚举中的常量，序列化字段值为null,值序列化为0
		public static void testWriteNullBooleanAsFalse() {
			Student student = new Student();
			student.setName("张三");
			student.setId(3);
			student.setAge(23);
			student.setEmail("zs@sina.com");
			student.setBirthday(getDate());
//			student.setFlag(true);
			//空值，不会被序列化
			//{"age":23,"birthday":1624359430408,"email":"zs@sina.com","id":3,"name":"张三"}
			String jsonString = JSON.toJSONString(student);
			//方法得参数上，添加枚举类型
			//{"age":23,"birthday":1624359430408,"email":"zs@sina.com","flag":false,"id":3,"name":"张三"}
			String jsonString2 = JSON.toJSONString(student,SerializerFeature.WriteNullBooleanAsFalse);
			
			System.out.println(jsonString);
			System.out.println(jsonString2);
		}
		
		//PrettyFormat  WriteDateUseDateFormat
		//WriteNullBooleanAsFalse枚举中的常量，序列化字段值为null,值序列化为0
		public static void testWriteDateUseDateFormatPrettyFormat() {
			Student student = new Student();
			student.setName("张三");
		//	student.setId(3);
			student.setAge(23);
			student.setEmail("zs@sina.com");
			student.setBirthday(getDate());
			student.setFlag(true);
			//空值，不会被序列化
			//{"age":23,"birthday":1624359430408,"email":"zs@sina.com","id":3,"name":"张三"}
			String jsonString = JSON.toJSONString(student);
			//方法得参数上，添加枚举类型
			//{"age":23,"birthday":1624359430408,"email":"zs@sina.com","flag":false,"id":3,"name":"张三"}
			String jsonString2 = JSON.toJSONString(student,SerializerFeature.WriteDateUseDateFormat,
					SerializerFeature.PrettyFormat);
			
			System.out.println(jsonString);
			System.out.println(jsonString2);
		}
	
	public static void main(String[] args) {
		
		testWriteDateUseDateFormatPrettyFormat();
		
	}

}
