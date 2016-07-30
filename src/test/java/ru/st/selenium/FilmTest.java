package ru.st.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.st.selenium.model.Film;
import ru.st.selenium.model.User;
import ru.st.selenium.pages.TestBase;

/**
 * Created by Maria on 29.07.2016.
 */
public class FilmTest extends TestBase{

    @BeforeMethod
    public void mayBeLogout() {
        if (app.getUserHelper().isNotLoggedIn()) {
            return;
        }
        app.getUserHelper().logout();
    }

    @Test
    public void addFilmOk(){
        User user = new User().setLogin("admin").setPassword("admin");
        Film film = new Film().setTitle("Jaws").setYear("1975");

        app.getUserHelper().loginAs(user);
        int beforeAdd = app.getFilmHelper().getCountFilms();
        app.getFilmHelper().create(film);
        app.getNavigationHelper().openMainPage();
        int afterAdd = app.getFilmHelper().getCountFilms();

        Assert.assertEquals(afterAdd, beforeAdd + 1);
    }

    @Test
    public void deleteFilm(){
        User user = new User().setLogin("admin").setPassword("admin");
        Film film = new Film().setTitle("Jaws");

        app.getUserHelper().loginAs(user);
        app.getFilmHelper().search(film.getTitle());
        int beforeDelete = app.getFilmHelper().getCountFilms();
        app.getFilmHelper().delete(film);
        app.getNavigationHelper().openMainPage();
        int afterDelete = app.getFilmHelper().getCountFilms();

        Assert.assertEquals(afterDelete, beforeDelete - 1);
    }

    @Test
    public void addFilmFailed(){
        User user = new User().setLogin("admin").setPassword("admin");
        Film film = new Film().setTitle("Jaws").setYear("");

        app.getUserHelper().loginAs(user);
        app.getFilmHelper().create(film);

        Assert.assertTrue(app.getFilmHelper().error().isEnabled());
    }
}
