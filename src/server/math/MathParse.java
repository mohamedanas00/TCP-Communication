package server.math;

public class MathParse {
    private MathOperations mathOperations;

    
    public MathParse() {
        this.mathOperations =new MathOperations();
    }


    public double parseMessage(String message) throws IllegalArgumentException{
        try {
            double result = Double.MAX_VALUE;
            String[] elements = message.split(":");
            if(elements.length != 3)
                throw new IllegalArgumentException("Parsing Error!");
            

            double firstValue = 0;
            double secondValue = 0;

            firstValue = Double.parseDouble(elements[1]);
			secondValue = Double.parseDouble(elements[2]);

            switch (elements[0].charAt(0)) {
                case '+':
                    result = mathOperations.add(firstValue, secondValue);
                    break;
                case '-':
                    result = mathOperations.sub(firstValue, secondValue);
                    break;
                case '*':
                    result = mathOperations.mul(firstValue, secondValue);
                    break;
                case '/':
                    result = mathOperations.div(firstValue, secondValue);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid math operation!");
            }
            return result;
        } catch (Exception e) {
                throw new IllegalArgumentException("Parsing Error!");
        }
    }
}
