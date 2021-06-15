package net.school.model;

public class Person {
   private Long id;
   private String firstName;
   private String lastName;
   private String email;
   private int tokens;
   
   public Person() {}
   
   public Person(Long id, String firstName, String lastName, String email, int tokens) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.tokens = tokens;
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

   public void setTokens(int tokens) {
      this.tokens = tokens;
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

   public int getTokens() {
      return tokens;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Long getId() {
      return id;
   }

   @Override
   public String toString() {
      return "Person{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              ", tokens=" + tokens +
              '}';
   }
}

