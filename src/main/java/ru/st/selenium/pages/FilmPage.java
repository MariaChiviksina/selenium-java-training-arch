package ru.st.selenium.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

/**
 * Created by MashaChiv on 29.07.2016.
 */
public class FilmPage extends AnyPage {

    private boolean acceptNextAlert = true;

    public FilmPage(PageManager pages) {
        super(pages);
    }

    @FindBy(css = "img[alt=\"Remove\"]")
    public WebElement removeBtn;

    public void removeFilm(){
        removeBtn.click();
        assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this[\\s\\S]$"));
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
