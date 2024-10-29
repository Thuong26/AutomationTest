package pages;

import helpers.Keyword;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TimKiemPage extends Keyword {

    public TimKiemPage(WebDriver driver1) {
        this.driver = driver1;
    }

    // các element trên trang web
    private By BIEU_TUONG_SEARCH = By.xpath("/html/body/header[1]/div/div[4]/div/span");
    private By TXT_SEARCH = By.xpath("/html/body/header[2]/div/div[1]/div[2]/form/input[1]");
    private By BTN_SEARCH = By.xpath("/html/body/header[2]/div/div[1]/div[2]/form/span/button");

    private By LBL_RESULT1 = By.xpath("//a[contains(text(),'Chân váy midi xoè lưới')]");
    private By LBL_RESULT2 = By.xpath("//a[contains(text(),'Áo thun ôm xếp ly vai')]");
    private By LBL_RESULT3 = By.xpath("//*[@id=\"template-search\"]/section[2]/div/div/div[3]/h2");
    private By LBL_RESULT = By.xpath("//a[contains(text(),'Áo lụa nhún eo')]");

    // Overlay xuất hiện sau khi nhập text tìm kiếm
    private By OVERLAY = By.xpath("//div[contains(@class, 'tw-bg-black/40')]");

    @Step("Đợi và đóng overlay nếu xuất hiện")
    public TimKiemPage closeOverlay() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Tối đa chờ 10 giây
        try {
            // Chờ overlay xuất hiện và click để đóng nó
            wait.until(ExpectedConditions.visibilityOfElementLocated(OVERLAY));
            clickElement(OVERLAY); // Click để tắt overlay
            System.out.println("Overlay đã được đóng");
        } catch (TimeoutException e) {
            System.out.println("Không tìm thấy overlay, tiếp tục thực hiện tìm kiếm");
        }
        return this;
    }

    @Step("Tìm kiếm với từ khóa")
    public TimKiemPage timKiem(String tukhoa) {
        clickElement(BIEU_TUONG_SEARCH); // Click vào biểu tượng tìm kiếm
        setText(TXT_SEARCH, tukhoa); // Nhập từ khóa vào ô tìm kiếm

        closeOverlay(); // Đóng overlay nếu nó xuất hiện

        clickElement(BTN_SEARCH); // Click vào nút tìm kiếm
        return this;
    }

    @Step("Thông báo khi Search từ khóa chu hoa")
    public TimKiemPage thayKetQuaSearch(String ketqua) {
        verifyElementText(LBL_RESULT, ketqua); // Ví dụ kiểm tra text của element
        return this;
    }

    @Step("Thông báo khi Search từ khóa gần đúng")
    public TimKiemPage thayKetQuaSearch1(String ketqua) {
        verifyElementText(LBL_RESULT1, ketqua); // Kiểm tra text của element gần đúng
        return this;
    }

    @Step("Thông báo khi Search từ khóa đúng")
    public TimKiemPage thayKetQuaSearch2(String ketqua) {
        verifyElementText(LBL_RESULT2, ketqua); // Kiểm tra text của element từ khóa chính xác
        return this;
    }

    @Step("Thông báo khi từ khóa fail")
    public TimKiemPage thayKetQuaSearchfail(String ketqua) {
        verifyElementText(LBL_RESULT3, ketqua); // Kiểm tra text khi không có kết quả tìm kiếm
        return this;
    }

}
