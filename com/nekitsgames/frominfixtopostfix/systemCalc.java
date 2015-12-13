package com.nekitsgames.frominfixtopostfix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class systemCalc {

    private static String getStringRepresentation(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }

    public static String infixToPostfix(String StartInfix) throws ExpressionsException{
        int i;
        char[] infix = StartInfix.toCharArray();
        ArrayList<Character> postfix = new ArrayList<>();
        ArrayList<Character> numbers = new ArrayList<>();
        ArrayList<Character> chars = new ArrayList<>();

        for(i = 0; i != infix.length; i++){
            int tmp;
            if (i%2 == 0){
             tmp = Integer.parseInt(String.valueOf(infix[i]));
             if (tmp !=1 & tmp!=2 & tmp!=3 & tmp!=4 & tmp!= 5 & tmp!= 6 & tmp!=7 & tmp!= 8 & tmp!=9 & tmp!=0){
                 System.err.println(tmp);
                 throw new ExpressionsException("Ошибка #nnn1! Выражение типа infix выраженно неправельно.");
             }
             numbers.add(infix[i]);
         }

            if (i%2 != 0){
                tmp = (int) infix[i];
                if (tmp != (int) "+".charAt(0) & tmp != (int) "-".charAt(0) & tmp != (int) "*".charAt(0) & tmp != (int) "/".charAt(0)){
                    throw new ExpressionsException("Ошибка #nnn2! Выражение типа infix выраженно неправельно.");
                }
                chars.add(infix[i]);
            }
        }

        if (numbers.toArray().length - 1 != chars.toArray().length){
            throw new ExpressionsException("Ошибка #nnn3! Выражение типа infix выраженно неправельно.");
        }

        numbers.addAll(chars);
        postfix = numbers;
        return getStringRepresentation(postfix);
    }

    public static String postfixToInfix(String Startpostfix) throws ExpressionsException{
        boolean isChars = false;
        int i;
        char tmp;
        boolean ok = false;
        char[] postfix = Startpostfix.toCharArray();
        ArrayList<Character> infix = new ArrayList<>();
        ArrayList<Character> numbers = new ArrayList<>();
        ArrayList<Character> chars = new ArrayList<>();
        for (i = 0; i != postfix.length; i++) {
            tmp = postfix[i];
            if (tmp == "1".charAt(0) || tmp == "2".charAt(0) || tmp == "3".charAt(0) || tmp == "4".charAt(0) || tmp== "5".charAt(0) || tmp== "6".charAt(0) || tmp=="7".charAt(0) || tmp == "8".charAt(0) || tmp=="9".charAt(0) || tmp=="0".charAt(0)){
                if (isChars) {
                    throw new ExpressionsException("Ошибка #nnn4. Выражение postfix указанно неправельно.");
                }
                numbers.add(postfix[i]);
                ok = true;
            }
            if ((tmp == "+".charAt(0)) || (tmp ==  "-".charAt(0)) ||  (tmp == "*".charAt(0)) || (tmp == "/".charAt(0))){
                chars.add(postfix[i]);
                isChars = true;
                ok = true;
            }

                if (!ok){
                    throw new ExpressionsException("Ошибка #nnn5. Выражение postfix указанно неправельно.");
                }
            }

       if (numbers.toArray().length - 1 != chars.toArray().length){
            throw new ExpressionsException("Ошибка #nnn6. Выражение postfix указанно неправельно.");
        }
        for (i = 0; i != (postfix.length / 2); i++){
                infix.add(numbers.get(i));
                infix.add(chars.get(i));
        }
        infix.add(numbers.get(postfix.length / 2));


        return getStringRepresentation(infix);

    }

}
