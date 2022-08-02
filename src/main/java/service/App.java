package service;

public class App {

  public static void main(String[] args) throws Exception{
    
    DataService.populateData();
    
    MenuService menuService = new MenuService();
    
    // display introductory message
    menuService.intro();
    
    // show main menu
    menuService.mainMenu();

    }    

}
