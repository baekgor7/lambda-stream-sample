package stream;

public class Student2 {

    public enum Sex {MALE, FEMALE}
    public enum City {Seoul, Pusan}

    private String name;
    private Sex sex;
    private int score;
    private City city;

    public Student2(String name, Sex sex, int score) {
        this.name = name;
        this.sex = sex;
        this.score = score;
    }

    public Student2(String name, Sex sex, int score, City city) {
        this.name = name;
        this.sex = sex;
        this.score = score;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public int getScore() {
        return score;
    }

    public City getCity() {
        return city;
    }

}
