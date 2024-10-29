package pages;
import helpers.Keyword;
import org.openqa.selenium.*;
import io.qameta.allure.Step;

public class GioHangPage extends Keyword {


    public GioHangPage(WebDriver driver1) {
        this.driver = driver1;
    }

    // các element trên trang web

    private By SAN_PHAM_1 = By.xpath("//a[contains(text(),'Chân váy xòe nhún tầng midi cotton')]");
    private By KICH_THUOC_SP1 = By.xpath("//body[1]/div[4]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[3]/label[1]/span[1]");
    private By SO_LUONG_SP1 = By.xpath("/html/body/section[2]/section[1]/div/div/div/div/div[2]/form/div[5]/div[2]/div/div[1]");
    private By BTN_THEM_VAO_GIO = By.xpath("//*[@id=\"add-to-cart-form\"]/div[5]/div[2]/div/div[1]/div[2]/div/button");
    private By BTN_XEM_GIO_HANG = By.xpath("/html/body/div[10]/div/div/div/div[2]/div[2]/a[2]");
    private By LBL_Result_TenSP1 = By.xpath("//*[@id=\"cart-tab\"]/div/div[1]/form/div[2]/div[1]/div[1]/div[3]/div[1]/h3/a");
    private By LBL_Result_SoLuongSP1 = By.xpath("//*[@id=\"qtyMobile1129035624\"]");
    private By TIEP_TUC_MUA = By.xpath("//*[@id=\"logo\"]/a/img");
    private By SAN_PHAM_2 = By.xpath("//a[contains(text(),'Áo thun ôm xếp ly vai')]");
    private By LBL_Result_TenSP2 = By.xpath("//*[@id=\"cart-tab\"]/div/div[1]/form/div[2]/div[1]/div[2]/div[3]/div[1]/h3/a");

    @Step("Check Gio hang khi them 1 SP")
    public GioHangPage Them1SP() {
        hover();
        clickElement(SAN_PHAM_1);
        clickElement(BTN_THEM_VAO_GIO);
        clickElement(BTN_XEM_GIO_HANG);
        return this;
    }
    @Step("label result số lượng 1sp")
    public GioHangPage lbl_result_soluong1SP() {
        verifyElement(LBL_Result_SoLuongSP1,"1");
        return this;
    }

    @Step("Check Gio hang khi them 2 SP giong nhau")
    public GioHangPage Them2SPGiongNhau() {
        hover();
        clickElement(SAN_PHAM_1);
        clickElement(SO_LUONG_SP1);
        clickElement(BTN_THEM_VAO_GIO);
        clickElement(BTN_XEM_GIO_HANG);
        return this;
    }
    @Step("label result tên sp1")
    public GioHangPage lbl_result_tenSP1(String thongBao) {
        verifyElementText(LBL_Result_TenSP1,thongBao);// ví dụ kia là element text thông báo false
        return this;
    }

    @Step("label result số lượng sp1")
    public GioHangPage lbl_result_soluongSP1() {
        verifyElement(LBL_Result_SoLuongSP1,"2");
        return this;
    }

    @Step("Check Gio hang khi them 2 SP khac nhau")
    public GioHangPage Them2SPKhacNhau() {
        hover();
        clickElement(SAN_PHAM_1);
        clickElement(SO_LUONG_SP1);
        clickElement(BTN_THEM_VAO_GIO);
        clickElement(BTN_XEM_GIO_HANG);
        clickElement(TIEP_TUC_MUA);
        hover2();
        clickElement(SAN_PHAM_2);
        clickElement(BTN_THEM_VAO_GIO);
        clickElement(BTN_XEM_GIO_HANG);
        return this;
    }

    @Step("label result tên sp2")
    public GioHangPage lbl_result_tenSP2(String thongBao) {
        verifyElementText(LBL_Result_TenSP2,thongBao);// ví dụ kia là element text thông báo false
        return this;
    }
    @Step("Đóng popup giỏ hàng")
    public GioHangPage closePopup() {
        try {
            // Giả định bạn có một nút đóng modal có class là 'close' (như trong HTML bạn đã cung cấp)
            clickElement(By.cssSelector(".close"));
        } catch (Exception e) {
            System.out.println("Không thể tìm thấy nút đóng modal: " + e.getMessage());
        }
        return this;
    }
    public void clickElement(By by) {
        try {
            WebElement element = driver.findElement(by);
            // Kiểm tra xem phần tử có hiển thị không trước khi click
            if (element.isDisplayed()) {
                element.click();
            }
        } catch (ElementClickInterceptedException e) {
            // Nếu click không thành công, thử JavaScript để click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(by));
        }
    }
}
