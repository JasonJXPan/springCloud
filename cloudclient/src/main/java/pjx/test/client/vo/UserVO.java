package pjx.test.client.vo;

import java.io.Serializable;

/**
 * 类作用描述
 *
 * @author panjinxin
 * @since 18/12/31
 */
public class UserVO implements Serializable {

    private static final long serialVersionUID = -7116142449253206327L;

    private String id;
    private String name;

    public UserVO() {
    }

    public UserVO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
