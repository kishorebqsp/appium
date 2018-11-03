package scripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import POM.Homepage;
import POM.Loginpage;
import POM.Logintodetails;
import POM.Signuppage;
import POM.Wishlistpage;
import generic.Constant;
import generic.Excelsheet;
import generic.Property;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Validlogin implements Constant {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities d=new DesiredCapabilities();
		d.setCapability("deviceName","Asus");
		d.setCapability("platformName","android");
		d.setCapability("platformVersion","6.0.1");
		d.setCapability("appPackage", "com.myntra.android");
		d.setCapability("appActivity","com.myntra.android.activities.LoginRegisterActivity");
		URL u=new URL("http://localhost:4723/wd/hub");
		AndroidDriver<MobileElement> driver=new  AndroidDriver<MobileElement>(u,d);
		Loginpage l=new Loginpage(driver);
		Thread.sleep(9000);
		l.manubutton();
		//Thread.sleep(3000);
		l.loginbtn();
		
		Signuppage s=new Signuppage(driver);
	
		s.signupbtn();
		
		Logintodetails dl=new Logintodetails(driver);
		
		String email = Property.getproperty(propertypath,"username");
	
		dl.emailtxtbox(email);
		
		//String pass = Property.getproperty(propertypath,"password");
		String pass = Excelsheet.getexceldata(excelpath,"Sheet1",1,1);
		
		dl.passwordtxtbox(pass);
		
		dl.loginbutton();
		
		
		Homepage h=new Homepage(driver);
	
		h.wishlistbtn();

	   Wishlistpage w=new Wishlistpage(driver);
	   
	   w.shopnowbtn();
	}
}
