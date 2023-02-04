package classJava;

public class Player {
    private static final int DEFAULT_MINIMUM_BASE_CASH = 10000;
    private static final int DEFAULT_MAXIMUM_BASE_CASH = 50000;
    public static Integer cash;
    public static Integer baseCash;
    public static Integer round;
    public Player(Integer cash,
                  Integer baseCash,
                  Integer round){
        this.cash=cash;
        this.baseCash=baseCash;
        this.round=round;
    }
    public static void setBaseCash(){
        baseCash=Car.randomNumber(DEFAULT_MINIMUM_BASE_CASH,DEFAULT_MAXIMUM_BASE_CASH);
        cash=baseCash;
        round=0;
    }
    public static Boolean isWin(){
        if(cash>baseCash*2){
            return true;
        } else {
            return false;
        }
    }
}
