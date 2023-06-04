public class MultipleDimensionArray {

    public static final void main(String ... args) {
        String[][] matrix = new String[1][2];
        matrix[0][0] = "value00";
        matrix[0][1] = "value01";
        //matrix[1][0] = "value10";  // ArrayIndexOutOfBoundsException
        //matrix[1][1] = "value11";    // ArrayIndexOutOfBoundsException
    }
}
