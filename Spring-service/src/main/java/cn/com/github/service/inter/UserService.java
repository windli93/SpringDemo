package cn.com.github.service.inter;

import cn.com.github.domain.entity.User;

import java.util.List;

public interface UserService {

    public List<User> list();

    public User findByName(String name);

    public User save(User user);
}
