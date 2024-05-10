package com.example.querytesting.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeyTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String key1;
    private String key2;
    private String key3;
    private String key4;
    private String key5;

    @JsonBackReference(value = "device")
    @OneToOne(mappedBy = "keyTable", cascade = CascadeType.ALL)
    private Device device;
}
