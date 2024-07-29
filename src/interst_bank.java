
import java.util.Scanner;

interface hdfc{
    double getInterestRate();
}

class BOI implements hdfc {
    public double getInterestRate() {
        return 5.0;
    }
}

class UNION implements hdfc {
    public double getInterestRate() {
        return 6.0;
    }
}

class INDIAN implements hdfc {
    public double getInterestRate() {
        return 4.5;
    }
}

public class interst_bank {
    public static hdfc getBank(String bankName) {
        switch (bankName) {
            case "BOI": return new BOI();
            case "UNION": return new UNION();
            case "INDIAN": return new INDIAN();
            default: return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input (BANK_NAME AMOUNT MONTH): ");
        String input = scanner.nextLine();
        scanner.close();

        String[] parts = input.split(" ");
        if (parts.length != 3) {
            System.out.println("Invalid input format. Expected: BANK_NAME AMOUNT MONTH");
            return;
        }

        String bankName = parts[0];
        double amount = Double.parseDouble(parts[1]);
        int months = Integer.parseInt(parts[2]);

        hdfc bank = getBank(bankName);
        if (bank == null) {
            System.out.println("Bank " + bankName + " not found.");
            return;
        }

        double interest = (amount * bank.getInterestRate() * months) / 100;
        System.out.println("Calculated interest for " + bankName + " on amount " + amount + " for " + months + " months is: " + interest);
    }
}
