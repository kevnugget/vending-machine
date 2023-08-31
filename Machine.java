import java.util.Scanner;
public class Machine{
    public static void main (String[] args)
        {
            double itemCost = 14.69; // price of the item
            double userPay; // user inputs their initial payment
            Scanner input = new Scanner(System.in);
            System.out.println("The item is $14.69. How much will you enter?");
            userPay = input.nextDouble();
            double userChange = userPay - itemCost; // calculates how much is owed. if positve, vending owe. if negative, user owe. if 0, no owe.
            
            if (userChange < 0) // user owes money
            {
                while (userChange < 0)
                    {
                        System.out.println("Amount Paid: $" + userPay + ".");
                        System.out.println("Amount Owed: $" + (double)-1*Math.round(userChange*100)/100); // rounds amount to 2 decimals
                        System.out.println("Please enter more.");
                        double addUserPay = input.nextDouble();
                        userPay += addUserPay; // adds new input into userPay (old input)
                        userChange += addUserPay; // adjusts how much is owed
                    }    
            }

            if (userChange == 0.0 || userPay == itemCost) // weird error, revise
            {
                System.out.println("Amount Paid: $" + userPay + ".");
                System.out.println("*dispensing item*\n Thank you for your purchase!");
            }

            else  
            {
                System.out.println("Amount Paid: $" + userPay + ".");
                System.out.println("Change: $"+ (double) Math.round(userChange*100)/100);
                calculateChange(userChange);
            }

            
        }

            public static void calculateChange(double userChange)
            {
                userChange*=100;
                int dollarsOwed = (int) userChange / 100;
                userChange%=100;
                int quartersOwed = (int) userChange / 25;
                userChange%=25;
                int dimesOwed = (int) userChange / 10;
                userChange%=10;
                int nickelsOwed = (int) userChange / 5;
                userChange%=5;
                int penniesOwed = (int) userChange;

                System.out.print(dollarsOwed + " dollars\n" + quartersOwed + " quarters\n" + dimesOwed + " dimes\n" + nickelsOwed + " nickels\n" + penniesOwed + " pennies");

            }
    
}