package lzy.sys.auth.entity;

import lombok.*;
import lzy.common.entity.BaseIdEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * User: longzhiyou
 * Date: 2016/11/18
 * Time: 16:18
 */
@Getter
@Setter
@NoArgsConstructor
//@EqualsAndHashCode(callSuper=true)
@Entity
public class Role extends BaseIdEntity {

    private String title;
    private String name;

//    @ManyToMany(mappedBy ="roles",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @ManyToMany(cascade = CascadeType.ALL)
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions;

}
