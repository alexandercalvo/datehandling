package com.learning.console;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.learning.date.TimeToSecond;

public class CalculaTime {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		int timeInSecond;
        TimeToSecond timesecond = new TimeToSecond();
		try {
			
		System.out.println("Ingrese la hora");
		int hour = scanner.nextInt();
		System.out.println("Ingrese los minutos");
        int minute = scanner.nextInt();
        System.out.println("Ingrese los segundos");
        int second = scanner.nextInt();
        System.out.println("===================================================");
        System.out.println("| han transcurrido : "+timesecond
        		.calculateTime(
        +hour, minute, second)+" segundos desde "+hour+":"+minute+":"+second+ "|");
        System.out.println("==================================================");
		}catch (NumberFormatException | InputMismatchException e) {
			System.out.println("solo se permiten numeros");
			System.exit(0);
		}
		
	}
}
