import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import src.tests.HomeWork2Test;

public class TestRunner {
   public static void main(String[] args) {
      Result result = JUnitCore.runClasses(HomeWork2Test.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }

      System.out.println(result.wasSuccessful());
   }
}
