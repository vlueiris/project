
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.Scanner;

class EnumExample {
    public enum DayOfWeek {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a day of the week: ");
        String input = scanner.nextLine();

        DayOfWeek day = DayOfWeek.valueOf(input.toUpperCase());

        System.out.println("You entered " + day);
        scanner.close();
    }

}
