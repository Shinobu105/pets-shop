public class Main {
    public static void main(String[] args) throws InsufficientBalanceException {
        new Chinesedoge();
        new cats();
        new dinosaur();
        MyAnimalShop MAS=new MyAnimalShop();
        MAS.In();
        MAS.ForCustomer();
        MAS.close();

    }
}
/*
这次作业其实存在着很多问题没有解决，
其实我本来是打算通过循环来实现多个顾客多次购买的，但是我不知道怎么在循环中new出不同的customer并且能运用于其他的方法中
又因为已经到ddl了所以只能放弃。。（之前是连续的考试，没来得及研究）
正因这个暂时没有解决的问题我不能在商店购入时利用各个动物的类来输入动物的状态，使得整个程序在实际运用时是割裂的，没有实际意义
（感觉有蚂蚁在爬
还有一点就是如何合理的抛出异常，怎么明确指出问题出在哪里
 */