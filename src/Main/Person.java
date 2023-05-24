package Main;

public class Person {

    // -------------------------------------
    public enum Gender {
        MALE, FEMALE
    }

    // -------------------------------------
    public enum Job {
        PILOT, SAILOR, BUS_DRIVER, TRAIN_DRIVER, PASSENGER_PLANE_CREW
    }

    // -------------------------------------
    private String name;
    private String lastname;
    private int yearOfBirth;
    private String placeOfBirth;
    private Job job;
    private Gender gender;
    private double income;

    // constructor
    public Person(String name, String lastname, int yearOfBirth, String placeOfBirth, Job job, Gender gender,
            double income) {
        this.name = name;
        this.lastname = lastname;
        this.yearOfBirth = yearOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.gender = gender;
        // Only job and income can be changed after creation of Person
        setJob(job);
        setIncome(income);
    }

    // -----------------------------------
    public String getName() {
        return this.name;
    }

    // -----------------------------------
    public String getLastname() {
        return this.lastname;
    }

    // -----------------------------------
    public int getYearOfBirth() {
        return this.yearOfBirth;
    }

    // -----------------------------------
    public String getPlaceOfBirth() {
        return this.placeOfBirth;
    }

    // -----------------------------------
    public void setJob(Job job) {
        this.job = job;
    }

    public Job getJob() {
        return this.job;
    }
    // -----------------------------------
    // public void setGender(Gender gender) {
    // this.gender = gender;
    // }

    public Gender getGender() {
        return this.gender;
    }

    // -----------------------------------
    public void setIncome(double income) {
        this.income = income;
    }

    public double getIncome() {
        return this.income;
    }
    // -----------------------------------
}
