package edu.miu.cs545.springdatai.service.implementation;

import edu.miu.cs545.springdatai.dto.ReviewDto;
import edu.miu.cs545.springdatai.dto.UserDto;
import edu.miu.cs545.springdatai.entity.Review;
import edu.miu.cs545.springdatai.repo.UserRepository;
import edu.miu.cs545.springdatai.service.UserService;
import edu.miu.cs545.springdatai.utils.ReviewUtils;
import edu.miu.cs545.springdatai.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createNewUser(UserDto userDto) {
        return UserUtils.parseUserToUserDto(userRepository.save(UserUtils.parseUserDtoToUser(userDto)));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(u->UserUtils.parseUserToUserDto(u)).toList();
    }

    @Override
    public UserDto getUserById(Integer id) {
        return UserUtils.parseUserToUserDto(userRepository.getReferenceById(id));
    }

    @Override
    public UserDto updateUserById(Integer id, UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

}
