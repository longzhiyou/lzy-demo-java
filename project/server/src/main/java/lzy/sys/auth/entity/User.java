package lzy.sys.auth.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lzy.common.entity.BaseEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User: longzhiyou
 * Date: 2016/11/18
 * Time: 16:18
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
public class User extends BaseEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "lzy.common.entity.IdGenerator")
    @GeneratedValue(generator = "idGenerator")
    private Long userId;


    @NotEmpty(message="姓名不能为空")
    private String username;

    @Length(min=6,message="密码长度不能小于6位")
    private String password;

    private Boolean enabled=false;

}
