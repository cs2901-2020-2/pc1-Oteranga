package cs.lab;

import org.testng.Assert;
import org.testng.annotations.Test;

import cs.lab.RegistrApp;
import sun.security.x509.Extension;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Test
public class RegistrAppTest {

    @Test
    public void testCase0() {
        generic(0);
    }

    @Test
    public void testCase1() throws Extension{
        generic(1);
    }

    @Test(invocationCount = 100, threadPoolSize = 100)
    public void testCase2() {
        long startTime = System.currentTimeMillis();
        generic(0);
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        Assert.assertTrue(time <= 500);
    }

    private void generic(int i) throws Exception {
        List<String> input = readInput(i);
        String output = readOutput(i);
        RegistrApp app = new RegistrApp();
        app.parsing(input);
        String response = app.notifyObserver();
        Assert.assertEquals(response, output);
    }

    private List<String> readInput(int testNumber){
        List<String> lines = readFile(testNumber, "input");
        return lines;
    }

    private String readOutput(int testNumber){
        List<String> lines = readFile(testNumber, "output");
        return lines.get(0);
    }

    public List<String> readFile(int testNumber, String type){
        String fileName = "test_case<testNumber>_<type>";
        fileName = fileName.replace("<testNumber>", Integer.toString(testNumber));
        fileName = fileName.replace("<type>", type);
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        Scanner scan = new Scanner(is);
        List<String> lines = new ArrayList<String>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.add(line);
        }
        return lines;
    }
}
