import java.util.Scanner;

public class CashMachine implements ICashMachine {
    String BankName = "MyBank";

    public CashMachine(String bankName) {
        BankName = bankName;
    }

    @Override
    public void getBalance(BankCount bankCount) {
        if(pinCheck(bankCount))
            System.out.println(bankCount.getUser().getName() + " " + bankCount.getUser().getSurname() + " на вашем счёте " + bankCount.getName() + " - " +  bankCount.getBalance() + " рублей.");
    }

    @Override
    public void addCount(BankCount bankCount, float sum) {
        if(pinCheck(bankCount)) {
            bankCount.setBalance((bankCount.getBalance() + sum));
            System.out.println("На счёт " + bankCount.getName() + " переведено " + sum + " рублей. Удачного Bам дня, " + bankCount.getUser().getName() + "!");
        }
    }

    @Override
    public void takeMoney(BankCount bankCount, float sum) {
        float newSum = sum;
        if(!pinCheck(bankCount))
            return;
        if(!bankCount.getBankName().equals(BankName)) {
            System.out.println("При снятии средств будет списана комиссия 2%. Пользуйтесь услугами банка " + BankName + " и комиссии не будет.");
            newSum *= 1.02;
        }
        if(bankCount.getBalance() < newSum) {
            System.out.println("На вашем счёте недостаточно средств.");
        }
        else {
            bankCount.setBalance(bankCount.getBalance() - newSum);
            System.out.println("С счёта " + bankCount.getName() + " снято " + newSum + " рублей. Удачного Bам дня, " + bankCount.getUser().getName() + "!");
        }
    }

    @Override
    public void transferToCount(BankCount bankCount, BankCount bankCount2, float sum) {
        float newSum = sum;
        if(!pinCheck(bankCount))
            return;
        if(!bankCount.getBankName().equals(BankName)) {
            System.out.println("При переводе средств будет списана комиссия 2%. Пользуйтесь услугами банка " + BankName + " и комиссии не будет.");
            newSum *= 1.02;
        }
        if(bankCount.getBalance() < newSum) {
            System.out.println("На вашем счёте недостаточно средств.");
        }
        else {
            bankCount.setBalance(bankCount.getBalance() - newSum);
            bankCount2.setBalance(bankCount2.getBalance() + sum);
            System.out.println("С счёта " + bankCount.getName() + " переведено на счёт " + bankCount2.getName() + " " + sum + " рублей. Удачного Bам дня, " + bankCount.getUser().getName() + "!");
        }
    }

    private boolean pinCheck(BankCount bankCount){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите pin: ");
        if(bankCount.getUser().getPin().equals(sc.next()))
            return true;
        System.out.println("Произошла неизвестная ошибка!");
        return false;
    }
}
