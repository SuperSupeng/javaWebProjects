package cn.itcast.web.action;

import cn.itcast.domain.Customer;
import cn.itcast.domain.User;
import cn.itcast.service.CustomerService;
import cn.itcast.service.UserService;
import cn.itcast.utils.PageBean;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	//模型驱动
	private Customer customer = new Customer();
	
	private CustomerService cs;

	//属性驱动
	private Integer currentPage;
	private Integer pageSize;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public CustomerService getCs() {
		return cs;
	}

	public void setCs(CustomerService cs) {
		this.cs = cs;
	}

	public String list() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if (StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}

		//调用service查询分页数据
		PageBean pb = cs.getPageBean(dc, currentPage, pageSize);
		//将pageBean返回request
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}

	@Override
	public Customer getModel() {
		return customer;
	}

	
	
}
