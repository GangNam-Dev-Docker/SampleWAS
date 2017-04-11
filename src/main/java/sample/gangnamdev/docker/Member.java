package sample.gangnamdev.docker;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"fullname", "email"}
        )
)
public class Member {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP", updatable = false, insertable = false)
    private Date createTime;
}
