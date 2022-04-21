package bg.softuni.mobilelele.service.impl;

import bg.softuni.mobilelele.models.entities.UserRole;
import bg.softuni.mobilelele.repository.UserRoleRepository;
import bg.softuni.mobilelele.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepo;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepo) {
        this.userRoleRepo = userRoleRepo;
    }

    @Override
    public UserRole save(UserRole entity) {
        return this.userRoleRepo.save(entity);
    }
}
