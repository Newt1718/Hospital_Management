package Interface;

import Functions.Utilities;
import java.util.ArrayList;

public class Menu {
    private String title;
    private ArrayList<String> optionList = new ArrayList();

    public Menu(String title){
        this.title = title;
    }

    public void insertOption(String newOP){optionList.add(newOP);}

    public int getChoice(){
        int maxOP = optionList.size();
        String input = "Pick [1.."+maxOP+"]: ";
        String error = "Please choose between 1 and.." + maxOP;
        return Utilities.Gintminmax(input, error, 1, maxOP);
    }
    
    public void displayMenu(){
        System.out.println("\nWelcome To "+title); 
        for (int i=0;i<optionList.size();i++) {
            System.out.println(optionList.get(i));
        }
    }
}
