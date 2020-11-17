

import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Utils {
    public static CardSettings getCardSettings(String path) {
        if(path.isBlank()) return null;
        try {
            Gson gson = new Gson();
            return gson.fromJson(new FileReader(new File(path)), CardSettings.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Card> generateDeck(CardSettings cardSettings) {
        if(cardSettings==null) return null;
        List<Card> result = new ArrayList<>();
        for(CreatureTemplate template : cardSettings.creatures) {
            for(int i = 0; i < template.getDeckAmount();i++) {
                result.add(new CreatureCard(template.getTitle(), template.getDescription(), template.getMaxHealth(), template.getDefaultDamage()));
            }
        }
        for(SpellTemplate template : cardSettings.spells) {
            for(int i = 0; i < template.getDeckAmount();i++) {
                result.add(new SpellCard(template.getTitle(), template.getDescription(), template.getHeal(), template.getDamage()));
            }
        }
        Collections.shuffle(result);
        return result;
    }
}
