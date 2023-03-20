//package io.bootify.spring_boot_arlindiii.role;
//
//import io.bootify.spring_boot_arlindiii.util.WebUtils;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.springframework.web.util.WebUtils;
//
//
//@Controller
//@RequestMapping("/roles")
//public class RoleController {
//
//    @Autowired
//    private RoleService roleService;
//
//
//
//    @GetMapping
//    public String list(final Model model) {
//        model.addAttribute("roles", roleService.findAll());
//        return "role/list";
//    }
//
//    @GetMapping("/add")
//    public String add(@ModelAttribute("role") final Role role) {
//        return "role/add";
//    }
//
//
//    @PostMapping("/add")
//    public String add(@ModelAttribute("role") @Valid final Role role,
//            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
//        if (!bindingResult.hasFieldErrors("name") && roleService.nameExists(role.getName())) {
//            bindingResult.rejectValue("name", "Exists.role.name");
//        }
//        if (bindingResult.hasErrors()) {
//            return "role/add";
//        }
//        roleService.create(roleDTO);
////        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("role.create.success"));
//        return "redirect:/roles";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable final Long id, final Model model) {
//        model.addAttribute("role", roleService.get(id));
//        return "role/edit";
//    }
//
//    @PostMapping("/edit/{id}")
//    public String edit(@PathVariable final Long id,
//            @ModelAttribute("role") @Valid final Role role, final BindingResult bindingResult,
//            final RedirectAttributes redirectAttributes) {
//        final Role currentRole = roleService.get(id);
//        if (!bindingResult.hasFieldErrors("name") &&
//                !role.getName().equalsIgnoreCase(currentRole.getName()) &&
//                roleService.nameExists(role.getName())) {
//            bindingResult.rejectValue("name", "Exists.role.name");
//        }
//        if (bindingResult.hasErrors()) {
//            return "role/edit";
//        }
//        roleService.update(id, role);
////        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("role.update.success"));
//        return "redirect:/roles";
//    }
//
//    @PostMapping("/delete/{id}")
//    public String delete(@PathVariable final Long id, final RedirectAttributes redirectAttributes) {
//        final String referencedWarning = roleService.getReferencedWarning(id);
//        if (referencedWarning != null) {
//            redirectAttributes.addFlashAttribute(WebUtils.MSG_ERROR, referencedWarning);
//        } else {
//            roleService.delete(id);
//            redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("role.delete.success"));
//        }
//        return "redirect:/roles";
//    }
//
//}
