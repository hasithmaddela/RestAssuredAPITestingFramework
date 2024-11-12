package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	String filepath=System.getProperty("user.dir")+"\\TestData\\Userdata.xlsx";
	ExcelUtil eu=new ExcelUtil(filepath);
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException
	{
		int noofrows=eu.getRowCount("Sheet1");
		int noofcolumns=eu.getColumnCount("Sheet1", 0);
		String[][] data=new String[noofrows][noofcolumns];
		for(int i=1;i<=noofrows;i++) {
			for(int c=0;c<noofcolumns;c++) {
				data[i-1][c]=eu.getCellData("Sheet1", i, c);
			}
		}	
		return data;
	}
		
	@DataProvider(name="Usernamedata")
	public String[] userNameData() throws IOException
	{
		int noofrows=eu.getRowCount("Sheet1");
		String[] username=new String[noofrows];
		for(int i=1;i<=noofrows;i++) 
		{
			username[i-1]=eu.getCellData("Sheet1", i, 1);
		}
		return username;
	}
	}


