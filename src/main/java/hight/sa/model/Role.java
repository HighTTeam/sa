package hight.sa.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by neron.liu on 15/03/2017.
 */
@Data
public class Role {

    private Long id;
    private String role;
    private String name;
    private String description;
    private Date createdAt;

}
