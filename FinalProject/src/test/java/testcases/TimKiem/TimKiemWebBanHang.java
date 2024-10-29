package testcases.TimKiem;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.TimKiemPage;
import testcases.BaseTest;
import helpers.PropertiesFile;

public class TimKiemWebBanHang extends BaseTest {

    private HomePage homePage;
    private TimKiemPage timkiemPage ;

    @Test
    public void TimKiemTuKhoaGanDung(){
        timkiemPage =new TimKiemPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        timkiemPage.timKiem("váy");
        timkiemPage.thayKetQuaSearch1("Chân váy midi xoè lưới");
    }

    @Test
    public void TimKiemTuKhoaDung(){
        timkiemPage =new TimKiemPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        timkiemPage.timKiem("Áo thun ôm xếp ly vai");
        timkiemPage.thayKetQuaSearch2("Áo thun ôm xếp ly vai");
    }

    @Test
    public void TimKiemTuKhoaNhapKiTuDacBiet(){
        timkiemPage =new TimKiemPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        timkiemPage.timKiem("##$%%^%*%*");
        timkiemPage.thayKetQuaSearchfail("Không tìm thấy bất kỳ kết quả nào với từ khóa trên.");
    }

    @Test
    public void TimKiemTuKhoaNhapSo(){
        timkiemPage =new TimKiemPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        timkiemPage.timKiem("12345");
        timkiemPage.thayKetQuaSearchfail("Không tìm thấy bất kỳ kết quả nào với từ khóa trên.");
    }


    @Test
    public void TimKiemTuKhoaNhapKhongCoTrongDB(){
        timkiemPage =new TimKiemPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        timkiemPage.timKiem("Um ba la");
        timkiemPage.thayKetQuaSearchfail("Không tìm thấy bất kỳ kết quả nào với từ khóa trên.");
    }

    @Test
    public void TimKiemTuKhoachuhoakhongdau(){
        timkiemPage =new TimKiemPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        timkiemPage.timKiem("AO");
        timkiemPage.thayKetQuaSearch("Áo lụa nhún eo");
    }

    @Test
    public void TimKiemTuKhoachuhoacodau() {
        timkiemPage =new TimKiemPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        timkiemPage.timKiem("ÁO");
        timkiemPage.thayKetQuaSearch("Áo lụa nhún eo");
    }

}
