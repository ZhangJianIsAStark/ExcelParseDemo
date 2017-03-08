import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainEntrance {
    public static void main(String[] args) {
        ApnExcelParseTool excelParseTool = new ApnExcelParseTool();

        excelParseTool.setFilePath("/home/zhangjian/Desktop/all_apn_together.xlsx");

        Workbook workbook;
        try {
            workbook = excelParseTool.initWorkBook();

            List<ApnModel> outData = new ArrayList<>();

            if (workbook != null) {
                excelParseTool.parseWorkbook(workbook, outData);
            }

            if (outData.size() > 0) {
                new ApnWriteTool().write("/home/zhangjian/Desktop/apns-conf.xml", outData);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
