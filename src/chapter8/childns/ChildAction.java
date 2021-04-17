package chapter8.childns;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@ParentPackage(value="parentns")

@Namespace(value="/mychild")

@Results({@Result(name="success", location="/success.jsp"),@Result(name="error",location="/error.jsp")})
public class ChildAction {
	
	public String execute() throws Exception{
		try{
			System.out.println("child");
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
	}

}
