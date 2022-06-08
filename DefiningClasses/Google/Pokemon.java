package DefiningClasses.Google;

public class Pokemon {

    private final String name;
    private final String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }
    //Onyx Rock
    public String format(){
        return String.format("%s %s",name,type);
    }

}
