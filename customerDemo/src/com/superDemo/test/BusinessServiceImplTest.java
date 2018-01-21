import com.superDemo.domain.Customer;
        import com.superDemo.exception.IdIsNullException;
        import com.superDemo.service.BusinessService;
        import com.superDemo.service.impl.BusinessServiceImpl;
        import org.junit.Test;

        import java.util.Date;
        import java.util.List;

public class BusinessServiceImplTest {
    private BusinessService s = new BusinessServiceImpl();

    @Test
    public void testSaveCustomer(){
        for(int i = 0; i<200; i++){
            Customer c = new Customer();
            c.setName("james" + i);
            c.setBirthday(new Date());
            c.setGender("female");
            c.setPhonenum("119");
            c.setEmail("yy@itheima.com");
            c.setHobby("吃饭,睡觉,学java");
            c.setType("VVIP");
            c.setDescription("美女一个" + i);
            s.saveCustomer(c);
        }
    }

    @Test
    public void testFindAllCustomers() {
        List<Customer> cs = s.findAllCustomers();
        assert cs.size()==1;
    }

    @Test(expected = com.superDemo.exception.IdIsNullException.class)
    public void testUpdateCustomer()throws IdIsNullException{
        Customer c = new Customer();
        s.updateCustomer(c);
    }

    @Test
    public void testFindCustomerById() {
        Customer c = s.findCustomerById("LSWTMZ8AWHKS4CX29KUPZ9WZWSG8HKWZ");
        assert c!=null;
    }
    @Test
    public void testUpdateCustomer1() throws IdIsNullException {
        Customer c = s.findCustomerById("LSWTMZ8AWHKS4CX29KUPZ9WZWSG8HKWZ");
        c.setPhonenum("110");
        s.updateCustomer(c);
    }

    @Test
    public void testDeleteCustomerById() {
        s.deleteCustomerById("LSWTMZ8AWHKS4CX29KUPZ9WZWSG8HKWZ");
    }

}
