//package io.bootify.spring_boot_arlindiii.config;
//
//import org.springframework.beans.propertyeditors.StringTrimmerEditor;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.InitBinder;
//
//
//@ControllerAdvice
//public class ControllerConfig {
//
//    @InitBinder
//    void initBinder(final WebDataBinder binder) {
//        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
//    }
//
//}