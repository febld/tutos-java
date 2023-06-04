public class TestGarbageCollector {

    public void play() {
        System.out.println("play-");
    }
    public void finalize() {
        System.out.println("clean-");
    }
    public static void main(String... args) {
        TestGarbageCollector t1 = new TestGarbageCollector();
        t1.play();

        System.gc();

        TestGarbageCollector t2 = new TestGarbageCollector();
        t2.play();
    }
}
