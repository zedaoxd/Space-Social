package api.space.services;

import api.space.models.User;
import api.space.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import api.space.dtos.UserDTO;
import api.space.dtos.UserInsertDTO;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(UserDTO::new);
    }

    @Transactional
    public UserDTO save(UserInsertDTO dto) {
        User user = dto.toEntity();
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(Long id, UserDTO dto) {
        User user = userRepository.getReferenceById(id);
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setAddress(dto.getAddressDTO().toEntity());
        user.setProfilePhoto(dto.getProfilePhotoDTO().toEntity());
        user = userRepository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void addFriend(Long id, Long friendId) {
        User user = userRepository.getReferenceById(id);
        User friend = userRepository.getReferenceById(friendId);
        user.getFriends().add(friend);
        userRepository.save(user);
    }

    @Transactional
    public void removeFriend(Long id, Long friendId) {
        User user = userRepository.getReferenceById(id);
        User friend = userRepository.getReferenceById(friendId);
        user.getFriends().remove(friend);
        userRepository.save(user);
    }
}
