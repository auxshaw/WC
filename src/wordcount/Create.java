package wordcount;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Create {
	
	public void tips() {
    	System.out.println("-c ͳ���ַ���");
		System.out.println("-l ͳ������");
		System.out.println("-w ͳ�ƴʵĸ���");
		System.out.println("-a ͳ�ƿհ��У�ע���кʹ����е�����");
		System.out.println("�����ʽ����1:-c D://1.txt");
		System.out.println("��2:-c -w D://1.txt");
    }
	
	public void create(String command) throws IOException{		
        Count count=new Count();
        //��������Ƿ����
  		Pattern Pa = Pattern.compile("^(\\-[cwla]\\s+){1,4}\\s*+\\S+$");
  	    Matcher Ma = Pa.matcher(command);  
  	    if(!Ma.matches()) {
  	    	System.out.println("ָ���������������");       	
  	    }  
	    //�ļ�·��
	    int index = command.lastIndexOf(" ");
        String path = command.substring(index +1);
    	//ƥ������
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

