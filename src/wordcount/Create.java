package wordcount;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Create {
	
	public void tips() {
    	System.out.println("-c 统计字符数");
		System.out.println("-l 统计行数");
		System.out.println("-w 统计词的个数");
		System.out.println("-a 统计空白行，注释行和代码行的行数");
		System.out.println("命令格式：例1:-c D://1.txt");
		System.out.println("例2:-c -w D://1.txt");
    }
	
	public void create(String command) throws IOException{		
        Count count=new Count();
        //检查命令是否错误
  		Pattern Pa = Pattern.compile("^(\\-[cwla]\\s+){1,4}\\s*+\\S+$");
  	    Matcher Ma = Pa.matcher(command);  
  	    if(!Ma.matches()) {
  	    	System.out.println("指令错误，请重新输入");       	
  	    }  
	    //文件路径
	    int index = command.lastIndexOf(" ");
        String path = command.substring(index +1);
    	//匹配命令
    	Pattern pattern = Pattern.compile("\\-[cwla]");
        Matcher Match = pattern.matcher(command);     
        while(Match.find()) {
        switch (Match.group().replace("-", "")) {
            case "c":
            	count.countchar(path);
            	break;                  
            case "w":
            	count.countword(path);
            	break;
            case "l":
            	count.countline(path);
            	break;
            case "a":
            	count.countline3(path);
            	break;   
        }          
    }          
	}
}

