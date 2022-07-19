package javaexams.templates.behavioral.strategy;

public class ClientCode {

    public static void main(String[] args) {
        CalcData calcData = new CalcData(4.56, 5.789);

        calcData.setCalculationStrategy(new SumStrategy());
        System.out.println(calcData.calculate());

        calcData.setCalculationStrategy(new DivideStrategy());
        System.out.println(calcData.calculate());

    }
}

//10.349
//0.7877008118846087