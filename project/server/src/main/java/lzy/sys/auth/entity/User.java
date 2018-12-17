package lzy.sys.auth.entity;

import lombok.*;
import lzy.common.entity.BaseEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

/**
 * User: longzhiyou
 * Date: 2016/11/18
 * Time: 16:18
 */
@Getter
@Setter
//@Data
@NoArgsConstructor
//@EqualsAndHashCode(callSuper=true)
@Entity
public class User extends BaseEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "lzy.common.entity.IdGenerator")
    @GeneratedValue(generator = "idGenerator")
    private Long userId;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @OrderBy("id")
    private Set<Role> roles;

    @NotEmpty(message="姓名不能为空")
    private String username;

    @Length(min=6,message="密码长度不能小于6位")
    private String password;

    @Builder.Default
    private Boolean enabled=true;



//    public Set<Role> getRoles() {
//        return roles;
//    }
}
