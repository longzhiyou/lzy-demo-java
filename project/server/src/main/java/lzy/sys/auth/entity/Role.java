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

    private String name;

    @ManyToMany(mappedBy ="roles",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<User> users;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions;

}
