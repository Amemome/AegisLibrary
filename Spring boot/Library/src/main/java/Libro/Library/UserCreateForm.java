package Libro.Library;

import jakarta.validation.constraints.NotEmpty;


import lombok.Data;

@Data
public class UserCreateForm {
    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    @NotEmpty
    private String studentID;


}