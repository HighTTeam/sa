package hight.sa.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by neron.liu on 15/03/2017.
 */
@Data
public class User {

    private Long id;
    private String username;
    private String password;
    private Date createdAt;

}
