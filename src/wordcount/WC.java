package wordcount;
import java.io.*;
import java.util.*;

public class WC {
	
	public static void main(String[] args) throws IOException{		
		Create cr=new Create();
		cr.tips();	    
		Scanner scan = new Scanner(System.in);			
		String command=null;
		while(scan.hasNextLine()) {
		//读取控制台的命令			
		if (scan.hasNextLine()) {
	        command = scan.nextLine();}    
	    cr.create(command);
	}
		scan.close();
	}
    
}