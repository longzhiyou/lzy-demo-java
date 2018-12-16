package lzy.sys.auth.entity;

import lombok.*;
import lzy.common.entity.BaseIdEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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

    private String name;

    @ManyToMany(mappedBy ="permissions")
    private Set<Role> roles;

}
