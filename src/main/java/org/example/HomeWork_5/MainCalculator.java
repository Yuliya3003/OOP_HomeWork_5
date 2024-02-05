package org.example.HomeWork_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainCalculator {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(1,2,3));
        Calculator calc = new Calculator();
        System.out.println("Сумма первого списка: "+ calc.sum(array));
        List<Double> array2 = new ArrayList<>(Arrays.asList(1.0,2.2,3.0));
        System.out.println("Сумма второго списка: "+calc.sum(array2));

        System.out.println("Произведение первого списка: "+calc.multiplication(array));
        System.out.println("Произведение второго списка: "+calc.multiplication(array2));

        System.out.println("Деление первого списка: "+calc.division(array));
        System.out.println("Деление второго списка: "+calc.division(array2));

        System.out.println("Перевод в двоичный код из строки: "+ calc.convertToBinary("2"));
        System.out.println("Перевод в двоичный код из целочисленного числа: "+ calc.convertToBinary(2));
        System.out.println("Перевод в двоичный код из дробного числа: "+ calc.convertToBinary(2.9));
        System.out.println("Перевод в двоичный код из дробного числа с 0 после запятой: "+ calc.convertToBinary(2.0));



        System.out.println("Перевод в десятичную систему из строки: "+calc.convertFromBinary("10011.11"));
        System.out.println("Перевод в десятичную систему из целочисленного значения: "+calc.convertFromBinary(10011));
        System.out.println("Перевод в десятичную систему из дробного значения: "+calc.convertFromBinary(10011.11));
    }
}
