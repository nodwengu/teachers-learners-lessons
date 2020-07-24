package net.school.mapinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
   public static void main(String[] args) {
      Map<String, Integer> numbers = new HashMap<String, Integer>();
      
      numbers.put("a", new Integer(100));
      numbers.put("b", new Integer(200));
      numbers.put("c", new Integer(300));
      numbers.put("d", new Integer(400));
      numbers.put("e", new Integer(500));
      
      // Returns set view
      Set<Map.Entry<String, Integer> > set = numbers.entrySet();
      
      for (Map.Entry<String, Integer> item: set) {
         System.out.print(item.getKey() + ": ");
         System.out.println(item.getValue());
      }
      
      // Initial map
      System.out.println(numbers);
      
      numbers.put("a", 1000);
      numbers.remove("b");
      
      // Updated map
      System.out.println(numbers);
      
      
      
      
      
   }
}
