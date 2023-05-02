package UtilsLayer;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtils {

	public Response getUserAsPerId(RequestSpecification httpreq, String id) 
	{
		Response resp = httpreq.when().get(id);
		return resp;
	}

	public Response deleteUserAsPerId(RequestSpecification httpreq, String id)
	{
		return httpreq.when().delete(id);
	}
	
}
