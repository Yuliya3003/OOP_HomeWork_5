package org.example.HomeWork_5;

import java.util.List;

public class Calculator <T>{

    public double sum(List<? extends Number> numbers){
        double sum = 0.0;
        for (int i=0; i<numbers.size();i++) {
            sum+=numbers.get(i).doubleValue();
        }
        return sum;
    }

    public double multiplication(List<? extends Number> numbers){
        double res = 1.0;
        for (int i = 0; i < numbers.size(); i++) {
            res *= numbers.get(i).doubleValue();
        }
        return res;
    }

    public double division(List<? extends Number> numbers){
        double res = numbers.get(0).doubleValue();
        for (int i = 1; i < numbers.size(); i++) {
            res /= numbers.get(i).doubleValue();
        }
        return res;
    }

    public String convertToBinary(T num) {
        if (num instanceof Number) {
            double doubleValue = ((Number) num).doubleValue();
            if (doubleValue == (int) doubleValue) {
                return Integer.toBinaryString((int) doubleValue);
            } else {
                return convertDoubleToBinary(doubleValue);
            }
        } else if (num instanceof String) {
            try {
                double parsedValue = Double.parseDouble((String) num);
                if (parsedValue == (int) parsedValue){
                    return Integer.toBinaryString((int) parsedValue);
                } else {
                    return convertDoubleToBinary(parsedValue);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Неверный формат числа для строки");
            }
        }
        throw new IllegalArgumentException("Неподдерживаемый тип");
    }

    private String convertDoubleToBinary(Double number) {
        long intPart = Math.abs(number.longValue());
        double fractionalPart = Math.abs(number) - intPart;

        String intBinary = Integer.toBinaryString((int) intPart);
        StringBuilder fractionalBinary = new StringBuilder(".");

        for (int i = 0; i < 16; i++) {
            fractionalPart *= 2;
            int bit = (int) fractionalPart;
            fractionalBinary.append(bit);
            fractionalPart -= bit;
        }

        return intBinary + fractionalBinary.toString();
    }


    public T convertFromBinary(T input) {
        String binaryString = input.toString();
        try {
            if (binaryString.contains(".")) {
                return (T) convertToDouble(binaryString);
            } else {
                return (T) convertToInteger(binaryString);
            }
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Неверный двоичный формат.");
        }
    }

    private Integer convertToInteger(String binaryString) {
        return Integer.parseInt(binaryString, 2);
    }

    private Double convertToDouble(String binaryString) {
        String[] parts = binaryString.split("\\.");
        int intPart = Integer.parseInt(parts[0], 2);

        double fractionalPart = 0;
        if (parts.length > 1) {
            String fractionalBinary = parts[1];
            for (int i = 0; i < fractionalBinary.length(); i++) {
                fractionalPart += (fractionalBinary.charAt(i) - '0') / Math.pow(2, i + 1);
            }
        }

        return intPart + fractionalPart;
    }
}
