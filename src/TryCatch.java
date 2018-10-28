public class TryCatch {
      public static void testTryCatch() {
         try {
            int i = 10/0;
         } catch (Exception e) {
            System.out.println("+++++++++");
         }

         System.out.println("--------");
      }
      public static void main(String[] args) {
         System.out.println('c' - 'a');
      }
}
