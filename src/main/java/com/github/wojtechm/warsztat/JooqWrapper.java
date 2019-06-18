package com.github.wojtechm.warsztat;

import com.github.wojtechm.DataSourceConfig;
import org.jooq.DSLContext;
import org.jooq.Record5;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.jooq.impl.DSL.*;

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
        IntegratedDevelopmentEnvironment intellij = dawajIntellidżejkePoId(3);
        intellij.licencja = "Ultimate Edition: proprietary";
        zaktualizuj(intellij);
        wyświetlIde();
    }

    private void wyczyśćTabelę() {
        database.truncate("IntegratedDevelopmentEnvironment").execute();
    }

    private void dodajIde() {
        database.insertInto(table("IntegratedDevelopmentEnvironment"))
                .columns(field("nazwa"), field("licencja"),
                         field("czyNapisanyWJavie"), field("czyWspieraLinux"))
                .values("BlueJ", "GPL2+GNU linking exception", true, true)
                .values("Eclipse JDT", "EPL", false, true)
                .values("IntelliJ IDEA", "Community Edition: Apache License v2.0", true, true)
                .execute();
    }

    private void wyświetlIde() {
        Result<Record5<Object, Object, Object, Object, Object>> ide =
                database.select(field("IntegratedDevelopmentEnvironment.id"),
                                field("IntegratedDevelopmentEnvironment.nazwa"),
                                field("IntegratedDevelopmentEnvironment.licencja"),
                                field("IntegratedDevelopmentEnvironment.CzyNapisanyWJavie"),
                                field("IntegratedDevelopmentEnvironment.CzyWspieraLinux"))
                        .from(table("IntegratedDevelopmentEnvironment"))
                        .fetch();
        System.out.println(ide);
    }

    private IntegratedDevelopmentEnvironment dawajIntellidżejkePoId(int id) {
        return database.select(asterisk())
                .from(table("IntegratedDevelopmentEnvironment"))
                .where(condition("IntegratedDevelopmentEnvironment.id = ?", id))
                .fetchSingle()
                .into(IntegratedDevelopmentEnvironment.class);
    }

    private void zaktualizuj(IntegratedDevelopmentEnvironment integratedDevelopmentEnvironment) {
        database.update(table("IntegratedDevelopmentEnvironment"))
                .set(field("nazwa"), integratedDevelopmentEnvironment.nazwa)
                .set(field("licencja"), integratedDevelopmentEnvironment.licencja)
                .set(field("czyNapisanyWJavie"), integratedDevelopmentEnvironment.czyNapisanyWJavie)
                .set(field("czyWspieraLinux"), integratedDevelopmentEnvironment.czyWspieraLinux)
                .where("id = ?", integratedDevelopmentEnvironment.id)
                .execute();
    }
}
