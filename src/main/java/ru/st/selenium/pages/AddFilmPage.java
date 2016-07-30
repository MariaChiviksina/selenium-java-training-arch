package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Maria on 29.07.2016.
 */
public class AddFilmPage extends AnyPage {

    public AddFilmPage(PageManager pages) {
        super(pages);
    }

    @FindBy(name = "name")
    public WebElement filmName;

    @FindBy(name = "year")
    public WebElement filmYear;

    @FindBy(css = "img[alt=\"Save\"]")
    public WebElement saveBtb;


    public AddFilmPage setFilmName(String name){
        filmName.sendKeys(name);
        return this;
    }

    public AddFilmPage setYear(String year){
        filmYear.sendKeys(year);
        return this;
    }

    public void clickSaveBtn(){
        saveBtb.click();
    }

    public WebElement getError(){
        WebElement error = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("error")));
        Assert.assertTrue(error.isEnabled());

        return error;
    }
}
