import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.regex.*;
public class Movie {
public static String url;
public String Name;
public String showtime;
public Double rating;
public String photo;
public static ArrayList<String> movielist = new ArrayList<>();
public static ArrayList<String> movieratings = new ArrayList<>();
public static ArrayList<String> showtimeurls = new ArrayList<>();
public static ArrayList<String> showtimes = new ArrayList<>();
public static ArrayList<String> showtimeclick = new ArrayList<>();
public static ArrayList<String> urls = new ArrayList<>();

public static ArrayList<String> scraperShowtimes(String url) throws IOException{
	System.out.println(url);
	Document doc = Jsoup.connect(url).get();
	Elements Showtimes = doc.getElementsByClass("Theatre-Wrapper-First No-Showtimes-First");//doc.getElementsByClass("Btn Btn--default");
	
//	System.out.println(doc.html());

	for(Element showtime:Showtimes) {
		//System.out.println(url.split("/")[8]);
		/*if(showtime.outerHtml().contains(url.split("/")[8])) {
		showtimes.add(showtime.wholeText());
		showtimeclick.add(showtime.outerHtml().split("\"")[9]);
		}*/
		Elements Showtimez = showtime.getElementsByClass("Btn Btn--default");
		for(Element showtim:Showtimez) {
			if(showtime.outerHtml().contains(url.split("/")[8])) {
			//	System.out.println(showtim.outerHtml().split("\"")[9]);//.replaceAll("(?![\\d*\\d:\\d\\d])",""));
				showtimes.add(showtim.wholeText());
				showtimeclick.add("https://www.amctheatres.com"+showtim.outerHtml().split("\"")[9]);
				//System.out.println("Showtime: https://www.amctheatres.com"+showtim.outerHtml().split("\"")[9]);
		}
	}
	}
	
	
	return null;
}

public static ArrayList<String> scraperMovies() throws IOException{
	if(Theatre.type.equals("AMC")) {
	Document doc = Jsoup.connect(url).get();
	Elements imageUrls = doc.getElementsByClass("Picture--rectangle");//doc.select("src$=.jpg");
	Elements showtimeUrls = doc.getElementsByClass("Btn Btn--primary");
	Elements movies = doc.getElementsByTag("h3");

	int z = 0;
	for(Element showtimeurl:showtimeUrls) {
		String sorig = showtimeurl.outerHtml();
		String s = sorig.split("\"")[3];
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		s = "https://www.amctheatres.com"+s+"/"+sorig.split("/")[2]+"/"+dateFormat.format(date)+"/"+url.split("/")[5]+"/all";
		System.out.println(s);
		showtimeurls.add(s);
		z++;
	}
	for(Element movie:movies) {
		if((!(movie.ownText()==null)||!(movie.ownText().length()==0))&&!(movie.ownText().equals("Not finding what you're looking for?"))&&!(movie.ownText().equals("Features"))&&!(movie.ownText().equals("Amenities and Accessibility"))&&!(movie.ownText().equals("Other Policies"))&&!(movie.ownText().equals("Our Company"))&&!(movie.ownText().equals("Movies"))&&!(movie.ownText().equals("Programming"))&&!(movie.ownText().equals("More"))){//
		movielist.add(movie.ownText());
		}

	}
	int x =0;
	for(Element image:imageUrls) {
//		Elements a =image.getElementsByTag("a");
//		for(Element img:a) {
//		if(	img.child(0).attr("src").contains(".jp")) {
//			urls.add(img.attr("src"));
//		}
//		}
		if(x<movies.size()-8) {
		String s = image.html();//.replaceAll("<img src=\"", "");
		s = s.split("\"")[1];
		
		urls.add(s);
		x++;}
	}

	System.out.println(url);
	return movielist;
	}
	if(Theatre.type.equals("REGAL")) {
		System.out.println(url);
		Document doc = Jsoup.connect(url).get();
		System.out.println(doc.html());
		Elements movies = doc.getElementsByClass("qb-movie-name");
		for(Element movie:movies) {
			
			movielist.add(movie.ownText());
			System.out.println(movie.ownText());
		}
	}
	if(Theatre.type.equals("CINEMARK")) {
		System.out.println(url);
		Document doc = Jsoup.connect(url).get();
		Elements movies = doc.getElementsByClass("movieLink");
		Elements imgUrls = doc.getElementsByClass("movieLink");

		for(Element movie:movies) {
		
			if((!(movie.ownText()==null)||!(movie.ownText().length()==0))&&(!(movie.ownText().equals("Details"))&&((movie.ownText().matches("\\w+[\\w*|\\W*]*"))))) {
				movielist.add(movie.ownText());
				
			}
			
		}
		int x = 0;
		for(Element imgUrl:imgUrls) {
			if(Math.pow(-1, x)==1) {
			if(imgUrl.html().contains("\"")) {
			if(imgUrl.html().split("\"")[1].contains(".jpg")){
				urls.add("https://www.cinemark.com"+imgUrl.html().split("\"")[1]);
				
			}
			}
			
			}
			x++;
		}
	}
	return movielist;
}

}
