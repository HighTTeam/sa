package hight.sa.controller.security;

import hight.sa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by neron.liu on 16/03/2017.
 */
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public ResponseEntity<List<String>> listAll() {
        return ResponseEntity.ok(roleService.findAll().stream().map(i -> i.getRole()).collect(Collectors.toList()));
    }

}
