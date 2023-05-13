package model.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Name extends Data<String>{

    public Name(String name, String data) throws Exception {
        super(name, data);
    }

    @Override
    public boolean validData(String data) {
        Pattern pattern = Pattern.compile("^[ёЁа-яА-Яa-zA-Z0-9\\s\\(\\)\\._-]{1,50}$");
        Matcher matcher = pattern.matcher(data);
        return matcher.find();
    }
}
