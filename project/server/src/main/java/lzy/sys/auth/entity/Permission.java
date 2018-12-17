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
//@Data
@Getter
@Setter
@NoArgsConstructor
//@EqualsAndHashCode(callSuper=true)
@Entity
public class Permission extends BaseIdEntity {

    private String title;
    private String name;

//    @ManyToMany(mappedBy ="permissions",cascade = {CascadeType.PERSIST, CascadeType.MERGE})

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "role_permission",
            joinColumns = @JoinColumn(name = "permission_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
