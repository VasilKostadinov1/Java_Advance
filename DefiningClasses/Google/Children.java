package DefiningClasses.Google;

public class Children {
    private final String name;
    private final String birthday;

    public Children(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }
    //SaraJohnson 13/03/1933
    public String format(){
        return String.format("%s %s",name,birthday);
    }
}
