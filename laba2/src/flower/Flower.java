package flower;

public class Flower {
    private int height;
    public Flower(int height){
        this.height=height;
    }

    public int getHeight() {
        return this.height;
    }
    public Bud makeBud(String smell){

        return new Bud(smell);
    }

}
