package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.Model.Goods;

import java.util.List;

@Service
public interface GoodsService {
    List<Goods> getAllGoods();
    Goods show(long id);
    void save(Goods goods);
    void update(long id, Goods goods);
    void delete(long id);
}
