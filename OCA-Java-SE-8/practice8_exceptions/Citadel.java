class CastleUnderSiegeException extends Exception {}
class KnightAttackingException extends CastleUnderSiegeException {}
public class Citadel {
  public void openDrawbridge() throws RuntimeException {
    try {
      throw new KnightAttackingException();
    }
    catch (Exception e) {
      throw new ClassCastException();
      //throw new KnightAttackingException(); //DOES NOT COMPILE : MUST BE CAUGHT or DECLARED TO BE THROWN
    }
    finally {
      //throw new CastleUnderSiegeException(); //DOES NOT COMPILE : MUST BE CAUGHT or DECLARED TO BE THROWN
    }
  }
  public void openDrawbridgeDontDeclareThrow() {
    try {
      throw new KnightAttackingException();
    }
    catch (Exception e) {
      throw new ClassCastException();
    }
  }
  public static void main(String... args) {
    new Citadel().openDrawbridge();
    new Citadel().openDrawbridgeDontDeclareThrow();
  }
}
