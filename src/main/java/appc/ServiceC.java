package appc;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@LocalBean
@WebService(serviceName = "ServiceCService", portName = "ServiceCPort", endpointInterface = "appc.IServiceC", targetNamespace = "http://appc/ServiceC")
public class ServiceC implements IServiceC {

	@Override
	public int jumble(int leftOne, int rightOne, int leftTwo, int rightTwo) {
		// TODO Use Service A & B to do this		
		return (leftOne + rightOne) - (leftTwo + rightTwo);
	}

}
