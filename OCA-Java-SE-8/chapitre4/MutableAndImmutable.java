
public class MutableAndImmutable {

  public static void main(String... args) {
    
    /*
     * working with not immutable class
     */
    StringBuilder sb = new StringBuilder("initial");
    NotImmutable problem = new NotImmutable(sb);
    sb.append(" / added from sb");
    StringBuilder gotBuilder = problem.getBuilder();
    gotBuilder.append(" / added from gotBuilder");
    System.out.println("not immutable : " + problem.getBuilder());
    
    /*
     * working with immutable class
     */
    StringBuilder sb2 = new StringBuilder("initial");
    CorrectedNotImmutable immute = new CorrectedNotImmutable(sb2);
    sb2.append(" / added from sb2");
    StringBuilder gotBuilder2 = immute.getBuilder();
    gotBuilder2.append(" / added from gotBuilder");
    System.out.println("immutable : " + immute.getBuilder());
  }
}


public class Immutable {

  /* No setter,
   * Only getters
   * Initial value set in the constructor
   */

  private int property;
  
  public Immutable(int p) {
    this.property = p;
  }
  
  public int getProperty() {
    return property;
  }
}

public class NotImmutable {

  private StringBuilder builder;
  
  public NotImmutable(StringBuilder b) {
    builder = b;
  }
  
  public StringBuilder getBuilder() {
    return builder;
  }
} 

public class CorrectedNotImmutable {

  private StringBuilder builder;
  
  public CorrectedNotImmutable(StringBuilder b) {
    builder = new StringBuilder(b); // make a copy of the mutable object
  }
  
  public StringBuilder getBuilder() {
    return new StringBuilder(builder); // make a copy of the mutable object
  }
}