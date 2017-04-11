package sample.gangnamdev.docker;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MemberRequest {
    @NotNull
    private String fullname;
    @NotNull
    private String phone;
    @NotNull
    private String email;
}
