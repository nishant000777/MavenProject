package VOXIBrowser;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class ExcelHandler {
    static ArrayList<String> arrlstTestData = new ArrayList();
    protected static int intGblTestCaseRowNumber;
    protected static Map<String, String> mapTestData = new HashMap();

    public static void readData(String TestCaseID) throws Exception {
        File src = new File("src/main/resources/TestData/Book1.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook xsf = new XSSFWorkbook(fis);
        XSSFSheet sheet = xsf.getSheetAt(0);
        int rc = sheet.getPhysicalNumberOfRows();
        arrlstTestData.clear();
        mapTestData.clear();
        Iterator var4 = sheet.iterator();
        int cc = 0;
        DataFormatter dataFormatter = new DataFormatter();
        if (var4.hasNext()) {
            Row row = (Row) var4.next();
            cc = row.getPhysicalNumberOfCells();
            for (int intcount = 0; intcount <= cc; ++intcount) {
                arrlstTestData.add(dataFormatter.formatCellValue(row.getCell(intcount)));
            }
        }
        intGblTestCaseRowNumber = -1;
        int inttmpRowCnt = 0;

        for (Iterator var10 = sheet.iterator(); var10.hasNext(); ++inttmpRowCnt) {
            Row row = (Row) var10.next();
            String strTestCaseID = dataFormatter.formatCellValue(row.getCell(0));
            if (strTestCaseID.equals(TestCaseID)) {
                for (int intcount = 0; intcount <= cc; ++intcount) {
                    mapTestData.put((String) arrlstTestData.get(intcount), dataFormatter.formatCellValue(row.getCell(intcount)));
                }

                intGblTestCaseRowNumber = inttmpRowCnt;
            }
        }

        Assert.assertTrue(intGblTestCaseRowNumber >= 0, "Test case ID not found in the datasheet :: Test case Id is : " + TestCaseID);
        mapTestData.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
       /* for(int i=1; i<=rc;i++)
        {
            String check = sheet.getRow(i).getCell(0).getStringCellValue();
            Optional<String> optCheck = Optional.of(check);
            if(optCheck.isPresent() && optCheck.get().equals(TestCaseID))
              {
                  System.out.println("before firstname");
                  firstName = sheet.getRow(i).getCell(1).getStringCellValue();
                  lastName = sheet.getRow(i).getCell(2).getStringCellValue();
                  dateOfBirth = sheet.getRow(i).getCell(3).getNumericCellValue();
                  userName = sheet.getRow(i).getCell(4).getStringCellValue();
                  email = sheet.getRow(i).getCell(5).getStringCellValue();
                  postCode = sheet.getRow(i).getCell(6).getStringCellValue();
                  break;
              }

        }*/


    }
}