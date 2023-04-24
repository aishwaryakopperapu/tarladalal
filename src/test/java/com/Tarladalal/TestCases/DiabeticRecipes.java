package com.Tarladalal.TestCases;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Tarladalal.Utilities.ExcelWriter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiabeticRecipes extends ExcelWriter {

	@BeforeTest
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.tarladalal.com/");
		//driver.manage().timeouts().pageLoadTimeout(10 ,TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10 ,TimeUnit.SECONDS);
	}

	@Test
	public void recipeTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='txtsearch']")).sendKeys("Diabetic recipies");
		driver.findElement(By.xpath("//input[@class='txtsearch']")).sendKeys(Keys.ENTER);
		List<WebElement> linkSize = driver.findElements(By.xpath("//div[@class='rcc_rcpcore']/span/a"));
		linksCount = linkSize.size();
		for (int j = 1; j <= 5; j++) {
			driver.findElement(By.xpath("(//a[text()='" + j + "'])[1]")).click();
			for (int i = 1; i <= linksCount; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,250)", "");
				driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]")).click();
				String ingredient = driver.findElement(By.xpath("//div[@id='rcpinglist']")).getText();
				//ingredientList.add(ingredient);
				System.out.println("ingredient------>>" + ingredient);
				// ingredient = ingredientList.get(i).toString();
				if ((ingredient.contains("rice") || ingredient.contains("corn") || ingredient.contains("curd")
						|| ingredient.contains("processed grains") || ingredient.contains("rice flour")
						|| ingredient.contains("rice rava") || ingredient.contains("white rice")
						|| ingredient.contains("sugar") || ingredient.contains("white bread")
						|| ingredient.contains("pasta") || ingredient.contains("soda")
						|| ingredient.contains("flavoured water") || ingredient.contains("gatorade")
						|| ingredient.contains("apple juice") || ingredient.contains("orange juice")
						|| ingredient.contains("pomegranate juice") || ingredient.contains("margarines")
						|| ingredient.contains("peanut butter") || ingredient.contains("spreads")
						|| ingredient.contains("frozen foods") || ingredient.contains("flavoured yogurt")
						|| ingredient.contains("cereals") || ingredient.contains("puffed rice")
						|| ingredient.contains("barn flakes") || ingredient.contains("honey")
						|| ingredient.contains("instant oatmeal") || ingredient.contains("maple syrup")
						|| ingredient.contains("jaggery") || ingredient.contains("sweets")
						|| ingredient.contains("candies") || ingredient.contains("chochlates")
						|| ingredient.contains("all purpose flour") || ingredient.contains("alcoholic beverages")
						|| ingredient.contains("jams") || ingredient.contains("jelly") || ingredient.contains("mango")
						|| ingredient.contains("cucumber") || ingredient.contains("tomatoes")
						|| ingredient.contains("canned pineapple") || ingredient.contains("canned peaches")
						|| ingredient.contains("canned mangoes") || ingredient.contains("canned pear")
						|| ingredient.contains("canned mixed fruits") || ingredient.contains("canned oranges")
						|| ingredient.contains("canned cherries") || ingredient.contains("chips")
						|| ingredient.contains("mayonnaise") || ingredient.contains("palmolein oil")
						|| ingredient.contains("powdered milk") || ingredient.contains("peas")
						|| ingredient.contains("beans") || ingredient.contains("corn flour")
						|| ingredient.contains("doughnuts") || ingredient.contains("pastries")
						|| ingredient.contains("cookies") || ingredient.contains("croissants")
						|| ingredient.contains("sweetend tea") || ingredient.contains("sweetend coffee")
						|| ingredient.contains("packaged snacks") || ingredient.contains("soft drinks")
						|| ingredient.contains("banana") || ingredient.contains("melon")
						|| ingredient.contains("diary milk") || ingredient.contains("cheese")
						|| ingredient.contains("butter"))) {
					System.out.println("Inside If loop");
					System.out.println("Its not a diabetic friendly recipe");
					driver.navigate().back();
					// break;
				} else {
					ingredientList.add(ingredient);
					
					String currentURL = driver.getCurrentUrl();
					 RecipeLink.add(currentURL); 
					 System.out.println(currentURL);
					 Thread.sleep(1000);
					System.out.println("Inside else loop****" + ingredientList.size());
					String PrepTime = driver.findElement(By.xpath("//p//time[1]")).getText();
					prepTimeList.add(PrepTime);
					System.out.println(PrepTime);
					String cookTime = driver.findElement(By.xpath("//p//time[2]")).getText();
					cookTimeList.add(cookTime);
					System.out.println(cookTime);
					String Method = driver.findElement(By.xpath("//div[@id='recipe_small_steps']")).getText();
					MethodList.add(Method);
					System.out.println(Method);
					js.executeScript("window.scrollBy(0,5000)", "");
					Thread.sleep(2000);
					
                    try {
					String NutrientsValue = driver.findElement(By.xpath("//table[@id='rcpnutrients']/tbody")).getText();
					NutrientList.add(NutrientsValue);
					System.out.println(NutrientsValue);
                    }
                    catch(Exception e) {
                    	NutrientList.add("NA");
                    }
					Thread.sleep(1000);
					driver.navigate().back();
					Thread.sleep(1000);
					String recipeID = driver
							.findElement(By.xpath("//div[@class='rcc_recipecard'][" + i + "]/div[2]/span ")).getText();
					recipeidList.add(recipeID);
					System.out.println(recipeID);
					String recipeName = driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]"))
							.getText();
					recipeNameList.add(recipeName);
					System.out.println(recipeName);
					Thread.sleep(1000);
					

					
					 
				}
				// driver.findElement(By.xpath("(//a[text()='" + j + "'])[1]")).click();
				System.out.println("Page Number is : " + j);
				ExcelWriter.writeExcelSheet();
				System.out.println("Writing excelsheet");
			}
		}
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}
}
