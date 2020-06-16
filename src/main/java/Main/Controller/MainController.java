package Main.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import Main.Model.Location;


@Controller
public class MainController {

	 @PostMapping("/getPlace")
	 public String locationSubmit(@ModelAttribute Location location, BindingResult bindingResult, @RequestParam("name") String name) {
		 
		 
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<String> topic_body = restTemplate.exchange("https://nominatim.openstreetmap.org/?addressdetails=1&q="+location.getName()+"&format=json&limit=1", 
					HttpMethod.GET, null, String.class );
		     		 
			String  topics = topic_body.getBody(); 
			System.out.println(topics);
			topics = topics.replace("\"address\":{", "");
			topics = topics.replace("[","");
			topics = topics.replace("]","");
			topics = topics.replace("}}","");
			topics = topics.replace("{","");
			
			List<String> test = new ArrayList<String>();
			
			String[] list = topics.split(",\"");
			Location l = new Location();
			
			for (int i = 0; i < list.length; i++) {
				
				String j =list[i].replace("\"", "");
				list[i] = j;

				 String[] list1 = list[i].split(":");
				 
		 		
				if (list1[0].equals("lat")  ) {
					test.add(list1[1]);
				}
				if ( list1[0].equals("lon") ) {
								
					test.add(list1[1]);
							}
				if ( list1[0].equals("place_id") ) {
					
					test.add(list1[1]);
				}
				if ( list1[0].equals("country") ) {
					
					test.add(list1[1]);
				}
			}
			System.out.println(test);
			location.setCountry(test.get(3));
			location.setPlace_id(test.get(0));
			location.setLatitude(test.get(1));
			location.setLongitud(test.get(2));
			
			System.out.println(location);
		    return "details";
	  }
	 
	 @GetMapping("/")
	 public String locationSubmit(Model model) {
		 
		 	model.addAttribute("Location", new Location());
		
			return "locationInterface";
	  }
	 

}
