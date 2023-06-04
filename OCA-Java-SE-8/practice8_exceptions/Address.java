
public class Address {
    public String getAddress(String street, String city) {
        try {
            return street.toString() + " : " + city.toString();
        }
        finally {
            System.out.print("Posted:");
        }
    }
    public static void main(String... args) {
        //String street = null;
        //String city = null;
        String street = "rue du centre";
        String city = "ouagadoudou";
        System.out.print(new Address().getAddress(street,city));
    }
}
