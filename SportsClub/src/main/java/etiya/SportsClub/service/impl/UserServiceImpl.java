package etiya.SportsClub.service.impl;

import etiya.SportsClub.dto.UserDTO;
import etiya.SportsClub.entity.User;
import etiya.SportsClub.repository.UserRepository;
import etiya.SportsClub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        return modelMapper.map(userRepository.save(user), UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserDTO.class))
                .orElse(null);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO user) {

        Optional<User> resultUser = userRepository.findById(id);

        if(resultUser.isPresent()) {
            resultUser.get().setFirstName(user.getFirstName());
            resultUser.get().setLastName(user.getLastName());
            resultUser.get().setEmail(user.getEmail());
            resultUser.get().setPassword(user.getPassword());

            return modelMapper.map(userRepository.save(resultUser.get()), UserDTO.class);
        }
        return null;

    }

    @Override
    public Boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }

}
