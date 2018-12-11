package lzy.module.account.repository;

import lzy.module.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Modifying
    @Query("update Account t set t.deleteFlag = 1 where t.accountId = ?1")
    @Override
    void delete(Long id);


}
