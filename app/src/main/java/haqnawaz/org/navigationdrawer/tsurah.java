package haqnawaz.org.navigationdrawer;

public class tsurah {
    public int SurahId;
    public String SurahName;

    public tsurah(int surahId, String surahName) {
        SurahId = surahId;
        SurahName = surahName;
    }

    public int getSurahId() {
        return SurahId;
    }

    public void setSurahId(int surahId) {
        SurahId = surahId;
    }

    public String getSurahName() {
        return SurahName;
    }

    public void setSurahName(String surahName) {
        SurahName = surahName;
    }
}
