package model.base;

import model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class CSVExport extends Exporter{
    public CSVExport(String filename) {
        this.filename = filename;
    }

    private String filename;
    @Override
    public void export(User[] data) throws IOException {
        StringBuilder output = new StringBuilder();
        for (User user : data) {
            output.append(user.getLastName().getData());
            output.append(";");
            output.append(user.getFirstName().getData());
            output.append(";");
            output.append(user.getPhone().getData());
            output.append(";");
            output.append(user.getDescription());
            output.append(";");
            output.append(buildCD(user.getDataMap()));
            output.append("\n");
        }

        PrintWriter file = new PrintWriter(filename, "Cp1251");
        file.println(output.toString());
        file.close();
    }

    private String buildCD(Map<String, Data> cd) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        for (String key : cd.keySet()) {
            res.append(cd.get(key).getClass().getSimpleName());
            res.append(":");
            res.append(cd.get(key).getName());
            res.append(":");
            res.append(cd.get(key).getData().toString());
            if (i++ + 1 != cd.size())
                res.append("+");
        }
        return res.toString();
    }
}
