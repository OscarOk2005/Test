import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String surname, name, pin;
    private int id;

    private ArrayList<BankCount> bankCounts;

    public User() {
        bankCounts = new ArrayList<>();
    }

    public User(String surname, String name, String pin, int id) {
        this.surname = surname;
        this.name = name;
        this.pin = pin;
        this.id = id;
        bankCounts = new ArrayList<>();
    }

    public void addCount(BankCount bankCount) {
        bankCounts.add(bankCount);
    }

    public int getCountSize() {
        return bankCounts.size();
    }

    public ArrayList<BankCount> getBankCounts() {
        return bankCounts;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void insertData() {
        bankCounts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите Ваше имя: ");
        setName(sc.next());
        System.out.print("Введите Вашу фамилию: ");
        setSurname(sc.next());
    }
}
