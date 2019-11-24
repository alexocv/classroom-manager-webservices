package org.classroom.service.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * the Student DTO
 * @author alexc
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {


    private Long id;
    private String firstName;
    private String lastName;
}
