public class NumberValue {

    //int i = _1_1_1;  // DOES NOT COMPILE : cannot find symbol (_ au début indique un identifiant de variable)
    //int j = 1_1_1_;  // DOES NOT COMPILE : illegal underscore
    int k = 1_1_1;

    long l = 111_111_111;

    //double d = 11_.1_;  // DOES NOT COMPILE : illegal underscore (à la fin et avant le point)
    //double e = 1_1._1;  // DOES NOT COMPILE : illegal underscore (au début après le point)
    //double f = 1_1.1_;  // DOES NOT COMPILE : illegal underscore (à la fin)
    double g = 1_1.1_1;

    public void print() {
        StringBuilder sb = new StringBuilder("");
        sb.append(k).append(" ").append(l).append(" ").append(g);
        System.out.println(sb.toString());
    }

    public static void main(String... args) {
        new NumberValue().print();
    }
}
