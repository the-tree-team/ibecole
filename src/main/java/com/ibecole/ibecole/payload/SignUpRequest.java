package com.ibecole.ibecole.payload;

import com.ibecole.ibecole.entity.admin.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 02/08/17 && idirene youcef.
 */

@Getter
@Setter
public class SignUpRequest {
    @NotBlank
    @Size(min = 4, max = 40)
    private String name;

    @NotBlank
    @Size(min = 3, max = 15)
    private String username;

    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;

    private List<Role> roles ;


}
