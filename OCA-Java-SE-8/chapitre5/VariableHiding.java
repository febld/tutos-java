/*
 * Hiding variables
 * Java variables cannot be overridden but instead hidden
 */

class Rodent {
   protected int tailLength = 4;
   public void getRodentDetails() {
   	 System.out.println("[parentTail=" + tailLength + "]");
   }
}

public class VariableHiding extends Rodent {
  protected int tailLength = 8;
  public void getMouseDetails() {
  	System.out.println("[tail=" + tailLength + ", parentTail=" + super.tailLength + "]");
  }

  public static void main(String... args) {
  	VariableHiding vh = new VariableHiding();
  	vh.getRodentDetails();
  	vh.getMouseDetails();

  	Rodent r = new VariableHiding();
  	System.out.println("rodent tail = " + r.tailLength);
  }

 }