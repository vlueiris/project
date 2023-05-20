/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.Buildings.Hotel;
import java.util.ArrayList;
import java.util.List;

import Main.Person;
import Main.Buildings.Terminal;
import java.util.Scanner;

public class City {

    private List<Person> population;
    private List<Hotel> hotels;
    private List<Terminal> terminals;

    private double budget;

    // constructor
    public City(double budget) {
        this.population = new ArrayList<>();
        this.hotels = new ArrayList<>();
        this.terminals = new ArrayList<>();
        // this.budget = budget;
    }

    // methods
    public void addPerson(Person person) {
        population.add(person);
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public void addTerminal(Terminal terminal) {
        terminals.add(terminal);
    }

    // getters and setters
    public List<Person> getPopulation() {
        return population;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public double getBudget() {
        return budget;
    }
    //
    // public static void main(String[] args) {
    // City myCity = new City(1000000, 1234.56);
    // System.out.println("Population: " + myCity.getPopulation());
    // System.out.println("Area: " + myCity.getArea());
    // }

    public static City the_city;

    public static void main(String[] args) {
        // add some Person objects to the list
        final int the_budget = 100000;
        the_city = new City(the_budget);

        the_city.addPerson(new Person("Maryam", "Qarai", 18, "Qom", Person.Job.PILOT, Person.Gender.FEMALE, 1000000.1));
        the_city.addPerson(
                new Person("Emmet", "Emmet", 48, "Legoland", Person.Job.BUS_DRIVER, Person.Gender.MALE, 10000.1));

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            System.out.println("Menu:");
            System.out.println("1. Build terminal");
            System.out.println("2. Buy vehicle");
            System.out.println("3. Recruit driver");
            System.out.println("4. Show terminal info");
            System.out.println("5. Build hotel");
            System.out.println("6. Build room in hotel");
            System.out.println("7. Show hotel info");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid choice. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    // showTeminalBuildingMenu()
                    break;
                case 2:
                    // showTeminalBuildingMenu()
                    System.out.println("You chose Option 2.");
                    break;
                case 3:
                    // showTeminalBuildingMenu()
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

}
