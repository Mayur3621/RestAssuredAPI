package StepDefination;

import BaseAPILayer.BaseApi;
import UtilsLayer.RestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmployeeAPIStepDef {
	private static RequestSpecification httpreq;
	private static Response resp;

	@Given("get the request specification object and pass basepath as {string}")
	public void get_the_request_specification_object_and_pass_basepath_as(String basePath) {
		BaseApi base = new BaseApi();
		httpreq = base.getRequestSpecification(basePath);
	}

	@When("user hit get request as per the emp id as {int}")
	public void user_hit_get_request_as_per_the_emp_id_as(Integer id) {
		RestUtils rest = new RestUtils();
		resp = rest.getUserAsPerId(httpreq, Integer.toString(id));
	}

	@Then("user validate status code as {int}")
	public void user_validate_status_code_as(Integer code) {
		
		System.out.println(resp.getStatusCode());
		resp.then().log().all().assertThat().statusCode(code);

	}

	@Then("user validate status line as {string}")
	public void user_validate_status_line_as(String line) {

		resp.then().assertThat().statusLine(line);

	}

	@When("user hit delete request as per the emp id as {int}")
	public void user_hit_delete_request_as_per_the_emp_id_as(Integer id) {
		RestUtils rest = new RestUtils();
		resp =rest.deleteUserAsPerId(httpreq, Integer.toString(id));
	
	}
	
	@Then("user validate response content-type header")
	public void user_validate_response_content_type_header() {
	   resp.then().assertThat().contentType("application/json; charset=utf-8");
	   
	}

}
