package com.example.shoppingapp.bean;

public class User {


    /**
     * token : 6ae228b8-94b6-4914-985a-cace428df900
     * data : {"id":297074,"logo_url":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLECZDia4QrdiamAvzwMq4b3nSJN6g3icYXHKfedlWvibfvDicicGRWXGoXib9xesuu2ZheuVo3YAOibWIklA/132","username":"乾哥","mobi":"15021994943"}
     * status : 1
     * message : success
     */

    private String token;
    private DataBean data;
    private int status;
    private String message;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * id : 297074
         * logo_url : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLECZDia4QrdiamAvzwMq4b3nSJN6g3icYXHKfedlWvibfvDicicGRWXGoXib9xesuu2ZheuVo3YAOibWIklA/132
         * username : 乾哥
         * mobi : 15021994943
         */

        private int id;
        private String logo_url;
        private String username;
        private String mobi;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogo_url() {
            return logo_url;
        }

        public void setLogo_url(String logo_url) {
            this.logo_url = logo_url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getMobi() {
            return mobi;
        }

        public void setMobi(String mobi) {
            this.mobi = mobi;
        }
    }
}
