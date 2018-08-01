package DD_Rough;

import DD_Core.testCore;
import DD_Util.ExcelReader;

public class testRunmode extends testCore{
	
	public static ExcelReader excel=new ExcelReader("F:\\DataDrivenFramework\\DataDrivenFacebookProject\\src\\DD_Properties\\test_data.xlsx");
	public static boolean  isExecutable()
	{
		for(int rownum=2;rownum<=excel.getRowCount("test_suit1");rownum++)
		{
			if(excel.getCellData("test_suit1", "tcid", rownum).equals("LoginTest"))
         {
        	 if(excel.getCellData("test_suit1", "runmode", rownum).equals("Y"))
        	 {
        		 return true;
        	 }
        	 else
        	 {
        		 return false;
        	 }
         }
		}
		return false;
	}
	public static void main(String[] args) {

		System.out.println(isExecutable());

	}

}
