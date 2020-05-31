package sofyuni.sfworkshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sofyuni.sfworkshop.model.entity.Role;
import sofyuni.sfworkshop.model.service.RoleServiceModel;
import sofyuni.sfworkshop.repository.RoleRepository;
import sofyuni.sfworkshop.service.RoleService;

import javax.annotation.PostConstruct;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void init(){
        if (this.roleRepository.count() == 0){
            Role admin = new Role("ADMIN");
            Role user = new Role("USER");

            this.roleRepository.saveAndFlush(admin);
            this.roleRepository.saveAndFlush(user);
        }
    }

    @Override
    public RoleServiceModel findByName(String name) {
        return this.roleRepository.findByName(name)
                .map(role -> this.modelMapper.map(role, RoleServiceModel.class)).orElse(null);
    }
}
