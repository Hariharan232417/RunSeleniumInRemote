package listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class MethodInterceptor implements IMethodInterceptor{

	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		List<IMethodInstance> result = new ArrayList();
		
		Map<String,String> map1 = new HashMap();
		map1.put("TCName", "TC001");
		map1.put("Execute", "True");
		map1.put("count", "2");
		
		Map<String,String> map2 = new HashMap();
		map2.put("TCName", "TC002");
		map2.put("Execute", "false");
		map1.put("count", "3");
		
		List<Map<String,String>> lst = new ArrayList();
		lst.add(map1);
		lst.add(map2);
		
		for(int i=0;i<methods.size();i++)
		{
			for(int j=0;j<lst.size();j++)
			{
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(lst.get(j).get("TCName")))
				{
					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(lst.get(j).get("count")));
					result.add(methods.get(i));
				}
			}
		}
		
		return result;
		
		//TC001 will be executed 2 times as the invocation count = 2
	}

}
