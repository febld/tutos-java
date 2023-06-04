public class Casting {

    public static void main(String... args) {

        byte a = 40, b = 50;

        //byte sum = (byte) a + b ;  // DOES NOT COMPILE : incompatible type: possible lossy conversion from int to byte.
                                     //  --> 'cast' operator has higher precedence than '+' operator so is evaluated first.

        byte sum = (byte) (a + b) ;  

        System.out.println("sum=" + sum);
        
    }
}
