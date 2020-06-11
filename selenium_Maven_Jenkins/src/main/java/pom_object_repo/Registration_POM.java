package pom_object_repo;

import org.openqa.selenium.By;

public class Registration_POM {
	//POM
		 public static By Registration_Link =  By.cssSelector("a[href='register.php']");
		 public static By FirstName =  By.cssSelector("input[name='firstName']");
		 public static By LastName =  By.name("lastName");
		 public static By PhoneNo =  By.name("phone");
		 public static By Email =  By.xpath("//*[@id='userName']");		 
		 public static By Address = By.name("address1");
		 public static By City =  By.name("city");
		 public static By State =  By.name("state");
		 public static By PostalCode =  By.name("postalCode");
		 public static By Country =  By.name("country");
		 //selectByIndex
		 public static By UserName =  By.xpath("//*[@id='email']");
		 public static By Password =  By.cssSelector("input[name='password'][type='password']");
		 public static By Confirmationpassword =  By.cssSelector("input[name='confirmPassword'][type='password']");
		 public static By SubmitButton =  By.cssSelector("input[name='submit'][type='submit']");
}
