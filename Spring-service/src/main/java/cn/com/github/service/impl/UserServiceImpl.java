package cn.com.github.service.impl;

import cn.com.github.domain.entity.User;
import cn.com.github.repo.dao.UserRepository;
import cn.com.github.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public List<User> list() {
        return repository.findAll();
    }

    @Override
    public User findByName(String name) {
        return repository.findByUserName(name);
    }

    public User save(User user) {
        return repository.save(user);
    }
}
