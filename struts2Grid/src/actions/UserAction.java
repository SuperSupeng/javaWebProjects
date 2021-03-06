package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import domain.User;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;
import service.BusinessService;
import service.impl.BusinessServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    private List<User> users = new ArrayList();
    private BusinessService s = new BusinessServiceImpl();

    private String isUpload;
    private String[] interests;
    private File upload;
    private String uploadFileName;
    private InputStream fileInputStream;
    private String downloadFileName;

    public String userLogin() {
        user = s.login(user.getLogonName(), user.getLogonPwd());
        if(user==null){
            addActionError("错误的用户名或密码");
            return INPUT;
        }
        ServletActionContext.getRequest().getSession().setAttribute("user", user);
        return SUCCESS;
    }

    public String findAllUser(){
        users = s.findAllUsers();
        return SUCCESS;
    }

    public String listByCondition(){
        users = s.findUsersByCondition(user.getUserName(), user.getSex(), user.getEducation(), isUpload);
        return SUCCESS;
    }

    public String addUser() throws IOException {
        if(interests!=null&&interests.length>0){
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<interests.length;i++){
                if(i>0){
                    sb.append(",");
                }
                sb.append(interests[i]);
            }
            user.setInterest(sb.toString());
        }
        if(upload!=null){
            String realPath = ServletActionContext.getRequest().getRealPath("/files");
            File storeDirectory = new File(realPath);
            if(!storeDirectory.exists()){
                storeDirectory.mkdirs();
            }
            user.setPath("/files");
            String newFileName = TokenHelper.generateGUID()+"."+ FilenameUtils.getExtension(uploadFileName);
            user.setFilename(newFileName);
            FileUtils.copyFile(upload, new File(storeDirectory, newFileName));
        }
        s.addUser(user);
        return SUCCESS;
    }

    public String findOneUser(){
        user = s.findUserById(user.getUserID());
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.push(user);
        return SUCCESS;
    }

    public String viewUser(){
        user = s.findUserById(user.getUserID());
        ValueStack vs = ActionContext.getContext().getValueStack();
        vs.push(user);
        return SUCCESS;
    }

    public String delUser(){
        s.delUser(user);
        return SUCCESS;
    }

    public String download() throws FileNotFoundException {
        //根据id查询用户
        User u = s.findUserById(user.getUserID());
        String realPath = ServletActionContext.getServletContext().getRealPath(u.getPath());
        downloadFileName = u.getFilename();
        fileInputStream = new FileInputStream(realPath+"/"+downloadFileName);
        return SUCCESS;
    }

    public String editUser() throws IOException{
        //数据已经封装到了User对象中了：除了爱好和简历名称和简历存放路径

        //单独处理爱好
        if(interests!=null&&interests.length>0){
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<interests.length;i++){
                if(i>0){
                    sb.append(",");
                }
                sb.append(interests[i]);
            }
            user.setInterest(sb.toString());
        }

        if(upload!=null){
            //TODO 把老文件删掉

            //文件上传
            //文件上传的真实路径
            String realPath = ServletActionContext.getServletContext().getRealPath("/files");
            File storeDirectory = new File(realPath);
            if(!storeDirectory.exists()){
                storeDirectory.mkdirs();
            }

            user.setPath("/files");

            String newFileName = TokenHelper.generateGUID()+"."+FilenameUtils.getExtension(uploadFileName);
            user.setFilename(newFileName);
            FileUtils.copyFile(upload, new File(storeDirectory, newFileName));

        }else{
            //用户没有选择重新上传，保持住原有的文件名和路径
            User dbUser = s.findUserById(user.getUserID());
            user.setFilename(dbUser.getFilename());
            user.setPath(dbUser.getPath());
        }
        //保存用户的基本信息
        s.editUser(user);
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getIsUpload() {
        return isUpload;
    }

    public void setIsUpload(String isUpload) {
        this.isUpload = isUpload;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public InputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(InputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    public String getDownloadFileName() {
        return downloadFileName;
    }

    public void setDownloadFileName(String downloadFileName) {
        this.downloadFileName = downloadFileName;
    }

    @Override
    public User getModel() {
        return user;
    }
}
