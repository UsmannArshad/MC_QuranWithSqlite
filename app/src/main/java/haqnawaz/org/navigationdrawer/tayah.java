package haqnawaz.org.navigationdrawer;

public class tayah {
    public int ayahId;
    public int SurahId;
    public String ArabicText;
    public String UrduTarajama;
    public String EnlishTarjama;
    public int ParaId;
    public int RakuId;

    public tayah(int ayahId, int surahId, String arabicText, String urduTarajama, String enlishTarjama, int paraId, int rakuId) {
        this.ayahId = ayahId;
        SurahId = surahId;
        ArabicText = arabicText;
        UrduTarajama = urduTarajama;
        EnlishTarjama = enlishTarjama;
        ParaId = paraId;
        RakuId = rakuId;
    }

    public int getAyahId() {
        return ayahId;
    }

    public void setAyahId(int ayahId) {
        this.ayahId = ayahId;
    }

    public int getSurahId() {
        return SurahId;
    }

    public void setSurahId(int surahId) {
        SurahId = surahId;
    }

    public String getArabicText() {
        return ArabicText;
    }

    public void setArabicText(String arabicText) {
        ArabicText = arabicText;
    }

    public String getUrduTarajama() {
        return UrduTarajama;
    }

    public void setUrduTarajama(String urduTarajama) {
        UrduTarajama = urduTarajama;
    }

    public String getEnlishTarjama() {
        return EnlishTarjama;
    }

    public void setEnlishTarjama(String enlishTarjama) {
        EnlishTarjama = enlishTarjama;
    }

    public int getParaId() {
        return ParaId;
    }

    public void setParaId(int paraId) {
        ParaId = paraId;
    }

    public int getRakuId() {
        return RakuId;
    }

    public void setRakuId(int rakuId) {
        RakuId = rakuId;
    }
}
