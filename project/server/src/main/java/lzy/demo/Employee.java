package lzy.demo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * User: longzhiyou
 * Date: 2019/1/9
 * Time: 16:04
 */
public class Employee {

    @NotNull
    @Size(min = 5, max = 50)
    private String name;
    @Pattern(regexp = "Admin|IT|Sales|Accounts")
    private String dept;
    @Past
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

}
