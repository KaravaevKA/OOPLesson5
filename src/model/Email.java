package model;

import model.base.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email extends Data<String> {

    public Email(String name, String data) throws Exception {
        super(name, data);
    }

    @Override
    public boolean validData(String data) {
        Pattern pattern = Pattern.compile("^[ёЁа-яА-Яa-zA-Z0-9\\._-]+@[ёЁа-яА-Яa-zA-Z0-9._-]+\\.[ёЁа-яА-Яa-zA-Z]{2,63}$");
        Matcher matcher = pattern.matcher(data);
        return matcher.find();
    }
}
