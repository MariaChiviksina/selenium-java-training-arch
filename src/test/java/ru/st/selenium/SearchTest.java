package ru.st.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.Film;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;

import java.util.List;

/**
 * Created by MashaChiv on 30.07.2016.
 */
public class SearchTest extends TestBase{

    @BeforeMethod
    public void mayBeLogout() {
        if (app.getUserHelper().isNotLoggedIn()) {
            return;
        }
        app.getUserHelper().logout();
    }

    @Test
    public void FilmFindOK(){
        User user = new User().setLogin("admin").setPassword("admin");
        Film film = new Film().setTitle("Jaws").setYear("1975");

        app.getUserHelper().loginAs(user);
        app.getFilmHelper().search(film.getTitle());

        List<WebElement> filmsList= app.getFilmHelper().getFilmsList();
        for (WebElement filmEl : filmsList) {
            Assert.assertTrue(film.getTitle().equals(filmEl.findElement(By.className("title")).getText()));
        }
    }

    @Test
    public void FilmFindFailed(){
        User user = new User().setLogin("admin").setPassword("admin");
        Film film = new Film().setTitle("kjhkj").setYear("1975");

        app.getUserHelper().loginAs(user);
        app.getFilmHelper().search(film.getTitle());

        Assert.assertTrue(app.getFilmHelper().isNotFind());
    }

    @AfterMethod
    public void clearSearchField(){
        app.getFilmHelper().clearSearch();
    }
}
