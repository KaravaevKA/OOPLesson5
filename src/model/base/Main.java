package model.base;

import model.Presenter;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws Exception {
        Presenter presenter = new Presenter();
        presenter.mainMenu();
    }
}
