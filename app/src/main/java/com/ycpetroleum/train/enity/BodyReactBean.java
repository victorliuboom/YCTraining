package com.ycpetroleum.train.enity;

import java.util.List;

/**
 * @Auth Mr.Jobs(乔元培)
 * @Date 2016/8/1
 * @Time 10:42
 * 别人可以拷贝我的代码，但是不能拷贝我不断往前的激情(0-0)。
 **/
public class BodyReactBean {

    private ObjBean obj;
    private boolean success;
    private String msg;
    private Object attributes;

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

    public static class ObjBean {
        private int count;
        /**
         * id : 8a7cf9295635b352015643f86db0301a
         * socketcode : 987ac200-2795-4ab1-b26b-8790c085ec6e
         * userid : 18710948468
         * flag : 0
         * createtime : 2016-08-01 10:39:29
         * type : 0
         * action : null
         */

        private List<ListBean> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String id;
            private String socketcode;
            private String userid;
            private String flag;
            private String createtime;
            private String type;
            private Object action;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSocketcode() {
                return socketcode;
            }

            public void setSocketcode(String socketcode) {
                this.socketcode = socketcode;
            }

            public String getUserid() {
                return userid;
            }

            public void setUserid(String userid) {
                this.userid = userid;
            }

            public String getFlag() {
                return flag;
            }

            public void setFlag(String flag) {
                this.flag = flag;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Object getAction() {
                return action;
            }

            public void setAction(Object action) {
                this.action = action;
            }
        }
    }
}
