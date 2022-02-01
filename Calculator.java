public class Calculator {

    private int lowerLimit;
    private int upperLimit;

    public Calculator(int lowerLimit, int upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public int add(int firstNumber, int secondNumber) {
        validateParameters(firstNumber, secondNumber);
        int result = firstNumber + secondNumber;
        validateResult(result);
        return result;
    }

    public int substract(int firstNumber, int secondNumber) {
        validateParameters(firstNumber, secondNumber);
        int result = firstNumber - secondNumber;
        validateResult(result);
        return result;
    }

    private void validateParameters(int firstNumber, int secondNumber) {
        if (firstNumber > upperLimit || firstNumber < lowerLimit) {
            throw new RuntimeException("The first parameter exceeds a limit." +
            "\nUpper Limit: " + upperLimit + "\nLower Limit: " + lowerLimit);
        }
        if (secondNumber > upperLimit || secondNumber < lowerLimit) {
            throw new RuntimeException("The second parameter exceeds a limit." +
            "\nUpper Limit: " + upperLimit + "\nLower Limit: " + lowerLimit);
        }
    }

    private void validateResult(int result) {
        if (result > upperLimit) {
            throw new RuntimeException("Result exceeded upper limit.");
        }
        if (result < lowerLimit) {
            throw new RuntimeException("Result exceeded lower limit.");
        }
    }

    public void setUpperLimit(int newUpperLimit) {
        this.upperLimit = newUpperLimit;
    }

    public int getUpperLimit() {
        return this.upperLimit;
    }

    public void setLowerLimit(int newLowerLimit) {
        this.lowerLimit = newLowerLimit;
    }

    public int getLowerLimit() {
        return this.lowerLimit;
    }
}
