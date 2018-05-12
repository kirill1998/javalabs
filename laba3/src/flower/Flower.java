package flower;

abstract public class Flower {
    protected int height;

    public Flower(int height){
        this.height=height;
    }

    protected int getHeight() {
        return this.height;
    }
    protected Leaf makeLeaf(int length){

        return new Leaf( length);

    }
    protected Petal makeBud(Bud bud,  String smell, String color){
           bud = new Bud(smell);
           bud.setSmell(smell);

          return  bud.makePetal( color);



    }
    public int increaseHeight(){
        this.height+=5;
        return this.height;
    }
    public void wither(Leaf leaf){ //засохнуть
   leaf=null;
    }

}
