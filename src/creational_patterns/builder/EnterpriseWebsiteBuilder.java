package creational_patterns.builder;

public class EnterpriseWebsiteBuilder extends WebsiteBuilder {

    @Override
    void buildName() {
        website.setName("Enterprise");
    }

    @Override
    void buildPrice() {
        website.setPrice(10000);
    }

    @Override
    void buildCms() {
        website.setCms(CMS.ALIFRESCO);
    }
}
