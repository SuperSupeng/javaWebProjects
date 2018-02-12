package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class DownLoadAction extends ActionSupport {
    private InputStream photoIn;
    private String filename;

    public InputStream getPhotoIn() {
        return photoIn;
    }

    public void setPhotoIn(InputStream photoIn) {
        this.photoIn = photoIn;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String download() throws Exception {
        String realPath = ServletActionContext.getServletContext().getRealPath("/中.jpg");
        filename = FilenameUtils.getName(realPath);
        filename = URLEncoder.encode(filename, "UTF-8");
        photoIn = new FileInputStream(realPath);
        return SUCCESS;
    }
}
