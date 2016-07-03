package cn.edu.shu.society.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;


/**
 * @author 祥文
 * @Description 文件工具类
 * @time 2014-12-8 15:36
 */
public class FileUtil {

    /**
     * @param fileName 原始文件名
     * @return 修改后数字文档名
     * @Description 文件名生成
     */
    public static String generateFileName(String fileName) {
        int position = fileName.lastIndexOf(".");
        String extension = fileName.substring(position);
        return UUID.randomUUID().toString() + extension;
    }

    /**
     * @param fileName
     * @return
     */
    public static String printContentType(String fileName) {
        Path path = Paths.get(fileName);
        String contentType = null;
        try {
            contentType = Files.probeContentType(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentType;
    }

    /**
     * 复制文件
     *
     * @param sourceFile
     * @param targetFile
     * @throws IOException
     */
    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            // 关闭流
            try {
                if (inBuff != null)
                    inBuff.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            // 关闭流
            try {
                if (outBuff != null)
                    outBuff.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除文件
     *
     * @param file
     * @return
     */
    public static boolean deleteFile(File file) {
        boolean flag = false;
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }
}
