/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Main.Buildings.Airport;
import Main.Buildings.BusTerminal;
import Main.Buildings.ShippingPort;
import Main.Buildings.TrainStation;
import Main.Buildings.Hotel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// import Main.Person;
import Main.Buildings.Terminal;
import Main.Person.Job;
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
        // Create the city
        final double the_budget = 500000;
        final int max_population = 500;
        the_city = new City(the_budget, max_population);
        // ---------------------------------------
        // Build its population
        the_city.addPerson(new Person("Maryam", "Qarai", 1390, "Qom", Person.Job.PILOT, Person.Gender.FEMALE, 150.1));
        the_city.addPerson(
                new Person("Emmet", "Brickowski", 1362, "Legoland", Person.Job.BUS_DRIVER, Person.Gender.MALE, 500.1));
        the_city.addPerson(
                new Person("Emmet", "Emmet", 1375, "Legoland", Person.Job.PILOT, Person.Gender.MALE, 500.1));
        the_city.addPerson(
                new Person("Emmet", "Awesome", 1375, "Legoland", Person.Job.PILOT, Person.Gender.MALE, 500.1));
        the_city.addPerson(
                new Person("Amin", "Masoodi", 1353, "Tehran", Person.Job.SAILOR, Person.Gender.MALE, 80.1));
        the_city.addPerson(
                new Person("Lucy", "Wyldstyle", 1370, "California", Person.Job.TRAIN_DRIVER, Person.Gender.FEMALE,
                        75.5));
        the_city.addPerson(
                new Person("Lloyd", " Montgomery", 2000, "LegoNinjago", Person.Job.BUS_DRIVER, Person.Gender.MALE,
                        65.3));
        the_city.addPerson(
                new Person("Jay", "kay", 1385, "Seoul", Person.Job.TRAIN_DRIVER, Person.Gender.MALE, 55.6));
        the_city.addPerson(
                new Person("Kane", "Stone", 1385, "Washington", Person.Job.PASSENGER_PLANE__CREW, Person.Gender.MALE,
                        175.5));
        the_city.addPerson(
                new Person("Kai", "Lee", 1385, "Tokyo", Person.Job.SAILOR, Person.Gender.MALE, 85.2));
        the_city.addPerson(
                new Person("Ella", "Gertrude", 1369, "London", Person.Job.BUS_DRIVER, Person.Gender.FEMALE, 95.5));
        the_city.addPerson(
                new Person("Elizabeth", " Phantomhive", 1385, "Paris", Person.Job.PASSENGER_PLANE__CREW,
                        Person.Gender.FEMALE, 750));

        // ---------------------------------------
        the_city.addTerminal(new Airport(80000, "Qom", "Mehr", "Shohada", 15000, true, 3));
        the_city.addTerminal(new Airport(80000, "Soor", "Panda", "Khersabd", 30000, true, 13));
        the_city.addTerminal(new Airport(80000, "Gooor", "Khersabad", "Shongolabd", 15000, true, 5));
        // ---------------------------------------

        // ----------------------------------------
        // Now build the city itself
        List<String> options = Arrays.asList("Build a terminal", "Buy a vehicle", "Hire a driver",
                "Show terminals info", "Build a hotel", "Build a room in hotel", "Show hotels info");
        List<Runnable> actions = Arrays.asList(City::buildTeminal, City::buyVehiclesForTeminal,
                City::hireyDriversForTerminal,
                City::showTerminalsInfo, City::buildHotel, City::buildRoomForHotel, City::showHotelsInfo);

        showOptionsMenuChooseActions("Please select a task:", options, actions);
        // ---------------------------------------
        // System.out.println("\u001B[31mThis text is red!\u001B[0m");
        // System.out.println("Area: " + myCity.getArea());
        // System.exit(0);
        scanner.close();
    }

    // ===================================================================================================================
    private static void buildTeminal() {

        List<String> options = Arrays.asList("Airport", "Bus terminal", "Shipping port", "Train station");
        List<Runnable> actions = Arrays.asList(City::buildAirport, City::buildBusTerminal, City::buildShippingPort,
                City::buildTrainStation);

        showOptionsMenuChooseActions("Please select a terminal type to build:",
                options, actions);

    }

    // --------------------------------------------------------------------------
    private static void buildAirport() {

        try {
            System.out.print(
                    "-----------------------------------------\nHow much do you want to spend for building the airport? ");
            double _construction_cost = scanner.nextDouble();
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
            // Eat the newline from previous input
            scanner.nextLine();
            System.out.print("Enter the name of the city in which the airport will be built: ");
            String _city_name = scanner.nextLine();
            System.out.print("Enter the name of the airport: ");
            String _airport_name = scanner.nextLine();
            System.out.print("Enter the construction site address for the airport: ");
            String _address = scanner.nextLine();
            System.out.print("Over how much area will the airport be built? ");
            double _area = scanner.nextDouble();
            System.out.print("Will the airport be an international airport (true/false)? ");
            boolean _is_international = scanner.nextBoolean();
            System.out.print("How many runways will the airport have? ");
            int _num_runways = scanner.nextInt();

            // -------------------------------------------------
            Airport _airport = new Airport(_construction_cost, _city_name, _airport_name, _address, _area,
                    _is_international, _num_runways);
            the_city.addTerminal(_airport);

            System.out.println(
                    ANSIColor.GREEN.getCode() + "Congrats! Your airport is readdy!" + ANSIColor.WHITE.getCode());

        } catch (Exception e) {
            System.out.println("Invalid data type!");

        }

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

        List<String> options = Arrays.asList("Boat", "Ship", "Bus", "Train", "Cargo Plane", "Passenger Plane");
        List<Runnable> actions = Arrays.asList(City::buyBoat, City::buyShip, City::buyBus,
                City::buyTrain, City::buyCargoPlane, City::buyPassengerPlane);

        showOptionsMenuChooseActions("What type of vehicle do you want to buy?",
                options, actions);
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
        List<BusTerminal> allBusTerminals = new ArrayList<>();
        // -------------------------
        System.out.println("\nPlease select one of the bus terminals:");
        for (Terminal _terminal : the_city.terminals) {
            if (_terminal instanceof BusTerminal) {
                allBusTerminals.add((BusTerminal) _terminal);
                System.out.println(allBusTerminals.indexOf(_terminal) + ". " + _terminal.getTerminalName());
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

        // 3. Add the bus to the city terminal
        InterCityBus bought_bus = new InterCityBus(_totalSeatNum);
        allBusTerminals.get(chosen_terminal_index).addVehicle(bought_bus);
    }

    // -----------------------------------------
    private static void buyTrain() {
    }

    // -----------------------------------------
    private static void buyCargoPlane() {
        // 1. Show list of all airport by name and allow for user to choose one by
        // its number (user chooses)
        int chosen_terminal_index = -1;
        List<Airport> allAirports = new ArrayList<>();
        // -------------------------
        // Check for available budget
        if (the_city.getBudget() < CargoPlane.purchasePrice) {
            System.out.println(
                    ANSIColor.RED.getCode() + "You don't have enough money to buy the plane!"
                            + ANSIColor.WHITE.getCode());
            return;
        } else {
            the_city.useBudget((CargoPlane.purchasePrice));
        }
        // -------------------------------------------------
        for (Terminal _terminal : the_city.terminals) {
            if (_terminal instanceof Airport) {
                allAirports.add((Airport) _terminal);
                System.out.println((allAirports.indexOf(_terminal) + 1) + ". " + _terminal.getTerminalName());
            }
            System.out.println("\nPlease select one of the airports: ");
            try {
                chosen_terminal_index = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid choice. Please enter a number.");
                // scanner.nextLine();
                continue;
            }
        }
        // -------------------------------------------------
        // 2. Get the specs for the bus to be added to that terminal
        System.out.print("How much weight will your cargo plane carry? ");
        double _sumTolerableWeight = scanner.nextDouble();

        // 3. Add the bus to the terminal
        CargoPlane bought_cargo_plane = new CargoPlane(_sumTolerableWeight);
        allAirports.get(chosen_terminal_index - 1).addVehicle(bought_cargo_plane);
    }

    // -----------------------------------------
    private static void buyPassengerPlane() {
    }

    // ===================================================================================================================
    private static void hireyDriversForTerminal() {
        List<String> options = Arrays.asList("Pilot", "Sailor", "Bus Driver", "Train Driver", "Passenger Plane Crew");
        List<Runnable> actions = Arrays.asList(City::hirePilot, City::hireSailor, City::hireBusDriver,
                City::hireTrainDriver, City::hirePassengerPlaneCrew);

        showOptionsMenuChooseActions("Which type of skill should the person you want to employ have?",
                options, actions);
    }

    // --------------------------------------------------------------------------
    private static void hirePilot() {
        // 1. Show list of all airports by name and allow for user to choose one by
        Terminal chosen_airport = chooseObject(Airport.class, the_city.getTerminals());
        // ---------------------------------------------------------
        // 2. Show list of all pilots in the city who are pilots (by name) and
        Person chosen_pilot = choosePersonByJob(Job.PILOT, the_city.getPopulation());
        // ---------------------------------------------------------
        // 3. Emply the person in the terminal
        System.out.println(
                ANSIColor.GREEN.getCode() + "\nCongrats! You have employed " +
                        chosen_pilot.getName() + " "
                        + chosen_pilot.getLastname() + " at the " + chosen_airport.getTerminalName()
                        + " airport!"
                        + ANSIColor.WHITE.getCode());

    }

    // -----------------------------------------
    private static void hireSailor() {
        // 1. Show list of all shippingport by name and allow for user to choose one by
        // its number (user chooses)
        List<ShippingPort> availableShippingPorts = new ArrayList<>();
        for (Terminal _terminal : the_city.getTerminals()) {
            if (_terminal instanceof ShippingPort) {
                availableShippingPorts.add((ShippingPort) _terminal);
                System.out.println(
                        "\t" + (availableShippingPorts.indexOf(_terminal) + 1) + ". " + _terminal.getTerminalName());
            }
        }
        if (availableShippingPorts.size() == 0) {
            System.out.println("The city has no shipping ports! To emply a sailor first build shipping port.");
            return;
        }
        int chosen_shipping_port_index = -1;
        System.out.print("\nPlease select one of the shipping ports:");
        while (true) {
            try {
                chosen_shipping_port_index = scanner.nextInt();
                chosen_shipping_port_index--;
                if (chosen_shipping_port_index < 0 || chosen_shipping_port_index >= availableShippingPorts.size()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                continue;
            }
        }
        // ---------------------------------------------------------
        // 2. Show list of all pilots in the city who are pilots (by name) and
        // allow for user to choose one by its number (user chooses)
        List<Person> availableSailors = new ArrayList<>();
        for (Person _person : the_city.getPopulation()) {
            if (_person.getJob() == Job.SAILOR) {
                availableSailors.add(_person);
                System.out.println("\t" + (availableSailors.indexOf(_person) + 1) + ". " + _person.getLastname() + "," +
                        _person.getName() + " (year of birth: " + _person.getYearOfBirth() + ")");
            }
        }
        if (availableSailors.size() == 0) {
            System.out.println("The city has no sailors!");
            return;
        }
        int chosen_sailor_index = -1;
        System.out.print("\nPlease select one of sailors of the city to employ:");
        while (true) {
            try {
                chosen_sailor_index = scanner.nextInt();
                chosen_sailor_index--;
                if (chosen_sailor_index < 0 || chosen_sailor_index >= availableSailors.size()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                continue;
            }
        }
        // -------------------------
        Person chosen_sailor = the_city.getPopulation().get(chosen_sailor_index);
        // Check for available budget
        if (the_city.getBudget() < chosen_sailor.getIncome()) {
            System.out.println(
                    ANSIColor.RED.getCode() + "You don't have enough money to hire this sailor!"
                            + ANSIColor.WHITE.getCode());
            return;
        }
        the_city.useBudget(chosen_sailor.getIncome());
        // --------------------------------------------
        Terminal chosen_shippingport = availableShippingPorts.get(chosen_shipping_port_index);
        // 3. Emply the person in the terminal
        chosen_shippingport.hireEmployee(the_city.getPopulation().get(chosen_sailor_index));
        System.out.println(
                ANSIColor.GREEN.getCode() + "Congrats! You have employed " + chosen_sailor.getName() + " "
                        + chosen_sailor.getLastname() + " at the " + chosen_shippingport.getTerminalName()
                        + " shippingport!"
                        + ANSIColor.WHITE.getCode());

    }

    // -----------------------------------------
    private static void hireBusDriver() {
        // 1. Show list of all shippingport by name and allow for user to choose one by
        // its number (user chooses)
        List<BusTerminal> availableBusTerminals = new ArrayList<>();
        for (Terminal _terminal : the_city.getTerminals()) {
            if (_terminal instanceof BusTerminal) {
                availableBusTerminals.add((BusTerminal) _terminal);
                System.out.println(
                        "\t" + (availableBusTerminals.indexOf(_terminal) + 1) + ". " + _terminal.getTerminalName());
            }
        }
        if (availableBusTerminals.size() == 0) {
            System.out.println("The city has no bus terminals! To emply a bus driver first build bus terminal.");
            return;
        }
        int chosen_bus_terminal_index = -1;
        System.out.print("\nPlease select one of the bus terminals:");
        while (true) {
            try {
                chosen_bus_terminal_index = scanner.nextInt();
                chosen_bus_terminal_index--;
                if (chosen_bus_terminal_index < 0 || chosen_bus_terminal_index >= availableBusTerminals.size()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                continue;
            }
        }
        // ---------------------------------------------------------
        // 2. Show list of all pilots in the city who are pilots (by name) and
        // allow for user to choose one by its number (user chooses)
        List<Person> availableBusDrivers = new ArrayList<>();
        for (Person _person : the_city.getPopulation()) {
            if (_person.getJob() == Job.BUS_DRIVER) {
                availableBusDrivers.add(_person);
                System.out.println(
                        "\t" + (availableBusDrivers.indexOf(_person) + 1) + ". " + _person.getLastname() + "," +
                                _person.getName() + " (year of birth: " + _person.getYearOfBirth() + ")");
            }
        }
        if (availableBusDrivers.size() == 0) {
            System.out.println("The city has no bus drivers!");
            return;
        }
        int chosen_bus_drivers_index = -1;
        System.out.print("\nPlease select one of bus drivers of the city to employ:");
        while (true) {
            try {
                chosen_bus_drivers_index = scanner.nextInt();
                chosen_bus_drivers_index--;
                if (chosen_bus_drivers_index < 0 || chosen_bus_drivers_index >= availableBusDrivers.size()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                continue;
            }
        }
        // -------------------------
        Person chosen_bus_driver = the_city.getPopulation().get(chosen_bus_drivers_index);
        // Check for available budget
        if (the_city.getBudget() < chosen_bus_driver.getIncome()) {
            System.out.println(
                    ANSIColor.RED.getCode() + "You don't have enough money to hire this bus driver!"
                            + ANSIColor.WHITE.getCode());
            return;
        }
        the_city.useBudget(chosen_bus_driver.getIncome());
        // --------------------------------------------
        Terminal chosen_bus_terminal = availableBusTerminals.get(chosen_bus_terminal_index);
        // 3. Emply the person in the terminal
        chosen_bus_terminal.hireEmployee(the_city.getPopulation().get(chosen_bus_drivers_index));
        System.out.println(
                ANSIColor.GREEN.getCode() + "Congrats! You have employed " + chosen_bus_driver.getName() + " "
                        + chosen_bus_driver.getLastname() + " at the " + chosen_bus_terminal.getTerminalName()
                        + " bus terminal!"
                        + ANSIColor.WHITE.getCode());

    }

    // -----------------------------------------
    private static void hireTrainDriver() {
        // 1. Show list of all shippingport by name and allow for user to choose one by
        // its number (user chooses)
        List<TrainStation> availableTrainStation = new ArrayList<>();
        for (Terminal _terminal : the_city.getTerminals()) {
            if (_terminal instanceof TrainStation) {
                availableTrainStation.add((TrainStation) _terminal);
                System.out.println(
                        "\t" + (availableTrainStation.indexOf(_terminal) + 1) + ". " + _terminal.getTerminalName());
            }
        }
        if (availableTrainStation.size() == 0) {
            System.out.println("The city has no train station! To emply a train driver first build train station.");
            return;
        }
        int chosen_train_station_index = -1;
        System.out.print("\nPlease select one of the train stations:");
        while (true) {
            try {
                chosen_train_station_index = scanner.nextInt();
                chosen_train_station_index--;
                if (chosen_train_station_index < 0 || chosen_train_station_index >= availableTrainStation.size()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                continue;
            }
        }
        // ---------------------------------------------------------
        // 2. Show list of all pilots in the city who are pilots (by name) and
        // allow for user to choose one by its number (user chooses)
        List<Person> availableTrainDrivers = new ArrayList<>();
        for (Person _person : the_city.getPopulation()) {
            if (_person.getJob() == Job.TRAIN_DRIVER) {
                availableTrainDrivers.add(_person);
                System.out.println(
                        "\t" + (availableTrainDrivers.indexOf(_person) + 1) + ". " + _person.getLastname() + "," +
                                _person.getName() + " (year of birth: " + _person.getYearOfBirth() + ")");
            }
        }
        if (availableTrainDrivers.size() == 0) {
            System.out.println("The city has no train drivers!");
            return;
        }
        int chosen_train_drivers_index = -1;
        System.out.print("\nPlease select one of train drivers of the city to employ:");
        while (true) {
            try {
                chosen_train_drivers_index = scanner.nextInt();
                chosen_train_drivers_index--;
                if (chosen_train_drivers_index < 0 || chosen_train_drivers_index >= availableTrainDrivers.size()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                continue;
            }
        }
        // -------------------------
        Person chosen_train_driver = the_city.getPopulation().get(chosen_train_drivers_index);
        // Check for available budget
        if (the_city.getBudget() < chosen_train_driver.getIncome()) {
            System.out.println(
                    ANSIColor.RED.getCode() + "You don't have enough money to hire this train driver!"
                            + ANSIColor.WHITE.getCode());
            return;
        }
        the_city.useBudget(chosen_train_driver.getIncome());
        // --------------------------------------------
        Terminal chosen_train_station = availableTrainStation.get(chosen_train_station_index);
        // 3. Emply the person in the terminal
        chosen_train_station.hireEmployee(the_city.getPopulation().get(chosen_train_drivers_index));
        System.out.println(
                ANSIColor.GREEN.getCode() + "Congrats! You have employed " + chosen_train_driver.getName() + " "
                        + chosen_train_driver.getLastname() + " at the " + chosen_train_station.getTerminalName()
                        + " train station!"
                        + ANSIColor.WHITE.getCode());

    }

    // -----------------------------------------
    private static void hirePassengerPlaneCrew() {
    }

    // ===================================================================================================================
    private static void showTerminalsInfo() {
        // 1. Show list of all terminals by name and allow for user to choose one by its

        List<String> options = Arrays.asList("Airports", "Bus terminals", "Shipping ports", "Train stations");
        List<Runnable> actions = Arrays.asList(City::showAirports, City::showBusTerminals, City::showShippingPorts,
                City::showTrainStations);

        showOptionsMenuChooseActions("Please select a terminal type:",
                options, actions);

    }

    // -----------------------------------------
    private static void showAirports() {
        // 1. Show list of all airports by name and allow for user to choose one by
        // its number (user chooses)
        List<Airport> availableAirports = new ArrayList<>();
        for (Terminal _terminal : the_city.getTerminals()) {
            if (_terminal instanceof Airport) {
                availableAirports.add((Airport) _terminal);
                System.out.println(
                        "\t" + (availableAirports.indexOf(_terminal) + 1) + ". " + _terminal.getTerminalName());
            }
        }
        if (availableAirports.size() == 0) {
            System.out.println("The city has no airports!");
            return;
        }
        int chosen_airport_index = -1;
        System.out.print("\nPlease select one of the airports to show its info:");
        while (true) {
            try {
                chosen_airport_index = scanner.nextInt();
                chosen_airport_index--;
                if (chosen_airport_index < 0 || chosen_airport_index >= availableAirports.size()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                continue;
            }
        }

    }

    // -----------------------------------------
    private static void showBusTerminals() {

    }

    // -----------------------------------------
    private static void showShippingPorts() {
    }

    // -----------------------------------------
    private static void showTrainStations() {
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
        System.out.println(ANSIColor.MAGENTA.getCode() + "---------------------------\nRemaining budget: "
                + the_city.budget
                + "\n---------------------------"
                + ANSIColor.WHITE.getCode());
    }

    // ===================================================================================================================
    public static Person choosePersonByJob(Job job, List<Person> population) {
        List<Person> personsOfProfession = new ArrayList<>();
        System.out.println("\n\nList of " + job.name() + "s:");

        for (Person _person : population) {
            if (_person.getJob() == job) {
                personsOfProfession.add(_person);
                System.out.println(
                        "\t" + (personsOfProfession.indexOf(_person) + 1) + ". " + _person.getLastname() + "," +
                                _person.getName() + " (year of birth: " + _person.getYearOfBirth() + ")");
            }
        }

        if (personsOfProfession.size() == 0) {
            System.out.println("The city has no " + job.name() + "s!");
            return null;
        }
        int chosen_professional_index = -1;
        while (true) {
            try {
                System.out.print("Choose one of the " + job.name() + "s: ");

                chosen_professional_index = scanner.nextInt();
                chosen_professional_index--;
                if (chosen_professional_index < 0 || chosen_professional_index >= personsOfProfession.size()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid choice.");
                scanner.nextLine();
                continue;
            }
        }
        // -------------------------
        Person chosen_pilot = the_city.getPopulation().get(chosen_professional_index);
        // Check for available budget
        if (the_city.getBudget() < chosen_pilot.getIncome()) {
            System.out.println(
                    ANSIColor.RED.getCode() + "You don't have enough money to hire this " + job.name() + "!"
                            + ANSIColor.WHITE.getCode());
            return null;
        }
        the_city.useBudget(chosen_pilot.getIncome());

        // -------------------------
        return personsOfProfession.get(chosen_professional_index);
    }

    // ===================================================================================================================
    public static <T extends Terminal> T chooseObject(Class<T> derivedClass, List<Terminal> terminals) {
        List<T> derivedObjects = new ArrayList<>();
        System.out.println("\n\nAvailable " + derivedClass.getSimpleName() + "s:");
        for (Terminal _terminal : terminals) {
            if (derivedClass.isInstance(_terminal)) {
                derivedObjects.add(derivedClass.cast(_terminal));
                System.out.println(
                        "\t" + (derivedObjects.indexOf(_terminal) + 1) + ". " + _terminal.getTerminalName());
            }
        }

        if (derivedObjects.size() == 0) {
            System.out.println("The city has no " + derivedClass.getSimpleName() + "s!");
            return null;
        }
        int chosen_derivedTerminal_index = -1;
        while (true) {
            try {
                System.out.print("Choose one of the " + derivedClass.getSimpleName() + "s: ");

                chosen_derivedTerminal_index = scanner.nextInt();
                chosen_derivedTerminal_index--;
                if (chosen_derivedTerminal_index < 0 || chosen_derivedTerminal_index >= derivedObjects.size()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid choice.");
                scanner.nextLine();
                continue;
            }
        }

        return derivedObjects.get(chosen_derivedTerminal_index);

    }

    // ===================================================================================================================
    public static void showOptionsMenuChooseActions(String promptString, List<String> options,
            List<Runnable> actions) {
        int choice = -1;
        showBudgetLine();
        while (choice != 0) {

            System.out.print("\n" + promptString + "\n");

            for (int i = 0; i < options.size(); i++) {
                System.out.println("\t" + (i + 1) + ". " + options.get(i));
            }
            System.out.println("\t0. Return or exit");
            System.out.print("\nEnter your choice: ");

            try {
                choice = scanner.nextInt();
                if (choice < 0 || choice >= options.size()) {
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
