package BasicFunctionalities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReading 
{
	public static void main(String[] args) throws IOException 
	{
		//create a file stream so that it has access to read the file 
		FileInputStream fis = new FileInputStream("C:\\Users\\BRLAVAN\\Desktop\\DL\\Personal\\DataDrivenFramework\\src\\test\\resources");
		
		//pass the fis to workbook as an argument
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		//get the counts of the sheets in the excel
		int Sheet_count= workbook.getNumberOfSheets();
		
		//iterate to the required sheetname
		for(int i=0;i<Sheet_count;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("data"))
			{
				//sheet name
				XSSFSheet sheet_name=workbook.getSheetAt(i);
				//step 1: identify the TestCase column by scanning entire column
				//iterate throw every rows of the sheet.
				Iterator<Row>rows= sheet_name.iterator(); // sheet is collection of rows
				//identify the first row
				Row firstRow=rows.next();
				//scan the row by reading each and every cell to identify TestCase
				Iterator<Cell>cell=firstRow.cellIterator(); // row is collection of cells
				int k=0;
				int column=0;
				while(cell.hasNext())
				{
					Cell value=cell.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCase"))
					{
						//to find the index of the cell
						column=k;
					}
					k++;
				}
								
				//step 2: once test case is identified scan entire column to find the purchase row
				//scan through the rows
				while(rows.hasNext())
				{
					Row r=rows.next();
					Cell Row_value=r.getCell(column);
				}
				
				
				
				//step 3: once you identify purchase, fetch entire row.
				
			}
		}
	}
}
