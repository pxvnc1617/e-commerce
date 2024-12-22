package commerce.example.e_commerce.service;

import commerce.example.e_commerce.entity.User;
import commerce.example.e_commerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public Optional<User> getUser(long id) {
        return userRepository.findById(id);
    }

    public Optional<User> registerUser(User user) {
        userRepository.save(user);
        return getUserByUserId(user.getUserId());
    }

    public Optional<User> getUserByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
}
