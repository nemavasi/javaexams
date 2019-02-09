package javaexams.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class TProcess
{



    private static class ResultFromCommand extends Thread {
        private InputStream inputStream = null;

        // This abstract class is the superclass of all classes representing an input stream of bytes.
        ResultFromCommand(InputStream is, String type) {
            this.inputStream = is;
        }

        public void run() {
            String str = null;
            try {

                // Reads text from a character-input stream, buffering characters so as to provide for the efficient reading of characters, arrays, and lines.
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                while ((str = br.readLine()) != null) {
                    System.out.println(str);
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    public static void main(final String[] args) throws IOException
    {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("ping 8.8.8.8");
        ResultFromCommand cError, cResult;
        cError = new ResultFromCommand(process.getErrorStream(), "ERROR");
        cResult = new ResultFromCommand(process.getInputStream(), "OUTPUT");
        cError.start();
        cResult.start();
    }
}