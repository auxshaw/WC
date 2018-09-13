package wordcount;
import java.io.*;
import java.util.regex.*;

public class Count {
	
	String str=null;
	//统计字符数
	public void countchar(String path) throws IOException{ 
		int countchar1=0;
		BufferedReader br=new BufferedReader(new FileReader(path));	
		while((str=br.readLine())!=null){			
			Pattern p = Pattern.compile("\\S");
	        Matcher m = p.matcher(str);
	        while(m.find()) {
			countchar1++;}
		}					
		System.out.println("字符数："+countchar1);
		br.close();
	}
	
	    //统计词的个数
	public void countword(String path) throws IOException{ 
		int countworde=0;
		int countwordc=0;
		int countword=0;	
		StringBuffer sbf = new StringBuffer();
		BufferedReader br=new BufferedReader(new FileReader(path));	
		while((str=br.readLine())!=null){	
			//统计中文字数
			Pattern pa = Pattern.compile("[\\u4e00-\\u9fa5]");
	        Matcher ma = pa.matcher(str);
	        while(ma.find()){
	            countwordc++;
	        }	        	
	        //统计英文单词数
	        sbf.append(str);
		    String word=sbf.toString().replaceAll("[^a-zA-Z0-9]"," ");
		    String[] words=word.split("\\s+");		    
		    countworde=words.length;			            		    
		}
		countword=countwordc+countworde;
		System.out.println("词的数目："+countword);
		br.close();
	}

	//统计行数
	public void countline(String path) throws IOException{ 
		int countline1=0;			
		BufferedReader br=new BufferedReader(new FileReader(path));
		while((str=br.readLine())!=null){
			countline1++;
		}
		System.out.println("行数："+countline1);
		br.close();
	}
    
	//统计空白行，代码行和注释行各行行数
	public void countline3(String path) throws IOException{
		int spacelines=0;
		int codelines=0;
		int notelines=0;
		String notebegin="\\s*/\\*.*";
		String noteend=".*\\*/\\s*";
		String noteall="//.*";
		String regxspace="\\s*\\S?\\s*";
		boolean flag = false;
		BufferedReader br=new BufferedReader(new FileReader(path));		 
		while((str=br.readLine())!=null){			
			if (str.matches("\\s*/\\*.*\\*/\\s*")) { 
	        	notelines++;	
	        	continue;}
		      if (str.matches(notebegin)) {
	         	  notelines++;flag = true;} 
	            else if (str.matches(noteend)) {
	        	    notelines++; flag = false;}
                  else if(str.matches(regxspace)){
     	              spacelines++;}
                    else if (str.matches(noteall)) {
            	        notelines++;}	 
                      else if (true == flag)
                          notelines++;
                        else codelines++;
	        }	
		System.out.println("空白行："+spacelines);
		System.out.println("注释行："+notelines);
		System.out.println("代码行："+codelines);
		br.close();
	}
	
}
