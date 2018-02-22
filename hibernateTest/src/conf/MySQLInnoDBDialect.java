package conf;

import org.hibernate.dialect.MySQL5Dialect;

public class MySQLInnoDBDialect extends MySQL5Dialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
