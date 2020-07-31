import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11 {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Movie mov1 = new Movie();
		mov1 = Movie.getMovie(1);
		mov1.getTitle();
		mov1.getGenre();

		HashMap<Integer, String> genreMap = new HashMap<>();
		genreMap.put(1, "animated");
		genreMap.put(2, "drama");
		genreMap.put(3, "horror");
		genreMap.put(4, "scifi");

		boolean happy = true;

		while (happy) {
			System.out.println("Please select your favorite genre: ");
			System.out.println(" 1) animated\n 2) drama\n 3) horror\n 4) scifi");
			System.out.println("======================");
			Integer number = Validator.catchOne(scan.nextLine());
			while (number > 4 || number < 1) {
				System.out.println("Please enter a number from 1 to 4.");
				number = Validator.catchOne(scan.nextLine());
			}
			String faveGenre = genreMap.get(number);

			List<String> movList = new ArrayList<>();

			for (int i = 0; i <= 99; i++) {
				Movie move1 = Movie.getMovie(i);
				String daGenre = move1.getGenre();

				if (daGenre.equalsIgnoreCase(faveGenre)) {
					String daTitle = move1.getTitle();
					movList.add(daTitle);
				}
			}
			
			System.out.println("======================");
			System.out.println("You should watch...\n");
			Collections.sort(movList);

			for (int i = 0; i < movList.size(); i++) {
				System.out.println(movList.get(i));
			}
		
			System.out.println("\nWould you like to see some other movies?  (y/n) \n");
			happy = Validator.iDo(scan.nextLine());
		}
		
		System.out.println("\n      Fare thee well.");
	}
}
