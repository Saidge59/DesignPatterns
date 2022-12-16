package creational_patterns.abstract_factory;

public class AddressFactoryApp {
    public static void main(String[] args) {
        System.out.println ("Example for the Abstract Factory pattern");
        System.out.println ();
        System.out.println(" (take a look in the RunPattern code. Notice that you can");
        System.out.println(" use the Address and PhoneNumber classes when writing");
        System.out.println(" almost all of the code. This allows you to write a very");
        System.out.println(" generic framework, and plug in Concrete Factories");
        System.out.println(" and Products to specialize the behavior of your code)");
        System.out.println();

        System.out.println("Creating U.S. Address and Phone Number:");
        AddressFactory USAddressFactory = new USAddressFactory();
        Address usAddress = USAddressFactory.createAddress();
        PhoneNumber usPhone = USAddressFactory.createPhoneNumber();

        usAddress.setStreet("142 Lois Lane");
        usAddress.setCity("Metropolis");
        usAddress.setRegion("WY");
        usAddress.setPostalCode("54321");
        usPhone.setPhoneNumber("7039214722");

        System.out.println("U.S. address:");
        System.out.println(usAddress.getFullAddress()) ;
        System.out.println("U.S. phone number:");
        System.out.println(usPhone.getPhoneNumber()) ;
        System.out.println();
        System.out.println();

        System.out.println("Creating French Address and Phone Number:");
        AddressFactory frenchAddressFactory = new FrenchAddressFactory();
        Address frenchAddress = frenchAddressFactory.createAddress();
        PhoneNumber frenchPhone = frenchAddressFactory.createPhoneNumber();

        frenchAddress.setStreet("21 Rue Victor Hugo");
        frenchAddress.setCity("Courbevoie");
        frenchAddress.setPostalCode("40792");
        frenchPhone.setPhoneNumber("011324290");

        System.out.println("French address:");
        System.out.println(frenchAddress.getFullAddress());
        System.out.println("French phone number:");
        System.out.println(frenchPhone.getPhoneNumber());
    }
}


// ========= abstract factory =========
interface AddressFactory {
    Address createAddress();
    PhoneNumber createPhoneNumber();
}

// ========= abstract factory =========


// ========= concrete factory =========
class USAddressFactory implements AddressFactory{
    public Address createAddress() { return new USAddress(); }
    public PhoneNumber createPhoneNumber() { return new USPhoneNumber(); }
}

class FrenchAddressFactory implements AddressFactory{
    public Address createAddress() { return new FrenchAddress(); }
    public PhoneNumber createPhoneNumber() { return new FrenchPhoneNumber(); }
}
// ========= concrete factory =========


// ========= abstract product =========
abstract class Address{
    private String street;
    private String city;
    private String region;
    private String postalCode;

    public static final String EOL_STRING = System.getProperty("line.separator");
    public static final String SPACE = " ";

    public String getStreet(){ return street; }
    public String getCity(){ return city; }
    public String getPostalCode(){ return postalCode; }
    public String getRegion(){ return region; }
    public abstract String getCountry();

    public String getFullAddress() {
        return street + EOL_STRING + city + SPACE + postalCode + EOL_STRING;
    }

    public void setStreet(String newStreet){ street = newStreet; }
    public void setCity(String newCity){ city = newCity; }
    public void setRegion(String newRegion){ region = newRegion; }
    public void setPostalCode(String newPostalCode) { postalCode = newPostalCode; }
}

abstract class PhoneNumber{
    private String phoneNumber;
    public abstract String getCountryCode();

    public String getPhoneNumber(){ return phoneNumber; }

    public void setPhoneNumber(String newNumber){

        try{
            Long.parseLong(newNumber);
            phoneNumber = newNumber;
        } catch (NumberFormatException exc){
            System.out.println(exc);
        }
    }
}
// ========= abstract product =========


// ========= concrete product address =========
class USAddress extends Address {
    private static final String COUNTRY = "UNITED STATES";
    private static final String COMMA = ",";

    public String getCountry() {
        return COUNTRY;
    }

    public String getFullAddress() {
        return getStreet() + EOL_STRING +
                getCity() + COMMA + SPACE + getRegion() +
                SPACE + getPostalCode() + EOL_STRING +
                COUNTRY + EOL_STRING;
    }
}

class FrenchAddress extends Address{
    private static final String COUNTRY = "FRANCE";

    public String getCountry() { return COUNTRY; }

    public String getFullAddress(){
        return getStreet() + EOL_STRING +
                getPostalCode() + SPACE + getCity() +
                EOL_STRING + COUNTRY + EOL_STRING;
    }
}
// ========= concrete product address =========


// ========= concrete product phone number =========
class USPhoneNumber extends PhoneNumber{
    private static final String COUNTRY_CODE = "01";
    private static final int NUMBER_LENGTH = 10;

    public String getCountryCode(){ return COUNTRY_CODE; }

    public void setPhoneNumber(String newNumber){
        if (newNumber.length() == NUMBER_LENGTH) {
            super.setPhoneNumber(newNumber);
        }
    }
}

class FrenchPhoneNumber extends PhoneNumber{
    private static final String COUNTRY_CODE = "33";
    private static final int NUMBER_LENGTH = 9;

    public String getCountryCode(){ return COUNTRY_CODE; }

    public void setPhoneNumber(String newNumber){
        if (newNumber.length() == NUMBER_LENGTH) {
            super.setPhoneNumber(newNumber);
        }
    }
}
// ========= concrete product phone number =========