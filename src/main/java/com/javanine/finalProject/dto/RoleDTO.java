package com.javanine.finalProject.dto;

import com.javanine.finalProject.model.enums.UserRole;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private Long id;
    private UserRole roleName;
}
