package com.Tarladalal.TestCases;
import java.io.File;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Allergy {
	public static WebDriver driver;
	static WebElement pgno;
	private static String[] links = null;
	private static int linksCount = 0;
	public static ArrayList<String> MilkList = new ArrayList<String>();
	public static ArrayList<String> SoyList = new ArrayList<String>();
	public static ArrayList<String> SesameList = new ArrayList<String>();
	public static ArrayList<String> PeanutList = new ArrayList<String>();
	public static ArrayList<String> WalnutList = new ArrayList<String>();
	public static ArrayList<String> HazelnutList = new ArrayList<String>();
	public static ArrayList<String> PecanList = new ArrayList<String>();
	public static ArrayList<String> CashewList = new ArrayList<String>();
	public static ArrayList<String> PistaList= new ArrayList<String>();
	public static ArrayList<String> NoAllergyList=new ArrayList<String>();
	
	public static XSSFWorkbook workbook = new XSSFWorkbook();
	public static XSSFSheet sheet=workbook.createSheet("Allergy");
	public static String path=System.getProperty("user.dir")+ "/src/test/resources/RecipeBook/Allergy.xlsx";//creates demo file in the folder
	public static File excelFile=new File(path);
	public static FileOutputStream Fos=null;
	
	public static void main(String[] args) throws InterruptedException {
		//WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.tarladalal.com/");
		driver.findElement(By.xpath("//a[@title='Recipea A to Z']")).sendKeys(Keys.ENTER);
		List<WebElement> linkSize = driver.findElements(By.xpath("//div[@class='rcc_rcpcore']/span/a"));
		linksCount = linkSize.size();
		System.out.println(linksCount);
		List<WebElement> pagination = driver.findElements(By.xpath("//div[@id='maincontent']/div[1]/div[2]/a"));
		int pgCnt = pagination.size();
		System.out.println("Total Number of pages are " + pgCnt);
		for (int j = 1; j <= pgCnt; j++) {
		
			driver.findElement(By.xpath("//div[@id='maincontent']/div[1]/div[2]/a["+j+"]")).click();
			
			for (int i = 1; i <= linksCount; i++) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,250)", "");
				driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]")).click();
				String ingredient = driver.findElement(By.xpath("//div[@id='rcpinglist']")).getText();
				
				if (ingredient.contains("Milk"))
				{
					System.out.println("Inside If loop");
					System.out.println("the following recipes are not recommended for Milk allergy as it contains milk");
					driver.navigate().back();
					String recipeName = driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]")).getText();
					System.out.println(recipeName);
					MilkList.add(recipeName);
				}
				else if (ingredient.contains("Soy"))
				{
					System.out.println("Inside If loop");
					System.out.println("the following recipes are not recommended for soy allergy as it contains soy");
					driver.navigate().back();
					String recipeName = driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]")).getText();
					System.out.println(recipeName);
					SoyList.add(recipeName);
				}
				else if (ingredient.contains("Sesame"))
				{
					System.out.println("Inside If loop");
					System.out.println("the following recipes are not recommended for Sesame allergy as it contains Sesame");
					driver.navigate().back();
					String recipeName = driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]")).getText();
					System.out.println(recipeName);
					SesameList.add(recipeName);
				}
				else if (ingredient.contains("Peanuts"))
				{
					System.out.println("Inside If loop");
					System.out.println("the following recipes are not recommended for Peanuts allergy as it contains Peanuts");
					driver.navigate().back();
					String recipeName = driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]")).getText();
					System.out.println(recipeName);
					PeanutList.add(recipeName);
				}
				
				else if (ingredient.contains("walnut"))
				{
					System.out.println("Inside If loop");
					System.out.println("the following recipes are not recommended for walnut allergy as it contains walnut");
					driver.navigate().back();
					String recipeName = driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]")).getText();
					System.out.println(recipeName);
					WalnutList.add(recipeName);
				}
				else if (ingredient.contains("hazelnut"))
				{
					System.out.println("Inside If loop");
					System.out.println("the following recipes are not recommended for hazelnut allergy as it contains hazelnut");
					driver.navigate().back();
					String recipeName = driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]")).getText();
					System.out.println(recipeName);
					HazelnutList.add(recipeName);
				}
				else if (ingredient.contains("pecan"))
				{
					System.out.println("Inside If loop");
					System.out.println("the following recipes are not recommended for pecan allergy as it contains pecan");
					driver.navigate().back();
					String recipeName = driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]")).getText();
					System.out.println(recipeName);
					PecanList.add(recipeName);
				}
				else if (ingredient.contains("cashew"))
				{
					System.out.println("Inside If loop");
					System.out.println("the following recipes are not recommended for cashew allergy as it contains cashew");
					driver.navigate().back();
					String recipeName = driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]")).getText();
					System.out.println(recipeName);
					CashewList.add(recipeName);
				}
				else if (ingredient.contains("pista"))
				{
					System.out.println("Inside If loop");
					System.out.println("the following recipes are not recommended for pista allergy as it contains pista");
					driver.navigate().back();
					String recipeName = driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]")).getText();
					System.out.println(recipeName);
					PistaList.add(recipeName);
				}
				else
				{
					System.out.println("Inside If loop");
					System.out.println("the following recipes dont have allergy foods");
					driver.navigate().back();
					String recipeName = driver.findElement(By.xpath("(//span[@class='rcc_recipename'])[" + i + "]")).getText();
					System.out.println(recipeName);
					NoAllergyList.add(recipeName);
				}
			}
		}
		
		
		
		 sheet=workbook.getSheet("Allergy");
		 System.out.println("Creating Header");
		 sheet.createRow(0);
			sheet.getRow(0).createCell(0).setCellValue("Milk");
			sheet.getRow(0).createCell(1).setCellValue("Soy");
			sheet.getRow(0).createCell(2).setCellValue("Sesame");
			sheet.getRow(0).createCell(3).setCellValue("Peanuts");
			sheet.getRow(0).createCell(4).setCellValue("walnut ");
			sheet.getRow(0).createCell(5).setCellValue("hazelnut");
			sheet.getRow(0).createCell(6).setCellValue("pecan");
			sheet.getRow(0).createCell(7).setCellValue("cashew");
			sheet.getRow(0).createCell(8).setCellValue("pista");
			
			int rowno = 1;
			
				System.out.println("Entering ExcelSheet");
				XSSFRow row = sheet.createRow(rowno++);
				row.createCell(0).setCellValue(MilkList.toString());
				row.createCell(1).setCellValue(SoyList.toString());
				row.createCell(2).setCellValue(SesameList.toString());
				row.createCell(3).setCellValue(PeanutList.toString());
				row.createCell(4).setCellValue(WalnutList.toString());
				row.createCell(5).setCellValue(HazelnutList.toString());
				row.createCell(6).setCellValue(CashewList.toString());
				row.createCell(6).setCellValue(PistaList.toString());
				row.createCell(6).setCellValue(NoAllergyList.toString());
				
		
	}
}
