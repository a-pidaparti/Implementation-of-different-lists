// written by pidap008

public class ElephantWriterTest {

    @org.junit.Test
    public void readElephants() {
        ElephantWriter tempWriter = null;
        ElephantHerd a = new ElephantHerd();
        boolean result = tempWriter.readElephants(a, "src/ElephantText.txt");

        tempWriter.writeElephants(a, "outElephants.txt");
        ElephantHerd b = new ElephantHerd();
        result = tempWriter.readElephants(b, "outElephants.txt");
        result = false;
        if(a.toString().equals(b.toString())){
            result = true;
        }
        assert(result);
    }

    @org.junit.Test
    public void writeElephants() {
        // writer already tested in readElephants test, so redundant
    }
}