import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.event.SwingPropertyChangeSupport;

public class VendingMachine {
    private Map<String, Double> snacks;

    public VendingMachine() {
        snacks = new HashMap<>(); 
        snacks.put("Doritos",2.0);
        snacks.put("Potato Chips",2.0);  
        snacks.put("Pretzels",1.5);  
        snacks.put("m&ms",2.5);  
        snacks.put("Goldfish",2.0);  
        snacks.put("Cheez-its",2.5);  
        snacks.put("Mint Gum",.5);  
        snacks.put("Skittles",2.0);  
        snacks.put("Snickers",1.5);  
        snacks.put("KitKat",1.5);  
        snacks.put("Cheetos",2.0);  
        snacks.put("Sour Patch Kids",1.5);   
}
    public String chooseSnack() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose your favorite snack!");
        for (String snack : snacks.keySet()) {
            System.out.println(snack + " - $" + snacks.get(snack));
        }
        System.out.println("Please enter which snack you would like: ");
        String selectedSnack = scan.nextLine().trim();
        while(!snacks.containsKey(selectedSnack)) {
            System.out.println("Sorry that snack is not available. Please choose from the available options.");
            selectedSnack = scan.nextLine().trim();
        }
        return selectedSnack;
    }
    
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        String selectedSnack = vendingMachine.chooseSnack();
        System.out.println("You have selected: " + selectedSnack);
	}
}