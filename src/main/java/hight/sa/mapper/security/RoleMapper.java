package hight.sa.mapper.security;

import hight.sa.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by neron.liu on 15/03/2017.
 */
@Mapper
public interface RoleMapper {

    public List<Role> findAll();

}
