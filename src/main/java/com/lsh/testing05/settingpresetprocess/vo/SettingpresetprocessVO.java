package com.lsh.testing05.settingpresetprocess.vo;

import java.util.List;

public class SettingpresetprocessVO {
	
	public int ORIGIN_PROCESS_ID;
	public int SETTING_PRESET_ID;
	public int SETTING_PRESET_PROCESS_INDEX;
	public int SETTING_PRESET_PROCESS_ID;
	public List<SettingpresetprocessVO> list;
	public String ORIGIN_PROCESS_NAME;
	
	public int[] ORIGIN_PROCESS_ID2;
	public int[] SETTING_PRESET_ID2;
	public int[] SETTING_PRESET_PROCESS_INDEX2;
	public int[] SETTING_PRESET_PROCESS_ID2;
	
	
	public String getORIGIN_PROCESS_NAME() {
		return ORIGIN_PROCESS_NAME;
	}
	public void setORIGIN_PROCESS_NAME(String oRIGIN_PROCESS_NAME) {
		ORIGIN_PROCESS_NAME = oRIGIN_PROCESS_NAME;
	}
	public int getORIGIN_PROCESS_CODE() {
		return ORIGIN_PROCESS_CODE;
	}
	public void setORIGIN_PROCESS_CODE(int oRIGIN_PROCESS_CODE) {
		ORIGIN_PROCESS_CODE = oRIGIN_PROCESS_CODE;
	}
	public int ORIGIN_PROCESS_CODE;
	public int[] getSETTING_PRESET_PROCESS_ID2() {
		return SETTING_PRESET_PROCESS_ID2;
	}
	public void setSETTING_PRESET_PROCESS_ID2(int[] sETTING_PRESET_PROCESS_ID2) {
		SETTING_PRESET_PROCESS_ID2 = sETTING_PRESET_PROCESS_ID2;
	}
	public int[] getORIGIN_PROCESS_ID2() {
		return ORIGIN_PROCESS_ID2;
	}
	public void setORIGIN_PROCESS_ID2(int[] oRIGIN_PROCESS_ID2) {
		ORIGIN_PROCESS_ID2 = oRIGIN_PROCESS_ID2;
	}
	public int[] getSETTING_PRESET_ID2() {
		return SETTING_PRESET_ID2;
	}
	public void setSETTING_PRESET_ID2(int[] sETTING_PRESET_ID2) {
		SETTING_PRESET_ID2 = sETTING_PRESET_ID2;
	}
	public int[] getSETTING_PRESET_PROCESS_INDEX2() {
		return SETTING_PRESET_PROCESS_INDEX2;
	}
	public void setSETTING_PRESET_PROCESS_INDEX2(int[] sETTING_PRESET_PROCESS_INDEX2) {
		SETTING_PRESET_PROCESS_INDEX2 = sETTING_PRESET_PROCESS_INDEX2;
	}
	
	
	
	
	public List<SettingpresetprocessVO> getList() {
		return list;
	}
	public void setList(List<SettingpresetprocessVO> list) {
		this.list = list;
	}
	public int getSETTING_PRESET_PROCESS_ID() {
		return SETTING_PRESET_PROCESS_ID;
	}
	public void setSETTING_PRESET_PROCESS_ID(int sETTING_PRESET_PROCESS_ID) {
		SETTING_PRESET_PROCESS_ID = sETTING_PRESET_PROCESS_ID;
	}
	public int getORIGIN_PROCESS_ID() {
		return ORIGIN_PROCESS_ID;
	}
	public void setORIGIN_PROCESS_ID(int oRIGIN_PROCESS_ID) {
		ORIGIN_PROCESS_ID = oRIGIN_PROCESS_ID;
	}
	public int getSETTING_PRESET_ID() {
		return SETTING_PRESET_ID;
	}
	public void setSETTING_PRESET_ID(int sETTING_PRESET_ID) {
		SETTING_PRESET_ID = sETTING_PRESET_ID;
	}
	public int getSETTING_PRESET_PROCESS_INDEX() {
		return SETTING_PRESET_PROCESS_INDEX;
	}
	public void setSETTING_PRESET_PROCESS_INDEX(int sETTING_PRESET_PROCESS_INDEX) {
		SETTING_PRESET_PROCESS_INDEX = sETTING_PRESET_PROCESS_INDEX;
	}


}
