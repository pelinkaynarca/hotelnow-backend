package com.tobeto.java4a.hotelnow.services.rules;

import com.tobeto.java4a.hotelnow.core.utils.exceptions.types.AuthorizationException;
import com.tobeto.java4a.hotelnow.core.utils.messages.Messages;
import com.tobeto.java4a.hotelnow.entities.concretes.Role;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRules  {


    public void loggedInUserMustBeManager() {
        List<Role> rolesOfLoggedInUser = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream().map(r -> Role.valueOf(r.getAuthority())).toList();
        if (!rolesOfLoggedInUser.contains(Role.MANAGER))
            throw new AuthorizationException(Messages.Error.AUTHORIZATION_VIOLATION);
    }

    public void loggedInUserMustBeAdmin() {
        List<Role> rolesOfLoggedInUser = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream().map(r -> Role.valueOf(r.getAuthority())).toList();
        if (!rolesOfLoggedInUser.contains(Role.ADMIN))
            throw new AuthorizationException(Messages.Error.AUTHORIZATION_VIOLATION);
    }
}
