
package com.unicesar.utils;

import com.unicesar.views.LoginView;
import com.vaadin.navigator.Navigator;
import com.unicesar.views.RegistrarNotas;


public class Views {
    
    public static final String MAIN = "MAINVIEW";
    public static final String LOGIN = "LOGINVIEW";
    public static final String REGISTRARNOTAS = "REGISTRARNOTASVIEW";
    
    
    public static void setViewsUI(Navigator vNavigator){
        vNavigator.addView(Views.LOGIN, LoginView.class);
//        vNavigator.addView(Views.MAIN, MainView.class);
        vNavigator.addView(Views.REGISTRARNOTAS, RegistrarNotas.class);
        
    }

    
}
