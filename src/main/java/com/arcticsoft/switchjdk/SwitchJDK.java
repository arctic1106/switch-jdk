package com.arcticsoft.switchjdk;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class SwitchJDK {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		try (var stream = Files.list(Path.of("C:\\JDKS"))) {
			var jdks = stream.filter(Files::isDirectory).toList();

			System.out.println("\nAvailable JDKs:\n---------------------------");
			for (int i = 0; i < jdks.size(); i++) {
				System.out.printf("%d. %s%n", i + 1, jdks.get(i).getFileName());
			}
			System.out.println("q. Quit");
			System.out.print("\nSelect JDK (or q to quit): ");

			var choice = scanner.nextLine();
			switch (choice) {
				case "q" ->	System.out.println("Exiting program.");
				default -> {
					var selection = Integer.parseInt(choice);
					if (selection <= jdks.size()) {
						var jdk = jdks.get(selection - 1);
						new ProcessBuilder("pwsh", "-Command", "Remove-Item 'C:\\jdk\\*' -Recurse -Force").inheritIO().start().waitFor();
						new ProcessBuilder("pwsh", "-Command", "Copy-Item '" + jdk + "\\*' -Destination 'C:\\jdk' -Recurse -Force").inheritIO().start().waitFor();
						System.out.println("Installed: " + jdk.getFileName());
					} else {
						System.out.println("Invalid selection. Exiting program.");
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
