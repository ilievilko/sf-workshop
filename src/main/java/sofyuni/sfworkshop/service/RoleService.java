package sofyuni.sfworkshop.service;

import sofyuni.sfworkshop.model.service.RoleServiceModel;

public interface RoleService {

    RoleServiceModel findByName(String name);
}
