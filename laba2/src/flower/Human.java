package flower;

public class Human {
    private String name;


    public Human() {}

    public Human(String name) {
        this.name = name;

    }
    public Flower plain(int height){
        return new Flower(height);

    }
    public  Bud pour(Flower flower, String
                     smell){
      return  flower.makeBud(smell);
    }
    public String smell(Bud bud){
      return bud.getSmell();
    }

}
