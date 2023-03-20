package io.bootify.spring_boot_arlindiii.role;

import io.bootify.spring_boot_arlindiii.user.User;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "Role")
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
//    @Column(nullable = false, updatable = false)
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column
    private OffsetDateTime lastUpdated;


    public Role(String name)
    {
        this.name=name;
    }

    public Role(Long id, String name)
    {
        this.id = id;
        this.name=name;
    }

}