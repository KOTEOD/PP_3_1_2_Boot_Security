package ru.kata.spring.boot_security.demo.Model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    String name;

    @Column
    String producerGoods;

    @Column (nullable = false)
    String section;

    @Column (nullable = false)
    String price;

    @Column
    String deliveryDate;
}
