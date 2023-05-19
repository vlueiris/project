package Main;

public class Person {

    public enum Gender {
        MALE, FEMALE

    }

    public enum Job {
        PILOT, SAILOR, BUS_DRIVER, TRAIN_DRIVER, TRAIN_CREW
    }

    private String name;
    private String lastname;
    private int yearOfBirth;
    private String placeOfBirth;
    private Job job;
    private Gender gender;
    private double income;

// constructor
    public Person(String name, String lastname, int yearOfBirth, String placeOfBirth, Job job, Gender gender, double income) {
        setName(name);
        setLastname(lastname);
        setYearOfBirth(yearOfBirth);
        setPlaceOfBirth(placeOfBirth);
        setJob(job);
        setGender(gender);
        setIncome(income);
    }

// setters
    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setIncome(double income) {
        this.income = income;
    }

// getters
    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getJob() {
        return job;
    }

    public String getGender() {
        return gender;
    }

    public double getIncome() {
        return income;
    }
}
