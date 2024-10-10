import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        User user1 = new User("Около-Кулак", "Оскар", "0000", 1);
        BankCount bC1 = new BankCount("Ипотека", "MyBank", "MBC1734", 1000, user1);
        BankCount bC2 = new BankCount("Другая ипотека", "BSP", "SP78345", 500, user1);
        user1.addCount(bC1);
        user1.addCount(bC2);
        users.add(user1);
        Scanner sc = new Scanner(System.in);
        CashMachine cashMachine = new CashMachine("MyBank");
        while(1 == 1){
            System.out.println("1. Создать пользователя.");
            System.out.println("2. Создать счёт.");
            System.out.println("3. Узнать счёт.");
            System.out.println("4. Пополнить счёт.");
            System.out.println("5. Снять деньги с счёта.");
            System.out.println("6. Перевести на другой счёт.");
            System.out.print("Введите команду: ");
            switch (sc.nextInt()){
                case 1: {
                    User newUser = new User();
                    newUser.insertData();
                    boolean notExist = true;
                    for(int i = 0; i < users.size(); i++){
                        if( users.get(i).getName().equals(newUser.getName()) && users.get(i).getSurname().equals(newUser.getSurname())){
                            notExist = false;
                            System.out.println("Такой пользователь уже существует.");
                            break;
                        }
                    }
                    if(!notExist)
                        break;
                    System.out.print("Задайте pin: ");
                    String pin = sc.next();
                    try{
                        int tmp = Integer.parseInt(pin);
                        if(tmp > 9999 || tmp < 0)
                            tmp += Integer.parseInt("ierhvuie");
                    } catch (Throwable s){
                        System.out.println("Пин должен состоять из 4 цифр.");
                        break;
                    }
                    newUser.setPin(pin);
                    newUser.setId(users.size());
                    users.add(newUser);
                    System.out.println("Пользователь успешно создан.");
                    break;
                }
                case 2:{
                    System.out.print("Введите Ваше имя: ");
                    String name = sc.next();
                    System.out.print("Введите Вашу фамилию: ");
                    String surname = sc.next();
                    int i = 0;
                    for(; i < users.size(); i++)
                        if(users.get(i).getName().equals(name) && users.get(i).getSurname().equals(surname)){
                            break;
                        }
                    if(i == users.size()){
                        System.out.println("Проверьте правильность заполнения полей.");
                        break;
                    }

                    BankCount newBankCount = new BankCount();
                    newBankCount.insertData();
                    newBankCount.setUser(users.get(i));
                    users.get(i).addCount(newBankCount);
                    System.out.println("Счёт успешно создан!");
                    break;
                }
                // Узнать счёт
                case 3:{
                    System.out.print("Введите номер вашего счёта: ");
                    String num = sc.next();
                    boolean finded = false;
                    BankCount bankCount = new BankCount();
                    // Поиск счёта
                    for(int i = 0; i < users.size(); i++){
                        for(int j = 0; j < users.get(i).getCountSize(); j++){
                            if(users.get(i).getBankCounts().get(j).getNumber().equals(num)) {
                                bankCount = users.get(i).getBankCounts().get(j);
                                finded = true;
                                break;
                            }
                        }
                        if(finded)
                            break;
                    }
                    if(!finded) {
                        System.out.println("Произошла неизвестная ошибка.");
                        break;
                    }
                    cashMachine.getBalance(bankCount);
                    break;
                }
                // Пополнить счёт
                case 4:{
                    System.out.print("Введите номер вашего счёта: ");
                    String num = sc.next();
                    boolean finded = false;
                    BankCount bankCount = new BankCount();
                    // Поиск счёта
                    for(int i = 0; i < users.size(); i++){
                        for(int j = 0; j < users.get(i).getCountSize(); j++){
                            if(users.get(i).getBankCounts().get(j).getNumber().equals(num)) {
                                bankCount = users.get(i).getBankCounts().get(j);
                                finded = true;
                                break;
                            }
                        }
                        if(finded)
                            break;
                    }
                    if(!finded) {
                        System.out.println("Произошла неизвестная ошибка.");
                        break;
                    }
                    System.out.print("Внесите сумму: ");
                    cashMachine.addCount(bankCount, sc.nextFloat());
                    break;
                }
                // Снятие
                case 5:{
                    System.out.print("Введите номер вашего счёта: ");
                    String num = sc.next();
                    boolean finded = false;
                    BankCount bankCount = new BankCount();
                    // Поиск счёта
                    for(int i = 0; i < users.size(); i++){
                        for(int j = 0; j < users.get(i).getCountSize(); j++){
                            if(users.get(i).getBankCounts().get(j).getNumber().equals(num)) {
                                bankCount = users.get(i).getBankCounts().get(j);
                                finded = true;
                                break;
                            }
                        }
                        if(finded)
                            break;
                    }
                    if(!finded) {
                        System.out.println("Произошла неизвестная ошибка.");
                        break;
                    }
                    System.out.print("Введите снимаемую сумму: ");
                    cashMachine.takeMoney(bankCount, sc.nextFloat());
                    break;
                }
                // Перевод
                case 6:{
                    // Поиск начального счёта
                    System.out.print("Введите номер вашего счёта: ");
                    String num = sc.next();
                    boolean finded = false;
                    BankCount bankCount = new BankCount();
                    // Поиск счёта
                    for(int i = 0; i < users.size(); i++){
                        for(int j = 0; j < users.get(i).getCountSize(); j++){
                            if(users.get(i).getBankCounts().get(j).getNumber().equals(num)) {
                                bankCount = users.get(i).getBankCounts().get(j);
                                finded = true;
                                break;
                            }
                        }
                        if(finded)
                            break;
                    }
                    if(!finded) {
                        System.out.println("Произошла неизвестная ошибка.");
                        break;
                    }

                    System.out.print("Введите номер счёта для перевода: ");
                    String num2 = sc.next();
                    finded = false;
                    BankCount bankCount2 = new BankCount();
                    // Поиск счёта
                    for(int i = 0; i < users.size(); i++){
                        for(int j = 0; j < users.get(i).getCountSize(); j++){
                            if(users.get(i).getBankCounts().get(j).getNumber().equals(num2)) {
                                bankCount2 = users.get(i).getBankCounts().get(j);
                                finded = true;
                                break;
                            }
                        }
                        if(finded)
                            break;
                    }
                    if(!finded) {
                        System.out.println("Вы не можете перевести на этот счёт так как он не существует!");
                        break;
                    }
                    if(bankCount == bankCount2){
                        System.out.println("Вы не можете перевести на тот же самый счёт.");
                        break;
                    }
                    System.out.print("Введите переводимую сумму: ");
                    cashMachine.transferToCount(bankCount, bankCount2, sc.nextFloat());
                    break;
                }
                default:
                    return;
            }
        }
    }
}