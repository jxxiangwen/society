package cn.edu.shu.society.admin.rest;


import cn.edu.shu.society.enums.ClientError;
import cn.edu.shu.society.enums.FilePath;
import cn.edu.shu.society.exception.AppException;
import cn.edu.shu.society.util.FileUtil;
import com.wordnik.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Api(value = "file", description = "文件操作相关API")
@RestController
@RequestMapping(value = "/admin/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    // @ModelAttribute("files")//此属性用于初始类时调用,但上传文件后不能时时反应上传文件个数,不适合动态数据
    public List<String> loadFiles(HttpServletRequest request, String path) {
        List<String> files = new ArrayList<>();
        String ctxPath = request.getSession().getServletContext().getRealPath("/") + path;
        File file = new File(ctxPath);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            String fileName = null;
            for (File aFile : listFiles) {
                fileName = aFile.getName();
                if (aFile.isFile()) {
                    files.add(fileName);
                }
            }
        } else {
            throw new AppException(ClientError.FILE_PATH_ERROR.getMsg(), ClientError.FILE_PATH_ERROR.getCode());
        }
        return files;
    }

    @RequestMapping(value = "/upload/office", method = RequestMethod.POST)
    public ModelAndView uploadOffice(HttpServletRequest request,
                                     HttpServletResponse response, BindException errors)
            throws Exception {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("file");

        String name = multipartRequest.getParameter("name");
        // 获得文件名：
        String realFileName = file.getOriginalFilename();
        logger.info("上传文件名：: " + realFileName);
        realFileName = FileUtil.generateFileName(realFileName);
        logger.info("转换后：: " + realFileName);
        // 获取路径
        String ctxPath = request.getSession().getServletContext().getRealPath("/") + FilePath.OFFICE.getPath();
        // 创建文件
        File dirPath = new File(ctxPath);
        if (!dirPath.exists()) {
            dirPath.mkdir();
        }
        File uploadFile = new File(ctxPath + realFileName);
        FileCopyUtils.copy(file.getBytes(), uploadFile);
        return new ModelAndView("success");
    }

    @RequestMapping("/download/office/{fileName}")
    public ModelAndView downloadOffice(@PathVariable("fileName") String fileName,
                                       HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        String ctxPath = request.getSession().getServletContext().getRealPath("/") + FilePath.OFFICE.getPath();
        String downLoadPath = ctxPath + fileName;
        try {
            long fileLength = new File(downLoadPath).length();
            response.setContentType("application/x-msdownload;");
            response.setHeader("Content-disposition", "attachment; filename="
                    + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
            response.setHeader("Content-Length", String.valueOf(fileLength));
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return null;
    }
}
