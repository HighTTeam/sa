package hight.sa.model;

import hight.sa.common.utils.import_export.*;
import lombok.Data;

import java.util.Date;

/**
 * Created by neron.liu on 15/03/2017.
 */
@Data
@ExportOrder
public class User {

    @Export(name = "用户ID")
    private Long id;

    @Export(name = "用户名")
    private String username;

    private String password;

    @Export(name = "是否启用")
    @NumericMappings(values = {
            @NumericValue(key = 0, value = "停用"), @NumericValue(key = 0, value = "启用")
    })
    private Integer isEnabled;

    @Export(name = "创建时间")
    private Date createdAt;

}
