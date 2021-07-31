package com.cognizant.userservice.model.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDetailsResponse {

    private String userId;
    private String email;
    private String firstName;
    private String lastName;
}
