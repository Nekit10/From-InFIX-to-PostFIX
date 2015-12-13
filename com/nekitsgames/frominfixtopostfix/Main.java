package com.nekitsgames.frominfixtopostfix;

import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {

    private static boolean close;
    private static String inputExpr;
    private static int decision;
    private static char quit;
    private static Scanner sc = new Scanner(System.in);
    private static String res;

    public static void main(String[] args) {
        System.out.println("Добро пожаловать! Введите 1 для конвертации infix в postfix, введите 2 для конвертации из postfix в infix.");
        do {
            decision = sc.nextInt();
        } while ((decision != 1) & (decision != 2));
        System.out.println("Введите infix/postfix выражение.");
        inputExpr = sc.next();
        try {
            if (decision == 1) {
                res = systemCalc.infixToPostfix(inputExpr);
            } else {
                if (decision == 2) {
                res = systemCalc.postfixToInfix(inputExpr);
                }
            }
        } catch (ExpressionsException e){
            System.err.println(e);
        }
        System.out.println("Результат: " + res);
        sc.nextLine();
    }
}
