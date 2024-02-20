import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    private Map<String, Double> snacks = new HashMap<>();
    private double insertedMoney = 0;

    public VendingMachine() {
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
        Scanner var1 = new Scanner(System.in);
        System.out.println("Welcome to the vending machine!");
        System.out.println("Please choose your favorite snack from the following:");
        Iterator<String> var2 = this.snacks.keySet().iterator();

        while(var2.hasNext()) {
            String var3 = (String)var2.next();
            System.out.println(var3 + " - $" + this.snacks.get(var3));
        }

        System.out.println("Please enter which snack you would like: ");

        String var4;
        for(var4 = var1.nextLine().trim(); !this.snacks.containsKey(var4); var4 = var1.nextLine().trim()) {
            System.out.println("Sorry that snack is not available. Please choose from the available options.");
        }

    return var4;
    }

    public void insertMoney(Scanner scanner) {
        System.out.println("Please insert money now: (only $1 bills are accepted)");
        
        while(!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.nextLine();
            System.out.println("Please insert money now: (only $1 bills are accepted)");
        }

        int money = scanner.nextInt();

        if (money >= 1) {
            insertedMoney += money;
            System.out.println("Money inserted: $"+money);
        } else {
            System.out.println("only $1 bill accepted. Please try again.");
        }

    }

    public boolean confirmChoice(Scanner scanner, String selectedSnack, int money) {
        System.out.println("You have selected " + selectedSnack + " and inserted $" + money);
        System.out.print("Do you want to proceed with your purchase? (yes/no): ");
        String confirmation = scanner.next().toLowerCase();

        if (confirmation.equals("yes")) {
            return true;
        } else {
            return false;
        }
    }

    public void returnChange(double price, double moneyInserted) {
        double change = moneyInserted - price;
        if (change > 0) {
            System.out.println("Please take your change: $" + change);
        } else {
            System.out.println("No change to return.");
        }
    }
   
    public static void main(String[] var0) {
        VendingMachine vendingMachine = new VendingMachine();
        Scanner scanner = new Scanner(System.in);
    
        String selectedSnack = vendingMachine.chooseSnack();
        System.out.println("You have selected: " + selectedSnack);
    
        vendingMachine.insertMoney(scanner);
    
        if (vendingMachine.confirmChoice(scanner, selectedSnack, (int) vendingMachine.insertedMoney)) {
            System.out.println("Transaction completed.");
            vendingMachine.returnChange(vendingMachine.snacks.get(selectedSnack), vendingMachine.insertedMoney);
            System.out.println("That is a very good choice, enjoy!");
        } else {
            System.out.println("Transaction canceled. Refunding $" + vendingMachine.insertedMoney);
        }
        scanner.close();
    }
}