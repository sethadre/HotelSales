import java.io.*;
import java.util.*;

public class Sales {
    public static void ServiceChoice()throws FileNotFoundException{
        boolean check = true;
        Scanner console = new Scanner(System.in);
        PrintWriter out = new PrintWriter("sales.txt");
        System.out.println("Any Clients?(y/n)");
        String input = console.next();

        while(input.equals("y")) {
            console.nextLine();
            System.out.println("Client Name:");
            out.write(console.nextLine() + ";");

            //Services
            System.out.println("Services:\nD)inner\nC)onference\nL)odging");
            switch (console.next().toUpperCase()) {
                case "D": out.write("Dinner;");
                    break;
                case "C": out.write("Conference;");
                    break;
                case "L": out.write("Lodging;");
                    break;
                default:
                    System.out.println("Not a valid Input");
                    check = false;
                    ServiceChoice();
                    break;
            }
            out.write(console.nextLine());

            //Price
            if(check == true) {
                System.out.println("Price: ");
                String price = console.nextLine();
                try{
                    double convert;
                    convert = Double.parseDouble(price);
                } catch (Exception e){
                    System.out.println("Not a double");
                    check = false;
                    ServiceChoice();
                }
                out.write(price + ";");

                //Date
                if(check == true) {
                    System.out.println("Date(mm/dd/yyyy): ");
                    out.write(console.nextLine() + ";\n");
                    System.out.println("Any more Clients?(y/n)");
                    input = console.next();
                    input = String.valueOf(input.charAt(0));
                    System.out.println(input);
                }

                out.close();
                System.out.println("Thanks");
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        /*Scanner console = new Scanner(System.in);

        PrintWriter out = new PrintWriter("sales.txt");
        System.out.println("Any Clients?(y/n)");
        String input = console.next();

        out.close();
        System.out.println("Thanks");
         */


        ServiceChoice();

        Scanner salesIn = new Scanner( new File ("sales2.txt")).useDelimiter(";");
        PrintWriter dinnerOut = new PrintWriter("dinner.txt");
        PrintWriter conferenceOut = new PrintWriter("conference.txt");
        PrintWriter lodgingOut = new PrintWriter("lodging.txt");
        //salesIn.useDelimiter(";");
        while(salesIn.hasNextLine()){
            String line = salesIn.nextLine();
            System.out.println(line);

            while(salesIn.hasNext()){
                String name = salesIn.next();
                String service = salesIn.next();
                double price = salesIn.nextDouble();
                String date = salesIn.next();
                salesIn.nextLine();
                if(service.equals("Lodging")) {
                    lodgingOut.write(name + ";" + service + ";" + price + ";" + date + ";\n");
                }
                if(service.equals("Dinner")){
                        dinnerOut.write(name + ";" + service + ";" + price +";"+ date + ";\n");
                }
                if(service.equals("Conference")) {
                    conferenceOut.write(name + ";" + service + ";" + price + ";" + date + ";\n");
                }

            }
            dinnerOut.close();
            conferenceOut.close();
            lodgingOut.close();
        }

    }

}