package YapBoard.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COMMENTS")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "content")
    private String content;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "posts_id")
    Posts post;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

}
