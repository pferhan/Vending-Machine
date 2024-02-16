import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    private Map<String, Double> snacks = new HashMap<>();

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
        System.out.println("Choose your favorite snack!");
        Iterator var2 = this.snacks.keySet().iterator();

        while(var2.hasNext()) {
            String var3 = (String)var2.next();
            System.out.println(var3 + " - $" + this.snacks.get(var3));
        }

        System.out.println("Please enter which snack you would like: ");

        String var4;
        for(var4 = var1.nextLine().trim(); !this.snacks.containsKey(var4); var4 = var1.nextLine().trim()) {
            System.out.println("Sorry that snack is not available. Please choose from the available options.");
        }

        var1.close();

    return var4;
    }
   
    public static void main(String[] var0) 
    {
        VendingMachine var1 = new VendingMachine();
        String var2 = var1.chooseSnack();
        System.out.println("You have selected: " + var2);
	}
}