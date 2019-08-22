import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CountriesTest {
    public static void main(String[] args) {
        File file = new File("countries.csv");

        try {
            Map<String, Country> countryMap = readFile(file);
            System.out.println(printCountryOfChoice(countryMap));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String printCountryOfChoice(Map<String, Country> countryMap) {
        Scanner in = new Scanner(System.in);
        Set<String> keys = countryMap.keySet();

        System.out.println("Podaj kod kraju, o którym chcesz wyświetlić informacje. \n" +
                "Dostępne państwa to: " + keys);
        String userChoice = in.nextLine().toUpperCase();

        if (countryMap.get(userChoice) == null) {
            return "Nie posiadam informacji na temat podanego państwa";
        } else {
            return countryMap.get(userChoice).toString();
        }
    }

    private static Map<String, Country> readFile(File file) throws IOException {
        Map<String, Country> countryMap = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        String[] split;
        String code;
        Country country;

        while ((line = br.readLine()) != null) {
            split = line.split(";");
            code = split[0];
            country = new Country(code, split[1], Integer.valueOf(split[2]));
            countryMap.put(code, country);
        }

        br.close();

        return countryMap;
    }
}
