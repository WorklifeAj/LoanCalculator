import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
    	while (true) {
        try {
        	 Scanner input = new Scanner(System.in);
        	 
        	 double interestrate;
        	 int term;
        	 
        	//ask user to enter Amount
            System.out.print("\nEnter Loan Principal amount (or quit to quit program) :\n ");
            //read amount
            String in = input.nextLine();

            // Check if the user wants to quit
            if (in.equalsIgnoreCase("quit")) {
                break;
            }

            double amount = Double.parseDouble(in);
            
            
          //ask user to enter Interest Rate
            System.out.print("Enter Interest rate in decimal:\n ");
            //read interest rate
            interestrate = input.nextDouble();
            
          //ask user to enter term in years
            System.out.print("Enter Term in years:\n ");
            //read interest rate
            term = input.nextInt();
            
            // Create a LoanCalculator object with given loan data
            LoanInterface loan = new LoanCalculator(amount, interestrate, term);
            // Calculate the monthly payment and total interest using the LoanCalculator object
            double monthlyPayment = loan.calculateMonthlyPayment();
            double totalInterest = loan.calculateTotalInterest();
            // Print the monthly payment and total interest
            System.out.printf("Monthly payment: $%.2f\n", monthlyPayment);
            System.out.printf("Total interest: $%.2f\n", totalInterest);
        } catch (IllegalArgumentException e) {
            // Handle the exception if the loan data is invalid
            System.out.println(e.getMessage());
        }
    	}
    }
}