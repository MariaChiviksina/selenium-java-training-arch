package ru.st.selenium.applogic1;

import org.openqa.selenium.WebElement;
import ru.st.selenium.applogic.FilmHelper;
import ru.st.selenium.model.Film;

import java.util.List;

public class FilmHelper1 extends DriverBasedHelper implements FilmHelper {

  public FilmHelper1(ApplicationManager1 manager) {
    super(manager.getWebDriver());
  }

  @Override
  public void create(Film film) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(Film film) {
    // TODO Auto-generated method stub

  }

  @Override
  public void search(String title) {
    // TODO Auto-generated method stub
//    return null;
  }

  @Override
  public int getCountFilms() {
    return 0;
  }

  @Override
  public WebElement error() {
    return null;
  }

  @Override
  public List<WebElement> getFilmsList() {
    return null;
  }

  @Override
  public boolean isNotFind() {
    return false;
  }

  @Override
  public void clearSearch() {

  }

}
