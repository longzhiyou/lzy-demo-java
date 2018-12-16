package lzy.demo;

import lombok.Data;
import lzy.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * User: longzhiyou
 * Date: 2017/1/13
 * Time: 19:26
 */
@Data
@Entity
public class Book extends BaseEntity {

    @Id
//    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;


    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_publisher")
//    @JoinTable(name = "book_publisher",
//            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "bookId", nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "publisher_id",
//                    referencedColumnName = "publisher_id", nullable = false))
    private Set<Publisher> publishers;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, Set<Publisher> publishers) {
        this.name = name;
        this.publishers = publishers;
    }

    @Override
    public String toString() {
        String result = String.format(
                "Book [id=%d, name='%s']%n",
                bookId, name);
        if (publishers != null) {
            for(Publisher publisher : publishers) {
                result += String.format(
                        "Publisher[id=%d, name='%s']%n",
                        publisher.getPublisherId(), publisher.getName());
            }
        }

        return result;
    }


}
