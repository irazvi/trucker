package egen.trucker.trucker.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;


@Data
@Entity
public class Reading {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(columnDefinition = "VARCHAR(17)")
    private String vin;

    @Column(columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "YYYY-MM-DDThh:mm:ss.sTZD")
    private Date timestamp;

    @Column(columnDefinition = "DECIMAL(10,8)")
    private double latitude;

    @Column(columnDefinition = "DECIMAL(11,8)")
    private double longitude;

    @Column(columnDefinition = "DECIMAL(3,1)")
    private double fuelVolume;

    @Column(columnDefinition = "DECIMAL(3)")
    private double speed;

    @Column(columnDefinition = "VARCHAR(4)")
    private int engineHp;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean checkEngineLightOn;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean engineCoolantLow;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    private boolean cruiseControlOn;

    @Column(columnDefinition = "VARCHAR(4)")
    private int engineRpm;

    @OneToOne(fetch= FetchType.EAGER,
    cascade =  CascadeType.ALL)
    private Tires tires;

    public Reading() {
        this.id = UUID.randomUUID().toString();
    }

    public String getTimestamp() {
        return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(timestamp);
    }
}
