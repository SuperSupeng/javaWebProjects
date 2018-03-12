import domain.TempData;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import service.TempDataService;
import service.impl.TempDataServiceImpl;
import util.HibernateUtils;

import java.io.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TempDataServiceTest {
    private TempDataService service = new TempDataServiceImpl();

    @Test
    public void saveTest() throws Exception {
        File file = new File("src\\out.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String s = null;
        while ((s = br.readLine()) != null) {
            TempData tempData = new TempData();
            tempData.setId(UUID.randomUUID().toString());
            tempData.setDataDate(new Date(s.substring(1, 5) + "/" + s.substring(6, 8) + "/" + s.substring(9, 11)));
            tempData.setTemperature(Double.parseDouble(s.substring(12, s.length()-1)));
            service.save(tempData);
        }
    }

    @Test
    public void findTest() throws Exception {
        TempDataService service = new TempDataServiceImpl();
        List<TempData> allData = service.findAllData(new Date("1901/01/01"), new Date("1901/03/05"), true);
        System.out.println(allData);
    }

    @Test
    public void demoTest() throws Exception {
        double min = Double.valueOf("");
        System.out.println(min);
    }
}
