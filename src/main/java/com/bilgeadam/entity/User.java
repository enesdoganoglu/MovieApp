package com.bilgeadam.entity;


import com.bilgeadam.utility.enums.EStatus;
import com.bilgeadam.utility.enums.EUserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String surname;
    @Column(length = 50)
    @Email
    private String email;
    @Column(length = 15)
    private String phone;
    @Column(length = 32)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$",
            message = "Şifre en az bir büyük, bir küçük, harf, rakam, ve özel karakterden oluşmalıdır.")
    private String password;
    @Column(length = 32)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=*!])(?=\\S+$).{8,}$",
            message = "Şifre en az bir büyük, bir küçük, harf, rakam, ve özel karakterden oluşmalıdır.")
    private String repassword;

    @ElementCollection
    private List<Integer> genreId;
    @ElementCollection
    private List<Integer> movieId;
    @ElementCollection
    private List<Integer> commentId;

    @Enumerated(EnumType.STRING) //Bu enum'ın bir string olarak kullanılacağını belirtir.
    @Builder.Default //Bir property build edilirken default değerini belirler.
    private EStatus status = EStatus.PENDING;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EUserType userType = EUserType.USER;
}
