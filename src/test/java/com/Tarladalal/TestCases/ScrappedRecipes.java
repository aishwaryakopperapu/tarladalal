package com.Tarladalal.TestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Tarladalal.Utilities.ExcelWriter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrappedRecipes extends ExcelWriter {
	
	@BeforeClass
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

	@Test(priority=1)
	public void DiabeticRecipeTest() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//input[@class='txtsearch']")).sendKeys("Diabetic recipies");
		driver.findElement(By.xpath("//input[@class='txtsearch']")).sendKeys(Keys.ENTER);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,250)", "");
		List<WebElement> pagination = driver.findElements(By.xpath("//div[@id='cardholder']/div[2]/a"));
		pgCnt = pagination.size();
		System.out.println("Total Number of pages are " +pgCnt);
		List<WebElement> linkSize = driver.findElements(By.xpath("//div[@class='rcc_rcpcore']/span/a"));
		linksCount = linkSize.size();
		for (int j = 1; j <= pgCnt; j++) {
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
					DingredientList.add(ingredient);
					
					String currentURL = driver.getCurrentUrl();
					 DRecipeLink.add(currentURL); 
					 System.out.println(currentURL);
					 Thread.sleep(1000);
					System.out.println("Inside else loop****" + ingredientList.size());
					String PrepTime = driver.findElement(By.xpath("//p//time[1]")).getText();
					DprepTimeList.add(PrepTime);
					System.out.println(PrepTime);
					String cookTime = driver.findElement(By.xpath("//p//time[2]")).getText();
					DcookTimeList.add(cookTime);
					System.out.println(cookTime);
					String Method = driver.findElement(By.xpath("//div[@id='recipe_small_steps']")).getText();
					DMethodList.add(Method);
					System.out.println(Method);
					js.executeScript("window.scrollBy(0,5000)", "");
					Thread.sleep(2000);
					
                    try {
					String NutrientsValue = driver.findElement(By.xpath("//table[@id='rcpnutrients']/tbody")).getText();
					DNutrientList.add(NutrientsValue);
					System.out.println(NutrientsValue);
                    }
                    catch(Exception e) {
                    	DNutrientList.add("NA");
                    }
					Thread.sleep(1000);
					driver.navigate().back();
					Thread.sleep(1000);
					String recipeID = driver
							.findElement(By.xpath("//div[@class='rcc_recipecard'][" + i + "]/div[2]/span ")).getText();
					DrecipeidList.add(recipeID);
					System.out.println(recipeID);
					String recipeName = driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]"))
							.getText();
					DrecipeNameList.add(recipeName);
					System.out.println(recipeName);
					Thread.sleep(1000);
					

					
					 
				}
				// driver.findElement(By.xpath("(//a[text()='" + j + "'])[1]")).click();
				System.out.println("Page Number is : " + j);
				ReceipeCode = 1;
				ExcelWriter.writeExcelSheet();
				System.out.println("Writing excelsheet");
			}
		}
	}
	@Test(priority = 2)
	public void recipeTest() throws InterruptedException, IOException {
		driver.findElement(By.xpath("//input[@class='txtsearch']")).sendKeys("High Blood Pressure");
		driver.findElement(By.xpath("//input[@class='txtsearch']")).sendKeys(Keys.ENTER);
		List<WebElement> linkSize = driver.findElements(By.xpath("//div[@class='rcc_rcpcore']/span/a"));
		linksCount = linkSize.size();
		System.out.println(linksCount);
		List<WebElement> pagination = driver.findElements(By.xpath("//div[@id='cardholder']/div[3]/a"));
		int pgCnt = pagination.size();
		System.out.println("Total Number of pages are " + pgCnt);
		for (int j = 1; j <= pgCnt; j++) {
			driver.findElement(By.xpath("(//a[text()='" + j + "'])[1]")).click();
			for (int i = 1; i <= linksCount; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,250)", "");
				driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]")).click();
				String ingredient = driver.findElement(By.xpath("//div[@id='rcpinglist']")).getText();
				ingredientList.add(ingredient);
				System.out.println(ingredient);
				if (ingredient.contains("Alcohol") || ingredient.contains("Pickles") || ingredient.contains("Sauces")
						|| ingredient.contains("mayonnaise") || ingredient.contains("White rice")
						|| ingredient.contains("white bread") || ingredient.contains("soft drinks")
						|| ingredient.contains("tea") || ingredient.contains("coffee") || ingredient.contains("chips")
						|| ingredient.contains("crackers") || ingredient.contains("pretzels")
						|| ingredient.contains("bacon") || ingredient.contains("ham") || ingredient.contains("canned")
						|| ingredient.contains("Frozen") || ingredient.contains("salt"))
				{
					System.out.println("Inside If loop");
					System.out.println("Its not a HyperTension friendly recipe");
					driver.navigate().back();
				} else {
					System.out.println("Inside else loop");
					ingredientList.add(ingredient);
					String currentURL = driver.getCurrentUrl();
					RecipeLink.add(currentURL);
					System.out.println(currentURL);
					String Method = driver.findElement(By.xpath("//div[@id='recipe_small_steps']")).getText();
					MethodList.add(Method);
					System.out.println(Method);
					try {
						String NutrientsValue = driver.findElement(By.xpath("//table[@id='rcpnutrients']/tbody"))
								.getText();
						NutrientList.add(NutrientsValue);
						System.out.println(NutrientsValue);
						String PrepTime = driver.findElement(By.xpath("//p//time[1]")).getText();
						prepTimeList.add(PrepTime);
						System.out.println(PrepTime);
						String cookTime = driver.findElement(By.xpath("//p//time[2]")).getText();
						cookTimeList.add(cookTime);
						System.out.println(cookTime);
						driver.navigate().back();
						String recipeID = driver
								.findElement(By.xpath("//div[@class='rcc_recipecard'][" + i + "]/div[2]/span "))
								.getText();
						recipeidList.add(recipeID);
						System.out.println(recipeID);
						String recipeName = driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]"))
								.getText();
						recipeNameList.add(recipeName);
						System.out.println(recipeName);
					} catch (Exception e) {
						NutrientList.add("NA");
					}
					js.executeScript("window.scrollBy(0,5000)", "");
					Thread.sleep(2000);
				}
				System.out.println("Page Number is : " + j);
				ReceipeCode = 2;
				ExcelWriter.writeExcelSheet();
				System.out.println("Writing excelsheet");
			}
		}
	}
	@Test(priority=3)
	  public void Hypothyroid_Recipe_list() throws InterruptedException, IOException
	  	{
	  		driver.findElement(By.xpath("//input[@class='txtsearch']")).sendKeys("Hypothyroid breakfast recipes");
	  		driver.findElement(By.xpath("//input[@class='txtsearch']")).sendKeys(Keys.ENTER);
	   		
	  		  		
	  		JavascriptExecutor js = (JavascriptExecutor) driver;
	  		js.executeScript("window.scrollBy(0,500)", "");
	   		
	  		List<WebElement> pagination = driver.findElements(By.xpath("//div[@id='cardholder']/div[2]/a"));
				pgCnt = pagination.size();
				System.out.println("Total Number of pages are " +pgCnt);
				
				
								
			  for (int j = 1; j <= pgCnt; j++)
				{
				  JavascriptExecutor js1= (JavascriptExecutor) driver;
		  		js1.executeScript("window.scrollBy(0,550)", "");
				
				  driver.findElement(By.xpath("//div[@id='cardholder']/div[2]/a["+j+"]")).click();
				  System.out.println("On page number "+j);
				
				      		
	  		  List<WebElement> linkSize = driver.findElements(By.xpath("//span[@class='rcc_recipename']/a"));
	  		  linksCount = linkSize.size();
	  		  System.out.println("Number of recipes on page "+j+" = "+linksCount);
	   		
	  		  			
	  			for (int i = 1; i <= linksCount; i++)
	  			{
	  				JavascriptExecutor js2 = (JavascriptExecutor) driver;
	  				js2.executeScript("window.scrollBy(0,250)", "");
	   				
	  				driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]" )).click();
	   				
	  				String ingredient = driver.findElement(By.xpath("//div[@id='rcpinglist']")).getText();
	  				//ingredientList.add(ingredient);
	  				//System.out.println(ingredient);
	   				
	  				if(!(ingredient.contains("Tofu") || ingredient.contains("Edamame") ||
	  						 ingredient.contains("Tempeh") || ingredient.contains("Cauliflower") ||
	  						 ingredient.contains("rice flour") || ingredient.contains("rice rava") ||
	  						 ingredient.contains("Broccoli") || ingredient.contains("Kale") ||
	  						 ingredient.contains("Spinach") || ingredient.contains("SweetPotatoes") ||
	  						 ingredient.contains("Strawberries") || ingredient.contains("Pine nuts") ||
	  						 ingredient.contains("peanuts") || ingredient.contains("peaches") ||
	  						 ingredient.contains("Greentea") ||
	  						 ingredient.contains("Coffee") || ingredient.contains("Alcohol") ||
	  						 ingredient.contains("Soy Milk") ||
	  						 ingredient.contains("White bread") || ingredient.contains("cakes") ||
	  						 ingredient.contains("Pastries") || ingredient.contains("Fried food") ||
	  						 ingredient.contains("Sugar") || ingredient.contains("Ham") ||
	  						 ingredient.contains("Bacon") || ingredient.contains("Salami") ||
	  						 ingredient.contains("sausages") || ingredient.contains("frozen food") ||
	  						 ingredient.contains("Gluten") || ingredient.contains("Sodas")
	  						 || ingredient.contains("Energy drink contains caffeine") || ingredient.contains("packaged food noodles")
	  						 ||ingredient.contains("packaged soups") || ingredient.contains("packaged salad dressings") ||
	  						 ingredient.contains("packaged sauces") || ingredient.contains("candies")))
	   						
	  				{
	  				System.out.println("Inside If loop");
	  				System.out.println("Its not Hypothyroid friendly recipe");
	  				driver.navigate().back();
	  				//break;
	  				}
	   				
	  				else
	  				{
	   					
	  					System.out.println("Inside else loop");
	   					
	  					TingredientList.add(ingredient);	
	   				
	   				
	   				
	   				 String currentURL = driver.getCurrentUrl();
				     TRecipeLink.add(currentURL);
				     System.out.println(driver.getCurrentUrl());
				    
	  				String PrepTime = driver.findElement(By.xpath("//p//time[1]")).getText();
	  				TprepTimeList.add(PrepTime);
	  				System.out.println(PrepTime);
	  				String cookTime = driver.findElement(By.xpath("//p//time[2]")).getText();
	  				TcookTimeList.add(cookTime);
	  				System.out.println(cookTime);
	  				String Method = driver.findElement(By.xpath("//div[@id='recipe_small_steps']")).getText();
	  				TMethodList.add(Method);
	  				System.out.println(Method);
	  				js.executeScript("window.scrollBy(0,5000)", "");
	  				Thread.sleep(1000);
	  				driver.navigate().back();
	  				Thread.sleep(2000);
	  				String recipeID =driver.findElement(By.xpath("//div[@class='rcc_recipecard']["+ i +"]/div[2]/span " )).getText();
	  				TrecipeidList.add(recipeID);
	  				System.out.println(recipeID);
	  				String recipeName = driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]")).getText();
	  				TrecipeNameList.add(recipeName);
	  				System.out.println(recipeName);
	  				Thread.sleep(1000);
	  				}
	   				
	  				  			
	  				System.out.println("Page Number is : " + j );
	  				ReceipeCode=3;
		  			ExcelWriter.writeExcelSheet();
		  			System.out.println("Writing excelsheet");
			}
		
				}
	  	}
	
	@Test(priority=4)
	public void pcos_Recipe_list() throws InterruptedException, IOException
	{
	driver.findElement(By.xpath("//input[@class='txtsearch']")).sendKeys("PCOS breakfast recipes");
	driver.findElement(By.xpath("//input[@class='txtsearch']")).sendKeys(Keys.ENTER);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)", "");
	List<WebElement> pagination = driver.findElements(By.xpath("//div[@id='cardholder']/div[3]/a"));
	pgCnt = pagination.size();
	System.out.println("Total Number of pages are " +pgCnt);
	for (int j = 1; j <= pgCnt; j++)
	{
	JavascriptExecutor js1= (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,550)", "");
	driver.findElement(By.xpath("//div[@id='cardholder']/div[3]/a["+j+"]")).click();
	System.out.println("On page number "+j);
	List<WebElement> linkSize = driver.findElements(By.xpath("//span[@class='rcc_recipename']/a"));
	linksCount = linkSize.size();
	System.out.println("Number of recipes on page "+j+" = "+linksCount);
	for (int i = 1; i <= linksCount; i++)
	{
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,250)", "");
	driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]" )).click();
	String ingredient = driver.findElement(By.xpath("//div[@id='rcpinglist']")).getText();
	if((ingredient.contains("white bread") || ingredient.contains("plain flour") ||
	ingredient.contains("sugar") || ingredient.contains("soy products") ||
	ingredient.contains("red meat") ||
	ingredient.contains("soda") || ingredient.contains("flavoured water") ||
	ingredient.contains("gatorade") || ingredient.contains("milk") ||
	ingredient.contains("cheese") ||
	ingredient.contains("yogurt") || ingredient.contains("butter") ||
	ingredient.contains("curd") || ingredient.contains("white rice") ||
	ingredient.contains("coffee") || ingredient.contains("vegetable oil") ||
	ingredient.contains("soybean oil") || ingredient.contains("canola oil") ||
	ingredient.contains("rapeseed oil") || ingredient.contains("sunflower oil") ||
	ingredient.contains("gluten") || ingredient.contains("all purpose flour")||
	ingredient.contains("doughnuts") || ingredient.contains("pastries")))
	{
	System.out.println("Inside If loop");
	System.out.println("Its not a PCOS friendly recipe");
	Thread.sleep(1000);
	driver.navigate().back();
	}
	else
	{
	PingredientList.add(ingredient);
	System.out.println("Inside else loop");
	String currentURL = driver.getCurrentUrl();
	PRecipeLink.add(currentURL);
	System.out.println(driver.getCurrentUrl());
	String PrepTime = driver.findElement(By.xpath("//p//time[1]")).getText();
	PprepTimeList.add(PrepTime);
	System.out.println(PrepTime);
	String cookTime = driver.findElement(By.xpath("//p//time[2]")).getText();
	PcookTimeList.add(cookTime);
	System.out.println(cookTime);
	String Method = driver.findElement(By.xpath("//div[@id='recipe_small_steps']")).getText();
	PMethodList.add(Method);
	System.out.println(Method);
	js.executeScript("window.scrollBy(0,5000)", "");
	Thread.sleep(1000);
	try {
	String NutrientsValue = driver.findElement(By.xpath("//table[@id='rcpnutrients']/tbody")).getText();
	PNutrientList.add(NutrientsValue);
	System.out.println(NutrientsValue);
	}
	catch(Exception e) {
	PNutrientList.add("NA");
	}
	driver.navigate().back();
	String recipeID =driver.findElement(By.xpath("//div[@class='rcc_recipecard']["+ i +"]/div[2]/span " )).getText();
	PrecipeidList.add(recipeID);
	System.out.println(recipeID);
	String recipeName = driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]")).getText();
	PrecipeNameList.add(recipeName);
	System.out.println(recipeName);
	Thread.sleep(1000);
	}
	System.out.println("Page Number is : " + j );
	ReceipeCode=4;
	ExcelWriter.writeExcelSheet();
	System.out.println("Writing excelsheet");
	}
	}
	}
		

	@AfterClass
	public void teardown() {
		driver.close();
	}
}
