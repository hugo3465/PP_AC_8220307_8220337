package pp_ac_8220307_8220337.Application;

public class MenuEditionAdmin implements MenuDisplay {

    @Override
    public void display() {
        System.out.println("Admin / Editions");
        System.out.println("1 - Add Edition");
        System.out.println("2 - Remove Edition");
        System.out.println("3 - Set Edition as Active");
        System.out.println("4 - Set Edition as Inactive");
        System.out.println("5 - Set Edition as Closed");
        System.out.println("6 - Set Edition as Canceled");
        System.out.println("7 - List all Editions");
        System.out.print("Choose an Option");
    }

    public static void editionMenu(MenuManagerUseless menuManager) {
        MenuDisplay menuEdition = new MenuEditionAdmin();
        boolean isRunning = true;

        while (isRunning) {
            menuManager.displayMenu(menuEdition);
            int option = menuManager.getInput();

            switch (option) {
                case 1:
                    // menuManager.editionManager.addEdition();
                    break;
                case 2:
                    // menuManager.editionManager.removeEdition();
                    break;
                case 3:
                    // menuManager.editionManager.setEditionAsActive();
                    break;
                case 4:
                    // menuManager.editionManager.setEditionAsInactive();
                    break;
                case 5:
                    // menuManager.editionManager.setEditionAsClosed();
                    break;
                case 6:
                    // menuManager.editionManager.setEditionAsCanceled();
                    break;
                case 7:
                    // menuManager.editionManager.listAllEditions();
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }
}