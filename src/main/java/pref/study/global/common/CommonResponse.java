package pref.study.global.common;

import lombok.Data;

@Data
public class CommonResponse {

    private boolean success;
    private Object data;

    public CommonResponse(boolean success, Object data){
        this.success = success;
        this.data = data;
    }
}
