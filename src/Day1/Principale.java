package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principale
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File fichier = new File("./src/Day1/data.txt");
		Scanner sc = new Scanner(fichier);

		int floor = 0;
		boolean basement = false;

		String ligne = sc.nextLine();
		for (int i = 0; i < ligne.length(); i++)
		{
			if (ligne.charAt(i) == '(')
			{
				floor++;
			} else
			{
				floor--;
			}
			if (floor < 0 && !basement)
			{
				basement = !basement;
				System.out.println(i + 1);
			}
		}

		System.out.println(floor);

		sc.close();
	}
}