package model;

import model.base.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber extends Data<String> {

    public PhoneNumber(String name, String data) throws Exception {
        super(name, data);
    }

    @Override
    public boolean validData(String data) {
        Pattern pattern = Pattern.compile("^[\\+80]{1}[0-9\\-\\s\\(\\)\\#]{3,30}$");
        Matcher matcher = pattern.matcher(data);
        return matcher.find();
    }
}
