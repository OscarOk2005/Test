public interface ICashMachine {
    void getBalance(BankCount bankCount);
    void addCount(BankCount bankCount, float sum);
    void takeMoney(BankCount bankCount, float sum);
    void transferToCount(BankCount bankCount, BankCount bankCount2, float sum);
}
