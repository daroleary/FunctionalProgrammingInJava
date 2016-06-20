package com.java8.compare;

public class IterateString {

    private static void printChar(int aChar) {
        System.out.println((char) (aChar));
    }

    public static void main(String[] args) {

        final String str = "w00t";

        str.chars()
                .mapToObj(ch -> (char) ch)
                .forEach(System.out::println);

        System.out.println("//" + "START:FILTER_OUTPUT");
        str.chars()
                .filter(Character::isDigit)
                .forEach(IterateString::printChar);
        System.out.println("");
        System.out.println("//" + "END:FILTER_OUTPUT");

        str.chars()
                .filter(Character::isDigit);

        str.chars()
                .filter(Character::isDigit)
                .forEach(IterateString::printChar);
    }
}
