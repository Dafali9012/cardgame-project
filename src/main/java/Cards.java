import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public abstract class Cards {

    public static CardTemplate[] getCardTemplates(String path) {
        String jsonData = "";
        CardTemplate[] result;

        try (Scanner scanner = new Scanner(Cards.class.getResourceAsStream(path))) {
            while (scanner.hasNext()) {
                jsonData = jsonData.concat(scanner.nextLine());
            }
        }

        Gson gson = new Gson();
        result = gson.fromJson(jsonData, CardTemplate[].class);

        return result;
    }

    public static List<Card> generateDeck(CardTemplate[] templates) {
        List<Card> result = new ArrayList<>();
        for (CardTemplate template : templates) {
            for (int i = 0; i < template.deckAmount; i++) {
                if (template.type.equals("creature"))
                    result.add(new CreatureCard(template.title, template.description, template.effect, template.health, template.damage));
                else if (template.type.equals("spell"))
                    result.add(new SpellCard(template.title, template.description, template.effect, template.health, template.damage));
            }
        }
        Collections.shuffle(result);
        return result;
    }
}
