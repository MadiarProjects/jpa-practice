package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Enumerated(value = EnumType.ORDINAL)
    private OrderStatus status;
    @Column(name = "delivery_address")
    private String deliveryAddress;
    @CreationTimestamp
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;
    @OneToMany(mappedBy = "order",cascade = CascadeType.PERSIST)
    private List<OrderProducts> orderProducts;
}
