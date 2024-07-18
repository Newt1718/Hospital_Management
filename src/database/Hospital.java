package database;

import Functions.Utilities;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Hospital {
    private boolean change = false;   
    private HashMap<String, Nurse> mapNurse = new HashMap<>();
    private HashMap<String, Patient> mapPatient = new HashMap<>();

    public void createNurse(){
        String Id, confirmation;
        do{
            do{
                Id=Utilities.StringForm("Input nurse's ID (N+6 numbers): ", "Please input the correct form.", "^[N|n]\\d{6}$");
                if(mapNurse.containsKey(Id) == true){System.out.println("ID existed, please choose a different ID.");}
            }while(mapNurse.containsKey(Id) == true);
                String name = Utilities.Gstring("Input Name: ", "Please input the correct form.");
                int age = Utilities.Gintmin("Input Age: ", "Please input the correct form.", 0);
                int Gender = Utilities.Gintminmax("Input Gender: (1=Male, 2=Female): ","1 or 2 only.", 1, 2);
                String gender; if(Gender == 1) {gender = "M";}else{gender = "F";}
                String address = Utilities.Gstring("Input Address: ", "Please input the correct form.");
                String phone = Utilities.StringForm("Input Phone number (10): ","Please input the correct form.","^\\d{10}$");
                String department = Utilities.Gstring("Input Department: ", "Please input the correct form.");
                String shift = Utilities.Gstring("Input Shift: ", "Please input the correct form.");
                double salary = Utilities.Gdouble("Input Salary: ", "Please input the correct form.", 0);   
                mapNurse.put(Id, new Nurse(Id, name, age, gender, address, phone, department, shift, salary));
                System.out.println("Nurse Added.");
                confirmation = Utilities.StringForm("Continue? (Y/N): ","Pick Y or N only.","^[N|n|Y|y]$");
                change = true;
        }while(confirmation.equalsIgnoreCase("Y"));
    }

    public void findNurse() {
        boolean confirm = false;
        String name = Utilities.Gstring("Nurse's name: ", "Nurse not found.");
        System.out.println("======================================================================================================");
        System.out.println(String.format("|%4s  |%10s      |%4s |%7s |%9s  |%9s    |%11s |%6s |%8s |", "ID", "NAME", "AGE", "GENDER", "ADDRESS", "PHONE", "DEPARTMENT", "SHIFT", "SALARY"));
        System.out.println("======================================================================================================");
        for (Nurse n : mapNurse.values()) {
            if (n.getName().toLowerCase().contains(name.toLowerCase())) {
                n.print();
                confirm = true;
            }
        }
        if (confirm == false) {
            System.out.println("Nurse not found.");
        }
        System.out.println("======================================================================================================");
    }

    public void updateNurse() {
        String Id, confirm;
        do{
            do{
                Id = Utilities.StringForm("Input nurse's ID (N+6 numbers): ", "Please input the correct form.", "^[N|n]\\d{6}$");
                if(mapNurse.containsKey(Id) == false){ System.out.println("Nurse not found.");}
            }while(mapNurse.containsKey(Id) == false);
                Nurse a = mapNurse.get(Id);
                System.out.println("======================================================================================================");
                System.out.println(String.format("|%6s  |%10s      |%4s |%9s |%12s  |%10s    |%11s |%6s |%8s |", "ID", "NAME", "AGE", "GENDER", "ADDRESS", "PHONE", "DEPARTMENT", "SHIFT", "SALARY"));
                System.out.println("======================================================================================================");
                a.print();
                System.out.println("======================================================================================================");

                String NewName = Utilities.UpString("Enter new name: ", a.getName());
                int NewAge = Utilities.UpInt("Enter new age: ", 0, a.getAge());
                String newGender;
                int choiceGender = Utilities.Gintminmax("Choose gender (1.Male | 2.Female): ", "Choose either 1 or 2", 1, 2);
                if(choiceGender == 1){ newGender = "Male";}else{newGender = "Female";}
                String NewAdd = Utilities.UpString("Input New Name: ", a.getAddress());
                String NewPh = Utilities.UpString("Input New Phone Number: ", a.getPhone());
                String NewDep = Utilities.UpString("Input New Department: ", a.getDepartment());
                String NewShift = Utilities.UpString("Input New Shift: ", a.getShift());
                double NewSal = Utilities.UpDou("Input New Salary: ", 0, a.getSalary());
                a.setName(NewName);   a.setAge(NewAge);   a.setGender(newGender);   a.setAddress(NewAdd);   a.setPhone(NewPh);  a.setDepartment(NewDep);    a.setShift(NewShift);   a.setSalary(NewSal);
            System.out.println("Updated finished.");
            confirm = Utilities.StringForm("Continue? (Y/N): ", "Pick Y or N only.", "^[N|n|Y|y]$");
            change = true;
        }while(confirm.equalsIgnoreCase("Y"));
    }

    public void deleteNurse(){
        String Id, confirm;
        do{
            do{
                Id = Utilities.StringForm("Input nurse's ID (N+6 numbers): ", "Please input the correct form.", "^[N|n]\\d{6}$");
                if(mapNurse.containsKey(Id) == false){System.out.println("The nurse does not exist");}
            }while(mapNurse.containsKey(Id) == false);
            mapNurse.remove(Id);
            System.out.println("Deleted finished.");
            confirm = Utilities.StringForm("Continue? (Y/N): ", "Pick Y or N only.", "^[N|n|Y|y]$");
            change = true;
        }while(confirm.equalsIgnoreCase("Y"));
    }

    public void addPatient(){
        String Id, confirm;
        do{
            do{
                Id = Utilities.StringForm("Input patient's ID (P+6 numbers): ", "Please input the correct form.", "^[P|p]\\d{6}$");
                if (mapPatient.containsKey(Id) == true) {
                    System.out.println("ID existed. Please choose a different ID.");
                }
            }while(mapPatient.containsKey(Id) == true);
            String name = Utilities.Gstring("Input name: ", "Please input the correct form.");
            int age = Utilities.Gintmin("Input age: ", "Please input the correct form.", 0);
            String gender;
            int choiceGender = Utilities.Gintminmax("Choose gender (1.Male | 2.Female): ", "Please choose either 1 or 2", 1, 2);
            if(choiceGender == 1){gender = "Male";}else{gender = "Female";
            }
            String address = Utilities.Gstring("Input Address: ", "Please input the correct form.");
            String phone = Utilities.StringForm("Input Phone number (10): ","Please input the correct form.","^\\d{10}$");
            String diagnosis = Utilities.Gstring("Input Diagnosis: ", "Please enter a valid diagnosis");
            String addmissionDate = Utilities.FormatDate("Input Addmission date: ", "Please input the correct form.");
            String dischargeDate = Utilities.FormatDate("Input Discharge date: ", "Please input the correct form.");
            System.out.println("======================================================================================================");
            for(Nurse x : mapNurse.values()){
                x.print();
            }
            System.out.println("======================================================================================================");
            if(mapNurse.size() < 2){
                System.out.println("Not enough nurses.");
            }else{
                boolean check1, check2;
                String idNurse1, idNurse2;
                do{
                    idNurse1 = Utilities.StringForm("Input nurse's ID (N+6 numbers): ", "Please input the correct form.", "^[N|n]\\d{6}$");
                    check1 = checkNurseVacancy(idNurse1);
                    if(check1 == false){
                        System.out.println("Nurse not found.");  
                    }
                }while(check1 == false);
                do{
                    idNurse2 = Utilities.StringForm("Input nurse's ID (N+6 numbers): ", "Please input the correct form.", "^[N|n]\\d{6}$");
                    check2 = checkNurseVacancy(idNurse2);
                    if(check2 == false){
                        System.out.println("Nurse not found.");
                    }
                    if(idNurse1.equalsIgnoreCase(idNurse2)){
                        System.out.println("Nurse already assigned to a different patient.");
                    }
                }while(check2 == false || (idNurse1.equalsIgnoreCase(idNurse2)));
                String nurseAssigned = idNurse1 + "," + idNurse2;

                mapPatient.put(Id, new Patient(Id, name, age, gender, address, phone, diagnosis, addmissionDate, dischargeDate, nurseAssigned));
                System.out.println("Patient added.");
                change = true;
            }
            confirm = Utilities.StringForm("Continue? (Y/N): ", "Pick Y or N only.", "^[Y|y|N|n]$");
        }while(confirm.equalsIgnoreCase("Y"));
    }

    public boolean checkNurseVacancy(String id){
        boolean check = false;
        for(Nurse x : mapNurse.values()){
            if(x.getId().equalsIgnoreCase(id)){
                check = true;
            }
        }
        if(check == true){
            int count = 0;
            for(Patient x : mapPatient.values()){
                if(x.getNurseAssigned().toLowerCase().contains(id)){
                    count++;
                }
            }
            if(count >= 2){
                check = false;
            }
        }
        return check;
    }

    public long datetransfer(String date) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        long l = sdf.parse(date).getTime();
        return l;
    }

//display patients
    public void displayPatients() throws ParseException{
        if(mapNurse.isEmpty()){
            System.out.println("Nurse not found.");
        }else{
            String startD = Utilities.FormatDate("Addmission date: ", "Please input the correct form.");
            String endD;
            do{
                endD = Utilities.FormatDate("Enter the discharge date: ", "Please input the correct form.");
                if (datetransfer(startD) >= datetransfer(endD)) {
                    System.out.println("Invalid, must be before discharge date");
                }
            }while (datetransfer(startD) >= datetransfer(endD));
            System.out.println("Patient list");
            System.out.printf("Start: %s\n", startD);
            System.out.printf("End: %s\n", endD);
            boolean check = false;
            for(Patient n : mapPatient.values()){
                if(datetransfer(n.getAdmissionDate()) >= datetransfer(startD) && datetransfer(endD) >= datetransfer(n.getAdmissionDate())){
                    n.print();
                    check = true;
                }
            }
            if(!check){
                System.out.println("No patient fit the record.");
            }
        }
    }

//Sort patients
    public void sortPatients(){
        ArrayList<Patient> list = new ArrayList();
        for(Patient x : mapPatient.values()){
            list.add(x);
        }
        int choice1 = Utilities.Gintminmax("Choose (1.Sort by ID/2.Sort by Name): ", "Only 1 or 2.", 1, 2);
        int choice2;

        System.out.println("Patient list ");
        if(choice1 == 1){
            System.out.println("Sorted by ID: ");
            choice2 = Utilities.Gintminmax("1.Ascending/2.Descending: ", "Only 1 or 2.", 1, 2);
            if(choice2 == 1){
                System.out.println("Sorted by Ascending: ");
                Collections.sort(list, (a, b) -> {
                    return a.getId().compareToIgnoreCase(b.getId());
                });
            }else{
                System.out.println("Sorted by Descending: ");
                Collections.sort(list, (a, b) -> {
                    return b.getId().compareToIgnoreCase(a.getId());
                });
            }
        }else{
            System.out.println("Sorted by Name: ");
            choice2 = Utilities.Gintminmax("1.Ascending/2.Descending: ", "Only 1 or 2.", 1, 2);
            if(choice2 == 1){
                System.out.println("Sorted by Ascending: ");
                Collections.sort(list, (a, b) -> {
                    return a.getName().compareToIgnoreCase(b.getName());
                });
            }else{
                System.out.println("Sorted by Descending: ");
                Collections.sort(list, (a, b) -> {
                    return b.getName().compareToIgnoreCase(a.getName());
                });
            }
        }
        System.out.println("=========================================================");
        for(int i = 0; i < list.size(); i++){
            list.get(i).print();
        }
        System.out.println("=========================================================");
    }

    public void saveData(){
        boolean checkNurse, checkPatient;
        if(change == true){
            checkNurse = true;
            checkPatient = true;
            try{
                FileOutputStream fos = new FileOutputStream("Nurses.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(mapNurse);
                oos.close();
                fos.close();
            }catch(Exception e){
                System.out.println("Save failed.");
                checkNurse = false;
            }
            if(checkNurse){
                System.out.println("Save complete.");
            }
            try{
                FileOutputStream fos = new FileOutputStream("Patients.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(mapPatient);
                oos.close();
                fos.close();
            }catch(Exception e) {
                System.out.println("Save failed.");
                checkPatient = false;
            }
            if(checkPatient == true) {
                System.out.println("Save complete.");
            }
        }else{
            System.out.println("Save failed.");
        }
    }

    public void loadData(){
        mapNurse.clear();
        mapPatient.clear();
        boolean checkNurse = false;
        boolean checkPatient = false;
        try{
            FileInputStream fis = new FileInputStream("Nurses.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            mapNurse = (HashMap<String, Nurse>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception e){
            System.out.println("Save failed.");
        }
        if(!checkNurse){
            System.out.println("Save complete.");
        }
        try{
            FileInputStream fis = new FileInputStream("Patients.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            mapPatient = (HashMap<String, Patient>) ois.readObject();
            fis.close();
            ois.close();
        }catch (Exception e){
            System.out.println("Save failed.");
        }
        if(!checkPatient){
            System.out.println("Save complete.");
        }
    }
}
