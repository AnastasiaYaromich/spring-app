package ru.yaromich.spring.entities;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    private Product product;

    @Column(name = "count")
    private Long count;

    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public void setUser(User user) { this.user = user; }
    public User getUser() { return user; }

    public void setProduct(Product product) { this.product = product; }
    public Product getProduct() { return product; }

    public void setCount(Long count) { this.count = count; }
    public Long getCount() { return count; }

    public Cart() {}

//    public Cart(User user, Product product, String count) {
//
//    }
}
