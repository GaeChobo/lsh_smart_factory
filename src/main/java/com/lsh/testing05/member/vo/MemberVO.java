package com.lsh.testing05.member.vo;

import java.sql.Date;
import java.util.List;

public class MemberVO {
	
	//메인카테고리
	public int PROCESS_MAIN_CATEGORY_ID;
	
	//로그인 성공 실패 여부
	public int login_fail;

	//비밀번호 성공 실패 여부
	public int pwd_find_fail;
	
	//생성 여부 확인
	public int Id_Credit;
	
	//종복 확인
	public int overlap;
	
	public int ORIGIN_ACCOUNT_ID; // 계정번호
	public int ORIGIN_ACCOUNT_DIVISION_ID; // 계정구분번호
	public String ORIGIN_ACCOUNT_MEMBERNAME; // 사용자 이름
	
	//작업자 이미지 경로
	public String ORIGIN_ACCOUNT_IMG_DIRECTORY;
	
	//작업자 속성 ID
	public int WORKER_PROPERTY_ID;
	//설비 ID
	public int ORIGIN_EQUIPMENT_ID;
	//공정 ID
	public int ORIGIN_PROCESS_ID;
	
	public String ORIGIN_ACCOUNT_PASSWORD;
	public String ORIGIN_ACCOUNT_TYPE;
	public String ORIGIN_ACCOUNT_EMPLOYEENUMBER;
	public String ORIGIN_ACCOUNT_DEPARTMENT;
	public String ORIGIN_ACCOUNT_TIER;
	public String ORIGIN_ACCOUNT_RESIDENTNUMBER;
	public Date ORIGIN_ACCOUNT_CREATEDATE;
	public int ORIGIN_ACCOUNT_EMPLOYMENT_STATUS_ID;
	
	public String firstline;
	public String secondline;
	
	public int getPROCESS_MAIN_CATEGORY_ID() {
		return PROCESS_MAIN_CATEGORY_ID;
	}
	public void setPROCESS_MAIN_CATEGORY_ID(int pROCESS_MAIN_CATEGORY_ID) {
		PROCESS_MAIN_CATEGORY_ID = pROCESS_MAIN_CATEGORY_ID;
	}
	public int getOverlap() {
		return overlap;
	}
	public void setOverlap(int overlap) {
		this.overlap = overlap;
	}
	public int getId_Credit() {
		return Id_Credit;
	}
	public void setId_Credit(int id_Credit) {
		Id_Credit = id_Credit;
	}
	public int getLogin_fail() {
		return login_fail;
	}
	public void setLogin_fail(int login_fail) {
		this.login_fail = login_fail;
	}
	public int getPwd_find_fail() {
		return pwd_find_fail;
	}
	public void setPwd_find_fail(int pwd_find_fail) {
		this.pwd_find_fail = pwd_find_fail;
	}

	public String getFirstline() {
		return firstline;
	}
	public void setFirstline(String firstline) {
		this.firstline = firstline;
	}
	public String getSecondline() {
		return secondline;
	}
	public void setSecondline(String secondline) {
		this.secondline = secondline;
	}	
	
	public String getORIGIN_ACCOUNT_IMG_DIRECTORY() {
		return ORIGIN_ACCOUNT_IMG_DIRECTORY;
	}
	public void setORIGIN_ACCOUNT_IMG_DIRECTORY(String oRIGIN_ACCOUNT_IMG_DIRECTORY) {
		ORIGIN_ACCOUNT_IMG_DIRECTORY = oRIGIN_ACCOUNT_IMG_DIRECTORY;
	}
	public int getWORKER_PROPERTY_ID() {
		return WORKER_PROPERTY_ID;
	}
	public void setWORKER_PROPERTY_ID(int wORKER_PROPERTY_ID) {
		WORKER_PROPERTY_ID = wORKER_PROPERTY_ID;
	}
	public int getORIGIN_EQUIPMENT_ID() {
		return ORIGIN_EQUIPMENT_ID;
	}
	public void setORIGIN_EQUIPMENT_ID(int oRIGIN_EQUIPMENT_ID) {
		ORIGIN_EQUIPMENT_ID = oRIGIN_EQUIPMENT_ID;
	}
	public int getORIGIN_PROCESS_ID() {
		return ORIGIN_PROCESS_ID;
	}
	public void setORIGIN_PROCESS_ID(int oRIGIN_PROCESS_ID) {
		ORIGIN_PROCESS_ID = oRIGIN_PROCESS_ID;
	}
	
	public int getORIGIN_ACCOUNT_ID() {
		return ORIGIN_ACCOUNT_ID;
	}
	public void setORIGIN_ACCOUNT_ID(int oRIGIN_ACCOUNT_ID) {
		ORIGIN_ACCOUNT_ID = oRIGIN_ACCOUNT_ID;
	}
	public int getORIGIN_ACCOUNT_DIVISION_ID() {
		return ORIGIN_ACCOUNT_DIVISION_ID;
	}
	public void setORIGIN_ACCOUNT_DIVISION_ID(int oRIGIN_ACCOUNT_DIVISION_ID) {
		ORIGIN_ACCOUNT_DIVISION_ID = oRIGIN_ACCOUNT_DIVISION_ID;
	}
	public String getORIGIN_ACCOUNT_MEMBERNAME() {
		return ORIGIN_ACCOUNT_MEMBERNAME;
	}
	public void setORIGIN_ACCOUNT_MEMBERNAME(String oRIGIN_ACCOUNT_MEMBERNAME) {
		ORIGIN_ACCOUNT_MEMBERNAME = oRIGIN_ACCOUNT_MEMBERNAME;
	}
	public String getORIGIN_ACCOUNT_PASSWORD() {
		return ORIGIN_ACCOUNT_PASSWORD;
	}
	public void setORIGIN_ACCOUNT_PASSWORD(String oRIGIN_ACCOUNT_PASSWORD) {
		ORIGIN_ACCOUNT_PASSWORD = oRIGIN_ACCOUNT_PASSWORD;
	}
	public String getORIGIN_ACCOUNT_TYPE() {
		return ORIGIN_ACCOUNT_TYPE;
	}
	public void setORIGIN_ACCOUNT_TYPE(String oRIGIN_ACCOUNT_TYPE) {
		ORIGIN_ACCOUNT_TYPE = oRIGIN_ACCOUNT_TYPE;
	}
	public String getORIGIN_ACCOUNT_EMPLOYEENUMBER() {
		return ORIGIN_ACCOUNT_EMPLOYEENUMBER;
	}
	public void setORIGIN_ACCOUNT_EMPLOYEENUMBER(String oRIGIN_ACCOUNT_EMPLOYEENUMBER) {
		ORIGIN_ACCOUNT_EMPLOYEENUMBER = oRIGIN_ACCOUNT_EMPLOYEENUMBER;
	}
	public String getORIGIN_ACCOUNT_DEPARTMENT() {
		return ORIGIN_ACCOUNT_DEPARTMENT;
	}
	public void setORIGIN_ACCOUNT_DEPARTMENT(String oRIGIN_ACCOUNT_DEPARTMENT) {
		ORIGIN_ACCOUNT_DEPARTMENT = oRIGIN_ACCOUNT_DEPARTMENT;
	}
	public String getORIGIN_ACCOUNT_TIER() {
		return ORIGIN_ACCOUNT_TIER;
	}
	public void setORIGIN_ACCOUNT_TIER(String oRIGIN_ACCOUNT_TIER) {
		ORIGIN_ACCOUNT_TIER = oRIGIN_ACCOUNT_TIER;
	}
	public String getORIGIN_ACCOUNT_RESIDENTNUMBER() {
		return ORIGIN_ACCOUNT_RESIDENTNUMBER;
	}
	public void setORIGIN_ACCOUNT_RESIDENTNUMBER(String oRIGIN_ACCOUNT_RESIDENTNUMBER) {
		ORIGIN_ACCOUNT_RESIDENTNUMBER = oRIGIN_ACCOUNT_RESIDENTNUMBER;
	}
	public Date getORIGIN_ACCOUNT_CREATEDATE() {
		return ORIGIN_ACCOUNT_CREATEDATE;
	}
	public void setORIGIN_ACCOUNT_CREATEDATE(Date oRIGIN_ACCOUNT_CREATEDATE) {
		ORIGIN_ACCOUNT_CREATEDATE = oRIGIN_ACCOUNT_CREATEDATE;
	}
	public int getORIGIN_ACCOUNT_EMPLOYMENT_STATUS_ID() {
		return ORIGIN_ACCOUNT_EMPLOYMENT_STATUS_ID;
	}
	public void setORIGIN_ACCOUNT_EMPLOYMENT_STATUS_ID(int oRIGIN_ACCOUNT_EMPLOYMENT_STATUS_ID) {
		ORIGIN_ACCOUNT_EMPLOYMENT_STATUS_ID = oRIGIN_ACCOUNT_EMPLOYMENT_STATUS_ID;
	}
	
	
}