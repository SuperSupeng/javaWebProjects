package action;

import com.opensymphony.xwork2.ActionSupport;
import service.BusinessService;

public class UserAction extends ActionSupport {
    private String name;
//	private BusinessService businessService = new BusinessServiceImpl();//耦合

    private BusinessService businessService;//和Spring中的一致

    public void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String regist(){
        //调用service
        businessService.regist();
        return SUCCESS;
    }
}
