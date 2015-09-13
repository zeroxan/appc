package appc;

import javax.ejb.Local;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Use;

@Local
@WebService(targetNamespace="http://appc/ServiceC")
@SOAPBinding(style=javax.jws.soap.SOAPBinding.Style.RPC, use=Use.LITERAL, parameterStyle=ParameterStyle.WRAPPED)
public interface IServiceC {

	int jumble(int leftOne, int rightOne, int leftTwo, int rightTwo);
	
}
