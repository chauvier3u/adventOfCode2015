package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principale
{

	public static void main(String[] args) throws FileNotFoundException
	{
		partOne();
		partTwo();
	}

	public static void partTwo() throws FileNotFoundException
	{
		File fichier = new File("./src/Day5/data.txt");
		Scanner sc = new Scanner(fichier);

		String line = "";

		int LettreNice = 0;

		while (sc.hasNextLine())
		{
			line = sc.nextLine();
			if (partTwoUn(line) && partTwoDeux(line))
			{
				LettreNice++;
			}
		}
		System.out.println(LettreNice);
		sc.close();
	}

	public static void partOne() throws FileNotFoundException
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

	public static boolean partTwoUn(String input)
	{
		for (int i = 0; i < input.length() - 2; i++)
		{
			char a = input.charAt(i);
			char b = input.charAt(i + 1);
			for (int j = i + 2; j < input.length() - 1; j++)
			{
				char c = input.charAt(j);
				char d = input.charAt(j + 1);
				if (a == c && b == d)
					return true;
			}
		}
		return false;
	}

	public static boolean partTwoDeux(String input)
	{
		for (int i = 0; i < input.length() - 2; i++)
		{
			if (input.charAt(i) == input.charAt(i + 2))
				return true;
		}
		return false;
	}
}