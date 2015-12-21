package com.app.service.taxi.taxiserviceapp;

/**
 * Created by Akila_chathuranga on 12/20/2015.
 */
public class Request_Msg {

    private String msg,status;
    private boolean accepted;

    public Request_Msg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

}
