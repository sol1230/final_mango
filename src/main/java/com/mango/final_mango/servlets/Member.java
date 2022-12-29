package com.mango.final_mango.servlets;

public class Member {

    private String USER_ID;
    private String PASSWORD;
    private String NAME;
    private String PHONE;
    private String BIRTH_DATE;

    public Member() {}

    public Member(String USER_ID, String PASSWORD, String NAME, String PHONE, String BIRTH_DATE) {
        super();
        this.USER_ID = USER_ID;
        this.PASSWORD = PASSWORD;
        this.NAME = NAME;
        this.PHONE = PHONE;
        this.BIRTH_DATE = BIRTH_DATE;
    }

    public String getUSER_ID() {
        return USER_ID;
    }
    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }
    public String getPASSWORD() {
        return PASSWORD;
    }
    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
    public String getNAME() {
        return NAME;
    }
    public void setNAME(String NAME) {
        this.NAME = NAME;
    }
    public String getPHONE() {
        return PHONE;
    }
    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }
    public String getBIRTH_DATE() {
        return BIRTH_DATE;
    }
    public void setBIRTH_DATE(String BIRTH_DATE) {
        this.BIRTH_DATE = BIRTH_DATE;
    }
    @Override
	public String toString() {
		return "Member [USER_ID=" + USER_ID + ", PASSWORD=" + PASSWORD + ", NAME=" + NAME
				+ ", PHONE=" + PHONE + ", BIRTH_DATE=" + BIRTH_DATE +  "]";
	}
	




}
