package Functions;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Utilities {

    public static Scanner sc = new Scanner(System.in);

    public static int Gintminmax(String inp, String badinp, int min, int max) {
        int numint;
        while(true){
            try{
                System.out.print(inp);
                numint = Integer.parseInt(sc.nextLine());
                if(numint<min || numint>max) {
                    throw new Exception();
                }return numint;
            }catch(Exception e){
                System.out.println(badinp);
            }
        }
    }


    public static int Gintmin(String inp, String badinp, int min){
        int numint2;
        while(true){
            try{
                System.out.print(inp);
                numint2=Integer.parseInt(sc.nextLine());
                if(numint2<min){
                    throw new Exception();               
                }return numint2;
            }catch(Exception e){
                System.out.println(badinp);
            }
        }
    }
    

    public static double Gdouble(String inp, String badinp, double min){
        double numdouble;
        while(true){
            try{
                System.out.print(inp);
                numdouble = Double.parseDouble(sc.nextLine());
                if(numdouble<min){
                    throw new Exception();
                }return numdouble;
            }catch(Exception e){
                System.out.println(badinp);
            }
        }
    }


    public static String FormatDate(String inp, String badinp){
        String dfdate;
        boolean f;
        while(true){
            System.out.print(inp);
            dfdate = sc.nextLine().trim();
            try{
                SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                date.setLenient(false);//lenient set false to throw exception when invalid inp appears.
                date.parse(dfdate);//convert String to SimpleDateFormat
                return dfdate;
            }catch(Exception e){
                System.out.println(badinp);
            }
        }
    }
    
    
    public static String Gstring(String inp, String badinp) {
        String Stringid;
        while(true){
            System.out.print(inp);
            Stringid = sc.nextLine().trim();
            if(Stringid.length()==0) {
                System.out.println(badinp);
            }else{
                return Stringid;
            }
        }
    }
    
    
    public static String StringForm(String inp, String badinp, String inpform) {
        String formid;
        boolean confirm;
        while(true){
            System.out.print(inp);
            formid=sc.nextLine().trim(); 
            confirm=formid.matches(inpform);
            if(formid.length()==0 || confirm==false) {
                System.out.println(badinp);
            }else{
                return formid;
            }
        }
    }


    public static int UpInt(String inp, int min, int oldinp){
        boolean confirm = true;
        int newnum = oldinp;
        do{
            try{
                System.out.print(inp);
                String newinp = sc.nextLine();
                if(newinp.isEmpty()){
                    confirm = false;
                }else{
                    newnum = Integer.parseInt(inp);
                    confirm = false;
                }
            }catch(Exception e){
                System.out.println("Please input number.");
            }
        }while(confirm==true || newnum<min);
        return newnum;
    }


    public static String UpString(String inp, String oldinp){
        String newSr = oldinp;
        System.out.printf(inp);
        String newinp = sc.nextLine();
        if(!newinp.isEmpty()){  
            newSr = newinp;
        }return newSr;
    }


    public static double UpDou(String inp, double min, double oldinp){
        double newDou = oldinp;
        boolean confirm = true;
        do{
            try{
                System.out.print(inp);
                String newinp = sc.nextLine();
                if(newinp.isEmpty()){
                    confirm=false;
                }else{
                    newDou = Double.parseDouble(newinp);
                    confirm=false;
                }
            }catch(Exception e){
                System.out.println("Please insert number.");
            }
        }while(confirm=true || newDou<min);
        return newDou;
    }
}
