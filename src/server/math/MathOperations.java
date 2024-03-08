package server.math;

public class MathOperations implements iMathOperations{

    @Override
    public double add(double firstValue, double secondValue) {
        return firstValue + secondValue;
    }

    @Override
    public double sub(double firstValue, double secondValue) {
		return firstValue - secondValue;

    }

    @Override
    public double mul(double firstValue, double secondValue) {
		return firstValue * secondValue;
    }

    @Override
    public double div(double firstValue, double secondValue) {
        if (secondValue != 0)
            return firstValue / secondValue;
        return Double.MAX_VALUE;
    }

    
}
