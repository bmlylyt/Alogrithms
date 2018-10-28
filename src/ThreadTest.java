public class ThreadTest {
   public static void main(String[] args) {
      Thread t = new Thread() {
         @Override
         public void run() {
            try {
               for (int i = 0; i < 100; i++) {
                  System.out.println(i);
                  if (this.isInterrupted()) {
                     throw new InterruptedException();
                  }
               }
            } catch(InterruptedException e) {
               return;
            }
         }
      };
      t.start();
      t.interrupt();
   }
}
