package com.github.wojtechm.warsztat;

/**
 * @author Wojciech Makiela
 */
class IntegratedDevelopmentEnvironment {

    long id;
    String nazwa;
    String licencja;
    boolean czyNapisanyWJavie;
    boolean czyWspieraLinux;

    public IntegratedDevelopmentEnvironment(long id, String nazwa, String licencja, boolean czyNapisanyWJavie, boolean czyWspieraLinux) {
        this.id = id;
        this.nazwa = nazwa;
        this.licencja = licencja;
        this.czyNapisanyWJavie = czyNapisanyWJavie;
        this.czyWspieraLinux = czyWspieraLinux;
    }

    @Override
    public String toString() {
        return "IntegratedDevelopmentEnvironment{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", licencja='" + licencja + '\'' +
                ", czyNapisanyWJavie=" + czyNapisanyWJavie +
                ", czyWspieraLinux=" + czyWspieraLinux +
                '}';
    }
    // BlueJ, GPL2+GNU linking exception, Yes, Yes
    // Eclipse JDT, EPL, No, Yes
    // IntelliJ IDEA, Community Edition: Apache License v2.0, Yes, Yes
}
