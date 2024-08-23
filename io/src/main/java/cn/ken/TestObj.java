package cn.ken;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Ken-Chy129
 * @date 2024/8/23
 */
public class TestObj implements Serializable {

    @Serial
    private static final long serialVersionUID = 3900367831212026835L;

    private String code;

    private String data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TestObj{" +
                "code='" + code + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
