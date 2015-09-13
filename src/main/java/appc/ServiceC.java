package appc;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.xml.ws.BindingProvider;

import appa.servicea.IServiceA;
import appa.servicea.ServiceAService;
import appb.serviceb.IServiceB;
import appb.serviceb.ServiceBService;

@Stateless
@LocalBean
@WebService(serviceName = "ServiceCService", portName = "ServiceCPort", endpointInterface = "appc.IServiceC", targetNamespace = "http://appc/ServiceC")
public class ServiceC implements IServiceC {

	@Override
	public int jumble(int leftOne, int rightOne, int leftTwo, int rightTwo) {
		// TODO Use Service A & B to do this		
		
		IServiceA serviceA = new ServiceAService().getServiceAPort();
		((BindingProvider)serviceA).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:9080/appa/ServiceAService");
		
		IServiceB serviceB = new ServiceBService().getServiceBPort();
		((BindingProvider)serviceB).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:9080/appb/ServiceBService");

		return serviceB.minus(serviceA.plus(leftOne, rightOne),serviceA.plus(leftTwo, rightTwo));
		
	}

}
