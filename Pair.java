public class Pair<String, Integer> {
    private String value1;
    private Integer value2;

    public void setValue2(Integer value2) {
        this.value2 = value2;
    }

    public String getValue1() {
        return this.value1;
    }

    public Integer getValue2() {
        return this.value2;
    }

    public Pair(String value1, Integer value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
}
