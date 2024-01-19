
// Define a LoanCalculator class that extends the Loan class
public class LoanCalculator extends Loan implements LoanInterface {
    public LoanCalculator(double amount, double interestRate, int term) {
        super(amount, interestRate, term);
    }
}
