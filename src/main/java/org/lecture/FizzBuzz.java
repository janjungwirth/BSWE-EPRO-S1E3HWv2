package org.lecture;
public class FizzBuzz {
    public static void main(String[] args) {
        String result ="";
        for (int i = 1; i <= 35; i++) {
            result += replaceWithFizzAndBuzz(i);
            result += ",";
        }
        result = result.substring(0, result.length() - 1); // Strip the last ,
        System.out.println(result);
    }
    public static String replaceWithFizzAndBuzz(Integer number) {
        String result = number % 3 == 0 ? "Fizz" : ""; // If number devided by 3 equals 0 -> result is Fizz
        result += number % 5 == 0 ? "Buzz" : ""; // If number devided by 5 equals 0 -> append Buzz
        return result.isEmpty() ? number.toString() : result; //if result is empty, get number, convert to string and return
    }
}