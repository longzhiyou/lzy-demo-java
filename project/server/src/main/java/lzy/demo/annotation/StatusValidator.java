package lzy.demo.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * User: longzhiyou
 * Date: 2019/1/9
 * Time: 13:52
 */
public class StatusValidator implements ConstraintValidator<Status, String> {
    private final String[] ALL_STATUS = {"created", "paid", "shipped", "closed"};
    public void initialize(Status status) {
    }
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(Arrays.asList(ALL_STATUS).contains(value))
            return true;
        return false;
    }
}
