package appc;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import appa.servicea.IServiceA;
import appa.servicea.ServiceAService;
import appb.serviceb.IServiceB;
import appb.serviceb.ServiceBService;

@Stateless
@LocalBean
@WebService(serviceName = "ServiceCService", portName = "ServiceCPort", endpointInterface = "appc.IServiceC", targetNamespace = "http://appc/ServiceC")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class ServiceC implements IServiceC {

	private final static Logger LOGGER = Logger.getLogger(ServiceC.class.getName()); 
	
	@PersistenceContext(unitName="bmt-db")
	private EntityManager entityManager;
	
	@Override
	public int jumble(int leftOne, int rightOne, int leftTwo, int rightTwo) {
		/*
		String serviceCclientId = "9aa19969-286b-43a5-9e04-4069530e6560";

		String url = "https://api.apim.ibmcloud.com/bluemixtraininganzgmailcom-dev/sb";
		
		Map<String, List<String>> serviceARequestHeaders = new HashMap<String, List<String>>();
		serviceARequestHeaders.put("X-IBM-Client-Id", Collections.singletonList(serviceCclientId));

		IServiceA serviceA = new ServiceAService().getServiceAPort();
		((BindingProvider)serviceA).getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, serviceARequestHeaders);
		((BindingProvider)serviceA).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url + "/ServiceAService");
		
		IServiceB serviceB = new ServiceBService().getServiceBPort();
		((BindingProvider)serviceB).getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, serviceARequestHeaders);
		((BindingProvider)serviceB).getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url + "/ServiceBService");
		
		int result = serviceB.minus(serviceA.plus(leftOne, rightOne),serviceA.plus(leftTwo, rightTwo));
		*/
		int result = ((leftOne + rightOne)-(leftTwo + rightTwo));

		LOGGER.info("leftOne="+leftOne + ", rightOne=" + rightOne + ",leftTwo="+leftTwo + ", rightTwo=" + rightTwo + ", result=" + result);
		
		// create an entity to store values
		JumbleResultEntity jumbleResultEntity = new JumbleResultEntity();
		jumbleResultEntity.setCreateDate(new Date());
		jumbleResultEntity.setParam1(leftOne);
		jumbleResultEntity.setParam1(rightOne);
		jumbleResultEntity.setParam1(leftTwo);
		jumbleResultEntity.setParam1(rightTwo);
		jumbleResultEntity.setResult(result);
		
		// store in database
		getEntityManager().persist(jumbleResultEntity);
		getEntityManager().flush();
		
		return result;		
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}
