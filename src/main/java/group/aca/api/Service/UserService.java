package group.aca.api.Service;
import group.aca.api.Entity.Client;
import group.aca.api.Entity.User;
import group.aca.api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé : " + id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public Optional<User> modifyUser(Integer id, User userAmodifier) {
        Optional<User> userDansLaBDD = this.userRepository.findById(id);

        if (userDansLaBDD.isPresent()){
            User userExistant = userDansLaBDD.get();

            userExistant.setPrenom(userAmodifier.getPrenom());
            userExistant.setNom(userAmodifier.getNom());
            userExistant.setTelephone(userAmodifier.getTelephone());
            userExistant.setEmail(userAmodifier.getEmail());

            userDansLaBDD = Optional.of(this.userRepository.save(userExistant));
        }

        return userDansLaBDD;
    }
}
