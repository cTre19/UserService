package com.cognizant.estock.userservice.domain;

import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private String email;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotEmpty
    private String password;
}
