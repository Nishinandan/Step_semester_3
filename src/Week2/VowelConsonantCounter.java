package Week2;

public class VowelConsonantCounter {

    public static void countVowelsAndConsonants(String text) {

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {

            char character = text.charAt(i);

            // Convert character to lowercase
            character = Character.toLowerCase(character);

            // Ignore spaces
            if (character == ' ') {
                continue;
            }

            // Check for vowels
            if (character == 'a' ||
                    character == 'e' ||
                    character == 'i' ||
                    character == 'o' ||
                    character == 'u') {

                vowels++;

            } else {

                // Since input contains only letters and spaces,
                // every non-vowel character is a consonant
                consonants++;
            }
        }

        System.out.println(
                "Vowels: " + vowels +
                        " | Consonants: " + consonants
        );
    }

    public static void main(String[] args) {

        String text = "Java Programming";

        countVowelsAndConsonants(text);
    }
}