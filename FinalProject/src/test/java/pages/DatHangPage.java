package pages;

import helpers.Keyword;
import org.openqa.selenium.By;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DatHangPage extends Keyword {


    public DatHangPage(WebDriver driver1) {
        this.driver = driver1;
    }

    // các element trên trang web
    private By SAN_PHAM_1 = By.xpath("//*[@id=\"template-index\"]/section[4]/section/div/div[2]/div/div/div[1]/div/form/div[1]/a/img[2]");
    private By BTN_MUA_NGAY = By.xpath("//*[@id=\"add-to-cart-form\"]/div[5]/div[2]/div/div[2]/button");
    private By TXT_HO_VA_TEN = By.xpath("//*[@id=\"billing_address_full_name\"]");
    private By TXT_EMAIL = By.xpath("//*[@id=\"checkout_user_email\"]");
    private By TXT_SĐT = By.xpath("//input[@id='billing_address_phone']");
    private By TXT_DIA_CHI = By.xpath("//input[@id='billing_address_address1']");
    private By CBB_TINH = By.xpath("//select[@id='customer_shipping_province']");
    private By CBB_HUYEN = By.xpath("//select[@id='customer_shipping_district']");
    private By CBB_XA = By.xpath("//select[@id='customer_shipping_ward']");
    private By BTN_PHUONG_THUCTT = By.xpath("//form[@id='form_next_step']");
    private By LBL_RESULT_PTTT = By.xpath("//h2[contains(text(),'Phương thức thanh toán')]");

    private By LBL_RESULT_HOVATEN = By.xpath("//p[contains(text(),'Vui lòng nhập họ tên')]");

    private By LBL_RESULT_EMAIL = By.xpath("//p[contains(text(),'Địa chỉ email không được trống')]");
    private By LBL_RESULT_SĐT = By.xpath("//p[contains(text(),'Số điện thoại không được trống')]");
    private By LBL_RESULT_DIACHI = By.xpath("//p[contains(text(),'Địa chỉ không được trống')]");
    private By LBL_RESULT_TINH = By.xpath("//p[contains(text(),'Vui lòng chọn tỉnh thành')]");


    @Step("Check Dat Hang Thanh Cong")
    public DatHangPage dathang(String hovaten, String email,String sđt, String diachi) {
        hover();
        clickElement(SAN_PHAM_1);
        clickElement(BTN_MUA_NGAY);
        clearText(TXT_HO_VA_TEN);
        clearText(TXT_EMAIL);
        clearText(TXT_SĐT);
        clearText(TXT_DIA_CHI);
        setText(TXT_HO_VA_TEN, hovaten);
        setText(TXT_EMAIL, email);
        setText(TXT_SĐT, sđt);
        setText(TXT_DIA_CHI, diachi);
        selectOptionByText(CBB_TINH,"Hưng Yên");
        selectOptionByText(CBB_HUYEN,"Huyện Khoái Châu");
        selectOptionByText(CBB_XA,"Xã Tân Dân");
        clickElement(BTN_PHUONG_THUCTT);
        return this;
    }


    @Step("label result PTTT")
    public DatHangPage lbl_result_PTTT(String thongBao) {
        verifyElementText(LBL_RESULT_PTTT,thongBao);// ví dụ kia là element text thông báo false
        return this;
    }

    @Step("label result HoVaTen")
    public DatHangPage lbl_result_hovaten(String thongBao) {
        verifyElementText(LBL_RESULT_HOVATEN,thongBao);// ví dụ kia là element text thông báo false
        return this;
    }

    @Step("label result Email")
    public DatHangPage lbl_result_email(String thongBao) {
        verifyElementText(LBL_RESULT_EMAIL,thongBao);// ví dụ kia là element text thông báo false
        return this;
    }

    @Step("label result SĐT")
    public DatHangPage lbl_result_sđt(String thongBao) {
        verifyElementText(LBL_RESULT_SĐT,thongBao);// ví dụ kia là element text thông báo false
        return this;
    }

    @Step("label result DiaChi")
    public DatHangPage lbl_result_diachi(String thongBao) {
        verifyElementText(LBL_RESULT_DIACHI,thongBao);// ví dụ kia là element text thông báo false
        return this;
    }

    @Step("label result Tinh")
    public DatHangPage lbl_result_tinh(String thongBao) {
        verifyElementText(LBL_RESULT_TINH,thongBao);// ví dụ kia là element text thông báo false
        return this;
    }
}
