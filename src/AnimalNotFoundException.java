public class AnimalNotFoundException extends RuntimeException{
    public String toString(){
        return "AnimalNotFoundException"+"库存不足";
    }
}
