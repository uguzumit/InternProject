package etiya.SportsClub.service;

import etiya.SportsClub.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User user);
    Boolean deleteUser(Long id);

}
