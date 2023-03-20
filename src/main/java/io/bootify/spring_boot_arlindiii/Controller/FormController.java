package io.bootify.spring_boot_arlindiii.Controller;

import io.bootify.spring_boot_arlindiii.Security.CustomUserDetails;
import io.bootify.spring_boot_arlindiii.Security.CustomUserDetailsService;
import io.bootify.spring_boot_arlindiii.form_model.FormModel;
import io.bootify.spring_boot_arlindiii.form_model.FormModelService;
import io.bootify.spring_boot_arlindiii.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.OffsetDateTime;
import java.util.List;

@Controller
@RequestMapping("/forms")
public class FormController {
    @Autowired
    FormModelService formModelService;

    @Autowired
    CustomUserDetailsService customUserDetailsService;


    @GetMapping
    public ModelAndView forms() {
        ModelAndView modelAndView = new ModelAndView("forms");
        modelAndView.addObject("forms", formModelService.getAll());
        return modelAndView;
    }



    //WAY 2
    @GetMapping("/new")
    public String showCreateForm(Model model) {

        FormModel form = new FormModel();
        model.addAttribute("form", form);
        return "create_form";
    }


//    //WAY 1
//        @PostMapping
//        public String createForm(@Valid FormModel formModel, BindingResult result, Model model)
//        {
//            FormModel form = new FormModel();
//            form.setComplete(formModel.isComplete());
//            form.setLastUpdated(formModel.getLastUpdated());
//            form.setFirstQuestion(formModel.getFirstQuestion());
//            form.setSecondQuestion(formModel.getSecondQuestion());
//            form.setThirdQuestion(formModel.getThirdQuestion());
//            form.setForthQuestion(formModel.getForthQuestion());
//            System.out.println(form.toString());
//            formModelService.save(form);
//
//            System.out.println(form.toString());
//            return "redirect:/forms";
//        }

    @PostMapping
    public String saveForm(@ModelAttribute("form") FormModel form)
    {
        form.setComplete(form.isComplete());
        form.setDateCreated(OffsetDateTime.now());
        form.setLastUpdated(OffsetDateTime.now());
//        form.setUser();
        formModelService.save(form);
        return "redirect:/forms";
    }



    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable("id") Long id, Model model) {
        FormModel formModel = formModelService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("FormModel id: " + id + " not found!"));

        //WE CAN ALSO USE THIS WAY
//        Optional<ToDoItem> todoItem = toDoService.getById(id);
//        if(todoItem.isPresent())
//        {
//            todoItem.get();
//        }

        formModelService.delete(formModel);
        return "redirect:/forms";
    }


//    @GetMapping("/{id}")
//    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
//        FormModel formModel = formModelService.getById(id)
//                .orElseThrow(() -> new IllegalArgumentException("FormModel id: " + id + " not found!"));
//
//        model.addAttribute("form", formModel);
//        return "edit_form";
//    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id,Model model)
    {
        model.addAttribute("form",formModelService.get(id));
        return "edit_form";
    }


    //BindingResult result,

    @PostMapping("/{id}")
    public String updateForm(@PathVariable Long id, @ModelAttribute("form") FormModel form, Model model) {

        FormModel existingForm = formModelService.get(id);

        existingForm.setId(id); // check if it works without this
        existingForm.setComplete(form.isComplete());
        existingForm.setLastUpdated(OffsetDateTime.now());
        existingForm.setFirstQuestion(form.getFirstQuestion());
        existingForm.setSecondQuestion(form.getSecondQuestion());
        existingForm.setThirdQuestion(form.getThirdQuestion());
        existingForm.setForthQuestion(form.getForthQuestion());
        System.out.println(form.toString());

        formModelService.save(existingForm);

        return "redirect:/forms";
    }

}
