package com.yakeManager.pojo;
//&#x8096;&#x5bb6;&#x6d77;
import com.yakeManager.pojo.emun.ClientType;

public class Client extends User {
    private Long client_id;
    //手机号码
    private Long client_phone;
    //邮箱
    private String client_email;
    //姓名
    private String client_name;
    //身份证号码
    private String client_ic;
    //用户类型
    private ClientType client_type;
    //个性签名
    private String signature;
    //头像（图片链接）
    private String avatar;

    public Client(){}
    public Client(Long client_id,Long client_phone, String client_email, String client_name, String client_ic, ClientType client_type, String signature, String avatar) {
        this.client_phone = client_phone;
        this.client_email = client_email;
        this.client_name = client_name;
        this.client_ic = client_ic;
        this.client_type = client_type;
        this.signature = signature;
        this.avatar = avatar;
        this.client_id=client_id;
    }

    public Client(long client_id, String password, long client_phone, String client_email, String client_name, String client_ic, ClientType client_type, String signature, String avatar) {
        super(client_id, password);
        this.client_phone = client_phone;
        this.client_email = client_email;
        this.client_name = client_name;
        this.client_ic = client_ic;
        this.client_type = client_type;
        this.signature = signature;
        this.avatar = avatar;
    }

    public Client(long client_id, String password, String identity, long client_phone, String client_email, String client_name, String client_ic, ClientType client_type, String signature, String avatar) {
        super(client_id, password, identity);
        this.client_phone = client_phone;
        this.client_email = client_email;
        this.client_name = client_name;
        this.client_ic = client_ic;
        this.client_type = client_type;
        this.signature = signature;
        this.avatar = avatar;
    }

    public long getClient_phone() {
        return client_phone;
    }

    public void setClient_phone(long client_phone) {
        this.client_phone = client_phone;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_ic() {
        return client_ic;
    }

    public void setClient_ic(String client_ic) {
        this.client_ic = client_ic;
    }

    public ClientType getClient_type() {
        return client_type;
    }

    public void setClient_type(ClientType client_type) {
        this.client_type = client_type;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
