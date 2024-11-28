package org.acme.dto;

import java.util.UUID;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private UUID id;

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String address;

    @NotNull
    private Long age;
}
