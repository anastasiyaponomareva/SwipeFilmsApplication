package controller;

import java.io.Serializable;
import java.util.List;

import entities.Film;
import entities.User;

/**
 * Created by Anastasiya on 26.05.2016.
 */
public class UserFilmsController implements Serializable {
    //TODO: think of architecture - should we pass films separately or put t inside User field
    //NB: no default constructor - nothing will work, if we don't know
    //who our user is

    List<Film> filmsList;
    User user;

    public UserFilmsController(User user) {
        this.user = user;
    }

    public UserFilmsController(List<Film> filmList, User user) {
        this.filmsList = filmList;
        this.user = user;
    }

    public List<Film> getFilmsList() {
        return filmsList;
    }

    public void setFilmsList(List<Film> filmsList) {
        this.filmsList = filmsList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
