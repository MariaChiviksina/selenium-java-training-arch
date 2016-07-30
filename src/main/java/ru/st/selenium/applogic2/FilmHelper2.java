package ru.st.selenium.applogic2;

import org.openqa.selenium.WebElement;
import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.model.Film;

import java.util.List;

public class FilmHelper2 extends DriverBasedHelper implements FilmHelper {

  public FilmHelper2(ApplicationManager2 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void create(Film film) {
    // TODO Auto-generated method stub
    pages.collectionPage.waitPageLoaded();
    pages.collectionPage.clickAddBtn();
    pages.addFilmPage.setFilmName(film.getTitle()).setYear(film.getYear()).clickSaveBtn();
  }

  @Override
  public void delete(Film film) {
    // TODO Auto-generated method stub

    pages.collectionPage.clickMovieBox();
    pages.filmPage.waitPageLoaded();
    pages.filmPage.removeFilm();
  }

  @Override
  public void search(String title) {
    // TODO Auto-generated method stub
    pages.collectionPage.waitPageLoaded();
    pages.collectionPage.setSearch(title);
  }

  @Override
  public int getCountFilms() {
    pages.collectionPage.waitPageLoaded();
    return pages.collectionPage.allFilms.size();
  }

  @Override
  public WebElement error() {
    return pages.addFilmPage.getError();
  }

  @Override
  public List<WebElement> getFilmsList() {
    return pages.collectionPage.getFilmsList();
  }

  @Override
  public boolean isNotFind() {
    return pages.collectionPage.isFilmNotFind();
  }

  @Override
  public void clearSearch() {
    pages.collectionPage.clearSearch();
  }

}
