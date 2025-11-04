package com.ui.listner;

import org.apache.commons.beanutils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.ui.constants.Env;
import com.ui.utility.JsonUtility;
import com.ui.utility.PropertiesUtils;

public class MyRetryAnalyzer implements IRetryAnalyzer {
	
	/*this is for Property file*/
	private  final int MAX_NUMBER_OF_ATTEMPS=Integer.parseInt(PropertiesUtils.readproperty(Env.QA, "MAX_NUMBER_OF_ATTEMPS"));
	
	/*this is for Property file
	private  final int MAX_NUMBER_OF_ATTEMPS=JsonUtility.readJson(Env.QA).getMAX_NUMBER_OF_ATTEMPS();
	*/

	private static int current_attemps=1;
	

	@Override
	public boolean retry(ITestResult result) {
		if(current_attemps<=MAX_NUMBER_OF_ATTEMPS) {
			current_attemps++;
			return true;
		}
		
		
		
		return false;
	}

}
