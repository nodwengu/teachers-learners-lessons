package net.school;

import java.util.ArrayList;

public class Cafeteria {
   private Products product;
   private int totalDailyTokens;
   private ArrayList sales = new ArrayList();
   
   public void sellBreakFast(Person person) {
      if (person instanceof Teacher) {
         Teacher teacher = (Teacher) person;
         if (teacher.getTokens() < 4){
            System.out.println(teacher.getEmail() + " does NOT have enough tokens to buy");
            return;
         }
         product = Products.BREAKFAST;
         teacher.buyBreakfast();
         this.totalDailyTokens += 4;
         sales.add(product + " by " + person.getFirstName());
         
      } else if (person instanceof Learner){
         Learner learner = (Learner) person;
         if (learner.getTokens() < 4){
            System.out.println(learner.getEmail() + " does NOT have enough tokens");
            return;
         }
         product = Products.BREAKFAST;
         learner.buyBreakfast();
         this.totalDailyTokens += 4;
         sales.add(product + " by " + person.getFirstName());
      }
   }
   
   public void sellAfternoonSnack(Person person) {
      if (person instanceof Teacher) {
         Teacher teacher = (Teacher)person;
         if (teacher.getTokens() < 3) {
            System.out.println(teacher.getEmail() + " does NOT have enough tokens");
            return;
         }
         product = Products.AFTERNOONSNACK;
         teacher.buyAfternoonSnack();
         this.totalDailyTokens += 3;
         sales.add(product + " by " + person.getFirstName());
         
      } else if (person instanceof Learner){
         Learner learner = ( (Learner) person );
         if (learner.getTokens() < 3) {
            System.out.println(learner.getEmail() + " does NOT have enough tokens");
            return;
         }
         product = Products.AFTERNOONSNACK;
         learner.buyAfternoonSnack();
         this.totalDailyTokens += 3;
         sales.add(product + " by " + person.getFirstName());
      }
   }
   
   public void sellLunch(Person person) {
      if (person instanceof Teacher) {
         Teacher teacher = ( (Teacher)person );
         if (teacher.getTokens() < 6) {
            System.out.println(teacher.getEmail() + " does NOT have enough tokens");
            return;
         }
         product = Products.LUNCH;
         teacher.buyLunch();
         this.totalDailyTokens += 6;
         sales.add(product + " by " + person.getFirstName());
         
      } else if (person instanceof Learner){
         Learner learner = ( (Learner) person );
         if (learner.getTokens() < 6) {
            System.out.println(learner.getEmail() + " does NOT have enough tokens");
            return;
         }
         product = Products.LUNCH;
         learner.buyLunch();
         this.totalDailyTokens += 6;
         sales.add(product + " by " + person.getFirstName());
      }
   }
   
   public void sellDrink(Person person) {
      if (person instanceof Teacher) {
         Teacher teacher = (Teacher)person;
         if (teacher.getTokens() < 2) {
            System.out.println(teacher.getEmail() + " does NOT have enough tokens");
            return;
         }
         product = Products.DRINK;
         teacher.buyDrink();
         this.totalDailyTokens += 2;
         sales.add(product + " by " + person.getFirstName());
        
      } else if (person instanceof Learner){
         Learner learner = ( (Learner) person );
         if (learner.getTokens() < 2){
            System.out.println(learner.getEmail() + " does NOT have enough tokens to buy");
            return;
         }
         product = Products.DRINK;
         learner.buyDrink();
         this.totalDailyTokens += 2;
         sales.add(product + " by " + person.getFirstName());
      }
   }
   
   public int getTotalDailyTokens() {
      return this.totalDailyTokens;
   }
   
   public ArrayList getSales() {
      return sales;
   }
   
   public void showSales() {
      if (sales != null) {
         for (int x = 0; x < sales.size(); x++) {
            System.out.println("Sale: " + x + " " + sales.get(x));
         }
      }
   }
   
   public Products getProduct() {
      return product;
   }
}
