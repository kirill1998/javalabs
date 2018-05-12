package flower;

public class Bud {
    public String smell;
    public Bud(String smell){
        this.smell=smell;


    }
    public void setSmell(String smell){
        this.smell=smell;
    }
    public Petal  makePetal(String color){

        return  new Petal(color);

    }
    public void dumpPetals(){

    }

}
