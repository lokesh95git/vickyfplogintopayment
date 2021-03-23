package com.fp.stepdefinition;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Fplogintopayment {
	public static WebDriver driver;
	@Given("User launches flipkart application")
	public void user_launches_flipkart_application() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	    
	}
	

	

	@When("user enter credentials")
	public void user_enter_credentials() throws InterruptedException {
		Thread.sleep(3000);
	   driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("8940422633");
	   driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Vignesh@1603");
	  }

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
	    
	}

	@When("user search for mobile")
	public void user_search_for_mobile() throws InterruptedException {
		Thread.sleep(5000);
	   WebElement s = driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"));
	   s.click();
	   s.sendKeys("iphone12pro");
	}

	@When("user click on search button")
	public void user_click_on_search_button() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
	    
	}

	@When("user switch to child window")
	public void user_switch_to_child_window() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='APPLE iPhone 12 Pro Max (Pacific Blue, 128 GB)']")).click();
		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for (String s : child) {
			if(!parent.equals(s)) {
				driver.switchTo().window(s);
				}	
		}
	}

	@When("user click on Add to cart button")
	public void user_click_on_Add_to_cart_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		Thread.sleep(5000);
			}

	@When("user click on placeorder and continue button")
	public void user_click_on_placeorder_and_continue_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _1seccl _3AWRsL']")).click();
		
	    
	}


	@Then("user check payment visibility")
	public void user_check_payment_visibility() {
		WebElement w1 = driver.findElement(By.xpath("//span[text()='Payment Options']"));
		
		if(w1.isDisplayed()) { 
			System.out.println("you are in payment page");
		}
		else {
			System.out.println("you are not in payment page");
		}
	   
	}



}
