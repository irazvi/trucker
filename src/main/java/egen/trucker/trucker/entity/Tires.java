package egen.trucker.trucker.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Tires {

    @Id
    @Column(columnDefinition = "VARCHAR(10)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(columnDefinition = "VARCHAR(2)")
    private int frontLeft;

    @Column(columnDefinition = "VARCHAR(2)")
    private int frontRight;

    @Column(columnDefinition = "VARCHAR(2)")
    private int rearLeft;

    @Column(columnDefinition = "VARCHAR(2)")
    private int rearRight;
}
