package com.github.wojtechm.warsztat;

import com.github.wojtechm.DataSourceConfig;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Wojciech Makiela
 */
class JooqWrapper {
    private DSLContext database;

    JooqWrapper(DataSourceConfig config) throws SQLException {
        Connection connection = DriverManager.getConnection(config.url, config.username, config.password);
        database = DSL.using(connection, SQLDialect.MYSQL);
    }


    void róbRzeczyZIde() {
        wyczyśćTabelę();
        dodajIde();
        wyświetlIde();
        IntegratedDevelopmentEnvironment intellij = dawajIntellidżejke();
        intellij.licencja = "Ultimate Edition: proprietary";
        zaktualizuj(intellij);
        wyświetlIde();
    }

    private void wyczyśćTabelę() {

    }

    private void dodajIde() {

    }

    private void wyświetlIde() {

    }

    private IntegratedDevelopmentEnvironment dawajIntellidżejke() {
        return null;
    }

    private void zaktualizuj(IntegratedDevelopmentEnvironment integratedDevelopmentEnvironment) {

    }
}
