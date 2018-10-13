package ua.kiev.prog.model.product;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private byte[] content;
    private String title;
    @OneToOne(mappedBy = "photo")
    private Product product;
}
