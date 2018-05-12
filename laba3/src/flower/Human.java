package flower;

public class Human {
    private String name;


    public Human() {}

    public Human(String name) {
        this.name = name;

    }
    public Rose plain(int height){
        return new Rose(height);

    }
    public  Petal pour(Bud bud,Leaf leaf,Rose rose, String smell, int length, String color ){
        leaf=rose.makeLeaf(length);
        return  rose.makeBud(bud ,smell, color);

    }
    public String smell(Bud bud){
      return "aroma";
    }

}
