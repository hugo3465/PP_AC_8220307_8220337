/**
 * Nome: Pedro Marcelo Santos Pinho
 * Número: 8220307
 * Turma: LEIT2
 * 
 * Nome: Hugo Ricardo Almeida Guimarães
 * Número: 8220337
 * Turma: LEIT2
 */

package pp_ac_8220307_8220337.Application;

import java.io.IOException;


import pp_ac_8220307_8220337.Application.Menus.MenuManager;
import pp_ac_8220307_8220337.Application.Menus.StartMenu;


public class PP_AC_8220307_8220337 {

    /**
     * @param args the command line arguments
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        MenuManager menu = new MenuManager();

        StartMenu.display(menu);

    }

}
