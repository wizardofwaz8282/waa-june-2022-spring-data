package edu.miu.cs545.jointable.service.implementation;

import edu.miu.cs545.jointable.dto.ReviewDto;
import edu.miu.cs545.jointable.dto.UserDto;
import edu.miu.cs545.jointable.entity.Review;
import edu.miu.cs545.jointable.repo.UserRepository;
import edu.miu.cs545.jointable.service.UserService;
import edu.miu.cs545.jointable.utils.ReviewUtils;
import edu.miu.cs545.jointable.utils.UserUtils;
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
    public List<Review> getById(int id) {
        return userRepository.findById(id).get().getReviews();
    }

    @Override
    public UserDto updateUserById(Integer id, UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void createNewReview(int id, ReviewDto reviewDto) {
        userRepository.findById(id).get().addReviews(ReviewUtils.parseReviewDtoToReview(reviewDto));
    }
}
