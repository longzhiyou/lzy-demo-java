package lzy.module.account.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lzy.common.entity.BaseEntity;
import lzy.common.entity.BaseIdEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *  账户
 * 基本概念
 * @link(https://blog.csdn.net/qq_35246620/article/details/77196554)
 * 支付账户和登录账户
 * 会计科目与账户
 * 内部账户和外部账户
 * User: longzhiyou
 * Date: 2017/11/8
 * Time: 13:32
 */
@Where(clause="delete_flag=0")
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Data
@Entity
public class Account extends BaseEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "lzy.common.entity.IdGenerator")
    @GeneratedValue(generator = "idGenerator")
    private Long accountId;

    String name;

//    账户使用的货币类型，注意虽然一张银行卡可以支持多个币种，实际在内部，还是针对每个币种建立独立的子账户。涉及到多币种的账户，也可以采用类似的建模方案。
//    会计科目代码，一般是一级会计科目的代码。

//    账户控制相关：
//
//    是否允许充值；
//    是否允许提现；
//    是否允许透支；
//    是否允许支付；
//    是否允许转账进入；
//    是否允许转账转出；
//    是否有安全保障；
//    是否激活；
//    是否冻结。

//    资金相关：
//
//    当前账户余额，等于可用余额+冻结余额；
//    当前账户可用余额；
//    当前账户冻结的余额，冻结余额指在账户上暂不能使用的额度。在支付的时候，往往是先冻结，商品出库后，再实际执行扣款。
//    银行卡、第三方支付信息：
//
//    第三方实体的 ID；
//    第三方账号，如银行卡号或者在第三方支付的open_id等；
//    第三方的app_id；
//    账号的失效日期，该账号什么时候失效。

}