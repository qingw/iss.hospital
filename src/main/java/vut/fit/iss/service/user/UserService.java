package vut.fit.iss.service.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import vut.fit.iss.domain.user.User;

import java.util.Optional;

public interface UserService {
    @Transactional(readOnly = true)
    @PreAuthorize("hasRole('ROLE_USER')")
    Optional<User> getByUserName(String userName);

    @Transactional(readOnly = true)
    @PreAuthorize("hasRole('ROLE_STAFF')")
    Optional<User> getById(Long id);

}
