package com.pet.facade;


import com.pet.dto.UserDTO;
import com.pet.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());

        return userDTO;
    }
}
