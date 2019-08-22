public class Country {
    private String code;
    private String name;
    private int populace;

    public Country() {
    }

    public Country(String code, String name, int populace) {
        this.code = code;
        this.name = name;
        this.populace = populace;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulace() {
        return populace;
    }

    public void setPopulace(int populace) {
        this.populace = populace;
    }

    @Override
    public String toString() {
        return name + " (" + code + ") ma " + populace + " ludności.";
    }
}
