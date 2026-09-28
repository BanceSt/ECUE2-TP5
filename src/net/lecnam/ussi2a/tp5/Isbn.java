package net.lecnam.ussi2a.tp5;

public class Isbn {

    private Isbn() {}

    public static boolean estValide(String isbn) {
        int total =0;
        for (int i =0;i < isbn.length();i++) {
            total += Character.getNumericValue(isbn.charAt(i)) * (i % 2 == 0 ? 1 : 3);
        }
        return total == 100;
    }
}
