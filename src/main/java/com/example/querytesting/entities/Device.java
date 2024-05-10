package com.example.querytesting.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String macAddress;
    private String deviceName;


    @JsonManagedReference(value = "device")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "key_id", referencedColumnName = "id")
    private KeyTable keyTable;

}
