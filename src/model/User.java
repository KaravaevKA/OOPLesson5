package model;

import model.base.Data;
import model.base.Name;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class User {
    public User(String firstName, String lastName, String description, String phone, Data[] dataMap) throws Exception {
        this.firstName = new Name("Имя", firstName);
        this.lastName = new Name("Фамилия", lastName);
        this.date = LocalDateTime.now();
        this.description = description;
        this.phone = new PhoneNumber("Номер телефона", phone);
        for (Data dm : dataMap) {
            this.dataMap.put(dm.getName(), dm);
        }
    }

    public Name getFirstName() {
        return firstName;
    }
    public Name getLastName(){
        return lastName;
    }
    public PhoneNumber getPhone(){
        return phone;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Data> getDataMap() {
        return dataMap;
    }

    private Name firstName;
    private Name lastName;
    private LocalDateTime date;
    private String description;
    private PhoneNumber phone;
    private Map<String, Data> dataMap = new HashMap<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Фамилия: ");
        sb.append(lastName.getData());
        sb.append(", Имя: ");
        sb.append(firstName.getData());
        sb.append(", Номер телефона: ");
        sb.append(phone.getData());
        sb.append(", Комментарий: ");
        sb.append(description);
        for (String dm_ks: dataMap.keySet()){
            sb.append(", " + dm_ks + " : ");
            sb.append(dataMap.get(dm_ks).getData().toString());
        }
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        return this.phone.getData().equals(((User) obj).phone.getData()) && this.date == ((User) obj).date;
    }
}
