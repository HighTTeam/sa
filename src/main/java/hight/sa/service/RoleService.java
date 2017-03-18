package hight.sa.service;

import hight.sa.mapper.security.RoleMapper;
import hight.sa.model.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by neron.liu on 16/03/2017.
 */
@Slf4j
@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> findAll(){
        return roleMapper.findAll();
    }

}
