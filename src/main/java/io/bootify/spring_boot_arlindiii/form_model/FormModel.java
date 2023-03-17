package io.bootify.spring_boot_arlindiii.form_model;

import io.bootify.spring_boot_arlindiii.user.User;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Set;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormModel {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstQuestion;

    @Column(nullable = false)
    private String secondQuestion;

    @Column(nullable = false)
    private String thirdQuestion;

    @Column(nullable = false)
    private String forthQuestion;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column
    private OffsetDateTime lastUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;



//    public FormModel(String firstQuestion, String secondQuestion, String thirdQuestion, String forthQuestion, User user){
//        this.user = user;
//        this.firstQuestion = firstQuestion;
//        this.secondQuestion = secondQuestion;
//        this.thirdQuestion = thirdQuestion;
//        this.forthQuestion = forthQuestion;
//    }

    public FormModel(String firstQuestion, String secondQuestion, String thirdQuestion, String forthQuestion){
        this.firstQuestion = firstQuestion;
        this.secondQuestion = secondQuestion;
        this.thirdQuestion = thirdQuestion;
        this.forthQuestion = forthQuestion;
    }

//    public FormModel(Long id,String firstQuestion, String secondQuestion, String thirdQuestion, String forthQuestion, User user){
//        this.id = id;
//        this.user=user;
//        this.firstQuestion = firstQuestion;
//        this.secondQuestion = secondQuestion;
//        this.thirdQuestion = thirdQuestion;
//        this.forthQuestion = forthQuestion;
//    }


//    public void addUser(User u)
//    {
//        System.out.println("We are inside the addUser Method That is called by FormModel");
//        FormModel;
//    }

}
