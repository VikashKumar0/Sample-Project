package com.example.linchpin.sampleapplication.Models;

/**
 * Created by linchpin on 7/7/16.
 */
public class ResponseBody {
    private int errorCode;
    private String statusMsg;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
}
