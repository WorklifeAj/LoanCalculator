
public class Loan implements LoanInterface {
    // Private instance variables to store loan data
    private double amount; //principal amount
    private double interestRate; //interest rate percentage
    private int term; //Loan term in years

    // Constructor to create a Loan object with given loan data
    public Loan(double amount, double interestRate, int term) {
        this.amount = amount;
        this.interestRate = interestRate;
        this.term = term;
    }

    // Getter methods to access the private instance variables
    public double getAmount() {
        return amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTerm() {
        return term;
    }

    // Implement the calculateMonthlyPayment() method from the LoanInterface
    @Override
    public double calculateMonthlyPayment() {
        // Throw an exception if any of the loan data is invalid
        if (getAmount() <= 0 || getInterestRate() <= 0 || getTerm() <= 0) {
            throw new IllegalArgumentException("Invalid loan data");
        }

        // Calculate the monthly payment using the loan data
        double monthlyInterestRate = getInterestRate() / 12;
        int termInMonths = getTerm() * 12;
        double numerator = monthlyInterestRate * Math.pow(1 + monthlyInterestRate, termInMonths);
        double denominator = Math.pow(1 + monthlyInterestRate, termInMonths) - 1;
        double monthlyPayment = getAmount() * (numerator / denominator);
        return monthlyPayment;
    }

    // Implement the calculateTotalInterest() method from the LoanInterface
    @Override
    public double calculateTotalInterest() {
        // Calculate the total interest using the monthly payment and loan data
        double monthlyPayment = calculateMonthlyPayment();
        double totalInterest = (monthlyPayment * getTerm() * 12) - getAmount();
        return totalInterest;
    }
}