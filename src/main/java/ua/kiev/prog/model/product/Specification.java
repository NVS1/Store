package ua.kiev.prog.model.product;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "specifications")
public class Specification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dimensions;
    private String weight;
    private String display;
    private String processor;
    private String memory;
    private String storage;
    private String graphics;
    private String camera;
    private String os;
    private String sensors;
    private String other;
    private String equipment;
    @OneToOne(mappedBy = "specification", fetch = FetchType.LAZY)
    private Product product;
}
