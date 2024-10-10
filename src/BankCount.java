import java.util.ArrayList;
import java.util.Scanner;

public class BankCount {
    private String name, bankName, number;
    private float balance;

    private User user;

    public BankCount() {

    }

    public BankCount(String name, String bankName, String number, float balance, User user) {
        this.name = name;
        this.bankName = bankName;
        this.number = number;
        this.balance = balance;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public String getBankName() {
        return bankName;
    }

    public float getBalance() {
        return balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setBalance(float balance) {
        if(balance > 0)
            this.balance = balance;
        else
            this.balance = 0;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void insertData(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите название банка, в котором хотите завести счёт: ");
        setBankName(sc.nextLine());
        System.out.print("Введите название для счёта: ");
        setName(sc.nextLine());
        System.out.print("Введите номер для счёта: ");
        setNumber(sc.next());
        System.out.print("Введите начальный взнос: ");
        setBalance(sc.nextInt());
    }
}
