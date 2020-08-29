package egen.trucker.trucker.entity;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;
import lombok.Data;

@Data
@Entity
public class Alert {

    @Id
    @GeneratedValue
    private int id;

    @Column(columnDefinition = "VARCHAR(17)")
    private String vin;

    @Column(columnDefinition = "VARCHAR(6)")
    private String priority;

    @Column(columnDefinition = "VARCHAR(40)")
    private String description;

    @Column(columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "YYYY-MM-DDThh:mm:ss.sTZD")
    private Date timestamp;

    @Column(columnDefinition = "DECIMAL(10,8)")
    private double latitude;

    @Column(columnDefinition = "DECIMAL(11,8)")
    private double longitude;
}
