package lzy.file;

import lombok.Data;

/**
 *
 * Created by longzhiyou on 2018/12/15.
 */

@Data
public class FastDFSFile {


    private String name;
    private byte[] content;
    private String ext;
    private String md5;
    private String author;

}
