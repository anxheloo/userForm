//package io.bootify.spring_boot_arlindiii.util;
//
//import io.bootify.spring_boot_arlindiii.form_model.FormModel;
//import io.bootify.spring_boot_arlindiii.role.Role;
//import io.bootify.spring_boot_arlindiii.user.User;
//
//import java.time.OffsetDateTime;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Set;
//
//public class prova213 {
//
//    public static void main(String[] args)
//    {
//        //            Create Roles to test  the app
//        Role role1 = new Role(Long.valueOf(1),"User");
//        role1.setDateCreated(OffsetDateTime.now());
//
//        Role role2 = new Role(Long.valueOf(2),"Admin");
//        role2.setDateCreated(OffsetDateTime.now());
//
//
////            Create Admin role to test the app
//        User admin = new User(Long.valueOf(1),"Nixhi","Nixhi","nixhi@gmail.com", "nixhi123", Arrays.asList(role2));
//        admin.setDateCreated(OffsetDateTime.now());
//
//        User user = new User(Long.valueOf(2),"Noel","Ceno","noel@gmail.com", "noel123", Arrays.asList(role1));
//        user.setDateCreated(OffsetDateTime.now());
//
//        FormModel form1 = new FormModel(Long.valueOf(1),"Whats your day?","How was your day","What is the day?","How many days?",user);
//        form1.setDateCreated(OffsetDateTime.now());
//
//        FormModel form2 = new FormModel(Long.valueOf(2),"Whats your day?","How was your day","What is the day?","How many days?",user);
//        form2.setDateCreated(OffsetDateTime.now());
//
//
//        User admin1 = new User(Long.valueOf(1),"Nixhi","Nixhi","nixhi@gmail.com", "nixhi123", Arrays.asList(role2));
//        admin.setDateCreated(OffsetDateTime.now());
//
//        User user1 = new User(Long.valueOf(2),"Noel","Ceno","noel@gmail.com", "noel123", Arrays.asList(role1),Set.of(form1,form2));
//        user.setDateCreated(OffsetDateTime.now());
//
//
//        System.out.println("Printing roles 1: "+role1);
//        System.out.println("Printing roles 2: "+role2);
//        System.out.println();
//        System.out.println("Printing admin: "+admin);
//        System.out.println("Printing user : "+user);
//        System.out.println();
//        System.out.println("Printing form 1: "+form1);
//        System.out.println("Printing form 2 : "+form2);
//        System.out.println();
//        System.out.println("Printing admin1 : "+admin1);
//        System.out.println("Printing user1 : "+user1);
//    }
//}
