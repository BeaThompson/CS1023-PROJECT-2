import java.util.*;

public class DogShelter {
              // Setting global constants
              static double[] gWeight;
              static final int gMAX_DOGS = 100;
              static Scanner gIN = new Scanner(System.in);
              static int gShelterSize;

              public static void main(String[] args) {
                  //Main method serves as Main Menu
                  //Users will be directed here after each method
                            //These variables are taken from user to direct to correct method
                            int optionMenu;
                            System.out.println("UTSA - Spring2022 - CS1083 - Section 005 - Project 2 - TexasShelter - written by Brayden Thompson");
                            //Allowing User to exit with option 0
                            do {
                                          System.out.print("Please, enter the number of dogs in the shelter (Max 100): ");
                                          gShelterSize = gIN.nextInt();
                                          gWeight = new double[gShelterSize];
                                          // Allowing to close shelter with option 4
                                          do {
                                                        System.out.println("MAIN MENU");
                                                        System.out.println("0 - Exit, 1 - Report, 2 - Assign/Modify dogs, 3 - (Ex)Change Dog, 4 - Close Shelter, 5 - List");
                                                        System.out.print("Select an option : ");
                                                        optionMenu = gIN.nextInt();
                                                        // Taking option from user
                                                        if (optionMenu == 0) {
                                                        break;
                                                        } else if ( optionMenu == 1) {
                                                                      report();
                                                        } else if ( optionMenu == 2) {
                                                                      assignModifyDog();
                                                        } else if (optionMenu == 3) {
                                                                      changeDog();
                                                        } else if (optionMenu == 4) {
                                                                      closeShelter();
                                                        } else if (optionMenu == 5) {
                                                                      listDogs();
                                                        } else if (optionMenu == 0) {
                                                                      break;
                                                        }
                                          } while (optionMenu != 4);
                            } while (optionMenu != 0);
                            //Ending program
                            System.out.println("Farewell");

                            
                            
              }
              //report gives the # of dogs in each weight class
              public static void report() {
                int i;
                // Array for sizes
                String[] sizes = {"Xsmall", "Small", "Medium", "Large", "Xlarge"};
                // Running through all the sections
                System.out.println("DOGS' REPORT");
                for (i = 4; i >-1; --i) {
                    System.out.println(sizes[i] + " : " + getDogsByClassification(i));
                }

              }
            //getDogsByClassification sweeps through array to find amount of dogs in each weight class
              public static int getDogsByClassification(int classificationCode){
                            int count = 0;
                            int i;
                            //for Xlarge dogs
                            if (classificationCode == 4){
                                for (i = 0; i < gWeight.length; ++i){
                                    if (gWeight[i] >= 90 && gWeight[i] <= 100) {
                                        ++count;
                                    }
                                }
                            //for Large dogs
                            } else if (classificationCode == 3){
                                for (i = 0; i < gWeight.length; ++i){
                                    if (gWeight[i] >= 50 && gWeight[i] < 90) {
                                        ++count;
                                    }
                                }
                            } 
                            //for medium
                            else if (classificationCode == 2){
                                for (i = 0; i < gWeight.length; ++i){
                                    if (gWeight[i] >= 30 && gWeight[i] < 50) {
                                        ++count;
                                    }
                                }
                            } 
                            //for small
                            else if (classificationCode == 1){
                                for (i = 0; i < gWeight.length; ++i){
                                    if (gWeight[i] >= 20 && gWeight[i] < 30) {
                                        ++count;
                                    }
                                }
                            } 
                            //for Xsmall
                            else if (classificationCode == 0){
                                for (i = 0; i < gWeight.length; ++i){
                                    if (gWeight[i] > 0 && gWeight[i] < 20) {
                                        ++count;
                                    }
                                }
                            } 
                            return count;
                //assignMod will assign weight to dogs in array
              }
              public static void assignModifyDog(){
                            int index;
                            //newWeight is used to swap into array
                            double newWeight = 0;
                            System.out.print("Enter the index (0 to " + gShelterSize + ") : ");
                            index = gIN.nextInt();
                            //Makes sure index is in range
                            while (index < 0 || index > gShelterSize){
                                          System.out.print("Value out of range, please, try again: ");
                                          index = gIN.nextInt();
                            }
                            System.out.println("The current weight of the dog at " + index + " is : " + gWeight[index]);
                            System.out.print("Enter the weight of the new dog (0.00 - 100.00) : ");
                            newWeight = gIN.nextDouble();
                            // Makes sure new range is in range
                            while (newWeight < 0.00 || newWeight > 100.00){
                                          System.out.print("Value out of range, please, try again: ");
                                          newWeight = gIN.nextDouble();
                            }
                            gWeight[index] = newWeight;
              }
              // changeDog will swap weight of 2 different dogs
              public static void changeDog() {
                            //These are the variables that will be swapped
                            int idxTo;
                            int idxFrom;
                            System.out.print("Enter the position from ( 0 to " + gShelterSize + ") : ");
                            idxTo = gIN.nextInt();
                            //Checking for valid input
                            while (idxTo < 0 || idxTo > gShelterSize) {
                                          System.out.print("Value out of range, please, try again: ");
                                          idxTo = gIN.nextInt();
                            }
                            System.out.print("Enter the position to change to ( 0 to " + gShelterSize + ") that is not " + idxTo);
                            idxFrom = gIN.nextInt();
                            //Checking for valid input
                            while (idxFrom < 0 || idxFrom > gShelterSize || idxFrom == idxTo) {
                                          System.out.print("Value out of range, please, try again: ");
                                          idxFrom = gIN.nextInt();
                            }
                            System.out.println(" To : " + idxTo + " From " + idxFrom);
                            System.out.println(" To : " + idxTo + " From " + idxFrom);
                            //Make sure they are not equal
                            if (gWeight[idxTo] != gWeight[idxFrom]) {
                                          swapFunction(gWeight[idxTo], gWeight[idxFrom]);
                            }
                            System.out.println(" To : " + idxTo + " From " + idxFrom);
                            
              }
              //swapFunction is used in changeDog to save redundancies
              public static void swapFunction(double x, double y){
                            //used in changeDog()
                            double temp = x;
                            x = y;
                            y = temp;
              }
              //closeShelter will reset the weight of all the dogs
              public static void closeShelter() {
                            int i;
                            for (i = 0; i < gShelterSize; ++i) {
                                          gWeight[i] = 0;
                            }
              }
              //list will give a list of all the dogs and their weight
              public static void listDogs() {
                            int i; // iterate through the array
                            System.out.println("LIST OF DOGS' WEIGHT");
                            for (i = 0; i < gShelterSize; ++i) {
                                          System.out.println("Dog[" + i + "] : " + gWeight[i]);
                            }

              }


}