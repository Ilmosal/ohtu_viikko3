package ohtu;

import java.util.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
		// vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "011120775";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/"+studentNr+"/submissions";
		String courseurl = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";
		String allurl = "https://studies.cs.helsinki.fi/ohtustats/stats";

        String bodyText = Request.Get(url).execute().returnContent().asString();
		String courseBodyText = Request.Get(courseurl).execute().returnContent().asString();
		String all = Request.Get(allurl).execute().returnContent().asString();

        Gson mapper = new Gson();
		JsonParser parser = new JsonParser();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
		Map<String, Object> map = mapper.fromJson(courseBodyText, Map.class);
		JsonObject data = parser.parse(all).getAsJsonObject();
      
	 	System.out.println("Kurssi: " + map.get("name") + ", " + map.get("term") +"\n");

		System.out.println("Opiskelijanumero: " + studentNr + "\n");

		ArrayList<Double> ex = (ArrayList<Double>)(map.get("exercises"));
 
        System.out.println("Oliot:");
        for (Submission submission : subs) {
			submission.setMaxEx(ex.get(submission.getWeek()-1).intValue());
         	System.out.println(submission);
        }

		int all_tehtavat = 0;
		int all_ex = 0;	

		for (String key: data.keySet()) {
			all_tehtavat += Integer.parseInt(data.getAsJsonObject(key).get("exercise_total").toString());
			all_ex += data.getAsJsonObject(key).get("exercises").getAsJsonArray().size() - 1;
		}

		int hours = 0;
		int tehtavat = 0;

		for (Submission sub : subs) {
			hours += sub.getHours();
			tehtavat += sub.getExercises().size();
		}

		System.out.println("\nyhteensä: " + tehtavat + " tehtavaa, " + hours + " tuntia");

		
		System.out.println("Kurssilla yhteensä " + all_ex + " palautusta, palautettavia tehtäviä " + Double.valueOf(all_tehtavat).intValue() + " kpl");
    }
}
