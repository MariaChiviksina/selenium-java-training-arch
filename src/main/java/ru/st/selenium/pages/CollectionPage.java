package ru.st.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Maria on 29.07.2016.
 */
public class CollectionPage extends AnyPage {

    public CollectionPage(PageManager pages) {
        super(pages);
    }

    @FindAll({@FindBy (className = "movie_box")})
    public List<WebElement> allFilms;

    @FindBy(id = "q")
    public WebElement search;

    @FindBy(css = "img[alt=\"Add movie\"]")
    public WebElement addMovieBtn;

    @FindBy(className = "title")
    public WebElement filmTitle;

    public void clickAddBtn(){
        addMovieBtn.click();
    }

    public void setSearch(String film){
        List<WebElement> films = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("movie_box")));

        search.clear();
        search.sendKeys(film + Keys.RETURN);

        ensureFilmsLoaded(films);
    }

    private void ensureFilmsLoaded(List<WebElement> films) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Boolean rsltsInvsbl = wait.until(ExpectedConditions.invisibilityOfAllElements(films));
        Assert.assertTrue(rsltsInvsbl);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public void clickMovieBox() {
        filmTitle.click();
    }

    public List<WebElement> getFilmsList(){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("movie_box")));
    }

    public boolean isFilmNotFind() {
        WebElement notFound = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("content")));
        String title = notFound.getText();
        return title.equals("No movies where found.");
    }

    public void clearSearch() {
        search.clear();
        search.sendKeys(Keys.RETURN);
    }
}
