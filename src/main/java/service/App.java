package service;

public class App {

  public static void main(String[] args) throws Exception{
    DataService dataService = new DataService();
    
    String data = dataService.readData();
    System.out.println(data);
    MenuService menuService = new MenuService();
    
    // display introductory message
    menuService.intro();
    
    // show main menu
    menuService.mainMenu();

    }    

}
