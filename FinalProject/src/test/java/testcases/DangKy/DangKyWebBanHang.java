package testcases.DangKy;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.DangKyPage;
import testcases.BaseTest;
import helpers.PropertiesFile;

public class DangKyWebBanHang extends BaseTest {

    private HomePage homePage;
    private DangKyPage dangkyPage;

//    @Test
//    public void DangKyThanhCong(){
//        homePage=new HomePage(driver);
//        dangkyPage =new DangKyPage(driver);
//        navigateToURL(PropertiesFile.getPropValue("url"));
//        homePage.moDangKy();
//        dangkyPage.dangKyVoi("Nguyễn","linh", "nguyenthilink09102000@gmail.com", "linh0910", "linh0910");
//        dangkyPage.thayThongBaoAlertDangKyThanhCong();
//    }

    @Test
    public void DangKyKhongThanhCong_FailHo()
    {
        homePage=new HomePage(driver);
        dangkyPage =new DangKyPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        homePage.moDangKy();
        dangkyPage.dangKyVoi("","linh", "nguyenthilink09102000@gmail.com","0368424724", "linh0910");
        dangkyPage.thayThongBaoFailHo("");
    }

    @Test
    public void DangKyKhongThanhCong_FailTen()
    {
        homePage=new HomePage(driver);
        dangkyPage =new DangKyPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        homePage.moDangKy();
        dangkyPage.dangKyVoi("nguyễn","", "nguyenthilink09102000@gmail.com","0368424724", "linh0910");
        dangkyPage.thayThongBaoFailTen("");
    }

    @Test
    public void DangKyKhongThanhCong_FailEmail()
    {
        homePage=new HomePage(driver);
        dangkyPage =new DangKyPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        homePage.moDangKy();
        dangkyPage.dangKyVoi("Nguyễn","linh", "","0368424724", "linh0910");
        dangkyPage.thayThongBaoFailEmail("");
    }

    @Test
    public void DangKyKhongThanhCong_FailPass()
    {
        homePage=new HomePage(driver);
        dangkyPage =new DangKyPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        homePage.moDangKy();
        dangkyPage.dangKyVoi("Nguyễn","linh", "nguyenthilink09102000@gmail.com","0368424724", "");
        dangkyPage.thayThongBaoFailPass("");
    }

    @Test
    public void DangKyKhongThanhCong_FailEmailDaTonTai()
    {
        homePage=new HomePage(driver);
        dangkyPage =new DangKyPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        homePage.moDangKy();
        dangkyPage.dangKyVoi("Nguyen","linh", "nguyenthilink09102000@gmail.com","0368424724", "linh0910");
        dangkyPage.thayThongBaoFailEmailDATonTai("Email đã tồn tại. Nếu bạn quên mật khẩu, bạn có thể thiết lập lại mật khẩu tại đây.");
    }

    @Test
    public void DangKyKhongThanhCong_FailEmailthieukitu()
    {
        homePage=new HomePage(driver);
        dangkyPage =new DangKyPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        homePage.moDangKy();
        dangkyPage.dangKyVoi("Nguyễn","linh", "aaagmail.com","0368424724", "linh0910");
        dangkyPage.thayThongBaoFailEmail("");
    }

    @Test
    public void DangKyKhongThanhCong_FailEmailthieudaucham()
    {
        homePage=new HomePage(driver);
        dangkyPage =new DangKyPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        homePage.moDangKy();
        dangkyPage.dangKyVoi("Nguyễn","linh", "aaa@gmailcom","0368424724", "linh0910");
        dangkyPage.thayThongBaoFailEmail("");
    }

    @Test
    public void DangKyKhongThanhCong_FailEmailcochuadaucach()
    {
        homePage=new HomePage(driver);
        dangkyPage =new DangKyPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        homePage.moDangKy();
        dangkyPage.dangKyVoi("Nguyễn","linh", "a @gmail.com","0368424724", "linh0910");
        dangkyPage.thayThongBaoFailEmail("");
    }
}
