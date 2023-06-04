public class Switch1 {

    public static void main(String... args) {
        int test = 30;
        int index = 0;
        switch(test) {
           case 30: index++;
           case 40: index+=2;
           default: index+=3;
        }
        System.out.println(index);
    }
}
