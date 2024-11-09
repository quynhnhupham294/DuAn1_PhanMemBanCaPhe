package Test;

import java.sql.Connection;
import utils.Jdbc;

public class Test {
    public static void main(String[] args) {
        Jdbc db = new Jdbc();
        Connection conn = db.getConnection(); // => Connect success!
    }
}
