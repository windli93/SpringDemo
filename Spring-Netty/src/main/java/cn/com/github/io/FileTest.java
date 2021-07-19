package cn.com.github.io;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * @AUTHOR windli
 * @DATE 2021/7/17 11:15
 * @DESC
 **/
@Slf4j
public class FileTest {

    @Test
    public void test1() throws Exception{
        //创建文件夹
        File dir = new File("D://dirDemo");
        log.info("file is exists:{}",dir.exists());
        if (!dir.exists()){
            dir.mkdir();
        }
        if (dir.isFile()){
            log.info("file is file");
        }else if (dir.isDirectory()){
            log.info("file is directory");
        }else {
            log.info("file error");
        }
        //创建文件
        File file = new File("D://dirDemo/fileDemo.txt");
        System.out.println(
                "\n Absolute path: " + file.getAbsolutePath() +
                        "\n Can read: " + file.canRead() +
                        "\n Can write: " + file.canWrite() +
                        "\n getName: " + file.getName() +
                        "\n getParent: " + file.getParent() +
                        "\n getPath: " + file.getPath() +
                        "\n length: " + file.length() +
                        "\n lastModified: " + file.lastModified() +
                        "\n isExist: " + file.exists());
        file.createNewFile();
        System.out.println("is file exist: " + file.exists());
        if(file.isFile()) {
            System.out.println("file is a file.");
        }else if(file.isDirectory()) {
            System.out.println("file is a directory");
        }

        System.out.println();
        for(String filename : dir.list()) {
            System.out.println(filename);
        }
    }
}
