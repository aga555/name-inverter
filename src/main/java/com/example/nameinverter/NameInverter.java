package com.example.nameinverter;

import java.util.ArrayList;
import java.util.List;

public class NameInverter {
    public String invert(String name) {
        if (StringHelper.isEmptyOrSpaces(name)) {
            return "";
        }
        ArrayList<String> splitName = splitName(name);
        return StringHelper.createInvertedString(splitName);
    }

    private ArrayList<String> splitName(String name) {
        return new ArrayList<>(List.of(name.split(" ")));
    }

    static class StringHelper {

        public static String createInvertedString(ArrayList<String> splitName) {
            splitName.removeIf(n -> List.of("Pan", "Pani").contains(n));
            return String.format("%s,%s", splitName.get(1), splitName.get(0));
        }

        public static boolean isEmptyOrSpaces(String name) {
            return name.trim().isEmpty();
        }
    }
}
