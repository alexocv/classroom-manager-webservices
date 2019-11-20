package org.classroom.service.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classes DTO
 * @author alexc
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassesDTO {
    private Long id;
    private String title;
    private String description;
    private Set<StudentDTO> students;

}
