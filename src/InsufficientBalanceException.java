public class InsufficientBalanceException extends RuntimeException{
    public String toString(){
        return "InsufficientBalanceException"+"余额不足";
    }
}
