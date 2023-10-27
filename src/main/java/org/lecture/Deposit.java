package org.lecture;

import java.util.Scanner;

public class Deposit {

    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {

        double startValue = 0;
        double monthlyDeposit = 0;
        double totalValue;
        int runningYears = 3;
        double interest = 0.003f;

        System.out.print("Enter start Value: ");
        startValue = inputScanner.nextFloat();
        inputScanner.nextLine();

        System.out.print("Enter monthly Deposit: ");
        monthlyDeposit = inputScanner.nextFloat();
        inputScanner.nextLine();

        do {
            System.out.print("Enter running Years > 3: ");
            runningYears = inputScanner.nextInt();
            inputScanner.nextLine();
        }while(runningYears < 3);

        totalValue = calculateTotalValue(startValue, monthlyDeposit, interest, runningYears*12);
        System.out.printf("Your final Amount after %d years will be %.2fEUR \n",runningYears, totalValue);
        System.out.printf("After %d months, 80%% of your Deposit will be reached.",getMonthsToTarget(startValue, monthlyDeposit, interest, totalValue*0.8));


    }
/*
* p = start Value
* r = monthly interest
* n = number of months
* d = monthly deposit
* */

    private static double calculateTotalValue(double p, double d, double r, int n) {
        double futureValuePrincipal = p * Math.pow(1 + r, n);
        double futureValueDeposits = d * ((Math.pow(1 + r, n) - 1) / r);
        return futureValuePrincipal + futureValueDeposits;
    }

    public static int getMonthsToTarget(double p, double d, double r,double target){
        double monthly=p;
        int months=0;
        while(monthly < target){
            monthly = calculateTotalValue(monthly,d,r,1);
            months++;
        }
        return months;
    }




}
