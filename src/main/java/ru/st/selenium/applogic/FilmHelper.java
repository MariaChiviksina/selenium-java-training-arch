package ru.st.selenium.applogic;

import org.openqa.selenium.WebElement;
import ru.st.selenium.model.Film;

import java.util.List;

public interface FilmHelper {

	void create(Film film);
	void delete(Film film);
	void search(String title);

	int getCountFilms();
	WebElement error();

    List<WebElement> getFilmsList();

	boolean isNotFind();

	void clearSearch();
}
