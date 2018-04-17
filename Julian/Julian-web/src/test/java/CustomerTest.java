import com.jua.base.criteria.Criteria;
import com.jua.referent.entity.Customer;
import com.jua.service.customer.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class CustomerTest {

	//实体
	public static String referent= "Julian\\Julian-referent\\src\\main\\java\\com\\jua\\referent\\entity";
	//原型
	public static String original_base = "Julian\\Julian-original\\src\\main\\java\\com\\jua\\original";
	//拓展dao
	public static String dao = "Julian\\Julian-dao\\src\\main\\java\\com\\jua\\dao";
	//拓展service
	public static String service = "Julian\\Julian-service\\src\\main\\java\\com\\jua\\service";

	@Autowired
  	private CustomerService customerService;


	@Test
  	public void test() throws Exception{
		Criteria c = new Criteria("loginName","nihao");

		Customer customer = customerService.queryBySingle(c);

		customer.setComment("setCommentsetCommentsetCommentsetCommentsetCommentsetCommentsetCommentsetCommentsetCommentsetCommentsetCommentsetCommentsetComment");

		customerService.update(customer);

		Customer customer1 = customerService.test("045e2d2d-63d4-432c-bb72-90f7b3d403f4");

		if(customer1 != null){

			System.out.println(customer1.getLoginName());

			System.out.println(customer1.getComment());

		}
  	}
}
