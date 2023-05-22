/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.Buildings.Airport;
import Main.Buildings.BusTerminal;
import Main.Buildings.Hotel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// import Main.Person;
import Main.Buildings.Terminal;
import Main.Vehicles.CargoPlane;
import Main.Vehicles.InterCityBus;

import java.util.Scanner;

public class City {

    // --------------------------------------------
    public enum ANSIColor {
        BLACK("\u001B[30m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        YELLOW("\u001B[33m"),
        BLUE("\u001B[34m"),
        MAGENTA("\u001B[35m"),
        CYAN("\u001B[36m"),
        WHITE("\u001B[37m");

        private final String code;

        ANSIColor(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    // --------------------------------------------
    private List<Person> population;
    private List<Hotel> hotels;
    private List<Terminal> terminals;

    private double budget;

    // constructor
    public City(double budget, int maxPopulation) {
        this.population = new ArrayList<>(maxPopulation);
        this.hotels = new ArrayList<>();
        this.terminals = new ArrayList<>();
        this.budget = budget;
    }

    // -------------------------------------------------------------
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

    // -------------------------------------------------------------
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

    // ---------------------------------------
    public double getBudget() {
        return budget;
    }

    public void useBudget(double amount) {
        if (amount > budget) {
            throw new IllegalArgumentException("Not enough money!");
        }
        budget -= amount;
    }

    // ===================================================================================================================
    public static City the_city;
    public static Scanner scanner = new Scanner(System.in);

    // ===================================================================================================================
    public static void main(String[] args) {

        // ---------------------------------------
        final double the_budget = 100000;
        final int max_population = 50000;
        the_city = new City(the_budget, max_population);
        // ---------------------------------------
        the_city.addPerson(new Person("Maryam", "Qarai", 1390, "Qom", Person.Job.PILOT, Person.Gender.FEMALE, 150.1));
        the_city.addPerson(
                new Person("Emmet", "Emmet", 1362, "Legoland", Person.Job.BUS_DRIVER, Person.Gender.MALE, 50.1));
        the_city.addPerson(
                new Person("Amin", "Masoodi", 1353, "Tehran", Person.Job.SAILOR, Person.Gender.MALE, 80.1));
        the_city.addPerson(
                new Person("Alina", "Jafari", 1385, "Tabriz", Person.Job.TRAIN_DRIVER, Person.Gender.FEMALE, 75.5));

        List<String> options = Arrays.asList("Build terminal", "Buy vehicle", "Recruit driver",
                "Show terminal info", "Build hotel", "Build room in hotel", "Show hotel info");
        List<Runnable> actions = Arrays.asList(City::buildTeminal, City::buyVehiclesForTeminal,
                City::recuitDriversForTerminal,
                City::showTerminalsInfo, City::buildHotel, City::buildRoomForHotel, City::showHotelsInfo);

        showMenuReadUserChoiceInt2("Please select a task:", options, actions);
        // ---------------------------------------
        // System.out.println("\u001B[31mThis text is red!\u001B[0m");

        // System.out.println("Area: " + myCity.getArea());
        // System.exit(0);

        // ---------------------------------------
        // int choice = -1;
        // while (choice != 0) {
        // showBudgetLine();

        // System.out.println("\nPlease select an option:");
        // System.out.println("1. Build terminal");
        // System.out.println("2. Buy vehicle");
        // System.out.println("3. Recruit driver");
        // System.out.println("4. Show terminal info");
        // System.out.println("5. Build hotel");
        // System.out.println("6. Build room in hotel");
        // System.out.println("7. Show hotel info");
        // System.out.println("0. Exit");
        // System.out.print("Enter your choice: ");

        // choice = showMenuReadUserChoiceInt("Please select a task:",
        // Arrays.asList("Build terminal", "Buy vehicle", "Recruit driver", "Show
        // terminal info",
        // "Build hotel", "Build room in hotel", "Show hotel info"));

        // try {
        // choice = scanner.nextInt();
        // } catch (Exception e) {
        // System.out.println("Invalid choice. Please enter a number.");
        // // scanner.nextLine();
        // continue;
        // }

        // switch (choice) {
        // case 1:
        // buildTeminal();
        // break;
        // case 2:
        // buyVehiclesForTeminal();
        // break;
        // case 3:
        // recuitDriversForTerminal();
        // break;
        // case 4:
        // showTerminalsInfo();
        // break;
        // case 5:
        // buildHotel();
        // break;
        // case 6:
        // buildRoomForHotel();
        // break;
        // case 7:
        // showHotelsInfo();
        // break;
        // case 0:
        // return;
        // default:
        // System.out.println("Invalid choice. Please try again.");
        // break;
        // }
        // }scanner.close();

    }

    // ===================================================================================================================
    private static void buildTeminal() {
        int choice = -1;
        while (choice != 0) {
            showBudgetLine();

            choice = showMenuReadUserChoiceInt("Please select a terminal type to build:",
                    Arrays.asList("Airport", "Bus terminal", "Shipping port", "Train station"));

            switch (choice) {
                case 1:
                    buildAirport();
                    break;
                case 2:
                    buildBusTerminal();
                    break;
                case 3:
                    buildShippingPort();
                    break;
                case 4:
                    buildTrainStation();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        // scanner.close();

    }

    // ===================================================================================================================
    private static void buildAirport() {

        try {
            System.out.print(
                    "-----------------------------------------\nHow much do you want to spend for building the airport?");
            double _construction_cost = scanner.nextDouble();
            // Eat the newline from previous input
            scanner.nextLine();
            System.out.print("Enter the name of the city in which the airport will be built:");
            String _city_name = scanner.nextLine();
            System.out.print("Enter the name of the airport:");
            String _airport_name = scanner.nextLine();
            System.out.print("Enter the construction site address for the airport:");
            String _address = scanner.nextLine();
            System.out.print("Over how much area will the airport be built?");
            double _area = scanner.nextDouble();
            System.out.print("Will the airport be an international airport (true/false) ?");
            boolean _is_international = scanner.nextBoolean();
            System.out.print("How many runways will the airport have?");
            int _num_runways = scanner.nextInt();

            // -------------------------------------------------
            // Check for available budget
            if (the_city.getBudget() < _construction_cost) {
                System.out.println(
                        ANSIColor.RED.getCode() + "You don't have enough money to build the airport!"
                                + ANSIColor.WHITE.getCode());
                return;
            } else {
                the_city.useBudget((_construction_cost));
            }
            // -------------------------------------------------
            Airport _airport = new Airport(_construction_cost, _city_name, _airport_name, _address, _area,
                    _is_international, _num_runways);
            the_city.addTerminal(_airport);

            System.out.println(
                    ANSIColor.GREEN.getCode() + "Congrats! Your airport is readdy!" + ANSIColor.WHITE.getCode());

        } catch (Exception e) {
            System.out.println("Invalid data type!");

        }

        // System.out.println("Will the airport be an international airport?");

        // System.out.println(ANSIColor.GREEN.getCode() +
        // "\n\n================================================"
        // + ANSIColor.WHITE.getCode());
        // System.out.println(ANSIColor.GREEN.getCode() + "Gooooooooooogooly" +
        // ANSIColor.WHITE.getCode());
        // System.out.println(ANSIColor.GREEN.getCode() +
        // "==============================================="
        // + ANSIColor.WHITE.getCode());

    }

    // -----------------------------------------
    private static void buildTrainStation() {
    }
    // -----------------------------------------

    private static void buildShippingPort() {
    }
    // -----------------------------------------

    private static void buildBusTerminal() {
    }

    // ===================================================================================================================
    private static void buyVehiclesForTeminal() {

        int choice = -1;
        while (choice != 0) {
            showBudgetLine();
            System.out.println("\nWhat type of vehicle do you want to buy?");
            System.out.println("1. Boat");
            System.out.println("2. Ship");
            System.out.println("3. Bus");
            System.out.println("4. Train");
            System.out.println("5. Cargo Plane");
            System.out.println("6. Passenger Plane");
            System.out.println("0. Return to main menu");
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
                    buyBoat();
                    break;
                case 2:
                    buyShip();
                    break;
                case 3:
                    buyBus();
                    break;
                case 4:
                    buyTrain();
                    break;
                case 5:
                    buyCargoPlane();
                    break;
                case 6:
                    buyPassengerPlane();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // --------------------------------------------------------------------------
    private static void buyBoat() {
    }

    // -----------------------------------------
    private static void buyShip() {
    }

    // -----------------------------------------
    private static void buyBus() {
        // 1. Show list of all bus terminals by name and allow for user to choose one by
        // its number (user chooses)
        int chosen_terminal_index = -1;
        List<BusTerminal> bus_terminals = new ArrayList<>();
        // -------------------------
        System.out.println("\nPlease select one of bus terminals:");
        for (Terminal _terminal : the_city.terminals) {
            if (_terminal instanceof BusTerminal) {
                bus_terminals.add((BusTerminal) _terminal);
                System.out.println(bus_terminals.indexOf(_terminal) + ". " + _terminal.getTerminalName());
            }
            try {
                chosen_terminal_index = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid choice. Please enter a number.");
                // scanner.nextLine();
                continue;
            }

        }
        // 2. Get the specs for the bus to be added to that terminal
        System.out.print("How many seats your buses will have?");
        int _totalSeatNum = scanner.nextInt();

        // 3. Add the bus to the terminal
        InterCityBus bought_bus = new InterCityBus(_totalSeatNum);
        bus_terminals.get(chosen_terminal_index).addVehicle(bought_bus);
    }

    // -----------------------------------------
    private static void buyTrain() {
    }

    // -----------------------------------------
    private static void buyCargoPlane() {
        // 1. Show list of all bus terminals by name and allow for user to choose one by
        // its number (user chooses)
        int chosen_terminal_index = -1;
        List<Airport> airports = new ArrayList<>();
        // -------------------------
        for (Terminal _terminal : the_city.terminals) {
            if (_terminal instanceof Airport) {
                airports.add((Airport) _terminal);
                System.out.println((airports.indexOf(_terminal) + 1) + ". " + _terminal.getTerminalName());
            }
            System.out.println("\nPlease select one of the airports:");
            try {
                chosen_terminal_index = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid choice. Please enter a number.");
                // scanner.nextLine();
                continue;
            }

        }
        // -------------------------------------------------
        // Check for available budget
        if (the_city.getBudget() < CargoPlane.purchasePrice) {
            System.out.println(
                    ANSIColor.RED.getCode() + "You don't have enough money to bug the plane!"
                            + ANSIColor.WHITE.getCode());
            return;
        } else {
            the_city.useBudget((CargoPlane.purchasePrice));
        }
        // -------------------------------------------------
        // 2. Get the specs for the bus to be added to that terminal
        System.out.print("How much weight will your cargo plane carry?");
        double _sumTolerableWeight = scanner.nextDouble();

        // 3. Add the bus to the terminal
        CargoPlane bought_cargo_plane = new CargoPlane(_sumTolerableWeight);
        airports.get(chosen_terminal_index - 1).addVehicle(bought_cargo_plane);
    }

    // -----------------------------------------
    private static void buyPassengerPlane() {
    }

    // ===================================================================================================================
    private static void recuitDriversForTerminal() {
    }

    // --------------------------------------------------------------------------
    private static void recuitPilot() {
    }

    // -----------------------------------------
    private static void recuitSailor() {
    }

    // -----------------------------------------
    private static void recuitBusDriver() {
    }

    // -----------------------------------------
    private static void recuitTrainDriver() {
    }

    // -----------------------------------------
    private static void recuitPassengerPlaneCrew() {
    }

    // ===================================================================================================================
    private static void showTerminalsInfo() {
    }
    // ===================================================================================================================

    private static void buildHotel() {

    }
    // ===================================================================================================================

    private static void buildRoomForHotel() {
        // 1. Show list of all hotels by name and allow for user to choose one by its
        // number (user chooses)

        // 2. Get the specs for the room to be added to that hotel
        // 3. Add the room to hotel

    }

    // ===================================================================================================================
    private static void showHotelsInfo() {

    }

    // ===================================================================================================================
    private static void showBudgetLine() {
        System.out.println(ANSIColor.MAGENTA.getCode() + "-------------------------------\nRemaining budget: "
                + the_city.budget
                + "\n-------------------------------"
                + ANSIColor.WHITE.getCode());
    }

    // ===================================================================================================================
    // public static int showMenuReadUserChoiceInt(String promptString, List<String> options) {
    //     int choice = -1;

    //     System.out.print("\n" + promptString + "\n");

    //     for (int i = 0; i < options.size(); i++) {
    //         System.out.println("\t" + (i + 1) + ". " + options.get(i));
    //     }
    //     System.out.println("\t0. Return or exit");
    //     System.out.print("\nEnter your choice: ");

    //     try {
    //         choice = scanner.nextInt();
    //         if (choice < 0 || choice >= options.size()) {
    //             throw new Exception();
    //         }
    //     } catch (Exception e) {
    //         System.out.println("Invalid choice. Please enter a number.");
    //         scanner.nextLine();
    //         return -1;
    //     } finally {
    //     }
    //     return choice;
    // }

    // ===================================================================================================================
    public static void showMenuReadUserChoiceInt2(String promptString, List<String> options, List<Runnable> actions) {
        int choice = -1;
        while (choice != 0) {

            System.out.print("\n" + promptString + "\n");

            for (int i = 0; i < options.size(); i++) {
                System.out.println("\t" + (i + 1) + ". " + options.get(i));
            }
            System.out.println("\t0. Return or exit");
            System.out.print("\nEnter your choice: ");

            try {
                choice = scanner.nextInt();
                if (choice <= 0 || choice >= options.size()) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Invalid choice. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            // valid choice made
            if (choice == 0)
                break;
            else
                // an action was chosen
                actions.get(choice - 1).run();
        }
    }
}
