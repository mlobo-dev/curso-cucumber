package features.steps;

import cucumber.api.Transformer;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter  extends Transformer<Date> {
    @Override
    public Date transform(String s) {
        DateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formater.parse(s);
        } catch (ParseException e) {
            return null;
        }

    }
}
