package net.school;

public class Person {
   private String firstName;
   private String lastName;
   private String email;
   
   public Person() {}
   
   public Person(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }
   
   
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }
   
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }
   
   public void setEmail(String email) {
      this.email = email;
   }
   
   public String getFirstName() {
      return firstName;
   }
   
   public String getLastName() {
      return lastName;
   }
   
   public String getEmail() {
      return email;
   }
   
   @Override
   public String toString() {
      return "Person{" +
              "firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              '}';
   }
   
   public void talk() {
      System.out.println("Person speaking...");
   }
}

