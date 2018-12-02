package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principale
{

	public static void main(String[] args) throws FileNotFoundException
	{
		File fichier = new File("./src/Day5/data.txt");
		Scanner sc = new Scanner(fichier);

		String line = "";

		boolean nice;

		int LettreNice = 0;

		while (sc.hasNextLine())
		{
			line = sc.nextLine();
			nice = false;
			// Rule 1
			if (troisVoyelles(line) && regleDeux(line) && regleTrois(line))
			{
				nice = true;
			}

			if (nice)
				LettreNice++;
		}
		System.out.println(LettreNice);
		sc.close();
	}

	public static boolean troisVoyelles(String input)
	{
		int compteur = 0;

		for (int i = 0; i < input.length(); i++)
		{
			if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o'
					|| input.charAt(i) == 'u')
			{
				compteur++;
			}
		}
		return compteur >= 3;
	}

	public static boolean regleDeux(String input)
	{
		for (int i = 1; i < input.length(); i++)
		{
			if (input.charAt(i) == input.charAt(i - 1))
				return true;
		}
		return false;
	}

	public static boolean regleTrois(String input)
	{
		for (int i = 1; i < input.length(); i++)
		{
			if ((((int) input.charAt(i)) - 1) == ((int) input.charAt(i - 1)))
			{
				if (input.charAt(i - 1) == 'a' || input.charAt(i - 1) == 'c' || input.charAt(i - 1) == 'p'
						|| input.charAt(i - 1) == 'x')
					return false;
			}
		}
		return true;
	}
}
