package appc;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class MainForm {

	@EJB
	private IServiceC serviceC;
	
	private int param1;
	
	private int param2;
	
	private int param3;
	
	private int param4;
	
	private int result;

	public int getParam1() {
		return param1;
	}

	public void setParam1(int param1) {
		this.param1 = param1;
	}

	public int getParam2() {
		return param2;
	}

	public void setParam2(int param2) {
		this.param2 = param2;
	}

	public int getParam3() {
		return param3;
	}

	public void setParam3(int param3) {
		this.param3 = param3;
	}

	public int getParam4() {
		return param4;
	}

	public void setParam4(int param4) {
		this.param4 = param4;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	public IServiceC getServiceC() {
		return serviceC;
	}
	
	public void setServiceC(IServiceC serviceC) {
		this.serviceC = serviceC;
	}
	
	public void jumble() {
		setResult(getServiceC().jumble(getParam1(), getParam2(), getParam3(), getParam4()));
	}
}
