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
import Main.Buildings.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Main.Buildings.Terminal;
import Main.Person.Job;
import Main.Vehicles.Boat;
import Main.Vehicles.CargoPlane;
import Main.Vehicles.InterCityBus;
import Main.Vehicles.PassengerPlane;
import Main.Vehicles.Ship;
import Main.Vehicles.Train;

import java.util.Scanner;

public class City {

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
        Person pilot1 = new Person("Maryam", "Qarai", 1390, "Qom", Person.Job.PILOT, Person.Gender.FEMALE, 150.1);
        Person pilot2 = new Person("Emmet", "Emmet", 1375, "Legoland", Person.Job.PILOT, Person.Gender.MALE, 500.1);
        the_city.addPerson(pilot1);
        the_city.addPerson(pilot2);
        the_city.addPerson(
                new Person("Emmet", "Brickowski", 1362, "Legoland", Person.Job.BUS_DRIVER, Person.Gender.MALE, 500.1));
        the_city.addPerson(
                new Person("Emmet", "Awesome", 1375, "Legoland", Person.Job.PILOT, Person.Gender.MALE, 500.1));
        the_city.addPerson(
                new Person("Amin", "Masoodi", 1353, "Tehran", Person.Job.SAILOR, Person.Gender.MALE, 80.1));
        the_city.addPerson(
                new Person("Lucy", "Wyldstyle", 1370, "California", Person.Job.TRAIN_DRIVER, Person.Gender.FEMALE,
                        75.5));
        the_city.addPerson(
                new Person("Lloyd", "Montgomery", 2000, "LegoNinjago", Person.Job.BUS_DRIVER, Person.Gender.MALE,
                        65.3));
        the_city.addPerson(
                new Person("Jay", "kay", 1385, "Seoul", Person.Job.TRAIN_DRIVER, Person.Gender.MALE, 55.6));
        the_city.addPerson(
                new Person("Kane", "Stone", 1385, "Washington", Person.Job.PASSENGER_PLANE_CREW, Person.Gender.MALE,
                        175.5));
        the_city.addPerson(
                new Person("Kai", "Lee", 1385, "Tokyo", Person.Job.SAILOR, Person.Gender.MALE, 85.2));
        the_city.addPerson(
                new Person("Ella", "Gertrude", 1369, "London", Person.Job.BUS_DRIVER, Person.Gender.FEMALE, 95.5));
        the_city.addPerson(
                new Person("Elizabeth", " Phantomhive", 1385, "Paris", Person.Job.PASSENGER_PLANE_CREW,
                        Person.Gender.FEMALE, 750));

        // ---------------------------------------
        Airport airport1 = new Airport(80000, "Qom", "Mehr", "Shohada", 15000, true, 3);
        airport1.hireEmployee(pilot1);
        airport1.hireEmployee(pilot2);
        the_city.addTerminal(airport1);

        the_city.addTerminal(new Airport(80000, "Soor", "Panda", "Khersabd", 30000, true, 13));
        the_city.addTerminal(new Airport(80000, "Gooor", "Khersabad", "Shongolabd", 15000, true, 5));

        // ---------------------------------------
        the_city.addTerminal(new TrainStation(20000, "Yazd", "Yazdi", "Laleh", 15000, 10, 5));
        the_city.addTerminal(new TrainStation(20000, "Tabriz", "Tabrizi", "Rose", 16000, 20, 9));

        the_city.addTerminal(new ShippingPort(30000, "Mahsha", "Abi", "Niloofar street", 19000.2, 10));
        the_city.addTerminal(new ShippingPort(30000, "Chahbah", "Nilgoon", "Nilestan street", 29000.9, 22));

        the_city.addTerminal(new BusTerminal(170000, "Rashtu", "Rashtra", "Meidan", 12000));
        the_city.addTerminal(new BusTerminal(18000, "Babol", "Amoli", "Rose st.", 13000));
        // ---------------------------------------

        // listProperties(the_city.getTerminals().get(0));
        // System.exit(0);

        // ----------------------------------------
        // Now build the city itself
        List<String> options = Arrays.asList("Build a terminal", "Buy a vehicle", "Hire a driver",
                "Show terminals info", "Build a hotel", "Build a room in hotel", "Show hotels info");
        List<Runnable> actions = Arrays.asList(City::buildTeminal, City::buyVehiclesForTeminal,
                City::hireyDriversForTerminal,
                City::showTerminalsInfo, City::buildHotel, City::buildRoomForHotel, City::showHotelsInfo);

        Utility.showOptionsMenuChooseActions("Please select a task:", options, actions);
        // ---------------------------------------
        // System.out.println("Area: " + myCity.getArea());
        // System.exit(0);
        scanner.close();
    }

    // ===================================================================================================================
    private static void buildTeminal() {

        List<String> options = Arrays.asList("Airport", "Bus terminal", "Shipping port", "Train station");
        List<Runnable> actions = Arrays.asList(City::buildAirport, City::buildBusTerminal, City::buildShippingPort,
                City::buildTrainStation);

        Utility.showOptionsMenuChooseActions("Please select a terminal type to build:",
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
                printErrorMessage("You don't have enough money to build the airport!");

                return;
            } else if (_construction_cost <= 0) {
                printErrorMessage("You must enter a positive number!");

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

            printSuccessMessage("The airport has been built!");

        } catch (Exception e) {
            printErrorMessage("Invalid data type!");

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

        try {
            System.out.print(
                    "-----------------------------------------\nHow much do you want to spend for building the train station? ");
            double _construction_cost = scanner.nextDouble();
            // Check for available budget
            if (the_city.getBudget() < _construction_cost) {
                printErrorMessage("You don't have enough money to build the train station!");

                return;
            } else if (_construction_cost <= 0) {
                printErrorMessage("You must enter a positive number!");

            } else {
                the_city.useBudget((_construction_cost));
            }
            // -------------------------------------------------
            // Eat the newline from previous input
            scanner.nextLine();
            System.out.print("Enter the name of the city in which the train station will be built: ");
            String _city_name = scanner.nextLine();
            System.out.print("Enter the name of the train station: ");
            String _train_station_name = scanner.nextLine();
            System.out.print("Enter the construction site address for the train station: ");
            String _address = scanner.nextLine();
            System.out.print("Over how much area will the train station be built? ");
            double _area = scanner.nextDouble();
            System.out.print("How many rails will enter the train station? ? ");
            int _input_rail_num = scanner.nextInt();
            System.out.print("How many rails will exit the train station? ");
            int _output_rail_num = scanner.nextInt();

            // -------------------------------------------------
            TrainStation _train_station = new TrainStation(_construction_cost, _city_name, _train_station_name,
                    _address, _area, _input_rail_num, _output_rail_num);
            the_city.addTerminal(_train_station);

            printSuccessMessage("The train_station has been built!");

        } catch (Exception e) {
            printErrorMessage("Invalid data type!");

        }
    }
    // -----------------------------------------

    private static void buildShippingPort() {

        try {
            System.out.print(
                    "-----------------------------------------\nHow much do you want to spend for building the shipping_port? ");
            double _construction_cost = scanner.nextDouble();
            // Check for available budget
            if (the_city.getBudget() < _construction_cost) {
                printErrorMessage("You don't have enough money to build the shipping_port!");
                return;
            } else if (_construction_cost <= 0) {
                printErrorMessage("You must enter a positive number!");

            } else {
                the_city.useBudget((_construction_cost));
            }
            // -------------------------------------------------
            // Eat the newline from previous input
            scanner.nextLine();
            System.out.print("Enter the name of the city in which the shipping_port will be built: ");
            String _city_name = scanner.nextLine();
            System.out.print("Enter the name of the shipping_port: ");
            String _shipping_port_name = scanner.nextLine();
            System.out.print("Enter the construction site address for the shipping_port: ");
            String _address = scanner.nextLine();
            System.out.print("Over how much area will the shipping_port be built? ");
            double _area = scanner.nextDouble();
            System.out.print("How many wharfs will the shipping_port have? ");
            int _wharf_num = scanner.nextInt();

            // -------------------------------------------------
            ShippingPort _shipping_port = new ShippingPort(_construction_cost, _city_name, _shipping_port_name,
                    _address, _area, _wharf_num);
            the_city.addTerminal(_shipping_port);

            printSuccessMessage("The shipping port has been built!");

        } catch (Exception e) {
            printErrorMessage("Invalid data type!");

        }
    }
    // -----------------------------------------

    private static void buildBusTerminal() {

        try {
            System.out.print(
                    "-----------------------------------------\nHow much do you want to spend for building the bus_terminal? ");
            double _construction_cost = scanner.nextDouble();
            // Check for available budget
            if (the_city.getBudget() < _construction_cost) {
                printErrorMessage("You don't have enough money to build a bus terminal!");

                return;
            } else if (_construction_cost <= 0) {
                printErrorMessage("You must enter a positive number!");

            } else {
                the_city.useBudget((_construction_cost));
            }
            // -------------------------------------------------
            // Eat the newline from previous input
            scanner.nextLine();
            System.out.print("Enter the name of the city in which the bus_terminal will be built: ");
            String _city_name = scanner.nextLine();
            System.out.print("Enter the name of the bus_terminal: ");
            String _bus_terminal_name = scanner.nextLine();
            System.out.print("Enter the construction site address for the bus_terminal: ");
            String _address = scanner.nextLine();
            System.out.print("Over how much area will the bus_terminal be built? ");
            double _area = scanner.nextDouble();

            // -------------------------------------------------
            BusTerminal _bus_terminal = new BusTerminal(_construction_cost, _city_name, _bus_terminal_name, _address,
                    _area);
            the_city.addTerminal(_bus_terminal);

            printSuccessMessage("The bus terminal has been built!");

        } catch (Exception e) {
            printErrorMessage("Invalid data type!");
        }
    }

    // ===================================================================================================================
    private static void buyVehiclesForTeminal() {

        List<String> options = Arrays.asList("Boat", "Ship", "Bus", "Train", "Cargo Plane", "Passenger Plane");
        List<Runnable> actions = Arrays.asList(City::buyBoat, City::buyShip, City::buyBus,
                City::buyTrain, City::buyCargoPlane, City::buyPassengerPlane);

        Utility.showOptionsMenuChooseActions("What type of vehicle do you want to buy?",
                options, actions);
    }

    // --------------------------------------------------------------------------
    private static void buyBoat() {
        // 0. Check for available budget
        if (the_city.getBudget() < Boat.purchasePrice) {
            printErrorMessage("You don't have enough money to buy a boat!");
            return;
        } else {
            the_city.useBudget((Boat.purchasePrice));
        }
        // 1. Show list of all shipping ports by name and allow for user to choose one
        Terminal chosen_shipping_port = chooseTerminal(ShippingPort.class, the_city.getTerminals());
        if (chosen_shipping_port == null) {
            return;
        }
        try {
            // 2. Get the specs for the boat to be added to that terminal
            System.out.print("how many paddles will your boat have? ");
            int _paddle_num = scanner.nextInt();

            // 3. Add the boat to the city terminal
            Boat bought_boat = new Boat(_paddle_num);
            chosen_shipping_port.addVehicle(bought_boat);
            // -------------------------------------------------
            printSuccessMessage("The boat has been bought and added to the port!");
        } catch (Exception e) {
            printErrorMessage("Invalid data type!");
        }
    }

    // -----------------------------------------
    private static void buyShip() {
        // 0. Check for available budget
        if (the_city.getBudget() < Ship.purchasePrice) {
            printErrorMessage("You don't have enough money to buy a ship!");
            return;
        } else {
            the_city.useBudget((Ship.purchasePrice));
        }
        try {
            // 1. Show list of all shipping ports by name and allow for user to choose one
            Terminal chosen_shipping_port = chooseTerminal(ShippingPort.class, the_city.getTerminals());
            if (chosen_shipping_port == null) {
                return;
            }
            // 2. Get the specs for the ship to be added to that terminal
            System.out.print("What will be the tonnage of your ship? ");
            int _tonnage = scanner.nextInt();

            // 3. Add the ship to the city terminal
            Ship bought_ship = new Ship(_tonnage);
            chosen_shipping_port.addVehicle(bought_ship);
            // -------------------------------------------------
            printSuccessMessage("The ship has been bought and added to the port!");
        } catch (Exception e) {
            printErrorMessage("Invalid data type!");
        }
    }

    // -----------------------------------------
    private static void buyBus() {
        // 0. Check for available budget
        if (the_city.getBudget() < InterCityBus.purchasePrice) {
            printErrorMessage("You don't have enough money to buy a bus!");
            return;
        } else {
            the_city.useBudget((InterCityBus.purchasePrice));
        }

        // 1. Show list of all bus terminals by name and allow for user to choose one
        Terminal chosen_bus_terminal = chooseTerminal(BusTerminal.class, the_city.getTerminals());
        if (chosen_bus_terminal == null) {
            return;
        }
        try {
            // 2. Get the specs for the bus to be added to that terminal
            System.out.print("How many seats your buses will have?");
            int _totalSeatNum = scanner.nextInt();

            // 3. Add the bus to the city terminal
            InterCityBus bought_bus = new InterCityBus(_totalSeatNum);
            chosen_bus_terminal.addVehicle(bought_bus);
            // -------------------------------------------------
            printSuccessMessage("The bus has been bought and added to the station!");
        } catch (Exception e) {
            printErrorMessage("Invalid data type!");
        }
    }

    // -----------------------------------------
    private static void buyTrain() {
        // 0. Check for available budget
        if (the_city.getBudget() < Train.purchasePrice) {
            printErrorMessage("You don't have enough money to buy a train!");
            return;
        } else {
            the_city.useBudget((Train.purchasePrice));
        }
        // 1. Show list of all train stations by name and allow for user to choose one
        Terminal chosen_train_station = chooseTerminal(TrainStation.class, the_city.getTerminals());
        if (chosen_train_station == null) {
            return;
        }

        try {
            // 2. Get the specs for the train to be added to that terminal
            System.out.print("How many wagons will your train have? ");
            int _wangon_num = scanner.nextInt();

            System.out.print("How many stars will your train have (1-5)? ");
            int _stars = scanner.nextInt();

            System.out.print(
                    "How many welfare facilities (RESTROOMS and RESTAURANTS) you want to be installed in your train? ");
            int _nwf = scanner.nextInt();
            scanner.nextLine();

            List<Train.WelfareFacility> welfareFacilities = new ArrayList<Train.WelfareFacility>();
            for (int i = 0; i < _nwf; i++) {
                System.out.print("Choose the type of facility #" + i + " (RESTROOM, RESTAURANT): ");
                String wf_str = scanner.nextLine();

                Train.WelfareFacility wf = Train.WelfareFacility.valueOf(wf_str);
                welfareFacilities.add(wf);

            }
            // -------------------------------------------------
            // 3. Add the train to the city terminal
            Train bought_train = new Train(_wangon_num, _stars, welfareFacilities);
            chosen_train_station.addVehicle(bought_train);
            // -------------------------------------------------
            printSuccessMessage("The train has been bought and added to the station!");

        } catch (Exception e) {
            printErrorMessage("Invalid data type!");

        }
    }

    // -----------------------------------------
    private static void buyCargoPlane() {
        // 0. Check for available budget
        if (the_city.getBudget() < CargoPlane.purchasePrice) {
            printErrorMessage("You don't have enough money to buy a cargo plane!");
            return;
        } else {
            the_city.useBudget((CargoPlane.purchasePrice));
        }

        // 1. Show list of all airports by name and allow for user to choose one
        Terminal chosen_airpot = chooseTerminal(Airport.class, the_city.getTerminals());
        if (chosen_airpot == null) {
            return;
        }
        try {
            // 2. Get the specs for the cargo_plane to be added to that terminal
            System.out.print("How much weight will your cargo_plane carry? ");
            double _tolerable_weight_sum = scanner.nextDouble();
            // 3. Add the cargo_plane to the city terminal
            CargoPlane bought_cargo_plane = new CargoPlane(_tolerable_weight_sum);
            chosen_airpot.addVehicle(bought_cargo_plane);
            // -------------------------------------------------
            printSuccessMessage("The cargo plane has been bought and added to the airport!");
        } catch (Exception e) {
            printErrorMessage("Invalid data type!");
        }

    }

    // -----------------------------------------
    private static void buyPassengerPlane() {
        // 0. Check for available budget
        if (the_city.getBudget() < PassengerPlane.purchasePrice) {
            printErrorMessage("You don't have enough money to buy a passenger plane!");
            return;
        } else {
            the_city.useBudget((PassengerPlane.purchasePrice));
        }

        // 1. Show list of all airports by name and allow for user to choose one
        Terminal chosen_airpot = chooseTerminal(Airport.class, the_city.getTerminals());
        if (chosen_airpot == null) {
            return;
        }
        try {
            // 2. Get the specs for the cargo_plane to be added to that terminal
            System.out.print("How many crew will your passenger plane have? ");
            int _crew_sum = scanner.nextInt();
            System.out.print("How many rows will your passenger plane have? ");
            int _seat_row = scanner.nextInt();

            // 3. Add the cargo_plane to the city terminal
            PassengerPlane bought_passenger_plane = new PassengerPlane(_crew_sum, _seat_row);
            chosen_airpot.addVehicle(bought_passenger_plane);
            // -------------------------------------------------
            printSuccessMessage("The passenger plane has been bought and added to the airport!");
        } catch (Exception e) {
            printErrorMessage("Invalid data type!");
        }
    }

    // ===================================================================================================================
    private static void hireyDriversForTerminal() {
        List<String> options = Arrays.asList("Pilot", "Sailor", "Bus Driver", "Train Driver", "Passenger Plane Crew");
        List<Runnable> actions = Arrays.asList(City::hirePilot, City::hireSailor, City::hireBusDriver,
                City::hireTrainDriver, City::hirePassengerPlaneCrew);

        Utility.showOptionsMenuChooseActions("Which type of skill should the person you want to employ have?",
                options, actions);
    }

    // --------------------------------------------------------------------------
    private static void hirePilot() {
        // 1. Show list of all airports by name and allow for user to choose one by
        Terminal chosen_airport = chooseTerminal(Airport.class, the_city.getTerminals());
        if (chosen_airport == null) {
            return;
        }
        // ---------------------------------------------------------
        // 2. Show list of all pilots in the city who are pilots (by name) and
        Person chosen_pilot = choosePersonByJob(Job.PILOT, the_city.getPopulation());
        if (chosen_pilot == null) {
            return;
        }
        // ---------------------------------------------------------
        // 3. Employ the person in the terminal
        chosen_airport.hireEmployee(chosen_pilot);

        printSuccessMessage("\nCongrats! You have employed " +
                chosen_pilot.getName() + " "
                + chosen_pilot.getLastname() + " at the " + chosen_airport.getTerminalName()
                + " airport!");

    }

    // -----------------------------------------
    private static void hireSailor() {
        // 1. Show list of all airports by name and allow for user to choose one by
        Terminal chosen_port = chooseTerminal(ShippingPort.class, the_city.getTerminals());
        if (chosen_port == null) {
            return;
        }
        // ---------------------------------------------------------
        // 2. Show list of all pilots in the city who are pilots (by name) and
        Person chosen_sailor = choosePersonByJob(Job.SAILOR, the_city.getPopulation());
        if (chosen_sailor == null) {
            return;
        }
        // ---------------------------------------------------------
        // 3. Emply the person in the terminal
        chosen_port.hireEmployee(chosen_sailor);

        printSuccessMessage("\nCongrats! You have employed " +
                chosen_sailor.getName() + " "
                + chosen_sailor.getLastname() + " at the " + chosen_port.getTerminalName()
                + " shipping-port!");

    }

    // -----------------------------------------
    private static void hireBusDriver() {
        // 1. Show list of all airports by name and allow for user to choose one by
        Terminal chosen_bus_terminal = chooseTerminal(BusTerminal.class, the_city.getTerminals());
        if (chosen_bus_terminal == null) {
            return;
        }
        // ---------------------------------------------------------
        // 2. Show list of all pilots in the city who are pilots (by name) and
        Person chosen_bus_driver = choosePersonByJob(Job.BUS_DRIVER, the_city.getPopulation());
        if (chosen_bus_driver == null) {
            return;
        }
        // ---------------------------------------------------------
        // 3. Emply the person in the terminal
        chosen_bus_terminal.hireEmployee(chosen_bus_driver);

        printSuccessMessage("\nCongrats! You have employed " +
                chosen_bus_driver.getName() + " "
                + chosen_bus_driver.getLastname() + " at the " + chosen_bus_terminal.getTerminalName()
                + " bus-terminal!");

    }

    // -----------------------------------------
    private static void hireTrainDriver() {
        // 1. Show list of all airports by name and allow for user to choose one by
        Terminal chosen_train_station = chooseTerminal(TrainStation.class, the_city.getTerminals());
        if (chosen_train_station == null) {
            return;
        }
        // ---------------------------------------------------------
        // 2. Show list of all pilots in the city who are pilots (by name) and
        Person chosen_train_driver = choosePersonByJob(Job.TRAIN_DRIVER, the_city.getPopulation());
        if (chosen_train_driver == null) {
            return;
        }
        // ---------------------------------------------------------
        // 3. Emply the person in the terminal
        chosen_train_station.hireEmployee(chosen_train_driver);

        printSuccessMessage("\nCongrats! You have employed " +
                chosen_train_driver.getName() + " "
                + chosen_train_driver.getLastname() + " at the " + chosen_train_station.getTerminalName()
                + " train-station!");

    }

    // -----------------------------------------
    private static void hirePassengerPlaneCrew() {
        // 1. Show list of all airports by name and allow for user to choose one by
        Terminal chosen_airport = chooseTerminal(Airport.class, the_city.getTerminals());
        if (chosen_airport == null) {
            return;
        }
        // ---------------------------------------------------------
        // 2. Show list of all pilots in the city who are pilots (by name) and
        Person chosen_plane_crew = choosePersonByJob(Job.PASSENGER_PLANE_CREW, the_city.getPopulation());
        if (chosen_plane_crew == null) {
            return;
        }
        // ---------------------------------------------------------
        // 3. Emply the person in the terminal
        chosen_airport.hireEmployee(chosen_plane_crew);

        printSuccessMessage("\nCongrats! You have employed " +
                chosen_plane_crew.getName() + " "
                + chosen_plane_crew.getLastname() + " at the " + chosen_airport.getTerminalName()
                + " airport!");

    }

    // ===================================================================================================================
    private static void showTerminalsInfo() {
        List<String> options = Arrays.asList("Airports", "Bus terminals", "Shipping ports", "Train stations");
        List<Runnable> actions = Arrays.asList(City::showAirports, City::showBusTerminals, City::showShippingPorts,
                City::showTrainStations);

        Utility.showOptionsMenuChooseActions("Please select a terminal type:",
                options, actions);
    }

    // -----------------------------------------
    private static void showAirports() {

        Terminal chosen_airport = chooseTerminal(Airport.class, the_city.getTerminals());
        if (chosen_airport == null) {
            return;
        }
        Utility.listProperties(chosen_airport);

    }

    // -----------------------------------------
    private static void showBusTerminals() {
        Terminal chosen_bus_terminal = chooseTerminal(BusTerminal.class, the_city.getTerminals());
        if (chosen_bus_terminal == null) {
            return;
        }
        Utility.listProperties(chosen_bus_terminal);

    }

    // -----------------------------------------
    private static void showShippingPorts() {
        Terminal chosen_shipping_port = chooseTerminal(ShippingPort.class, the_city.getTerminals());
        if (chosen_shipping_port == null) {
            return;
        }
        Utility.listProperties(chosen_shipping_port);
    }

    // -----------------------------------------
    private static void showTrainStations() {
        Terminal chosen_train_station = chooseTerminal(TrainStation.class, the_city.getTerminals());
        if (chosen_train_station == null) {
            return;
        }
        Utility.listProperties(chosen_train_station);
    }

    // ===================================================================================================================
    private static void buildHotel() {
        try {
            System.out.print(
                    "-----------------------------------------\nHow much do you want to spend for building the hotel? ");
            double _construction_cost = scanner.nextDouble();
            // Check for available budget
            if (the_city.getBudget() < _construction_cost) {
                printErrorMessage("You don't have enough money to build the hotel!");
                return;
            } else if (_construction_cost <= 0) {
                printErrorMessage("You must enter a positive number!");

            } else {
                the_city.useBudget((_construction_cost));
            }
            // -------------------------------------------------
            // Eat the newline from previous input
            scanner.nextLine();
            System.out.print("Enter the name of the hotel: ");
            String _hotel_name = scanner.nextLine();
            System.out.print("Enter the construction site address for the hotel: ");
            String _address = scanner.nextLine();
            System.out.print("How many stars do you want the hotel to have? ");
            int _stars = scanner.nextInt();

            // -------------------------------------------------
            Hotel _hotel = new Hotel(_construction_cost, _hotel_name,
                    _address, _stars);
            the_city.addHotel(_hotel);

            printSuccessMessage("\nCongrats! Your hotel is readdy!");

        } catch (Exception e) {
            printErrorMessage("Invalid data type!");

        }
    }

    // ===================================================================================================================
    private static void buildRoomForHotel() {
        // 1. Show list of all hotels by name and allow for user to choose one by its
        // number (user chooses)
        List<Hotel> availableHotels = the_city.getHotels();
        for (Hotel _hotel : availableHotels) {
            System.out.println(
                    "\t" + (availableHotels.indexOf(_hotel) + 1) + ". " + _hotel.getHotelName());

        }
        if (availableHotels.size() == 0) {
            printErrorMessage("The city has no hotels!");
            return;
        }
        int chosen_hotel_index = -1;
        System.out.print("\nPlease select the hotel to which you want to add a room: ");
        while (true) {
            try {
                chosen_hotel_index = scanner.nextInt();
                chosen_hotel_index--;
                if (chosen_hotel_index < 0 || chosen_hotel_index >= availableHotels.size()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                continue;
            }
        }
        // -------------------------------------------
        Hotel chosen_hotel = availableHotels.get(chosen_hotel_index);
        int roomNum = 0, bedsNum = 0;
        double area = 0, roomCost = 0;
        // ********************************************************************* */ Ask
        // the questions and get the values of room params
        // 2. Get the specs for the room to be added to that hotel
        Room built_room = new Room(roomNum, bedsNum, area, roomCost);
        // ---------------------------------------------------------
        // 3. Add the room to hotel
        chosen_hotel.addRoom(built_room);

        printSuccessMessage("\nCongrats! You have built a room at the " + chosen_hotel.getHotelName()
                + " hotel!");

    }

    // ===================================================================================================================
    private static void showHotelsInfo() {

        // 1. Show list of all shippingport by name and allow for user to choose one by
        // its number (user chooses)
        List<Hotel> availableHotels = the_city.getHotels();
        for (Hotel _hotel : availableHotels) {
            System.out.println(
                    "\t" + (availableHotels.indexOf(_hotel) + 1) + ". " + _hotel.getHotelName());

        }
        if (availableHotels.size() == 0) {
            printErrorMessage("The city has no hotels!");
            return;
        }
        int chosen_hotel_index = -1;
        System.out.print("\nPlease select one of the hotel to show its info:");
        while (true) {
            try {
                chosen_hotel_index = scanner.nextInt();
                chosen_hotel_index--;
                if (chosen_hotel_index < 0 || chosen_hotel_index >= availableHotels.size()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                continue;
            }
        }
        // -------------------------------------------
        Hotel chosen_hotel = availableHotels.get(chosen_hotel_index);

        Utility.listProperties(chosen_hotel);

    }

    // ===================================================================================================================
    static void showBudgetLine() {
        System.out.println(Utility.ANSIColor.MAGENTA.getCode() + "---------------------------\nRemaining budget: "
                + the_city.budget
                + "\n---------------------------"
                + Utility.ANSIColor.WHITE.getCode());
    }

    // ===================================================================================================================
    public static void printSuccessMessage(String msg) {
        System.out.println(
                Utility.ANSIColor.GREEN.getCode() + msg
                        + Utility.ANSIColor.WHITE.getCode());

    }

    // --------------------------------------------
    public static void printErrorMessage(String msg) {
        System.out.println(
                Utility.ANSIColor.RED.getCode() + msg
                        + Utility.ANSIColor.WHITE.getCode());

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
            printErrorMessage("The city has no " + job.name() + "s!");
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
                printErrorMessage("Invalid choice.");
                scanner.nextLine();
                continue;
            }
        }
        // -------------------------
        Person chosen_pilot = the_city.getPopulation().get(chosen_professional_index);
        // Check for available budget
        if (the_city.getBudget() < chosen_pilot.getIncome()) {
            printErrorMessage("You don't have enough money to hire this " + job.name() + "!");
            return null;
        }
        the_city.useBudget(chosen_pilot.getIncome());

        // -------------------------
        return personsOfProfession.get(chosen_professional_index);
    }

    // ===================================================================================================================
    public static <T extends Terminal> T chooseTerminal(Class<T> terminalSubtype, List<Terminal> terminals) {
        List<T> derivedObjects = new ArrayList<>();
        System.out.println("\n\nAvailable " + terminalSubtype.getSimpleName() + "s:");
        for (Terminal _terminal : terminals) {
            if (terminalSubtype.isInstance(_terminal)) {
                derivedObjects.add(terminalSubtype.cast(_terminal));
                System.out.println(
                        "\t" + (derivedObjects.indexOf(_terminal) + 1) + ". " + _terminal.getTerminalName());
            }
        }

        if (derivedObjects.size() == 0) {
            printErrorMessage("The city has no " + terminalSubtype.getSimpleName() + "s!");

            return null;
        }
        int chosen_derivedTerminal_index = -1;
        while (true) {
            try {
                System.out.print("Choose one of the " + terminalSubtype.getSimpleName() + "s: ");

                chosen_derivedTerminal_index = scanner.nextInt();
                chosen_derivedTerminal_index--;
                if (chosen_derivedTerminal_index < 0 || chosen_derivedTerminal_index >= derivedObjects.size()) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                printErrorMessage("Invalid choice.");
                scanner.nextLine();
                continue;
            }
        }

        return derivedObjects.get(chosen_derivedTerminal_index);

    }

}
