package lzy.sys.auth.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lzy.common.entity.BaseIdEntity;

import javax.persistence.Entity;

/**
 * User: longzhiyou
 * Date: 2016/11/18
 * Time: 16:18
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
public class Permission extends BaseIdEntity {

    private String name;

}
