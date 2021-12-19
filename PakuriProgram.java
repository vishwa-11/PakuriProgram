import java.util.Scanner;
public class PakuriProgram {
    //main menu method
    public static void menu() {
        System.out.println("Pakudex Main Menu");
        System.out.println("-----------------");
        System.out.println("1. List Pakuri");
        System.out.println("2. Show Pakuri");
        System.out.println("3. Add Pakuri");
        System.out.println("4. Evolve Pakuri");
        System.out.println("5. Sort Pakuri");
        System.out.println("6. Exit");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        System.out.print("Enter max capacity of the Pakudex: ");
        Scanner scnr = new Scanner(System.in);
        String maxCapacity = scnr.next();
        //a while loop that keeps going until a valid capacity is inputted. This checks whether the max capacity is valid using a try catch structure
        while (1 == 1) {
            try {
                if (Integer.parseInt(maxCapacity) <= 0) {
                    System.out.println("Please enter a valid size.");
                    System.out.print("Enter max capacity of the Pakudex: ");
                    maxCapacity = scnr.next();
                    continue;
                }
                else {
                    System.out.println("The Pakudex can hold " + Integer.parseInt(maxCapacity) + " species of Pakuri.");
                    break;
                }
            }
            // catches the exception and restarts the loop
            catch (Exception e) {
                System.out.println("Please enter a valid size.");
                System.out.print("Enter max capacity of the Pakudex: ");
                maxCapacity = scnr.next();
                continue;
            }
        }

        Pakudex Pakudeck = new Pakudex(Integer.parseInt(maxCapacity));
        System.out.println();
        menu();
        System.out.println();
        System.out.print("What would you like to do? ");
        String option = scnr.next();
        //another while loop that only stops with user input. uses try catch in order to display error message when letters are inputted.
        while (1 == 1) {
            try {
                if (Integer.parseInt(option) >= 1 && Integer.parseInt(option) <= 5) {
                    if (Integer.parseInt(option) == 1) {
                        //makes sure pakuri are present in the Pakuri array
                        if (Pakudeck.getSize() == 0) {
                            System.out.println("No Pakuri in Pakudex yet!");
                            System.out.println();
                        }
                        //if pakuri are present, a for loop displays each element
                        else {
                            System.out.println("Pakuri In Pakudex:");
                            int i;
                            for (i = 0; i < Pakudeck.getSize(); i++) {
                                System.out.println((i + 1) + ". " + Pakudeck.getSpeciesArray()[i]);
                            }
                        }
                    }

                    else if (Integer.parseInt(option) == 2) {
                        //first checks if the species are present
                        System.out.print("Enter the name of the species to display: ");
                        String species = scnr.next();
                        int species_index = 0;
                        int speciesMatch = 0;
                        int i;
                        for (i = 0; i < Pakudeck.getSize(); i++) {
                            if (species.equalsIgnoreCase(Pakudeck.getSpeciesArray()[i])) {
                                species_index = i;
                                speciesMatch++;
                                break;
                            }
                        }
                        //if so, then displays each element of the get stats array
                        if (speciesMatch == 1) {
                            System.out.println();
                            System.out.println("Species: " + Pakudeck.getSpeciesArray()[species_index]);
                            System.out.println("Attack: " + Pakudeck.getStats(species)[0]);
                            System.out.println("Defense: " + Pakudeck.getStats(species)[1]);
                            System.out.println("Speed: " + Pakudeck.getStats(species)[2]);
                        }
                        // if no such pakuri exists, then this:
                        else {
                            System.out.println("Error: No such Pakuri!");
                        }
                    }

                    else if (Integer.parseInt(option) == 3) {
                        if (Pakudeck.getSpeciesArray() != null) {
                            //checks if array is full
                            if (Pakudeck.getSpeciesArray().length == Pakudeck.getCapacity()) {
                                System.out.println("Error: Pakudex is full!");
                            }
                            else {
                                //otherwise adds the string element to the array. if species already in, then displays that
                                System.out.print("Enter the name of the species to add: ");
                                String species = scnr.next();
                                if (Pakudeck.addPakuri(species) == true) {
                                    System.out.println("Pakuri species " + species + " successfully added!");
                                }
                                else if (Pakudeck.checkIfSpeciesPresent(species) == true){
                                    System.out.println("Error: Pakudex already contains this species!");
                                }
                            }
                        }
                        // if no pakuri inside, then this:
                        else {
                            System.out.print("Enter the name of the species to add: ");
                            String species = scnr.next();
                            if (Pakudeck.addPakuri(species) == true) {
                                System.out.println("Pakuri species " + species + " successfully added!");
                            }
                            else {
                                System.out.println("Error: Pakudex already contains this species!");
                            }
                        }

                    }
                    // evolves the species
                    else if (Integer.parseInt(option) == 4) {
                        System.out.print("Enter the name of the species to evolve: ");
                        String species  = scnr.next();
                        if (Pakudeck.checkIfSpeciesPresent(species) == true) {
                            Pakudeck.evolveSpecies(species);
                            System.out.println(species + " has evolved!");
                        }
                        //if not species not existing, then this:
                        else {
                            System.out.println("Error: No such Pakuri!");
                        }
                    }
                    //Sorts the pakuri by calling the sort method
                    else if (Integer.parseInt(option) == 5) {
                        Pakudeck.sortPakuri();
                        System.out.println("Pakuri have been sorted!");
                    }
                    System.out.println();
                    menu();
                    System.out.println();
                    System.out.print("What would you like to do? ");
                    option = scnr.next();
                    continue;
                }
                //exits the loop
                else if (Integer.parseInt(option) == 6) {
                    System.out.println("Thanks for using Pakudex! Bye!");
                    break;
                }
                //ensures other numbers inputted for option receive an error statement
                else if (Integer.parseInt(option) <= 0 || Integer.parseInt(option) > 6) {
                    System.out.println("Unrecognized menu selection!");
                    System.out.println();
                    menu();
                    System.out.println();
                    System.out.print("What would you like to do? ");
                    option = scnr.next();
                    continue;
                }
            }
            //catches exception if letters are inputted for the option
            catch (NumberFormatException e) {
                System.out.println("Unrecognized menu selection!");
                System.out.println();
                menu();
                System.out.println();
                System.out.print("What would you like to do? ");
                option = scnr.next();
                continue;
            }
        }

    }
}
