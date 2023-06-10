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
import java.text.ParseException;
import java.time.LocalDate;

import ma02_resources.participants.Student;
import ma02_resources.project.Edition;
import ma02_resources.project.Project;
import ma02_resources.project.Status;
import pp_ac_8220307_8220337.Api.BaseEdition;
import pp_ac_8220307_8220337.Api.BaseProject;
import pp_ac_8220307_8220337.Api.BaseStudent;
import pp_ac_8220307_8220337.Api.EditionManagement;
import pp_ac_8220307_8220337.Api.interfaces.IEditionManagement;
import pp_ac_8220307_8220337.Application.Menus.MenuManager;
import pp_ac_8220307_8220337.Application.Menus.StartMenu;

public class PP_AC_8220307_8220337 {

    /**
     * @param args the command line arguments
     * @throws ParseException
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, ParseException {

        MenuManager menu = new MenuManager(5);

        StartMenu.display(menu);




        // Testes para ver se o write está a funcionar
        /*String name = menu.getUserInputString("Inser the name of the edition: ");
        String projectTemplate = menu.getUserInputString("Insert project template: ");
        LocalDate start = menu.getUserInputLocalDate("Insert stat date: ");
        LocalDate end = menu.getUserInputLocalDate("Insert end date: ");

        IEditionManagement teste = new EditionManagement();
        teste.addEdition(new BaseEdition(name, projectTemplate, start, end));

        teste.saveEditionsToFile("teste.bin");*/

    }

}
