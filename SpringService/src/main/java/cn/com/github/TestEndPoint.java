package cn.com.github;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;


public class TestEndPoint{

	private static final String ADDRESS = "http://localhost:9000/WebServicedemo"; 
    public static void main(String[] args) {
    	 
    	 System.out.println("Starting Server");  
         WebServiceImpl demo = new WebServiceImpl();  
         
         Endpoint.publish(ADDRESS, demo);
         System.out.println("Start success");
		
	} 
        
    @Test
    public void testSayHello(){
        
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(WebService.class);
        factory.setAddress(ADDRESS);
        WebService client = (WebService)factory.create();
        String reponse = client.sayHello("foo");
        System.out.println(reponse);
    }
	
}
