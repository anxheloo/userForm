package io.bootify.spring_boot_arlindiii.form_model;

import io.bootify.spring_boot_arlindiii.user.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FormModelRepository extends JpaRepository<FormModel, Long> {

    FormModel findFirstByUser(User user);


}
