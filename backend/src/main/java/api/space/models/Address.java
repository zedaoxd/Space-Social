package api.space.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "street", length = 100)
    private String street;

    @Column(name = "number", length = 10)
    private String number;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "state", length = 2)
    private String state;

    @Column(name = "zip", length = 9)
    private String zip;
}
