package creational_patterns.builder;

public class VisitCardWebsiteBuilder extends WebsiteBuilder{

    @Override
    void buildName() {
        website.setName("VisitCard");
    }

    @Override
    void buildPrice() {
        website.setPrice(500);
    }

    @Override
    void buildCms() {
        website.setCms(CMS.WORDPRESS);
    }
}
