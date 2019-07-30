package hu.nyirszikszi;

class Hegyek {
    private String HegycsucsNeve;
    private String Hegyseg;
    private int Magassag;

    Hegyek(String hegycsucsNeve, String hegyseg, int magassag) {
        HegycsucsNeve = hegycsucsNeve;
        Hegyseg = hegyseg;
        Magassag = magassag;
    }

    String getHegycsucsNeve() {
        return HegycsucsNeve;
    }

    String getHegyseg() {
        return Hegyseg;
    }

    int getMagassag() {
        return Magassag;
    }

    @Override
    public String toString() {
        return "Hegyek{" +
                "HegycsucsNeve='" + HegycsucsNeve + "'" +
                ", Hegyseg='" + Hegyseg + "'" +
                ", Magassag=" + Magassag +
                "}\n";
    }
}