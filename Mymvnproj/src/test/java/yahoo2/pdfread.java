package yahoo2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pdf_read
{

	public static void main(String[] args) throws Exception
	{
		
		//**** read data from the pdf in the website (URL)
		     
        FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://www.votigo.com/pdf/corp/CASE_STUDY_EarthBox.pdf");
		Thread.sleep(10000);
		//load the pdf doc from the URL
        PDDocument doc = PDDocument.load(new URL(driver.getCurrentUrl()));
        ///get text from the pdf doc
        String x1= new PDFTextStripper().getText(doc);
        System.out.println(x1);
       
        
        
        
      //****read data from pdf file in the local driver
		
		    //load the file into buffer for reading
      	BufferedInputStream filetoread=new BufferedInputStream
      				                  (new FileInputStream("e:\\betasoft4\\abc1.pdf"));
      		//parse the file to read
      		PDFParser parser = new PDFParser(filetoread);  
      		parser.parse();  
      		//read data from the parsed file  
      		String output=new PDFTextStripper().getText(parser.getPDDocument());  
      		System.out.println(output);  
      		parser.getPDDocument().close();
      		
      		
        //WebDriverWait wt=new WebDriverWait(driver,30);
       // wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(" "))));
        
        
        
        //break up the file content returned as a string into individual lines
          // List<String> ans= Arrays.asList(x1.split("\r\n"));
          // System.out.println(ans.get(0));
          // System.out.println(ans.get(1));
       //for(String x : ans)
     	//  System.out.println(x);*/

	}

}
