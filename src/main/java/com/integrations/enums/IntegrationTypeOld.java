package com.integrations.enums;

import com.integrations.util.*;

public enum IntegrationTypeOld {

	RSS("CSV", "csv",
			"/Users/edcast/eclipse-workspace/POM_Framework_Naveen/src/test/resources/CSV/integration_default.properties",
			"/Users/edcast/eclipse-workspace/POM_Framework_Naveen/src/test/resources/CSV/logo_banner.png",
			"/Users/edcast/eclipse-workspace/POM_Framework_Naveen/src/test/resources/CSV/csv.csv");

	String displayName;
	String name;
	String propPath;
	String logoBannerPath;
	String csvFilePath;

	private IntegrationTypeOld(String displayName, String name, String integrationPropertyPath, String logoBannerPath,
			String csvFilePath) {

		this.displayName = displayName;
		this.name = name;
		this.propPath = integrationPropertyPath;
		this.logoBannerPath = logoBannerPath;
		this.csvFilePath = csvFilePath;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getName() {
		return name;
	}

	public String getPropPath() {
		return propPath;
	}

	public String getLogoBannerPath() {
		return logoBannerPath;
	}

	public String getCsvFilePath() {
		return csvFilePath;
	}

}

