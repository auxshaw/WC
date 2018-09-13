package testcount;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import wordcount.Create;

    public class testcount1 {
	@Test
	public void testcreate () throws IOException{			
		Create cr=new Create();	
		cr.tips();
		cr.create("-c -w -l -a D:\\3.txt");
		cr.create("-q wqrqwf.asfaf");
	}
   }
	

