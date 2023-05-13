package model.base;

public abstract class Data<T> {
    public Data(String name, T data) throws Exception {
        if (validData(data)) {
            this.Name = name;
            this.data = data;
        } else
            throw new Exception("Ошибка данных");
    }
    public String getName(){
        return Name;
    }
    public T getData(){
        return data;
    }
    private String Name;
    private T data;
    public abstract boolean validData(T data);

    @Override
    public String toString() {
        return "Data{" +
                "Name='" + Name + '\'' +
                ", data=" + data +
                '}';
    }
}
