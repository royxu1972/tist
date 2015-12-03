package njxzc.royxu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.util.FieldMembers;
import com.util.StringUtil;
import com.util.generate.Generate;

@Controller
public class CodeGenerateController {
	static Map<String,String> map = new HashMap<String,String>();
	static {
		map.put("int", "int");
		map.put("Integer", "int");
		map.put("String", "varchar");
		map.put("Date", "datetime");
	}

	//修改为全自动生成的方法
	@RequestMapping(value="/generate",method=RequestMethod.POST)
	public ModelAndView saveGenerate(String class_name,String function_name,String module_name,String java_members,String generate_jspjs,String left_right){
		ModelAndView mav = new ModelAndView("jsonView");
		try{
//			System.err.println(class_name+"\n"+function_name+"\n"+module_name+"\n"+java_members);
			String[] j_members = java_members.split("\r\n");
			List<FieldMembers> fields = new ArrayList<FieldMembers>();
			for(String t : j_members){
//				System.out.println(t);
				String[] sperate_s = t.split(" ");
				String db_field_type = "varchar";
				//根据数据类型获得对应数据库字段的类型,默认为varchar
				if(!StringUtil.isEmpty(sperate_s[0])){
					if(!StringUtil.isEmpty(map.get(sperate_s[0]))){
						db_field_type = map.get(sperate_s[0]);
					}
				}
				FieldMembers fieldMembers = new FieldMembers(sperate_s[0],sperate_s[1],sperate_s[2],db_field_type,sperate_s[3]);
//				System.err.println(fieldMembers.toString());
				fields.add(fieldMembers);
			}
			String module_generate = Generate.generateNew(class_name, function_name, module_name,generate_jspjs,left_right,fields);
			mav.addObject("module_generate",module_generate);
			mav.addObject("success",true);
		}catch(Exception e){
			mav.addObject("success", false);
			mav.addObject("msg", e.getMessage());
		}
		return mav;
	}
	
//	@RequestMapping(value="/generate",method=RequestMethod.POST)
//	public ModelAndView saveGenerate(String class_name,String function_name,String module_name,String java_members,String generate_jspjs,String left_right){
//		ModelAndView mav = new ModelAndView("jsonView");
//		try{
////			System.err.println(class_name+"\n"+function_name+"\n"+module_name+"\n"+java_members);
//			String module_generate = Generate.generate(class_name, function_name, module_name,generate_jspjs,left_right);
//			String[] j_members = java_members.split("\r\n");
//			String field_function = "";
//			String field = "";
//			String form_code = "";
//			String field_js = "";
//			for(String t : j_members){
////				System.out.println(t);
//				String[] sperate_s = t.split(" ");
////				System.out.println(sperate_s.length);
//				field_function += FieldGenerate.getFieldFunction(sperate_s[0], sperate_s[1], sperate_s[2])+"\n\n";
//				field += FieldGenerate.getField(sperate_s[0], sperate_s[1], sperate_s[2])+"\n";
//				form_code += FieldGenerate.getFieldForm(sperate_s[1], sperate_s[2])+"\n";
//				field_js += FieldGenerate.getFieldJs(sperate_s[1], sperate_s[2])+"";
//			}
////			System.err.println(module_generate);
////			System.err.println(field_function);
//			mav.addObject("module_generate",module_generate);
//			mav.addObject("field_generate",field+"\n"+field_function);
//			mav.addObject("form_code",form_code);
//			mav.addObject("field_js",field_js);
//			mav.addObject("success",true);
//		}catch(Exception e){
//			mav.addObject("success", false);
//			mav.addObject("msg", e.getMessage());
//		}
//		return mav;
//	}
}
