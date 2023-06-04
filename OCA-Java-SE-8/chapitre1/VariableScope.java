package chapitre1;

public class VariableScope {

  public void eatIfHungry(boolean hungry) {
    if (hungry) {
      int bitesOfCheese = 1;
      {
        boolean teenyBit = true;
        System.out.println(bitesOfCheese);
      }
      System.out.println(teenyBit);
    }
    System.out.println(bitesOfCheese); // DO NOT COMPILE : out of scope
  }
}
