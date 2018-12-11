package lzy.ddd.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lzy.common.entity.BaseEntity;

import javax.persistence.MappedSuperclass;

/**
 * 添加 MappedSuperclass注解 此类的属性才会成为数据表字段
 * [2017-12-12 add by longzhiyou]
 */
@MappedSuperclass
@EqualsAndHashCode(callSuper=true)
@Data
public abstract class PersonEntity extends BaseEntity {

    private String name;
    private String gender;
    private String birth;

    private String firstName;
    private String lastName;

}
