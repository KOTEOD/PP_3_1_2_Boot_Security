package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.Model.Goods;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

}
