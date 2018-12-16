package lzy.demo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by longzhiyou on 2018/12/15.
 */
public interface BookRepository extends JpaRepository<Book, Integer> {
}
