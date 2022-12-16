package creational_patterns.builder;

public abstract class WebsiteBuilder {
    protected Website website;

    public Website getWebsite() {
        return website;
    }

    abstract void buildName();
    abstract void buildPrice();
    abstract void buildCms();

    public void createWebsite() {
        website = new Website();
    }
}
