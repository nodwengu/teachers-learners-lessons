package net.school.mapinterface;

import java.util.Map;

interface Notes {
   void addNotes(Map<String, String> notes);
}

public class InterfaceTest implements Notes {
   public static void main(String[] args) {
   
   }
   
   @Override
   public void addNotes(Map<String, String> notes) {
      notes.put("dsdsd", "sads");
   }
}
