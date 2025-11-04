package com.ui.pojo;

public class environments {
	private String url;
	private int MAX_NUMBER_OF_ATTEMPS=3;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getMAX_NUMBER_OF_ATTEMPS() {
		return MAX_NUMBER_OF_ATTEMPS;
	}

	public void setMAX_NUMBER_OF_ATTEMPS(int mAX_NUMBER_OF_ATTEMPS) {
		MAX_NUMBER_OF_ATTEMPS = mAX_NUMBER_OF_ATTEMPS;
	}
	

}
