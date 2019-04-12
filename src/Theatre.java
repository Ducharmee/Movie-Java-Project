import java.io.IOException;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Theatre extends Controller2 {
	public static ArrayList<String> location = new ArrayList<>();
	public static String type;

	
	
	public static ArrayList<String> scraperTheaters(String type) throws IOException{
		String url = "";
		if(type.equals("AMC")) {
		Document doc = Jsoup.connect("https://www.amctheatres.com/movie-theatres/states/massachusetts").get();
		Elements places = doc.getElementsByClass("Link-text Headline--h3");

		boolean firstplace = false;
		boolean lastplace = false;
		for(Element place:places) {
//			if(place.ownText().equals("AMC DINE-IN Framingham 16")) {
//				firstplace = true;
//			}
//			if(place.ownText().equals("AMC Assembly Row 12")) {
//				lastplace = true;
//			}
			if((!(place.ownText()==null)||!(place.ownText().length()==0))) {//&&firstplace&&!lastplace
			location.add(place.ownText());
			}
		}
		}
		
		else if(type.equals("REGAL")) {
			url = "https://www.regmovies.com/static/en/us/theatre-list";
			Document doc = Jsoup.connect(url).get();
			Elements places = doc.getElementsByTag("a");
			boolean firstplace = false;
			boolean lastplace = false;
			for(Element place:places) {
				if(place.ownText().equals("Bellingham, Regal Bellingham")) {
					firstplace = true;
				}
				if(place.ownText().equals("Taunton, Regal Silver City Galleria")) {
					lastplace = true;
				}
				if((!(place.ownText()==null)||!(place.ownText().length()==0))&&firstplace&&!lastplace) {
				location.add(place.ownText());
				}
		}}
		else if(type.equals("CINEMARK")) {
			url = "https://www.cinemark.com/massachusetts";
			location.add("Cinemark At Hampshire Mall and XD");
			location.add("Eastfield 16");
			location.add("West Springfield 15 and XD");
		}
		else if(type.equals("Black Stone Valley")) {
			
		}
		else if(type.equals("SHOWCASE")) {
		//program-list-title
			url = "https://www.showcasecinemas.com/theaters";
			Document doc = Jsoup.connect(url).get();
			Elements places = doc.getElementsByTag("h3");
			System.out.println(doc.html());
			boolean firstplace = false;
			boolean lastplace = false;
			for(Element place:places) {
				if(place.ownText().equals("Showcase SuperLux Chestnut Hill")) {
					firstplace = true;
				}
				if(place.ownText().equals("Showcase Cinemas Worcester North")) {
					lastplace = true;
				}
				if((!(place.ownText()==null)||!(place.ownText().length()==0))&&firstplace&&!lastplace) {
				location.add(place.ownText());
				
				}
				System.out.println(place.wholeText());
		}
			
		}
	
		return null;
	}
	

}
