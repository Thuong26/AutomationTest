package pages;

import helpers.Keyword;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import helpers.PropertiesFile;

public class DangKyPage extends Keyword {


    public DangKyPage(WebDriver driver1) {
        this.driver = driver1;
    }

// các element trên trang web

    private By TXT_HO = By.id("lastName");

    private By TXT_TEN = By.id("firstName");

    private By TXT_SDT = By.id("Phone");

    private By TXT_EMAIL = By.id("email");

    private By TXT_PASSWORD = By.id("password");

    private By TXT_NHAP_LAI_PASS = By.id("repassword");

    private By BTN_DANG_KY = By.xpath("/html/body/section[2]/div/div/div[2]/div/div/div/form/div[2]/div[3]/button");

    //đăng ký không thành công
    //thông báo "Bạn chưa nhập thông tin này!"
    private By LBL_RESULT_HO = By.xpath("//*[@id=\"lastName\"]");

    private By LBL_RESULT_TEN = By.xpath("/html/body/section[2]/div/div/div[2]/div/div/div/form/div[2]/div[1]/div[2]/fieldset/input");

    private By LBL_RESULT_SDT = By.xpath("/html/body/section[2]/div/div/div[2]/div/div/div/form/div[2]/div[1]/div[3]/fieldset/input");

    private By LBL_RESULT_EMAIL = By.xpath("/html/body/section[2]/div/div/div[2]/div/div/div/form/div[2]/div[2]/div[1]/fieldset/input");

    private By LBL_RESULT_PASSWORD = By.xpath("/html/body/section[2]/div/div/div[2]/div/div/div/form/div[2]/div[2]/div[2]/fieldset/input");

    private By LBL_RESULT_NHAP_LAI_PASS = By.xpath("//div[contains(text(),'Mật khẩu nhập lại không đúng!')]");

    //Email đã tồn tại. Nếu bạn quên mật khẩu, bạn có thể thiết lập lại mật khẩu tại đây.
    private By LBL_RESULT_EMAIL_DA_TON_TAI = By.xpath("/html/body/section[2]/div/div/div[2]/div/div/div/form/div[1]/div/ul/li");

    //Mật khẩu nhập lại không đúng!
    private By LBL_RESULT_MK_NHAP_LAI = By.xpath("//div[contains(text(),'Mật khẩu nhập lại không đúng!')]");

    @Step("Đăng Ký thành công")
    public DangKyPage DANGKYTHANHCONG() {
        setText(TXT_HO, PropertiesFile.getPropValue("ho"));
        setText(TXT_TEN, PropertiesFile.getPropValue("ten"));
        setText(TXT_SDT, PropertiesFile.getPropValue("sdt"));
        setText(TXT_EMAIL, "khanhlinh.");
        setText(TXT_PASSWORD, PropertiesFile.getPropValue("password"));
        clickElement(BTN_DANG_KY);
        verifyAlertText("Đăng ký thành công!");
        return this;
    }

    @Step("đăng ký không thành công")
    public DangKyPage dangKyVoi(String ho, String ten,String email, String sdt, String password) {
        setText(TXT_HO, ho);
        setText(TXT_TEN, ten);
        setText(TXT_EMAIL, email);
        setText(TXT_SDT, sdt);
        setText(TXT_PASSWORD, password);
        clickElement(BTN_DANG_KY);
        return this;
        // hàm này thì là nhập email và password rồi đăng nhập
        //đăng nhập xong tạo 1 hàm kiểu verify kết quả mong đợi
    }

    @Step("Thông báo ALERT đăng ký thành công")
    public DangKyPage thayThongBaoAlertDangKyThanhCong() {
        verifyAlertText("Đăng ký thành công!");// ví dụ kia là element text thông báo false
        return this;
    }


    @Step("Thông báo Bạn chưa nhập thông tin này!")
    public DangKyPage thayThongBaoEmailDaTonTai() {
        verifyElementText(LBL_RESULT_EMAIL_DA_TON_TAI,"Email đã tồn tại. Nếu bạn quên mật khẩu, bạn có thể thiết lập lại mật khẩu tại đây.");// ví dụ kia là element text thông báo false
        return this;
    }
    @Step("Thông báo Bạn chưa nhập thông tin này!")
    public DangKyPage thayThongBaoFailHo(String thongBao) {
        verifyElementText(LBL_RESULT_HO,thongBao);// ví dụ kia là element text thông báo false
        return this;
    }
    public DangKyPage thayThongBaoFailTen(String thongBao) {
        verifyElementText(LBL_RESULT_TEN,thongBao);// ví dụ kia là element text thông báo false
        return this;
    }
    public DangKyPage thayThongBaoFailEmail(String thongBao) {
        verifyElementText(LBL_RESULT_EMAIL,thongBao);// ví dụ kia là element text thông báo false
        return this;
    }
    public DangKyPage thayThongBaoFailSoDienThoai(String thongBao){
        verifyElementText(LBL_RESULT_SDT,thongBao);
        return this;
    }
    public DangKyPage thayThongBaoFailPass(String thongBao) {
        verifyElementText(LBL_RESULT_PASSWORD,thongBao);// ví dụ kia là element text thông báo false
        return this;
    }
    public DangKyPage thayThongBaoFailNhapLaiPass(String thongBao) {
        verifyElementText(LBL_RESULT_MK_NHAP_LAI,thongBao);// ví dụ kia là element text thông báo false
        return this;
    }

    @Step("Thông báo Email đã tồn tại.")
    public DangKyPage thayThongBaoFailEmailDATonTai(String thongBao) {
        verifyElementText(LBL_RESULT_EMAIL_DA_TON_TAI,thongBao);// ví dụ kia là element text thông báo false
        return this;
    }







}
