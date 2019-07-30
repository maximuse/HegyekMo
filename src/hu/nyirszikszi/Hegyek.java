package hu.nyirszikszi;

class Hegyek {
    private String hegycsucsNeve;
    private String hegyseg;
    private int magassag;

    Hegyek(String hegycsucsNeve, String hegyseg, int magassag) {
        this.hegycsucsNeve = hegycsucsNeve;
        this.hegyseg = hegyseg;
        this.magassag = magassag;
    }

    String getHegycsucsNeve() {
        return hegycsucsNeve;
    }

    String getHegyseg() {
        return hegyseg;
    }

    int getMagassag() {
        return magassag;
    }

    @Override
    public String toString() {
        return "Hegyek{" +
                "hegycsucsNeve='" + hegycsucsNeve + "'" +
                ", hegyseg='" + hegyseg + "'" +
                ", magassag=" + magassag +
                "}\n";
    }
}