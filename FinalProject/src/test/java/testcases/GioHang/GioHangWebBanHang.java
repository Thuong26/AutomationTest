package testcases.GioHang;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.GioHangPage;
import testcases.BaseTest;
import helpers.PropertiesFile;

public class GioHangWebBanHang extends BaseTest {

    private HomePage homePage;
    private GioHangPage giohangPage;

    @BeforeMethod
    public void setUp() {
        giohangPage = new GioHangPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url")); // Mở URL trước mỗi bài kiểm tra
    }

    @Test
    public void CheckGioHangThem1SP() {
        giohangPage.Them1SP();
        giohangPage.closePopup(); // Đóng popup
        giohangPage.lbl_result_tenSP1("Chân váy xòe nhún tầng midi cotton");
        giohangPage.lbl_result_soluong1SP();
    }

    @Test
    public void CheckGioHangThem2SPGiongNhau() {
        giohangPage.Them2SPGiongNhau();
        giohangPage.closePopup(); // Đóng popup
        giohangPage.lbl_result_tenSP1("Chân váy xòe nhún tầng midi cotton");
        giohangPage.lbl_result_soluongSP1();
    }

    @Test
    public void CheckGioHangThem2SPKhacNhau() {
        giohangPage.Them2SPKhacNhau();
        giohangPage.closePopup(); // Đóng popup
        giohangPage.lbl_result_tenSP1("Chân váy xòe nhún tầng midi cotton");
        giohangPage.lbl_result_tenSP2("Áo thun ôm xếp ly vai");
    }

}
