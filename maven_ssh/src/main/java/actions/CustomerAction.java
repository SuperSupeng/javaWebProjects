package actions;

import com.opensymphony.xwork2.ActionSupport;
import entity.Customer;
import service.CustomerService;

/**
 * @author super
 */
public class CustomerAction extends ActionSupport {
    private Long custId;
    private Customer customer;
    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String findCustomerById() {
        customer = customerService.findById(custId);

        System.out.println("aa"+custId);
        return SUCCESS;
    }
}
