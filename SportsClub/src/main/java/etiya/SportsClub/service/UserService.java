package etiya.SportsClub.service;

import etiya.SportsClub.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO user);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, UserDTO user);
    Boolean deleteUser(Long id);

}
