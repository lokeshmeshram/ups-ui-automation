package com.ups.automation.pageobject;

import com.ups.automation.UPSConstants;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "upshomepage")
public class UPSHomePage extends AbstractPage {

    UPSHomePage(){

    }

    public void bulkUpload(String listOfId,String actionName){
    	String [] ids = listOfId.split(",");
    	for (String id : ids){
    		readExcelData(actionName,id, "temp");
		}
	}

	/**
	 *
	 * @param sheetName - sheet-name of excel data input data file
	 * @return
	 */
	private void readExcelData(String sheetName, String jiraTestCaseId, String region)
	{
		ClassLoader classLoader = getClass().getClassLoader();
		DataHelper.data(classLoader.getResource(UPSConstants.SEARCH_REQUEST_PATH + UPSConstants.FILENAME + UPSConstants.XLSX).getPath(), sheetName,jiraTestCaseId);
	}
}