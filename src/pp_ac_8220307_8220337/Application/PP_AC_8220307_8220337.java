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
        
        
        
        // // ISTO SÃO APENAS TESTES, PODES APAGAR À VONTADE
        
        // Edition edition = new BaseEdition("Teste", "não sei se isto é um caminho", Status.ACTIVE, LocalDate.now(), LocalDate.now().plusDays(46));
        
        // String[] tags = {
        //     "teste",
        //     "teste2",
        //     "teste3"
        // };

        // edition.addProject("Jesus Quisto", "O que era aqui mesmo", tags);


        // for(int i = 0; i < edition.getNumberOfProjects(); i++) {
        //     System.out.println(edition.getProjects()[i].toString());
        // }

        // //System.out.println(edition.getProject("Jesus Quisto").toString());

            
    }
    
}
