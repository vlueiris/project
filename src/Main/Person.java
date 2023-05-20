package Main;

public class Person {

    // -------------------------------------
    public enum Gender {
        MALE, FEMALE

    }

    // -------------------------------------
    public enum Job {
        PILOT, SAILOR, BUS_DRIVER, TRAIN_DRIVER, PASSENGER_PLANE__CREW
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
        setName(name);
        setLastname(lastname);
        setYearOfBirth(yearOfBirth);
        setPlaceOfBirth(placeOfBirth);
        setJob(job);
        setGender(gender);
        setIncome(income);
    }

    // -----------------------------------
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    // -----------------------------------

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return this.lastname;
    }

    // -----------------------------------
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getYearOfBirth() {
        return this.yearOfBirth;
    }

    // -----------------------------------
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

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

    public void setGender(Gender gender) {
        this.gender = gender;
    }

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
