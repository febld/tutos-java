
public class UnitializedArray {

    static int[][] game;

    public static void main(String ... args) {
        game[3][3] = 6;          // 2nd : if 1st compile error is commented, NullPointerException is thrown at runtime
        Object[] obj = game;
        obj[3]  = "X";           // 3rd : Null Pointer exception at runtime
        game[3][3] = "X";        // 1st : DOES NOT COMPILE : String cannot be converte to int
        System.out.println(game[3][3]);
    }
}
