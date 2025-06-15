package com.example.cifradecesar;
import org.junit.jupiter.api.Test;

public class TesteCifraDeCesar {

    @Test
    public void testCifraDeCesarCurta() {
        String original = "Era uma vez uma menina chamada Clara que adorava explorar a floresta sozinha.";
        int deslocamento = 3;
        CifraDeCesar.cifraTeste(original, deslocamento);
    }

    @Test
    public void testCifraDeCesarLonga() {
        String original = "Considering how many fools can calculate, it is surprising that it should be thought either a difficult or a tedious task for any other fool to learn how to master the same tricks. Some calculus-tricks are quite easy. Some are enormously difficult. The fools who write the textbooks of advanced mathematics—and they are mostly clever fools—seldom take the trouble to show you how easy the easy calculations are. On the contrary, they seem to desire to impress you with their tremendous cleverness by going about it in the most difficult way. Being myself a remarkably stupid fellow, I have had to unteach myself the difficulties, and now beg to present to my fellow fools the parts that are not hard. Master these thoroughly, and the rest will follow. What one fool can do, another can.";
        int deslocamento = 10;
        CifraDeCesar.cifraTeste(original, deslocamento);
    }
}


