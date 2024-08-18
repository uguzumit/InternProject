package etiya.SportsClub.service.impl;

import etiya.SportsClub.dto.UserDTO;
import etiya.SportsClub.entity.User;
import etiya.SportsClub.mapper.UserMapper;
import etiya.SportsClub.repository.UserRepository;
import etiya.SportsClub.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.toEntity(userDTO);
        User createdUser = userRepository.save(user);
        return UserMapper.INSTANCE.toDTO(createdUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.INSTANCE.toDTO(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = UserMapper.INSTANCE.toEntity(userDTO);
        user.setId(id);
        User updatedUser = userRepository.save(user);
        return UserMapper.INSTANCE.toDTO(updatedUser);
    }

    @Override
    public Boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }
}
