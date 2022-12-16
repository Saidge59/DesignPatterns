package creational_patterns.builder;

public class Website {
    private String name;
    private int price;
    private CMS cms;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCms(CMS cms) {
        this.cms = cms;
    }

    @Override
    public String toString() {
        return "Website{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", cms=" + cms +
                '}';
    }
}
