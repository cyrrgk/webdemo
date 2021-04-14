package chapter7.dao;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.Validate;

public class BookDAO {
	
	private static Map<String,Integer> books = new LinkedHashMap<String,Integer>();
	
	static{
		books.put("Java整合详解与典型案列", 79);
		books.put("Visual C#2008 技术详解", 89);
		books.put("Strut 2技术详解", 69);
		books.put("Asp经典模块开发大全", 69);
		books.put("Asp .Net 3.5网络数据库开发实例自学手册", 79);
		books.put("XML开发典型应用:数据标记、处理、共享与分析", 65);
	}
	
    public Map<String,Integer> getBooks(String name){
    	Map<String,Integer> books = new LinkedHashMap<String,Integer>();
    	for(Map.Entry<String, Integer> entry:BookDAO.books.entrySet()){
    		if(entry.getKey().toLowerCase().contains(name.toLowerCase())){
    			books.put(entry.getKey(), entry.getValue());
    		}
    	}
    	
    	return books;
    }

}
