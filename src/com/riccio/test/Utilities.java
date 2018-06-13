package com.riccio.test;

public class Utilities {

    //returning a char array containing every nth char when source array length < n, return source array
    public char[] everyNthChar(char[] sourceArray, int n) {
        if (sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }
        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];
        int index = 0;

        for (int i = n - 1; i < sourceArray.length; i += n) {
            result[index++] = sourceArray[i];
        }
        return result;
    }

    //remove pairs of the same character that we are next to each other , by removing on an occurrence of the char
    //   ABCDEEF -> ABCDEF
    public String removePairs(String source) {
        //IF LENGTH is less than 2 , there wont be any pairs
        if (source.length() < 2) {
            return source;
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] string = source.toCharArray();
        for (int i = 0; i < string.length-1; i++) {
            if (string[i] != string[i + 1]) {
                stringBuilder.append(string[i]);
            }
        }
        stringBuilder.append(string[string.length-1]);
        return stringBuilder.toString();
    }

    //perform a conversion based on some internal business rule
    public int converter(int a, int b) {
        return (a / b) + (a * 30) - 2;
    }

    public String nullIfOddLenth(String source) {
        if (source.length() % 2 == 0) {
            return source;
        }
        return null;
    }
}
