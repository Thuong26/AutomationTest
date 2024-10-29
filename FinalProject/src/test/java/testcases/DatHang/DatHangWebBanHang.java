package testcases.DatHang;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.DatHangPage;
import testcases.BaseTest;
import helpers.PropertiesFile;

public class DatHangWebBanHang extends BaseTest {

    private HomePage homePage;
    private DatHangPage dathangPage;

    @Test(description = "đặt hàng thành công")
    public void CheckDatHangThanhCong() {
        dathangPage = new DatHangPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        dathangPage.dathang("Nguyễn Linh", "nguyenthilink09102000@gmail.com", "0985430221", "Thọ Bình");
        dathangPage.lbl_result_PTTT("Phương thức thanh toán");
    }

    @Test(description = "Đặt hàng không nhập họ và tên")
    public void CheckDatHangFailHoVaTen() {
        dathangPage = new DatHangPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        dathangPage.dathang("", "nguyenthilink09102000@gmail.com", "0985430221", "Thọ Bình");
        dathangPage.lbl_result_hovaten("Vui lòng nhập họ tên");
    }

    @Test
    public void CheckDatHangFailEmail() {
        dathangPage = new DatHangPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        dathangPage.dathang("Nguyễn Linh", "", "0985430221", "Thọ Bình");
        dathangPage.lbl_result_email("Địa chỉ email không được trống");
    }

    @Test
    public void CheckDatHangFailSĐT() {
        dathangPage = new DatHangPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        dathangPage.dathang("Nguyễn Linh", "nguyenthilink09102000@gmail.com", "", "Thọ Bình");
        dathangPage.lbl_result_sđt("Số điện thoại không được trống");
    }

    @Test
    public void CheckDatHangFailDiaChi() {
        dathangPage = new DatHangPage(driver);
        navigateToURL(PropertiesFile.getPropValue("url"));
        dathangPage.dathang("Linh", "nguyenthilink09102000@gmail.com", "0985430221", "");
        dathangPage.lbl_result_diachi("Địa chỉ không được trống");
    }
}
