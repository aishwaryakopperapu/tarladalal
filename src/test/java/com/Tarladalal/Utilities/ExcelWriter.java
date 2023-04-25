package com.Tarladalal.Utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeGroups;
public class ExcelWriter {
	public static WebDriver driver;
	public static int pgCnt;
	public static int linksCount = 0;
	public static ArrayList<String> recipeNameList = new ArrayList<String>();
	public static ArrayList<String> recipeidList = new ArrayList<String>();
	public static ArrayList<String> ingredientList = new ArrayList<String>();
	public static ArrayList<String> prepTimeList = new ArrayList<String>();
	public static ArrayList<String> cookTimeList = new ArrayList<String>();
	public static ArrayList<String> MethodList = new ArrayList<String>();
	public static ArrayList<String> NutrientList = new ArrayList<String>();
	public static ArrayList<String> RecipeLink = new ArrayList<String>();
	
	public static ArrayList<String> DrecipeNameList = new ArrayList<String>();
	public static ArrayList<String> DrecipeidList = new ArrayList<String>();
	public static ArrayList<String> DingredientList = new ArrayList<String>();
	public static ArrayList<String> DprepTimeList = new ArrayList<String>();
	public static ArrayList<String> DcookTimeList = new ArrayList<String>();
	public static ArrayList<String> DMethodList = new ArrayList<String>();
	public static ArrayList<String> DNutrientList = new ArrayList<String>();
	public static ArrayList<String> DRecipeLink = new ArrayList<String>();
	
	public static ArrayList<String> TrecipeNameList = new ArrayList<String>();
	public static ArrayList<String> TrecipeidList = new ArrayList<String>();
	public static ArrayList<String> TingredientList = new ArrayList<String>();
	public static ArrayList<String> TprepTimeList = new ArrayList<String>();
	public static ArrayList<String> TcookTimeList = new ArrayList<String>();
	public static ArrayList<String> TMethodList = new ArrayList<String>();
	public static ArrayList<String> TNutrientList = new ArrayList<String>();
	public static ArrayList<String> TRecipeLink = new ArrayList<String>();
	
	public static ArrayList<String> PrecipeNameList = new ArrayList<String>();
	public static ArrayList<String> PrecipeidList = new ArrayList<String>();
	public static ArrayList<String> PingredientList = new ArrayList<String>();
	public static ArrayList<String> PprepTimeList = new ArrayList<String>();
	public static ArrayList<String> PcookTimeList = new ArrayList<String>();
	public static ArrayList<String> PMethodList = new ArrayList<String>();
	public static ArrayList<String> PNutrientList = new ArrayList<String>();
	public static ArrayList<String> PRecipeLink = new ArrayList<String>();
	
	public static String Morbid=null;
	public static int ReceipeCode=0;
	public static XSSFWorkbook workbook = new XSSFWorkbook();
	public static XSSFSheet sheet1=workbook.createSheet("Diabetic");
	public static XSSFSheet sheet2=workbook.createSheet("HyperTension");
	public static XSSFSheet sheet3=workbook.createSheet("Hypothyroid");
	public static XSSFSheet sheet4=workbook.createSheet("Pcos");
		
	public static String path=System.getProperty("user.dir")+ "/src/test/resources/RecipeBook/DemoFinal6.xlsx";//creates demo file in the folder
	
	public static File excelFile=new File(path);
	public static FileOutputStream Fos=null;
	
		public static void writeExcelSheet() throws IOException {
			
		
		if(ReceipeCode == 1)
		{
				Morbid="Diabetic";
				sheet1=workbook.getSheet("Diabetic");
				
			
			
			System.out.println("RecipeCode is 1");
			System.out.println(workbook.getSheetName(0));
			sheet1.createRow(0);
			sheet1.getRow(0).createCell(0).setCellValue("RecipeId");
			sheet1.getRow(0).createCell(1).setCellValue("Recipe Name");
			
			sheet1.getRow(0).createCell(2).setCellValue("Ingredients");
			sheet1.getRow(0).createCell(3).setCellValue("Preparation Time");
			sheet1.getRow(0).createCell(4).setCellValue("Cooking Time");
			sheet1.getRow(0).createCell(5).setCellValue("Preparation method");
			sheet1.getRow(0).createCell(6).setCellValue("Nutrient values");
			sheet1.getRow(0).createCell(7).setCellValue("Targetted morbid conditions (Diabeties/Hypertension/Hypothyroidism)");
			sheet1.getRow(0).createCell(8).setCellValue("Recipe URL");
			int rowno = 1;
			int Totalrecipecount= DrecipeNameList.size();
			for (int i = 0; i < Totalrecipecount; i++) {
				
				XSSFRow row = sheet1.createRow(rowno++);
				row.createCell(0).setCellValue(DrecipeidList.get(i).toString());
				row.createCell(1).setCellValue(DrecipeNameList.get(i).toString());
				row.createCell(2).setCellValue(DingredientList.get(i).toString());
				row.createCell(3).setCellValue(DprepTimeList.get(i).toString());
				row.createCell(4).setCellValue(DcookTimeList.get(i).toString());
				row.createCell(5).setCellValue(DMethodList.get(i).toString());
				row.createCell(6).setCellValue(DNutrientList.get(i).toString());
				
				row.createCell(7).setCellValue(Morbid);
				row.createCell(8).setCellValue(DRecipeLink.get(i).toString());
							
		}
		}
			
		
		if (ReceipeCode == 2)
		{
				Morbid="HyperTension";
				sheet2=workbook.getSheet("HyperTension");
			
			System.out.println("RecipeCode is 2");
			System.out.println(workbook.getSheetName(1));
			sheet2.createRow(0);
			sheet2.getRow(0).createCell(0).setCellValue("RecipeId");
			sheet2.getRow(0).createCell(1).setCellValue("Recipe Name");
			sheet2.getRow(0).createCell(2).setCellValue("Ingredients");
			sheet2.getRow(0).createCell(3).setCellValue("Preparation Time");
			sheet2.getRow(0).createCell(4).setCellValue("Cooking Time");
			sheet2.getRow(0).createCell(5).setCellValue("Preparation method");
			sheet2.getRow(0).createCell(6).setCellValue("Nutrient values");
			sheet2.getRow(0).createCell(7).setCellValue("Targetted morbid conditions (Diabeties/Hypertension/Hypothyroidism)");
			sheet2.getRow(0).createCell(8).setCellValue("Recipe URL");
			int rowno = 1;
			int Totalrecipecount= recipeNameList.size();
			for (int i = 0; i < Totalrecipecount; i++) {
				
				XSSFRow row = sheet2.createRow(rowno++);
				row.createCell(0).setCellValue(recipeidList.get(i).toString());
				row.createCell(1).setCellValue(recipeNameList.get(i).toString());
				row.createCell(2).setCellValue(ingredientList.get(i).toString());
				row.createCell(3).setCellValue(prepTimeList.get(i).toString());
				row.createCell(4).setCellValue(cookTimeList.get(i).toString());
				row.createCell(5).setCellValue(MethodList.get(i).toString());
				row.createCell(6).setCellValue(NutrientList.get(i).toString());
				row.createCell(7).setCellValue(Morbid);
				row.createCell(8).setCellValue(RecipeLink.get(i).toString());
			
		}
		}
		
		if (ReceipeCode == 3)
		{
				Morbid="Hypothyroid";
				sheet3=workbook.getSheet("Hypothyroid");
			
			System.out.println("RecipeCode is 3");
			System.out.println(workbook.getSheetName(1));
			sheet3.createRow(0);
			sheet3.getRow(0).createCell(0).setCellValue("RecipeId");
			sheet3.getRow(0).createCell(1).setCellValue("Recipe Name");
			sheet3.getRow(0).createCell(2).setCellValue("Ingredients");
			sheet3.getRow(0).createCell(3).setCellValue("Preparation Time");
			sheet3.getRow(0).createCell(4).setCellValue("Cooking Time");
			sheet3.getRow(0).createCell(5).setCellValue("Preparation method");
			sheet3.getRow(0).createCell(6).setCellValue("Nutrient values");
			sheet3.getRow(0).createCell(7).setCellValue("Targetted morbid conditions (Diabeties/Hypertension/Hypothyroidism)");
			sheet3.getRow(0).createCell(8).setCellValue("Recipe URL");
			int rowno = 1;
			int Totalrecipecount= TrecipeNameList.size();
			for (int i = 0; i < Totalrecipecount; i++) {
				
				XSSFRow row = sheet3.createRow(rowno++);
				row.createCell(0).setCellValue(TrecipeidList.get(i).toString());
				row.createCell(1).setCellValue(TrecipeNameList.get(i).toString());
				row.createCell(2).setCellValue(TingredientList.get(i).toString());
				row.createCell(3).setCellValue(TprepTimeList.get(i).toString());
				row.createCell(4).setCellValue(TcookTimeList.get(i).toString());
				row.createCell(5).setCellValue(TMethodList.get(i).toString());
				row.createCell(6).setCellValue(TNutrientList.get(i).toString());
				row.createCell(7).setCellValue(Morbid);
				row.createCell(8).setCellValue(TRecipeLink.get(i).toString());
			
		}
		}
		
		if (ReceipeCode == 4)
		{
				Morbid="Pcos";
				sheet4=workbook.getSheet("Pcos");
			
			System.out.println("RecipeCode is 4");
			System.out.println(workbook.getSheetName(1));
			sheet4.createRow(0);
			sheet4.getRow(0).createCell(0).setCellValue("RecipeId");
			sheet4.getRow(0).createCell(1).setCellValue("Recipe Name");
			sheet4.getRow(0).createCell(2).setCellValue("Ingredients");
			sheet4.getRow(0).createCell(3).setCellValue("Preparation Time");
			sheet4.getRow(0).createCell(4).setCellValue("Cooking Time");
			sheet4.getRow(0).createCell(5).setCellValue("Preparation method");
			sheet4.getRow(0).createCell(6).setCellValue("Nutrient values");
			sheet4.getRow(0).createCell(7).setCellValue("Targetted morbid conditions (Diabeties/Hypertension/Hypothyroidism)");
			sheet4.getRow(0).createCell(8).setCellValue("Recipe URL");
			int rowno = 1;
			int Totalrecipecount= PrecipeNameList.size();
			for (int i = 0; i < Totalrecipecount; i++) {
				
				XSSFRow row = sheet4.createRow(rowno++);
				row.createCell(0).setCellValue(PrecipeidList.get(i).toString());
				row.createCell(1).setCellValue(PrecipeNameList.get(i).toString());
				row.createCell(2).setCellValue(PingredientList.get(i).toString());
				row.createCell(3).setCellValue(PprepTimeList.get(i).toString());
				row.createCell(4).setCellValue(PcookTimeList.get(i).toString());
				row.createCell(5).setCellValue(PMethodList.get(i).toString());
				row.createCell(6).setCellValue(PNutrientList.get(i).toString());
				row.createCell(7).setCellValue(Morbid);
				row.createCell(8).setCellValue(PRecipeLink.get(i).toString());
			
		}
		}
			
//		String path=System.getProperty("user.dir")+ "/src/test/resources/RecipeBook/DemoFinal.xlsx";//creates demo file in the folder
//		
//		File excelFile=new File(path);
//		FileOutputStream Fos=null;
		                   
			
				Fos=new FileOutputStream(excelFile);
			
			workbook.write(Fos);
			//workbook.close();
		
//		finally
//		{
//			try {
//				Fos.close();
//			} catch (IOException e) {
//			e.printStackTrace();
//			}
//		}
	}
//		public static void main(String[] args)
//		{
//		
//			writeExcelSheet();
//		}
}