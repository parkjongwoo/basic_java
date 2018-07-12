package com.util.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface SQLConnector {
	Connection getConnection() throws SQLException, ClassNotFoundException;
}
