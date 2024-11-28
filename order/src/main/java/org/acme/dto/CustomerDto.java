package org.acme.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    
    private UUID id;

    private String name;

    private String phone;

    private String email;

    private String address;

    private Long age;
}
