import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Cards {
    public static CardTemplate[] getCardTemplates(String path) {
        CardTemplate[] result = new CardTemplate[0];
        try {
            Gson gson = new Gson();
            result = gson.fromJson(new FileReader(new File(path)), CardTemplate[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Card> generateDeck(CardTemplate[] templates) {
        List<Card> result = new ArrayList<>();
        for(CardTemplate template : templates) {
            for(int i = 0; i < template.deckAmount; i++) {
                if(template.type.equals("creature")) result.add(new CreatureCard(template.title, template.description, template.effect, template.health, template.damage));
                else if(template.type.equals("spell")) result.add(new SpellCard(template.title, template.description, template.effect, template.health, template.damage));
            }
        }
        Collections.shuffle(result);
        return result;
    }
}
