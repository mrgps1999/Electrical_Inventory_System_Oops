import java.util.Scanner;

// -----------------------------------------------------
// Assignment (1)
// © Pratik Gondaliya, Yash Radadiya
// Written by: (Pratik Gondaliya 40194062;
//              Yash Radadiya 40198043)
// -----------------------------------------------------

public class Driver {
    public static Scanner sc = new Scanner(System.in);
    public static int object_created = 0;
    public static int count = 0;
    public static int increment = 0;
    public static boolean flag = false;
    public static int store = 0;
    public static String pass = "";
    public static Computer[] inventory;


    public static void main(String[] args) {
        //we are asking a user how many computer he/she can manage at a time in store?
        //and we are making array of Computer objects according to that size
        System.out.println("how many computers store can contain at a time?");
        Scanner scanner = new Scanner(System.in);
        int capacity = scanner.nextInt();
        inventory = new Computer[capacity];


        do {

            //Welcome Message
            System.out.println("      WELCOME!!!!!!     ");
            System.out.println("What do you want to do?");
            System.out.println("1. Enter new computers (password required)");
            System.out.println("2. Change information of a computer (password required)");
            System.out.println("3. Display all computers by a specific brand");
            System.out.println("4. Display all computers under a certain a price");
            System.out.println("5. Quit");
            System.out.println("Please enter your choice");
            int input = Integer.parseInt(sc.nextLine());


            switch (input) {

                case 1:
                    //Case 1 - starts from checking password as mentioned function above
                    //Then we ask about how many computer user/owner wants to enter now?
                    //If it exceeds size of limit, user won't be able to enter any computer
                    //If he enters proper value then for each pc we will input brand, model, SN and price
                    //We will assign it to inventory array at specific indexes
                    System.out.println("1. Enter new computers (password required)");
                    count = 0;
                    do {

                        System.out.println("1: Please Enter Password:");
                        pass = sc.nextLine().toLowerCase();

                        if (pass.equals("password")) {
                            increment = 0;
                            for (int i = 0; i < inventory.length; i++) {
                                if (inventory[i] == null) {
                                    increment = increment + 1;
                                }
                            }
                            //Asking owner how many computer you want to add!
                            System.out.println("How many computers you want to add ?");
                            try {
                                int additional_pc = Integer.parseInt(sc.nextLine());
                                if (additional_pc <= increment) {
                                    System.out.println("Congratulations we are ready add computers !!!");

                                    int diff = inventory.length - increment;
                                    int i = diff;
                                    //Ask about computer info

                                    do {
                                        i++;
                                        //ASking for details of computer
                                        System.out.println("Enter Brand Name:");
                                        String brand_name = sc.nextLine();
                                        System.out.println("Enter Model:");
                                        String model_name = sc.nextLine();
                                        System.out.println("Enter Price:");
                                        int pricee = Integer.parseInt(sc.nextLine());
                                        System.out.println("Enter SN:");
                                        Long SNN = Long.valueOf(sc.nextLine());
                                        inventory[i] = new Computer(brand_name, model_name, SNN, pricee);
                                        if (i == diff + additional_pc) {
                                            count = 3;
                                        }
                                    } while (i < diff + additional_pc);

                                } else {
                                    //if user enters incorrect attemps many time we will redirect them to welcome message
                                    System.out.println("There are only" + " " + increment + " " + "slots available!! Sorry!!!");

                                }
                            } catch (Exception e) {
                                System.out.println("Oops something is wrong!!!");
                                count = 3;
                            }


                        } else {
                            count = count + 1;
                            int diff = 3 - count;
                            System.out.println("Oops Wrong Input!!! " + diff + " attempts remaining!");


                            //System.out.println("Your Password is Wrong!!!");
                        }

                    } while (count != 3);


                    break;
                case 2:
                    //case 2 - update value by index
                    //User will be here then user wants to update the details of the computer for that we are asking for password.
                    System.out.println("2. Change information of a computer (password required)");
                    count = 0;
                    do {
                        System.out.println("2: Please Enter Password:");
                        pass = sc.nextLine().toLowerCase();
                        if (pass.equals("password")) {

                            int no_of_comp;
                            try {

                                do {
                                    //Asking user which computer no he/she wants to update
                                    System.out.println("Enter the no of computer which you want to update!!!");
                                    no_of_comp = Integer.parseInt(sc.nextLine());

                                    //Printing data which user tell us to show
                                    System.out.println("Computer: " + no_of_comp
                                            + "\nBrand: " + inventory[no_of_comp].getBrand()
                                            + "\nModel: " + inventory[no_of_comp].getModel()
                                            + "\nSN: " + inventory[no_of_comp].getSN()
                                            + "\nPrice: " + inventory[no_of_comp].getPrice() + "\n");

                                    //checking if capacity is there or not to add computer
                                    if (no_of_comp < inventory.length) {
                                        int value = 0;
                                        String attr = "";
                                        //inventory[no_of_comp].showData();
                                        do {

                                            System.out.println("What information would you like to change?\n");
                                            System.out.println("1. brand\n2. model\n3. SN\n4. price\n5. Quit");
                                            System.out.println("Enter your choice:");
                                            value = Integer.parseInt(sc.nextLine());
                                            if (value != 5) {
                                                System.out.println("Enter The details you want to update in " + value + " attribute:");
                                                attr = sc.nextLine();
                                            }
                                            switch (value) {
                                                case 1:
                                                    inventory[no_of_comp].setBrand(attr);

                                                    //Printing data with updated value
                                                    System.out.println("Data with Updated Value:\n");
                                                    System.out.println("Computer: " + no_of_comp
                                                            + "\nBrand: " + inventory[no_of_comp].getBrand()
                                                            + "\nModel: " + inventory[no_of_comp].getModel()
                                                            + "\nSN: " + inventory[no_of_comp].getSN()
                                                            + "\nPrice: " + inventory[no_of_comp].getPrice() + "\n");
                                                    break;
                                                case 2:
                                                    //for model
                                                    inventory[no_of_comp].setModel(attr);

                                                    System.out.println("Data with Updated Value:\n");
                                                    System.out.println("Computer: " + no_of_comp
                                                            + "\nBrand: " + inventory[no_of_comp].getBrand()
                                                            + "\nModel: " + inventory[no_of_comp].getModel()
                                                            + "\nSN: " + inventory[no_of_comp].getSN()
                                                            + "\nPrice: " + inventory[no_of_comp].getPrice() + "\n");
                                                    break;
                                                case 3:
                                                    //for SN
                                                    inventory[no_of_comp].setSN(Long.parseLong(attr));

                                                    System.out.println("Data with Updated Value:\n");
                                                    System.out.println("Computer: " + no_of_comp
                                                            + "\nBrand: " + inventory[no_of_comp].getBrand()
                                                            + "\nModel: " + inventory[no_of_comp].getModel()
                                                            + "\nSN: " + inventory[no_of_comp].getSN()
                                                            + "\nPrice: " + inventory[no_of_comp].getPrice() + "\n");
                                                    break;
                                                case 4:
                                                    //For price
                                                    inventory[no_of_comp].setPrice(Double.parseDouble(attr));

                                                    System.out.println("Data with Updated Value:\n");
                                                    System.out.println("Computer: " + no_of_comp
                                                            + "\nBrand: " + inventory[no_of_comp].getBrand()
                                                            + "\nModel: " + inventory[no_of_comp].getModel()
                                                            + "\nSN: " + inventory[no_of_comp].getSN()
                                                            + "\nPrice: " + inventory[no_of_comp].getPrice() + "\n");
                                                    break;
                                                case 5:
                                                    System.out.println("You have entered QUIT!!!");
                                                    break;
                                                default:
                                                    System.out.println("Please Enter Valid Number");
                                            }
                                        } while (value != 5);


                                        no_of_comp = 1;
                                        count = 3;
                                    } else {
                                        // If there is no Computer object at the specified index location, display a message asking the
                                        // user if he/she wishes to enter another computer, or quit this operation and go back to the main menu.

                                        System.out.println("Select from below Options");
                                        System.out.println("1. You want to enter another computer ?");
                                        System.out.println("2. Quit");
                                        int ans = Integer.parseInt(sc.nextLine());
                                        switch (ans) {
                                            case 1:
                                                continue;
                                            case 2:
                                                no_of_comp = 1;
                                                count = 3;

                                        }
                                    }

                                } while (no_of_comp > inventory.length);
                            } catch (Exception e) {
                                System.out.println("Oops something is wrong!!!");
                                count = 3;
                            }
                        } else {
                            count = count + 1;
                            int diff = 3 - count;
                            System.out.println("Oops Wrong Input!!! " + diff + " attempts remaining!");


                            //System.out.println("Your Password is Wrong!!!");
                        }
                    } while (count != 3);


                    break;
                case 3:
                    //Case 3 - This case is for finding out all product which has same brand_name as user enters
                    //It has function named as findComputersBy which takes care of this

                    System.out.println("3. Display all computers by a specific brand");

                    System.out.println("Enter Brand Name:");
                    try {
                        String in = sc.nextLine();

                        if (in != null) {
                            findComputersBy(in);
                        } else {
                            System.out.println("Enter Correct Input!!!");
                        }
                    } catch (Exception e) {
                        System.out.println("Oops something is wrong!!!");
                        count = 3;
                    }


                    break;
                case 4:
                    //Case 4 - This case is for finding out all product which has price under entered value by user
                    //It has function named as findCheaperThan which takes care of this

                    System.out.println("4. Display all computers under a certain a price.");
                    System.out.println("Enter Price:");
                    try {
                        double p = Integer.parseInt(sc.nextLine());
                        findCheaperThan(p);
                    } catch (Exception e) {
                        System.out.println("Oops something is wrong!!!");
                        count = 3;
                    }
                    break;
                case 5:
                    //User wants to exit!!! then user will be here

                    System.out.println("End of Driver!! See you soon!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter Correct Input!!!");

            }
        } while (flag == false);
    }
    
    /**
         * This function is for checking in inventory array that how many items has same brand as mentioned brand
         *
         * @param brandName we want to print items whose brand name is same as this parameter
         */
        public static void findComputersBy(String brandName) {

            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] != null) {
                    if (inventory[i].getBrand().toLowerCase().equals(brandName.toLowerCase())) {
                        System.out.println("Computer: " + i
                                + "\nBrand: " + inventory[i].getBrand()
                                + "\nModel: " + inventory[i].getModel()
                                + "\nSN: " + inventory[i].getSN()
                                + "\nPrice: " + inventory[i].getPrice() + "\n");
                    }
                }
            }
        }
        
        /**
         * This function is for checking in inventory array that how many items has less price than given value
         *
         * @param price we want to print items whose prices are less than this parameter
         */
        public static void findCheaperThan(double price) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] != null) {
                    if (inventory[i].getPrice() < price) {
                        System.out.println("Computer: " + i
                                + "\nBrand: " + inventory[i].getBrand()
                                + "\nModel: " + inventory[i].getModel()
                                + "\nSN: " + inventory[i].getSN()
                                + "\nPrice: " + inventory[i].getPrice() + "\n");
                    }
                }
            }

        }
       
}

