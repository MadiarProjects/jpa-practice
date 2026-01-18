package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name = "feed_back")
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "is_published")
    private Boolean isPublished;
    private byte rate;
    private String text;
    @Column(name = "publish_date")
    private LocalDateTime publishDate;
}
