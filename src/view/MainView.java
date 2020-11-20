package view;

import java.sql.SQLException;

public class MainView {
    public void Display() throws SQLException, ClassNotFoundException {
        //Affiche l'écran principal de l'application avec son menu

        //Selon la sélection dans le menu

        //affiche le formulaire User
        UserView userView = new UserView();
        userView.DisplayForm();

    }
}
