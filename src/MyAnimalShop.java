import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MyAnimalShop implements AnimalShop{
    public double money = 20000;
    public boolean isopen = true;
    Chinesedoge dog = new Chinesedoge();
    cats cat = new cats();
    dinosaur dinosaur = new dinosaur();


    public MyAnimalShop(){
        this.dog.isVaccineInjected=true;
        this.dog.age=3;
        this.dog.price=150;
        this.dog.type="我是猫";
        this.dog.sex='M';
        this.cat.type="汪汪汪";
        this.cat.age=2;
        this.cat.sex='F';
        this.cat.price = 300;
        this.dinosaur.type="代号穿山甲";
        this.dinosaur.age=80;
        this.dinosaur.sex='M';
        this.dinosaur.price = 11086;//这些是镇店之宝，不卖
    }
    public ArrayList<String> AnimalList = new ArrayList<>();
    public ArrayList<String> CustomerList = new ArrayList<>();
    Customer C = new Customer();

    @Override
    public void In() throws InsufficientBalanceException {
        Scanner scanf = new Scanner(System.in);
        System.out.println("当前资金：" + this.money);
        while (this.money >= 0) {
            System.out.println("请输入想要购买的动物种类(Chinesedog/cat/dinosaur)：");
            String buyin = scanf.next();

            switch (buyin) {
                case "Chinesedog":
                    if (this.money >= 100) {
                        this.money -= 100;
                        this.AnimalList.add("Chinesedog");
                    } else {
                        throw new InsufficientBalanceException();
                    }
                    break;
                case "cat":
                    if (this.money >= 200) {
                        this.money -= 200;
                        this.AnimalList.add("cat");
                    } else {
                        throw new InsufficientBalanceException();
                    }
                    break;
                case "dinosaur":
                    if (this.money >= 10086) {
                        this.money -= 10086;
                        this.AnimalList.add("dinosaur");
                    } else {
                        throw new InsufficientBalanceException();
                    }
                    break;
                default:
                    System.out.println("买不到");
                    break;
            }
            System.out.println("当前余额为："+this.money);
            System.out.println("继续购买请扣1");
            if(!scanf.next().equals("1")){
                break;
            }
        }


        if (this.money<=0){
            System.out.println("余额不足");
        }
        System.out.println(this.AnimalList);

    }

    @Override
    public void ForCustomer() {
        Scanner scanf = new Scanner(System.in);
        System.out.println("顾客姓名：");
        String temp = scanf.next();
        this.CustomerList.add(temp);
        C.setName(temp);
        C.setTimes(C.getTimes()+1);
        C.setClock(LocalDate.now());
        System.out.println("需要购买的动物：");
        String forsale=scanf.next();
        switch (forsale) {
            case "Chinesedog":
                boolean flag = false;
                for(int i=0;i<AnimalList.size();i++)
                {
                    if(AnimalList.get(i).equals("Chinesedog")){
                        this.AnimalList.remove("Chinesedog");
                        this.money+=150;
                        flag = true;
                    }
                }
                if(!flag) {
                    System.out.println("没有");
                    throw new AnimalNotFoundException();
                }
                break;
            case "cat":
                boolean flag1 = false;
                for(int i=0;i<AnimalList.size();i++)
                {
                    if(AnimalList.get(i).equals("cat")){
                        this.AnimalList.remove("cat");
                        this.money+=300;
                        flag1 = true;
                    }
                }
                if(!flag1) {
                    System.out.println("没有");
                    throw new AnimalNotFoundException();
                }
                break;
            case "dinosaur":
                boolean flag2 = false;
                for(int i=0;i<AnimalList.size();i++)
                {
                    if(AnimalList.get(i).equals("dinosaur")){
                        this.AnimalList.remove("dinosaur");
                        this.money+=11086;
                        flag2 = true;
                    }
                }
                if(!flag2) {
                    System.out.println("没有");
                    throw new AnimalNotFoundException();
                }
                break;
            default:
                System.out.println("不卖");
                break;
        }
        System.out.println("当前余额："+this.money+"剩余动物"+this.AnimalList);
        System.out.println("是否继续营业？（true/false）");
        isopen = scanf.nextBoolean();
        while (isopen){
            System.out.println("顾客姓名：");
            String temp1 = scanf.next();
            this.CustomerList.add(temp1);
            System.out.println("需要购买的动物：");
            String forsale1=scanf.next();
            switch (forsale1) {
                case "Chinesedog":
                    boolean flag9 = false;
                    for(int i=0;i<AnimalList.size();i++)
                    {
                        if(AnimalList.get(i).equals("Chinesedog")){
                            this.AnimalList.remove("Chinesedog");
                            this.money+=150;
                            flag9 = true;
                        }
                    }
                    if(!flag9) {
                        System.out.println("没有");
                        throw new AnimalNotFoundException();

                    }

                    break;
                case "cat":
                    boolean flag8 = false;
                    for(int i=0;i<AnimalList.size();i++)
                    {
                        if(AnimalList.get(i).equals("cat")){
                            this.AnimalList.remove("cat");
                            this.money+=300;
                            flag8 = true;
                        }
                    }
                    if(!flag8) {
                        System.out.println("没有");
                        throw new AnimalNotFoundException();
                    }
                    break;
                case "dinosaur":
                    boolean flag7 = false;
                    for(int i=0;i<AnimalList.size();i++)
                    {
                        if(AnimalList.get(i).equals("dinosaur")){
                            this.AnimalList.remove("dinosaur");
                            this.money+=11086;
                            flag7 = true;
                        }
                    }
                    if(!flag7) {
                        System.out.println("没有");
                        throw new AnimalNotFoundException();
                    }
                    break;
                default:
                    System.out.println("不卖");
                    break;
            }
            System.out.println("当前余额："+this.money+"剩余动物"+this.AnimalList);
            System.out.println("是否继续营业？（true/false）");
            isopen = scanf.nextBoolean();
        }



    }

    @Override
    public void close() {
        double getmoney = this.money-20000;
        System.out.println("今日顾客："+CustomerList);
        System.out.println("其中第一位顾客："+C);
        System.out.println("今日收益"+getmoney);
        System.out.println("店铺已打烊");
    }

}
