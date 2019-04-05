import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Theatre extends Controller2 {
	public static ArrayList<String> location = new ArrayList<>();;
	public static String type;
	public static ArrayList<String> movielist = new ArrayList<>();;
	
	public static ArrayList<String> scraperTheaters(String type) throws IOException{
		String url = "";
		if(type.equals("AMC")) {
		Document doc = Jsoup.connect("https://www.amctheatres.com/movie-theatres").get();
		Elements places = doc.getElementsByTag("a");
		boolean firstplace = false;
		boolean lastplace = false;
		for(Element place:places) {
			if(place.ownText().equals("Albany, Ga")) {
				firstplace = true;
			}
			if(place.ownText().equals("Yakima, Wa")) {
				lastplace = true;
			}
			if((!(place.ownText()==null)||!(place.ownText().length()==0))&&firstplace&&!lastplace) {
			location.add(place.ownText());
			}
		}
		}
		
		else if(type.equals("Regal Cinemas")) {
			url = "https://www.regmovies.com/static/en/us/theatre-list";
			Document doc = Jsoup.connect(url).get();
			Elements places = doc.getElementsByTag("a");
			boolean firstplace = false;
			boolean lastplace = false;
			for(Element place:places) {
				if(place.ownText().equals("Birmingham, Regal Trussville")) {
					firstplace = true;
				}
				if(place.ownText().equals("Laramie, Regal Fox Theater")) {
					lastplace = true;
				}
				if((!(place.ownText()==null)||!(place.ownText().length()==0))&&firstplace&&!lastplace) {
				location.add(place.ownText());
				}
		}}
		else if(type.equals("Cinemark Theatres")) {
			
		}
		else if(type.equals("Marcus Theatres")) {
			
		}
		else if(type.equals("Landmark Theatres")) {
			
		}
	
		return null;
	}
	
	public static ArrayList<String> scraperMovies() throws IOException{
		Document doc = Jsoup.connect("https://www.amctheatres.com/movies").get();
		
		Elements movies = doc.getElementsByTag("h3");

		for(Element movie:movies) {
			if(!(movie.ownText()==null)||!(movie.ownText().length()==0)) {
			movielist.add(movie.ownText());
			}

		}
		return movielist;
	}
}
