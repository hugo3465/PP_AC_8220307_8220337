package pp_ac_8220307_8220337.Application.Menus;

import ma02_resources.participants.Participant;
import ma02_resources.participants.Student;

/**
 * Nome: Pedro Marcelo Santos Pinho Número: 8220307 Turma: LEIT2
 *
 * Nome: Hugo Ricardo Almeida Guimarães Número: 8220337 Turma: LEIT2
 */
public class StudentMenu implements IMenu {
    private Participant student;

    public StudentMenu(Participant participant) {
        this.student = participant;
    }

    @Override
    public void display() {
        System.out.println("\n\t--- Hello " + student.getName() + " ---");
        System.out.println("\t1 - Add Submission");
        System.out.println("\t2 - Remove Submission");
        System.out.println("\t3 - Get Task");
        System.out.println("\t4 - List all Tasks");
        System.out.println("\t5 - List all Participants from Project");
        System.out.println("\t7 - Get progress from your Project");
        System.out.println("\t0 - Back\n");
    }

    public void display(MenuManager menuManager) {
        IMenu menuEdition = new StudentMenu(student);
        boolean isRunning = true;

        do {
            switch (menuManager.diplayMenu(menuEdition)) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    isRunning = false;
                default:
                    System.out.println("Invalid Option");
            }
        } while (isRunning);
    }
    
}
