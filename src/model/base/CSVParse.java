package model.base;

import model.Email;
import model.PhoneNumber;
import model.User;

import java.io.*;
import java.util.ArrayList;

public class CSVParse extends Parser{
    public CSVParse(String filename) throws FileNotFoundException {
        super(parse(filename));
    }

    private static ArrayList<User> parse(String filename) throws FileNotFoundException {
        ArrayList<User> res = new ArrayList<>();

        try (Reader in = new InputStreamReader(new FileInputStream(filename), "windows-1251")) {
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                res.add(new User(values[1], values[0], values[2], values[3], parceCS(values[4])));
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return res;
    }
    private static Data[] parceCS(String cs) throws Exception {
        String[] values = cs.split("\\+");
        Data[] res = new Data[values.length];
        for (int i = 0; i < values.length; i++) {
            String[] data = values[i].split(":");
            switch (data[0]){
                case "Email":
                    res[i] = new Email(data[1], data[2]);
                    break;
                case "Name":
                    res[i] = new Name(data[1], data[2]);
                    break;
                case "PhoneNumber":
                    res[i] = new PhoneNumber(data[1], data[2]);
                    break;
            }
        }
        return res;
    }
}
