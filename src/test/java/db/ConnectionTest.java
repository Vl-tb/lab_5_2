package db;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionTest {
    Connection con_1;
    Connection con_2;
    @BeforeEach
    void setUp() {
        con_1 = Connection.getConnection();
        con_2 = Connection.getConnection();
    }

    @Test
    void getConnection() {
        assertEquals(con_1, con_2);
    }
}