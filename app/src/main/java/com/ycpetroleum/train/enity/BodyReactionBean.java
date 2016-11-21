package com.ycpetroleum.train.enity;

import java.util.List;

/**
 * Auth Mr.Jobs(乔元培)
 * Date 2016/3/4
 * Time 15:28
 */
public class BodyReactionBean {

    /**
     * result : 0
     * des : success
     * datalist : [{"induceCount":"13","hour":"2016-03-04-15"},{"induceCount":"21","hour":"2016-03-04-14"},{"induceCount":"14","hour":"2016-03-04-13"},{"induceCount":"7","hour":"2016-03-04-12"},{"induceCount":"8","hour":"2016-03-04-11"},{"induceCount":"6","hour":"2016-03-04-10"},{"induceCount":"19","hour":"2016-03-04-09"},{"induceCount":"0","hour":"2016-03-04-08"},{"induceCount":"0","hour":"2016-03-04-07"},{"induceCount":"0","hour":"2016-03-04-06"},{"induceCount":"0","hour":"2016-03-04-05"},{"induceCount":"0","hour":"2016-03-04-04"},{"induceCount":"0","hour":"2016-03-04-03"},{"induceCount":"0","hour":"2016-03-04-02"},{"induceCount":"0","hour":"2016-03-04-01"},{"induceCount":"0","hour":"2016-03-04-00"},{"induceCount":"0","hour":"2016-03-03-23"},{"induceCount":"0","hour":"2016-03-03-22"},{"induceCount":"0","hour":"2016-03-03-21"},{"induceCount":"0","hour":"2016-03-03-20"},{"induceCount":"0","hour":"2016-03-03-19"},{"induceCount":"21","hour":"2016-03-03-18"},{"induceCount":"22","hour":"2016-03-03-17"},{"induceCount":"18","hour":"2016-03-03-16"}]
     * reqId : ilddotez_kt4
     */
    private int result;
    private String des;
    private List<DatalistEntity> datalist;
    private String reqId;

    public void setResult(int result) {
        this.result = result;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setDatalist(List<DatalistEntity> datalist) {
        this.datalist = datalist;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public int getResult() {
        return result;
    }

    public String getDes() {
        return des;
    }

    public List<DatalistEntity> getDatalist() {
        return datalist;
    }

    public String getReqId() {
        return reqId;
    }

    public class DatalistEntity {
        /**
         * induceCount : 13
         * hour : 2016-03-04-15
         */
        private String induceCount;
        private String hour;

        public void setInduceCount(String induceCount) {
            this.induceCount = induceCount;
        }

        public void setHour(String hour) {
            this.hour = hour;
        }

        public String getInduceCount() {
            return induceCount;
        }

        public String getHour() {
            return hour;
        }
    }
}
