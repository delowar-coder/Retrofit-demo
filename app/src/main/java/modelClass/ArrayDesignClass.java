package modelClass;

import java.util.List;

public class ArrayDesignClass {
    private List<Teams> data;

    public ArrayDesignClass(List<Teams> data) {
        this.data = data;
    }

    public List<Teams> getData() {
        return data;
    }

    public void setData(List<Teams> data) {
        this.data = data;
    }
}
