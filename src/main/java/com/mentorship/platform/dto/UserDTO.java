package com.mentorship.platform.dto;

import com.mentorship.platform.model.User.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String email;
    private Role role;
}
