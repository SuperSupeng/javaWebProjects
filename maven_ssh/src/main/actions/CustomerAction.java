package actions;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
    private Long custId;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String findCustomerById() {
        System.out.println("aa"+custId);
        return SUCCESS;
    }
}
