package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.Model.Goods;
import ru.kata.spring.boot_security.demo.Model.User;
import ru.kata.spring.boot_security.demo.repository.GoodsRepository;


import java.util.List;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;
    private final PasswordEncoder passwordEncoder;

    public GoodsServiceImpl(GoodsRepository goodsRepository, PasswordEncoder passwordEncoder) {
        this.goodsRepository = goodsRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsRepository.findAll();

    }

    @Override
    public Goods show(long id) {
        return goodsRepository.findById(id).orElseThrow(() -> new NullPointerException("Значение не найдено в базе данных"));
    }

    @Override
    @Transactional
    public void save(Goods goods) {
        goodsRepository.save(goods);
    }

    @Override
    public void update(long id, Goods goods) {
        goodsRepository.save(goods);
    }

    @Override
    public void delete(long id) {
        goodsRepository.deleteById(id);
    }

}
