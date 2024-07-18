package Interface;

import database.Hospital;
import java.text.ParseException;
import java.util.Scanner;

public class MenuUtil {
    public static void main(String[] args) throws ParseException {
        int choice = 0;
        Hospital hos = new Hospital();
        
        Menu display = new Menu("Hospital Management Program.");
             display.insertOption("1. Manage nurse.");
             display.insertOption("2. Manage patient.");
             display.insertOption("3. Save.");
             display.insertOption("4. Load");
             display.insertOption("5. Exit.");

        Menu displayNurse = new Menu("Nurse's Management.");
             displayNurse.insertOption("1/ Create.");
             displayNurse.insertOption("2/ Find.");
             displayNurse.insertOption("3/ Update.");
             displayNurse.insertOption("4/ Delete.");
             displayNurse.insertOption("5/ Main menu.");

        Menu displayPatient = new Menu("Patient's Management.");
             displayPatient.insertOption("1/ Add.");
             displayPatient.insertOption("2/ Display.");
             displayPatient.insertOption("3/ Sort.");
             displayPatient.insertOption("4/ Main menu.");
             

        do{
            display.displayMenu();
            choice = display.getChoice();
            switch(choice){
                case 1: int choiceNurse;
                        do {displayNurse.displayMenu();
                        choiceNurse = displayNurse.getChoice();
                        switch(choiceNurse){
                            case 1:hos.createNurse();
                                   break;
                            case 2:hos.findNurse();
                                   break;
                            case 3:hos.updateNurse();
                                   break;
                            case 4:hos.deleteNurse();
                                   break;
                            case 5:System.out.println("Main menu");
                                   break;
                        }
                    }while(choiceNurse != 5);
                    break;
                case 2: int choicePatient;
                        do {displayPatient.displayMenu();
                        choicePatient = displayPatient.getChoice();
                        switch (choicePatient) {
                            case 1:hos.addPatient();
                                   break;
                            case 2:hos.displayPatients();
                                   break;
                            case 3:hos.sortPatients();
                                   break;
                            case 4:System.out.println("Main menu");
                                   break;
                        }
                    }while(choicePatient != 4);
                    break;
                    
                case 3:hos.saveData();
                       break;
                       
                case 4:hos.loadData();
                       break;    
                    
                case 5: choice = 99;
                        break;
                default:System.out.println("Bad input. Please change input.");
                        break;
            }
        }while(choice != 99);System.out.println("Exit program!");
    }
}        

