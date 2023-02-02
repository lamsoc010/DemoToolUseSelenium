package com.vinhlam.tool.service;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class AutoPostStatusFacebook {
	
	public WebDriver driver;
	
	public Wait<WebDriver> wait;
	
	@Autowired
	public void AutoPostStatusFacebook() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
//		Option để tắt thông báo mặc định của chrome(push notification)
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notifications");
		
//		Khởi tạo WebDriver
		driver = new ChromeDriver(o);
		
//		Bật full màn hình
//		driver.manage().window().maximize();
		
//		Set thời gian đợi tìm element(implicit wait)
//		Set thời gian tìm kiểm 1 element là 10s, sau 10s không tìm thấy thì sẽ văng ra Exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		Tạo explicit wait với FluentWait
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class);
	}
	
	public void loginFacebook() throws InterruptedException {
		
		driver.navigate().to("https://www.facebook.com/");
		
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[1]/div[1]/input")).sendKeys("tranvinhlambds@gmail.com");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[1]/div[2]/div/input")).sendKeys("@Lam07772419991");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();

	}
	
	public void autoPostStatus() {
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div[2]/div/div/div/div[3]/div/div[2]/div/div/div/div[1]/div")));
		WebElement postElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div[2]/div/div/div/div[3]/div/div[2]/div/div/div/div[1]/div"));
		postElement.click();
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[1]/div[2]/div[2]/div/div/div/div/div/span/div/div")));
		WebElement showTypePost = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[1]/div[2]/div[2]/div/div/div/div/div/span/div/div"));
		showTypePost.click();
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"mount_0_0_7Y\"]/div[1]/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/div[2]/div/div[4]/div/div[1]/div[2]/div[1]/div/div/div/span")));
//		WebElement typePost = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[2]/div/div/div[2]/div/div/div[1]/div/div/div[2]/div/div[4]/div/div[1]/div[2]"));
		WebElement typePost = driver.findElement(By.xpath("//span[contains(text(),'Chỉ mình')]"));
		typePost.click();

		WebElement submitTypeButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div[2]/div/div"));
		submitTypeButton.click();

		WebElement inputElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div[1]/p"));
		inputElement.sendKeys("Test auto post facebook");

//		WebElement submitPostButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[3]/div[2]/div/div"));
//		submitPostButton.click();
	}

}
