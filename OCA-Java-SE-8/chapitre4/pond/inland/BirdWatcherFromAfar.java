package pond.inland;

import pond.shore.Bird; // different package than Bird

public class BirdWatcherFromAfar {  // does not inherit from Bird
  public void watchBird() {
    Bird = new Bird();
    bird.floatInWater();           // DOES NOT COMPILE : protected
    System.out.println(bird.text); // DOES NOT COMPILe : protected member
}