package egen.trucker.trucker.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Vehicle {

    @Id
    @Column(columnDefinition = "VARCHAR(17)")
    private String vin;

    @Column(columnDefinition = "VARCHAR(16)")
    private String make;

    @Column(columnDefinition = "VARCHAR(16)")
    private String model;

    @Column(columnDefinition = "VARCHAR(4)")
    private int year;

    @Column(columnDefinition = "INTEGER(4)")
    private int redlineRpm;

    @Column(columnDefinition = "VARCHAR(3)")
    private int maxFuelVolume;

    @Column(columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "YYYY-MM-DDThh:mm:ss.sTZD")
    private Date lastServiceDate;


}
