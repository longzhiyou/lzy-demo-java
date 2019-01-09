package lzy.demo.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * User: longzhiyou
 * Date: 2019/1/9
 * Time: 13:49
 */

@Constraint(validatedBy = {StatusValidator.class})
@Documented
@Target( { ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Status {

    String message() default "不正确的状态 , 应该是 'created', 'paid', shipped', closed'其中之一";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
