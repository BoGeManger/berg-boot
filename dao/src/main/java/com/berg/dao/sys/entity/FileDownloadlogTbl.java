package com.berg.dao.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统文件下载记录表
 * </p>
 *
 * @author 
 * @since 2020-06-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_file_downloadlog_tbl")
public class FileDownloadlogTbl implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 系统文件下载记录表id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文件路径
     */
    private String path;

    /**
     * 创建人
     */
    private String downloadUser;

    /**
     * 创建时间
     */
    private LocalDateTime downloadTimestamp;


}
